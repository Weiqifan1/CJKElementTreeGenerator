package org.example.CharRecursionObjectGenerator;


import org.example.ObjectTypes.CharMetaInfo;
import org.example.ObjectTypes.CharRecursionNode;

import java.util.*;

public class CharRecursionNodeService {

    public static Map<CharMetaInfo, String> generateIdsMapResult(String currentBreakdownSubsection,
                                                           Map<String, Map<CharMetaInfo, String>> customIds) {
        Map<CharMetaInfo, String> mapResult = customIds.get(currentBreakdownSubsection);
        return mapResult;
    }

    public static List<CharRecursionNode> generateSubsections(String currentBreakdownSubsection,
                                                              Map<CharMetaInfo, String> subsectionIdsMapResult,
                                                              Map<String, Map<CharMetaInfo, String>> customIds) {

        if (Objects.isNull(subsectionIdsMapResult) || subsectionIdsMapResult.get(CharMetaInfo.BREAKDOWN).equals(currentBreakdownSubsection)) {
            CharRecursionNode node = new CharRecursionNode.Builder()
                    .withCurrentBreakdownSubsection(currentBreakdownSubsection)
                    .build();
            return List.of(node);
        }

        String breakdownList = subsectionIdsMapResult.get(CharMetaInfo.BREAKDOWN);





        return new ArrayList<>();
    }


}
