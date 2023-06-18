package org.example.CharRecursionObjectGenerator;


import org.example.ObjectTypes.CharRecursionNode;

import java.util.*;

public class CharRecursionNodeService {

    public static Map<String, String> generateIdsMapResult(String currentBreakdownSubsection,
                                                           Map<String, Map<String, String>> customIds) {
        Map<String, String> mapResult = customIds.get(currentBreakdownSubsection);
        return mapResult;
    }

    public static List<CharRecursionNode> generateSubsections(String currentBreakdownSubsection,
                                                              Map<String, String> subsectionIdsMapResult,
                                                              Map<String, Map<String, String>> customIds) {

        if (Objects.isNull(subsectionIdsMapResult) || subsectionIdsMapResult.get("char").equals(currentBreakdownSubsection)) {
            CharRecursionNode node = new CharRecursionNode.Builder()
                    .withCurrentBreakdownSubsection(currentBreakdownSubsection)
                    .build();
            return List.of(node);
        }




        return new ArrayList<>();
    }
}
