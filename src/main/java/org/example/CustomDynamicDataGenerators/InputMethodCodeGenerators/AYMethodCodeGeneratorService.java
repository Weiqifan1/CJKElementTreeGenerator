package org.example.CustomDynamicDataGenerators.InputMethodCodeGenerators;

import org.example.ObjectTypes.GenericTypes.CJKDescription;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService.unicodeBreakup;

public class AYMethodCodeGeneratorService {
    public static List<String> generateFullCodeFromCodeMap(String currentBreakdownSubsection,
                                                           List<CharRecursionNode> subsequentSubsections,
                                                           HashMap<String, String> codeMap,
                                                           String originalInput) {

        boolean currentIsSingleChar = unicodeBreakup(currentBreakdownSubsection).size() < 2;
        boolean currentIsUnicode = Arrays.stream(CJKDescription.values())
                .map(CJKD -> String.valueOf(CJKD.getUnicodeCharacter())).collect(Collectors.toSet())
                .contains(currentBreakdownSubsection);
        String codeMapResult = codeMap.get(currentBreakdownSubsection);

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
        }else {
            String tes = "";
        }


        return null;
    }

    public static String generateNormalCodeFromFullCode(List<String> fullCode) {

        return null;
    }
}
