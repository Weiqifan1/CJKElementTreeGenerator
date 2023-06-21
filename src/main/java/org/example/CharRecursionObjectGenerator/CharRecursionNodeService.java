package org.example.CharRecursionObjectGenerator;


import org.example.ObjectTypes.CJKDescription;
import org.example.ObjectTypes.CharMetaInfo;
import org.example.ObjectTypes.CharRecursionNode;

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

    public static String generateCurrentMetaBreakdown(Map<CharMetaInfo, String> subsectionIdsMapResult) {
        if (Objects.isNull(subsectionIdsMapResult)) {
            return null;
        } else {
            return subsectionIdsMapResult.get(CharMetaInfo.BREAKDOWNMETA);
        }
    }

    public static List<CharRecursionNode> handleSubsectionPathways(String currentBreakdownSubsection,
                                                                   String currentMetaBreakdown,
                                                                   Map<CharMetaInfo, String> subsectionIdsMapResult,
                                                                   Map<String, Map<CharMetaInfo, String>> customIds) throws DataFormatException {
        List<CharRecursionNode> result = new ArrayList<>();
        result = handleEndnode(currentBreakdownSubsection, subsectionIdsMapResult);
        if (result != null) return new ArrayList<>();

        if (Objects.isNull(subsectionIdsMapResult) ) {
            result = handleSingleBreakdownString(currentBreakdownSubsection, currentMetaBreakdown, customIds);
        }
        if (Objects.isNull(subsectionIdsMapResult)) {
            return List.of(new CharRecursionNode.Builder().withCurrentBreakdownSubsection(currentBreakdownSubsection).build());
        }
        String breakdownList = subsectionIdsMapResult.get(CharMetaInfo.BREAKDOWN);

        if (Objects.nonNull(breakdownList) && Objects.isNull(result)
                && breakdownList.length() == breakdownList.replaceAll("\\s", "").length()) {
            result = handleSingleBreakdownString(currentBreakdownSubsection, currentMetaBreakdown, customIds);
        }

        List<String> multiBreaks = Arrays.stream(breakdownList.split("\\s")).toList();
        String idsMapMeta = subsectionIdsMapResult.get(CharMetaInfo.BREAKDOWNMETA);
        List<String> multiBreaksMeta = Arrays.stream(idsMapMeta.split("\\s")).toList();
        if (multiBreaks.size() != multiBreaksMeta.size()) {
            throw new DataFormatException("Breakdown doesnt have even elem and meta breakdown lengths: " + subsectionIdsMapResult.get(CharMetaInfo.CHAR));
        } else if (multiBreaks.size() > 1 && Objects.isNull(result)) {
            result = handleSplitBreakdown(customIds, multiBreaks, multiBreaksMeta);
        } else if (result.isEmpty() && breakdownList.replaceAll("\\s", "").equals(breakdownList)) {
            result = handleSingleBreakdownString(currentBreakdownSubsection, currentMetaBreakdown, customIds);
        } else {
            throw new DataFormatException("Unexpected breakdown state: " + subsectionIdsMapResult.get(CharMetaInfo.CHAR));
        }
        return result;
    }

    private static List<CharRecursionNode> handleSingleBreakdownString(String breakdown,
                                                                       String metaBreakdown,
                                                                       Map<String, Map<CharMetaInfo, String>> customIds) throws DataFormatException {
        List<String> breakList = unicodeBreakup(breakdown);
        if (breakList.size() > 1) {
            String first = breakList.get(0);
            if (first.equals(CJKDescription.OVERLAP)) { //OVERLAP('⿻');
                List<CharRecursionNode> result = overlapElemBreakdown(breakList, metaBreakdown, customIds);
                return result;
            } else if (first.equals(CJKDescription.HORI3) || first.equals(CJKDescription.VERT3)) { //HORI3('⿲') VERT3('⿳'),
                List<CharRecursionNode> result = threeElemBreakdown(breakList, metaBreakdown, customIds);
                return result;
            } else if (first.equals(CJKDescription.HORI2) //HORI2('⿰'),
                    || first.equals(CJKDescription.VERT2) //VERT2('⿱'),
                    || first.equals(CJKDescription.ENCIRALL) //ENCIRALL('⿴'),
                    || first.equals(CJKDescription.ENCIRTOP) //ENCIRTOP('⿵'),
                    || first.equals(CJKDescription.ENCIRBUT) //ENCIRBUT('⿶'),
                    || first.equals(CJKDescription.ENCIRLEFT) //ENCIRLEFT('⿷'),
                    || first.equals(CJKDescription.ENCTOPLEFT) //ENCTOPLEFT('⿸'),
                    || first.equals(CJKDescription.ENCTOPRIGHT) //ENCTOPRIGHT('⿹'),
                    || first.equals(CJKDescription.ENCTOPRIGHT)) { //ENCTOPRIGHT('⿹'),
                List<CharRecursionNode> result = twoElemBreakdown(breakList, metaBreakdown, customIds);
                return result;
            } else {
                //if the above doesnt match, we expect a series of individual strokes
                List<CharRecursionNode> result = new ArrayList<>();
                for (int i = 0; i < breakList.size(); i++) {
                    CharRecursionNode eachStroke = new CharRecursionNode(breakList.get(i), "", customIds);
                    result.add(eachStroke);
                }
                return result;
            }
        }else {
            //CharRecursionNode result = new CharRecursionNode(breakdown, metaBreakdown, customIds);
            return List.of();
        }
    }

    private static List<CharRecursionNode> overlapElemBreakdown(List<String> breakList, String metaBreakdown, Map<String, Map<CharMetaInfo, String>> customIds) throws DataFormatException {
        List<CharRecursionNode> result = new ArrayList<>();
        boolean hasOtherCJKDesc = hasOtherCJKDesc(breakList.subList(1, breakList.size() - 1));
        if (!hasOtherCJKDesc) {
            for (int i = 0; i < breakList.size(); i++) {
                CharRecursionNode first = new CharRecursionNode(breakList.get(i), metaBreakdown, customIds);
                result.add(first);
            }
        } else {
            throw new DataFormatException("unsupported overlapElemBreakdown: " + breakList);
        }
        return result;
    }

    private static List<CharRecursionNode> threeElemBreakdown(List<String> breakList,
                                                              String metaBreakdown,
                                                              Map<String, Map<CharMetaInfo, String>> customIds) throws DataFormatException {
        List<CharRecursionNode> result = new ArrayList<>();
        boolean hasOtherCJKDesc = hasOtherCJKDesc(breakList.subList(1, breakList.size() - 1));
        if (!hasOtherCJKDesc) {
            CharRecursionNode first = new CharRecursionNode(breakList.get(0), metaBreakdown, customIds);
            CharRecursionNode second = new CharRecursionNode(breakList.get(0), metaBreakdown, customIds);
            CharRecursionNode third = new CharRecursionNode(breakList.get(0), metaBreakdown, customIds);
            String restStr = String.join("", breakList.subList(3, breakList.size()));
            CharRecursionNode rest = new CharRecursionNode(restStr, metaBreakdown, customIds);
            result.add(first);
            result.add(second);
            result.add(third);
            result.add(rest);
        } else {
            throw new DataFormatException("unsupported threeElemBreakdown: " + breakList);
        }
        return result;
    }

    private static List<CharRecursionNode> twoElemBreakdown(List<String> breakList, String metaBreakdown, Map<String, Map<CharMetaInfo, String>> customIds) throws DataFormatException {
        List<CharRecursionNode> result = new ArrayList<>();
        boolean hasOtherCJKDesc = hasOtherCJKDesc(breakList.subList(1, breakList.size() - 1));
        if (!hasOtherCJKDesc) {
            CharRecursionNode first = new CharRecursionNode(breakList.get(0), metaBreakdown, customIds);
            CharRecursionNode second = new CharRecursionNode(breakList.get(1), metaBreakdown, customIds);
            String restStr = String.join("", breakList.subList(2, breakList.size()));
            CharRecursionNode rest = new CharRecursionNode(restStr, metaBreakdown, customIds);
            result.add(first);
            result.add(second);
            result.add(rest);
        } else {
            throw new DataFormatException("unsupported twoElemBreakdown: " + breakList);
        }
        return result;
    }

    private static List<CharRecursionNode> handleSplitBreakdown(Map<String, Map<CharMetaInfo, String>> customIds,
                                                                List<String> multiBreaks,
                                                                List<String> multiBreakMeta) throws DataFormatException {
        List<CharRecursionNode> result = new ArrayList<>();
        for (int i = 0; i < multiBreaks.size(); i++) {
            CharRecursionNode newRecur = new CharRecursionNode(multiBreaks.get(i), multiBreakMeta.get(i), customIds);
            result.add(newRecur);
        }
        return result;
    }

    private static List<CharRecursionNode> handleEndnode(String currentBreakdownSubsection, Map<CharMetaInfo, String> subsectionIdsMapResult) {
        boolean noNewSubsection = Objects.isNull(subsectionIdsMapResult)
                || subsectionIdsMapResult.get(CharMetaInfo.BREAKDOWN).equals(subsectionIdsMapResult.get(CharMetaInfo.BREAKDOWN));
        boolean noLongBreakdownString = Objects.isNull(currentBreakdownSubsection)
                || unicodeBreakup(currentBreakdownSubsection).size() < 2;
        if (noLongBreakdownString && noLongBreakdownString) {
            return null;
        }
        if (noNewSubsection
                || subsectionIdsMapResult.get(CharMetaInfo.BREAKDOWN).isEmpty()
                || subsectionIdsMapResult.get(CharMetaInfo.BREAKDOWN).length() < 2) {
            return null;
        }
        return new ArrayList<>();
    }

    private static List<String> unicodeBreakup(String breakdownList) {
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
        List<String> secondIsDesc = Arrays.stream(CJKDescription.values()).map(CJKDesc -> CJKDesc.name()).toList();
        boolean result = secondIsDesc.contains(str);
        return result;
    }

}
