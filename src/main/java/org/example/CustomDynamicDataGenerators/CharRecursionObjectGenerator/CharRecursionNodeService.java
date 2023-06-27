package org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator;


import org.example.ObjectTypes.GenericTypes.CJKDescription;
import org.example.ObjectTypes.GenericTypes.CharMetaInfo;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.zip.DataFormatException;

public class CharRecursionNodeService {

    public static Map<CharMetaInfo, String> generateIdsMapResult(String currentBreakdownSubsection,
                                                           Map<String, Map<CharMetaInfo, String>> customIds) {
        Map<CharMetaInfo, String> mapResult = customIds.get(currentBreakdownSubsection);
        return mapResult;
    }

    public static List<CharRecursionNode> handleSubsectionPathways(String currentBreakdownSubsection,
                                                                   Map<String, Map<CharMetaInfo, String>> customIds) throws DataFormatException {
        boolean isEndNode = isEndNode(currentBreakdownSubsection, customIds);
        if (isEndNode) return new ArrayList<>();
        List<String> splitMultiSubsections = Arrays.stream(currentBreakdownSubsection.split("\\s"))
                .filter(str -> Objects.nonNull(str) && !str.isEmpty()).toList();

        List<CharRecursionNode> updatedRecursionNode = new ArrayList<>();
        for (int i = 0; i < splitMultiSubsections.size(); i++) {
            CharRecursionNode recur = null;
            String substring = splitMultiSubsections.get(i);
            Map<CharMetaInfo, String> lookupResult = customIds.get(substring);
            List<String> currentBreakdonwUnicode = unicodeBreakup(substring);
            boolean severalDescElems = CJKDescElems(currentBreakdonwUnicode).size() > 1;
            updatedRecursionNode = doHandlePathways(
                    customIds, splitMultiSubsections, updatedRecursionNode, recur,
                    substring, lookupResult, currentBreakdonwUnicode, severalDescElems);
        }
        List<CharRecursionNode> result = avoidExcessivelyNestedBreakdowns(currentBreakdownSubsection, updatedRecursionNode);
        return result;
    }

    public static CharRecursionNode getNestedSubstrings(List<String> unicodeFromSingleBreakdown,
                                                        Map<String, Map<CharMetaInfo, String>> customIds) throws DataFormatException {
        List<String> currentUnprosessedUnicode = unicodeFromSingleBreakdown;
        Map<String, List<String>> intSubstitutes = new HashMap<>();
        int substitutionIntToBeUsed = 1;
        Map<String, CharRecursionNode> updatedRecursion = new HashMap<>();

        while (currentUnprosessedUnicode.size() > 0) {
            if (substitutionIntToBeUsed > 9) {
                throw new DataFormatException("substitution number is too large: " + unicodeFromSingleBreakdown);
            }
            Integer lastBreakdonwDescIndex = getIndexOfLastBreakdonwDescriptionChar(currentUnprosessedUnicode);
            if (Objects.isNull(lastBreakdonwDescIndex)) {
                intSubstitutes.put(String.valueOf(substitutionIntToBeUsed), currentUnprosessedUnicode);


                updatedRecursion = addToRecursion(customIds, currentUnprosessedUnicode, substitutionIntToBeUsed, updatedRecursion);
                currentUnprosessedUnicode = new ArrayList<>();
                substitutionIntToBeUsed++;

            } else {
                String breakDownElem = currentUnprosessedUnicode.get(lastBreakdonwDescIndex);
                if (isOVERLAPDesc(breakDownElem) || isTwoElementDesc(breakDownElem)) {
                    List<String> substringToPassOn = retrieveSubstringFromList(currentUnprosessedUnicode, lastBreakdonwDescIndex, 3);
                    updatedRecursion = addToRecursion(customIds, substringToPassOn, substitutionIntToBeUsed, updatedRecursion);
                    intSubstitutes.put(String.valueOf(substitutionIntToBeUsed), substringToPassOn);
                    currentUnprosessedUnicode = removemiddleSubstringFromList(
                            currentUnprosessedUnicode, substringToPassOn,
                            substitutionIntToBeUsed, lastBreakdonwDescIndex, 3);

                    substitutionIntToBeUsed++;
                } else if (isThreeElemDesc(breakDownElem)) {
                    List<String> substringToPassOn = retrieveSubstringFromList(currentUnprosessedUnicode, lastBreakdonwDescIndex, 4);
                    updatedRecursion = addToRecursion(customIds, substringToPassOn, substitutionIntToBeUsed, updatedRecursion);
                    intSubstitutes.put(String.valueOf(substitutionIntToBeUsed), substringToPassOn);
                    currentUnprosessedUnicode = removemiddleSubstringFromList(
                            currentUnprosessedUnicode, substringToPassOn,
                            substitutionIntToBeUsed, lastBreakdonwDescIndex, 4);
                    substitutionIntToBeUsed++;
                } else {
                    throw new DataFormatException("unknown breakdownDesc: " + unicodeFromSingleBreakdown);
                }
            }
        }
        int oneNumLess = substitutionIntToBeUsed - 2;
        CharRecursionNode finalResut = updatedRecursion.get(String.valueOf(oneNumLess));
        return finalResut;
    }

    private static List<CharRecursionNode> doHandlePathways(Map<String, Map<CharMetaInfo, String>> customIds,
                                                            List<String> splitMultiSubsections,
                                                            List<CharRecursionNode> updatedRecursionNode,
                                                            CharRecursionNode recur, String substring,
                                                            Map<CharMetaInfo, String> lookupResult,
                                                            List<String> currentBreakdonwUnicode, boolean severalDescElems) throws DataFormatException {
        String lookupStr = null;
        if (Objects.nonNull(lookupResult)) {
            lookupStr = lookupResult.get(CharMetaInfo.BREAKDOWN);
        }
        if (Objects.nonNull(lookupStr) && lookupStr.equals(substring)) {
            //the element is a char that exist but has the same lookup value
            recur = new CharRecursionNode.Builder().withCurrentBreakdownSubsection(substring).build();
            updatedRecursionNode.add(recur);
        }else if (Objects.nonNull(lookupStr)) {
            //the lookup result is a char that has a novel breakupValue- this can be a split string
            recur = new CharRecursionNode(lookupStr);
            updatedRecursionNode.add(recur);
        }else if (Objects.isNull(lookupStr)) {
            updatedRecursionNode = handleFinalSubsection(
                    customIds, splitMultiSubsections,
                    updatedRecursionNode, recur, substring,
                    currentBreakdonwUnicode, severalDescElems);
        }else {
            throw new DataFormatException("unhandle SubsectionPathways case");
        }
        return updatedRecursionNode;
    }

    private static List<CharRecursionNode> avoidExcessivelyNestedBreakdowns(String currentBreakdownSubsection, List<CharRecursionNode> updatedRecursionNode) {
        if (updatedRecursionNode.size() == 1
                && updatedRecursionNode.get(0).getCurrentBreakdownSubsection().equals(currentBreakdownSubsection)
                && !(updatedRecursionNode.get(0).getSubsequentSubsections().size() > 1)) {
            return new ArrayList<>();
        } else if (updatedRecursionNode.size() == 1
                && updatedRecursionNode.get(0).getCurrentBreakdownSubsection().equals(currentBreakdownSubsection)
                && (updatedRecursionNode.get(0).getSubsequentSubsections().size() > 1)) {
            return updatedRecursionNode.get(0).getSubsequentSubsections();
        } else {
            return updatedRecursionNode;
        }
    }

    private static List<CharRecursionNode> handleFinalSubsection(Map<String, Map<CharMetaInfo, String>> customIds,
                                                                 List<String> splitMultiSubsections,
                                                                 List<CharRecursionNode> updatedRecursionNode,
                                                                 CharRecursionNode recur,
                                                                 String substring,
                                                                 List<String> currentBreakdonwUnicode,
                                                                 boolean severalDescElems) throws DataFormatException {
        if (currentBreakdonwUnicode.size() == 1) {
            recur = new CharRecursionNode.Builder().withCurrentBreakdownSubsection(substring).build();
        } else if (severalDescElems) {
            recur = getNestedSubstrings(currentBreakdonwUnicode, customIds);
        } else {
            List<CharRecursionNode> newlittlelist = currentBreakdonwUnicode.stream().map(each -> {
                try {
                    return new CharRecursionNode(each);
                } catch (DataFormatException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
            if (splitMultiSubsections.size() == 1) {
                updatedRecursionNode.addAll(newlittlelist);
                return updatedRecursionNode;
            }else {
                recur = new CharRecursionNode.Builder()
                        .withCurrentBreakdownSubsection(substring)
                        .withSubsequentSubsections(newlittlelist).build();

            }
        }
        updatedRecursionNode.add(recur);
        return updatedRecursionNode;
    }

    private static boolean isEndNode(String currentBreakdownSubsection, Map<String, Map<CharMetaInfo, String>> customIds) {
        boolean mapIsEmpty = Objects.isNull(customIds.get(currentBreakdownSubsection));
        if (Objects.isNull(currentBreakdownSubsection) || currentBreakdownSubsection.isEmpty()) {
            return true;
        } else if (currentBreakdownSubsection.length() == 1 && mapIsEmpty) {
            return true;
        }
        return false;
    }

    private static List<String> CJKDescElems(List<String> unicodeFromSingleBreakdown) {
        List<String> numberOfCJKelem = new ArrayList<>();
        for (int i = 0; i < unicodeFromSingleBreakdown.size(); i++) {
            boolean testBoolean = stringIsCJK(unicodeFromSingleBreakdown.get(i));
            if (testBoolean) {
                numberOfCJKelem.add(unicodeFromSingleBreakdown.get(i));
            }
        }
        return numberOfCJKelem;
    }


    private static Map<String, CharRecursionNode> addToRecursion(Map<String, Map<CharMetaInfo, String>> customIds,
                                                                 List<String> substringToPassOn,
                                                                 int substitutionIntToBeUsed,
                                                                 Map<String, CharRecursionNode> updatedRecursion) throws DataFormatException {
        List<CharRecursionNode> nodeList = new ArrayList<>();
        for (String item: substringToPassOn) {
            CharRecursionNode lookup = updatedRecursion.get(item);
            if (Objects.isNull(lookup)) {
                nodeList.add(new CharRecursionNode(item));
            }else {
                nodeList.add(lookup);
            }
        }
        if (nodeList.size() == 1) {
            return updatedRecursion;
        }

        String mergeStrFromNodeList = "";
        for (CharRecursionNode eachNode : nodeList) {
            mergeStrFromNodeList = mergeStrFromNodeList + eachNode.getCurrentBreakdownSubsection();
        }
        CharRecursionNode newForRecursion = new CharRecursionNode.Builder()
                .withCurrentBreakdownSubsection(mergeStrFromNodeList)
                .withSubsequentSubsections(nodeList).build();
        updatedRecursion.put(String.valueOf(substitutionIntToBeUsed), newForRecursion);
        return updatedRecursion;
    }

    private static List<String> removemiddleSubstringFromList(List<String> currentFoundSubstrings,
                                                              List<String> substringToPassOn,
                                                              int substitutionIntToBeUsed,
                                                              Integer lastBreakdonwDescIndex,
                                                              int numberOfChars) {
        List<String> firstSubsection = currentFoundSubstrings.subList(0, lastBreakdonwDescIndex);
        List<String> lastEnd= currentFoundSubstrings.subList(lastBreakdonwDescIndex + numberOfChars, currentFoundSubstrings.size());
        List<String> updatedList = new ArrayList<>();
        updatedList.addAll(firstSubsection);
        updatedList.add(String.valueOf(substitutionIntToBeUsed));
        updatedList.addAll(lastEnd);
        return updatedList;
    }

    private static List<String> retrieveSubstringFromList(List<String> currentFoundSubstrings,
                                                    Integer lastBreakdonwDescIndex,
                                                    int numberOfChars) {

        List<String> targetSubstring = currentFoundSubstrings.subList(lastBreakdonwDescIndex, lastBreakdonwDescIndex+numberOfChars);
        return targetSubstring;
    }

    private static Integer getIndexOfLastBreakdonwDescriptionChar(List<String> unicodeFromSingleBreakdown) {
        Integer CJKindex = null;
        for (int i = 0; i < unicodeFromSingleBreakdown.size(); i++) {
            String unicodeChar  = unicodeFromSingleBreakdown.get(i);
            boolean isCJKDesc = stringIsCJK(unicodeChar);
            if (isCJKDesc) {
                CJKindex = i;
            }
        }
        return CJKindex;
    }

    private static boolean isOVERLAPDesc(String input) {
        if (Objects.nonNull(input) && input.equals(CJKDescription.OVERLAP)) {
            return true;
        }else {
            return false;
        }
    }

    private static boolean isThreeElemDesc(String inputStr) {
        char input = inputStr.charAt(0);
        if (input == CJKDescription.HORI3.getUnicodeCharacter() || input == CJKDescription.VERT3.getUnicodeCharacter()) {
            return true;
        }
        return false;
    }

    private static boolean isTwoElementDesc(String input) {
        char first = input.charAt(0);
        if (Objects.isNull(first)) {
            return false;
        }
        if (first == CJKDescription.HORI2.getUnicodeCharacter() //HORI2('⿰'),
                || first == CJKDescription.VERT2.getUnicodeCharacter() //VERT2('⿱'),
                || first == CJKDescription.ENCIRALL.getUnicodeCharacter() //ENCIRALL('⿴'),
                || first == CJKDescription.ENCIRTOP.getUnicodeCharacter() //ENCIRTOP('⿵'),
                || first == CJKDescription.ENCIRBUT.getUnicodeCharacter() //ENCIRBUT('⿶'),
                || first == CJKDescription.ENCIRLEFT.getUnicodeCharacter() //ENCIRLEFT('⿷'),
                || first == CJKDescription.ENCTOPLEFT.getUnicodeCharacter() //ENCTOPLEFT('⿸'),
                || first == CJKDescription.ENCTOPRIGHT.getUnicodeCharacter() //ENCTOPRIGHT('⿹'),
                || first == CJKDescription.ENCBUTLEFT.getUnicodeCharacter()) { //ENCBUTLEFT('⿺'),
        return true;
        }
        return false;
    }

    private static List<CharRecursionNode> overlapElemBreakdown(List<String> breakList, String metaBreakdown, Map<String, Map<CharMetaInfo, String>> customIds) throws DataFormatException {
        List<CharRecursionNode> result = new ArrayList<>();
        boolean hasOtherCJKDesc = hasOtherCJKDesc(breakList.subList(1, breakList.size() - 1));
        if (!hasOtherCJKDesc) {
            for (int i = 0; i < breakList.size(); i++) {
                CharRecursionNode first = new CharRecursionNode(breakList.get(i));
                result.add(first);
            }
        } else {
            throw new DataFormatException("unsupported overlapElemBreakdown: " + breakList);
        }
        return result;
    }
    
    public static List<String> unicodeBreakup(String breakdownList) {
        IntStream codePoints = breakdownList.codePoints();
        List<String> codePointStrings = codePoints.mapToObj(Character::toString).collect(Collectors.toList());
        return codePointStrings;
    }

    private static boolean hasOtherCJKDesc(List<String> input) {
        boolean hasOtherCJKDesc = false;
        List<String> secondIsDesc = Arrays.stream(CJKDescription.values()).map(CJKDesc -> CJKDesc.name()).toList();
        for (int i = 0; i < input.size(); i++) {
            String inp = input.get(i);
            if (secondIsDesc.contains(inp)) {
                hasOtherCJKDesc = true;
            }
        }
        return hasOtherCJKDesc;
    }

    private static boolean stringIsCJK(String str) {
        List<String> secondIsDesc = Arrays.stream(CJKDescription.values())
                .map(CJK -> String.valueOf(CJK.getUnicodeCharacter())).toList();
        boolean result = secondIsDesc.contains(str);
        return result;
    }

}
