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
        boolean currentIsUnicode = Arrays.stream(CJKDescription.values())
                .map(CJKD -> String.valueOf(CJKD.getUnicodeCharacter())).collect(Collectors.toSet())
                .contains(currentBreakdownSubsection);
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
            throw new DataFormatException("missing codes from char: "+ originalInput);
        }


        return null;
    }

    private static List<String> getCodesFromSubsections(List<CharRecursionNode> subsequentSubsections) {
        //TODO: write method
        return null;
    }

    private static boolean allSubsectionsHasCodes(List<CharRecursionNode> subsequentSubsections) {
        //TODO: write method
        return false;
    }

    public static String generateNormalCodeFromFullCode(List<String> fullCode) {

        return null;
    }
}
