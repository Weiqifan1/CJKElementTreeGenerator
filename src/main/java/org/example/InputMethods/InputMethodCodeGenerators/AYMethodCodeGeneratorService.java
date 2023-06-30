package org.example.InputMethods.InputMethodCodeGenerators;

import org.example.ObjectTypes.GenericTypes.CJKDescription;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import static org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService.unicodeBreakup;

public class AYMethodCodeGeneratorService {
    public static List<List<String>> generateFullCodeFromCodeMap(String currentBreakdownSubsection,
                                                           List<CharRecursionNode> subsequentSubsections,
                                                           HashMap<String, String> codeMap,
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
            //throw new DataFormatException("missing codes from char: "+ originalInput);
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

    private static List<List<String>> nonForkFullCodeRecur(List<CharRecursionNode> subsequentSubsections, List<List<String>> result) {
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

    public static List<String> generateNormalCodeFromFullCode(List<List<String>> fullCode, String originalInput) throws DataFormatException {
        List<String> result = new ArrayList<>();
        for (List<String> eachCode : fullCode) {
            String code = normalCodeFromFullCode(eachCode, originalInput);
            result.add(code);
        }
        return result;
    }

    private static String normalCodeFromFullCode(List<String> inputCode, String originalInput) throws DataFormatException {
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
            String threeTwo = noNullAndNoUni.get(2).substring(1);
            return oneone + twoone + threeone + threeTwo;
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
