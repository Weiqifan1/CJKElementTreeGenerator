package org.example.InputMethods.InputMethodCodeGenerators;

import org.example.ObjectTypes.GenericTypes.CJKDescription;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.GenericTypes.CodeDecompositionType;

import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import static org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator.CodeRecursionObjectGenerator.getNodeList;

public class AYMethodCodeGeneratorService {

    public static Map<String, CharRecursionNode> nodeListToMap(List<CharRecursionNode> nodeList) {
        Map<String, CharRecursionNode> result = new HashMap<>();
        for (CharRecursionNode node : nodeList) {
            String str = node.getOriginalInput();
            result.put(str, node);
        }
        return result;
    }

    public static List<List<String>> generateFullCodeFromCodeMap(String currentBreakdownSubsection,
                                                           List<CharRecursionNode> subsequentSubsections,
                                                           Map<String, String> codeMap,
                                                           String originalInput) throws DataFormatException {

        //split currentBreakdownSubsection
        List<String> splitBreakdown = Arrays.stream(currentBreakdownSubsection.split("\\s+")).toList();
        List<List<String>> result = new ArrayList<>();

        if ("乂".equals(currentBreakdownSubsection)) {
            String tes = "";
        }else if ("⿰白勺".equals(currentBreakdownSubsection)) {
            String test = "";
        }

        boolean isUnicodeDesc = isUnicodeDesc(currentBreakdownSubsection);
        String code = codeMap.get(currentBreakdownSubsection);
        boolean isEndNode = Objects.isNull(subsequentSubsections) || subsequentSubsections.isEmpty();
        if (isUnicodeDesc) {
            //handle endnode that is unicode desciption character
            List<String> temStr = new ArrayList<>();
            temStr.add(currentBreakdownSubsection);
            result.add(temStr);
        } else if (!isEndNode && Objects.nonNull(code)) {
            //handle node that is not an endnode but has a code in the codemap
            List<String> temStr = new ArrayList<>();
            temStr.add(code);
            result.add(temStr);
        } else if (isEndNode && Objects.nonNull(code)) {
            //handle endnode that has a code in the codemap
            List<String> temStr = new ArrayList<>();
            temStr.add(code);
            result.add(temStr);
        }else if (isEndNode) {
            //handle endnode that is not unicode description and doesnt have a code
            //TODO: this will continually need to be handled
            String test = "";
            throw new DataFormatException("missing codes from char: "+ originalInput + " elemMissimg: " + currentBreakdownSubsection);
        } else if (splitBreakdown.size() == 1) {
            //handle node that has nodes and is not a fork
            List<List<String>> cecusiveList = recursiveNonForkNodeHandling(subsequentSubsections);
            result = cecusiveList;
        } else if (splitBreakdown.size() > 1) {
            //handle node that has nodes and IS a fork
            List<List<String>> cecusiveList = forkNodeHandling(subsequentSubsections);
            result = cecusiveList;
        }
        if (Objects.isNull(result) || result.isEmpty()) {
            //throw new DataFormatException("missing codes from char: "+ originalInput);
        }
        return result;
    }

    private static List<List<String>> forkNodeHandling(List<CharRecursionNode> subsequentSubsections) {
        //handle node that has nodes and IS a fork
        List<List<String>> result = new ArrayList<>();
        for (CharRecursionNode recur : subsequentSubsections) {
            List<List<String>> eachFullCode = recur.getFullCode();
            result.addAll(eachFullCode);
        }
        return result;
    }

    private static List<List<String>> recursiveNonForkNodeHandling(List<CharRecursionNode> subsequentSubsections) {
        //handle node that has nodes and is not a fork
        //create a recursive function that takes the full codes from each CharRecursionNode
        List<List<String>> result = new ArrayList<>();
        result = nonForkFullCodeRecur(subsequentSubsections, result);

        return result;
    }

    private static List<List<String>> nonForkFullCodeRecur(List<CharRecursionNode> subsequentSubsections,
                                                           List<List<String>> result) {
        if (subsequentSubsections.isEmpty()) {
            return result;
        }
        //get head
        List<List<String>> head = subsequentSubsections.get(0).getFullCode();
        //get tail
        List<CharRecursionNode> updatedSubsequentSubsection = subsequentSubsections.subList(1, subsequentSubsections.size());

        List<List<String>> finishedResult = new ArrayList<>();
        for (int i = 0; i < head.size(); i++) {
            List<String> headStr = head.get(i);
            for (int k = 0; k < result.size(); k++) {
                List<String> resultStr = result.get(k);
                List<String> tempStr = new ArrayList<>();
                tempStr.addAll(headStr);
                tempStr.addAll(resultStr);
                finishedResult.add(tempStr);
            }
            if (result.isEmpty()) {
                finishedResult.add(headStr);
            }
        }
        return nonForkFullCodeRecur(updatedSubsequentSubsection, finishedResult);
    }

    private static boolean isUnicodeDesc(String currentBreakdownSubsection) {
        return Arrays.stream(CJKDescription.values())
                .map(CJKD -> String.valueOf(CJKD.getUnicodeCharacter())).collect(Collectors.toSet())
                .contains(currentBreakdownSubsection);
    }

    public static List<String> generateNormalCodeFromFullCode_4code(List<List<String>> fullCode,
                                                                    String originalInput) throws DataFormatException {
        List<String> result = new ArrayList<>();
        for (List<String> eachCode : fullCode) {
            String code = normalCodeFromFullCode_4code(eachCode, originalInput);
            result.add(code);
        }
        return result;
    }

    public static List<String> generateNormalCodeFromFullCode_5codeSecToLast(List<List<String>> fullCode,
                                                                             String originalInput) throws DataFormatException {
        List<String> result = new ArrayList<>();
        for (List<String> eachCode : fullCode) {
            String code = normalCodeFromFullCode_5code(eachCode, originalInput);
            result.add(code);
        }
        return result;
    }

    private static String normalCodeFromFullCode_4code(List<String> inputCode, String originalInput) throws DataFormatException {
        if (Objects.isNull(inputCode)) {
            return null;
        }
        //the full code is reversed by default. It needs to be corrected
        List<String> fullCode = new ArrayList<>(inputCode);
        Collections.reverse(fullCode);

        //ids breakup doesnt follow strokeorder. At some point, it might be nessasary to change it here.
        String resultingNormalCodes = extractFourCodes(fullCode);
        return resultingNormalCodes;
    }

    private static String normalCodeFromFullCode_5code(List<String> inputCode, String originalInput) throws DataFormatException {
        if (Objects.isNull(inputCode)) {
            return null;
        }
        //the full code is reversed by default. It needs to be corrected
        List<String> fullCode = new ArrayList<>(inputCode);
        Collections.reverse(fullCode);

        //ids breakup doesnt follow strokeorder. At some point, it might be nessasary to change it here.

        String resultingNormalCodes = extractFiveCodes(fullCode);
        return resultingNormalCodes;
    }

    private static String extractFiveCodes(List<String> fullCode) throws DataFormatException {   //filter our unicode character
        List<String> noNullAndNoUni = fullCode.stream()
                .filter(Objects::nonNull)
                .filter(code -> !code.isEmpty())
                .filter(code -> !isUnicodeDesc(code)).toList();
        // no code
        if (noNullAndNoUni.size() == 0) {
            return null;
        }
        //one code
        if (noNullAndNoUni.size() == 1) {
            return noNullAndNoUni.get(0);
        }
        //two codes
        if (noNullAndNoUni.size() == 2) {
            String oneone = noNullAndNoUni.get(0).substring(0, 1);
            String twoone = noNullAndNoUni.get(1).substring(0,1);
            String twotwo = noNullAndNoUni.get(1).substring(1);
            String oneTwo = noNullAndNoUni.get(0).substring(1);
            return oneone + twoone + twotwo + oneTwo;
        }

        //three codes
        if (noNullAndNoUni.size() == 3) {
            String oneone = noNullAndNoUni.get(0).substring(0, 1);
            String twoone = noNullAndNoUni.get(1).substring(0,1);
            String threeone = noNullAndNoUni.get(2).substring(0,1);
            String test = "";//noNullAndNoUni.get(2).substring(1);
            String last = "";

            String oneLast = noNullAndNoUni.get(0).substring(1);
            String twoLast = noNullAndNoUni.get(1).substring(1);
            String threeLast = noNullAndNoUni.get(2).substring(1);
            test = threeLast + twoLast + oneLast;
            if (test.length() < 3) {
                last = test;
            } else {
                last = test.substring(0,2);
            }
            return oneone + twoone + threeone + last;
        }

        //four
        if (noNullAndNoUni.size() == 4) {
            String oneone = noNullAndNoUni.get(0).substring(0, 1);
            String twoone = noNullAndNoUni.get(1).substring(0,1);
            String threeone = noNullAndNoUni.get(2).substring(0,1);
            String fourone = noNullAndNoUni.get(noNullAndNoUni.size()-1).substring(0,1);
            String test = "";
            String last = "";

            String oneLast = noNullAndNoUni.get(0).substring(1);
            String twoLast = noNullAndNoUni.get(1).substring(1);
            String threeLast = noNullAndNoUni.get(2).substring(1);
            String fourLast = noNullAndNoUni.get(3).substring(1);
            test = fourLast + threeLast + twoLast + oneLast;
            if (test.length() > 0) {
                last = test.substring(0,1);
            }
            return oneone + twoone + threeone + fourone + last;
        }

        //five+
        if (noNullAndNoUni.size() > 4) {
            String oneone = noNullAndNoUni.get(0).substring(0, 1);
            String twoone = noNullAndNoUni.get(1).substring(0,1);
            String threeone = noNullAndNoUni.get(2).substring(0,1);
            String seclast = noNullAndNoUni.get(noNullAndNoUni.size()-2).substring(0,1);
            String lastone = noNullAndNoUni.get(noNullAndNoUni.size()-1).substring(0,1);
            return oneone + twoone + threeone + seclast + lastone;
        }
        throw new DataFormatException("unhandled normal code code case");
    }

    private static String extractFourCodes(List<String> fullCode) throws DataFormatException {
        //filter our unicode character
        List<String> noNullAndNoUni = fullCode.stream()
                .filter(Objects::nonNull)
                .filter(code -> !code.isEmpty())
                .filter(code -> !isUnicodeDesc(code)).toList();
        // no code
        if (noNullAndNoUni.size() == 0) {
            return null;
        }
        //one code
        if (noNullAndNoUni.size() == 1) {
            return noNullAndNoUni.get(0);
        }
        //two codes
        if (noNullAndNoUni.size() == 2) {
            String oneone = noNullAndNoUni.get(0).substring(0, 1);
            String twoone = noNullAndNoUni.get(1).substring(0,1);
            String twotwo = noNullAndNoUni.get(1).substring(1);
            String oneTwo = noNullAndNoUni.get(0).substring(1);
            return oneone + twoone + twotwo + oneTwo;
        }

        //three codes
        if (noNullAndNoUni.size() == 3) {
            String oneone = noNullAndNoUni.get(0).substring(0, 1);
            String twoone = noNullAndNoUni.get(1).substring(0,1);
            String threeone = noNullAndNoUni.get(2).substring(0,1);
            String last = "";//noNullAndNoUni.get(2).substring(1);
            if (noNullAndNoUni.get(2).length() > 1) {
                last = noNullAndNoUni.get(2).substring(1);
            }else if (noNullAndNoUni.get(1).length() > 1){
                last = noNullAndNoUni.get(1).substring(1);
            }else {
                last = noNullAndNoUni.get(0).substring(1);
            }
            return oneone + twoone + threeone + last;
        }

        //four+
        if (noNullAndNoUni.size() > 3) {
            String oneone = noNullAndNoUni.get(0).substring(0, 1);
            String twoone = noNullAndNoUni.get(1).substring(0,1);
            String threeone = noNullAndNoUni.get(2).substring(0,1);
            String lastone = noNullAndNoUni.get(noNullAndNoUni.size()-1).substring(0,1);
            return oneone + twoone + threeone + lastone;
        }
        throw new DataFormatException("unhandled normal code code case");
    }
}
