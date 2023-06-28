package org.example.InputMethods.InputMethodCodeGenerators;

import org.example.ObjectTypes.GenericTypes.CJKDescription;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import static org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService.unicodeBreakup;

public class AYMethodCodeGeneratorService {
    public static List<String> generateFullCodeFromCodeMap(String currentBreakdownSubsection,
                                                           List<CharRecursionNode> subsequentSubsections,
                                                           HashMap<String, String> codeMap,
                                                           String originalInput) throws DataFormatException {

        boolean currentIsSingleChar = unicodeBreakup(currentBreakdownSubsection).size() < 2;
        boolean currentIsUnicode = isUnicodeDesc(currentBreakdownSubsection);
        String codeMapResult = codeMap.get(currentBreakdownSubsection);
        boolean allSubsectionsHasFullCode = allSubsectionsHasCodes(subsequentSubsections);

        if (currentIsUnicode) {
            return List.of(currentBreakdownSubsection);
        } else if (currentIsSingleChar
                && subsequentSubsections.size() == 0
                && Objects.nonNull(codeMapResult)) {
            return List.of(codeMapResult);
        } else if (currentIsSingleChar
                && subsequentSubsections.size() == 0) {
            //TODO: continue to implement missing codes
            String tes = "";
        }else if (allSubsectionsHasFullCode) {
            List<String> codesFromSubs = getCodesFromSubsections(subsequentSubsections);
            return codesFromSubs;
        }else {
            //throw new DataFormatException("missing codes from char: "+ originalInput);
        }
        return new ArrayList<>();

        //throw new DataFormatException("missing codes from char: "+ originalInput);

    }

    private static boolean isUnicodeDesc(String currentBreakdownSubsection) {
        return Arrays.stream(CJKDescription.values())
                .map(CJKD -> String.valueOf(CJKD.getUnicodeCharacter())).collect(Collectors.toSet())
                .contains(currentBreakdownSubsection);
    }

    private static List<String> getCodesFromSubsections(List<CharRecursionNode> subsequentSubsections) {
        if (Objects.isNull(subsequentSubsections)) {
            return new ArrayList<>();
        }
        //get full Codes from subsequent subsections
        List<String> fullCode = subsequentSubsections.stream()
                .map(recur -> recur.getFullCode())
                .filter(Objects::nonNull)
                .filter(code -> !code.isEmpty())
                .flatMap(Collection::stream).collect(Collectors.toList());

        //filter our unicode character
        List<String> noNullAndNoUni = fullCode.stream()
                .filter(Objects::nonNull)
                .filter(code -> !code.isEmpty())
                .filter(code -> !isUnicodeDesc(code)).toList();
        // no code
        if (noNullAndNoUni.size() == 0) {
            return new ArrayList<>();
        } else {
            return noNullAndNoUni;
        }
    }

    private static boolean allSubsectionsHasCodes(List<CharRecursionNode> subsequentSubsections) {
        boolean allSubsectionsHasFullCode = true;
        for (CharRecursionNode node : subsequentSubsections) {
            String current = node.getCurrentBreakdownSubsection();
            List<String> code = node.getFullCode();
            boolean isUnicode = isUnicodeDesc(current);
            if (Objects.isNull(code)) {
                return false;
            }
            if (!isUnicode && code.size() < 1) {
                allSubsectionsHasFullCode = false;
            }
        }
        return allSubsectionsHasFullCode;
    }

    public static String generateNormalCodeFromFullCode(List<String> fullCode) throws DataFormatException {
        String result = "";
        if (Objects.isNull(fullCode)) {
            return null;
        }
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
