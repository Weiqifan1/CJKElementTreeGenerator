package CustomDataGenerator.missingElementTests;

import org.example.CustomDataHandler.CustomDataReader;
import org.example.InputMethods.InputMethodData.AYmethodInputData;
import org.example.ObjectTypes.GenericTypes.CharMetaInfo;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.GenericTypes.CharacterSet;
import org.example.ObjectTypes.GenericTypes.CodeDecompositionType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator.CodeRecursionObjectGenerator.*;
import static org.example.GlobalConstants.*;
import static org.example.InputMethods.InputMethodCodeGenerators.AYMethodCodeGeneratorService.nodeListToMap;
import static org.junit.Assert.assertNotEquals;

public class MissingCustomElementsTest {

    private static List<CharRecursionNode> nodelist;
    private static Map<String, CharRecursionNode> nodeMap;
    private static Map<String, String> codeMap;
    private static Map<String, Map<CharMetaInfo, String>> idsMap;
    private static List<CharRecursionNode> nodelist_HeisigTrad;
    private static List<CharRecursionNode> nodelist_HeisigSimp;
    private static List<CharRecursionNode> nodelistTrad_3500x;
    private static List<CharRecursionNode> nodelistSimp_3500x;
    @BeforeClass
    public static void setUp() throws Exception {
        nodelist = getNodeList(CodeDecompositionType.CODE5_123zy_LIMMITBACKTRACK);
        nodeMap = nodeListToMap(nodelist);
        codeMap = AYmethodInputData.arrayInspiredElemsV1;
        idsMap = CustomDataReader.getCustomIdsMap(customIdsJsonMapPath);
        nodelistTrad_3500x = onlyNodesFromPathAndBelowNumber(nodelist, publicHtradFilePath, 3500, CharacterSet.MANDARINTRADITIONAL);
        nodelistSimp_3500x = onlyNodesFromPathAndBelowNumber(nodelist, publicHsimpFilePath, 3500, CharacterSet.MANDARINSIMPLIFIED);
    }

    @Test
    public void testtest() {
        CharRecursionNode test = nodeMap.get("逸");

        String test2 = "";
    }

    @Test
    public void leftSideHandAndLeftFoot() {
        //create a new map of all custom elements except one

        Set<String> codeMapElems = codeMap.keySet();
        //retrieve all characterws in nodelist that contains the missing elements
        List<String> relevantNodeListCharacters = nodelistTrad_3500x.stream()
                .filter(node -> nodeHasElement_onlyOneVersionPrChar("言", node))
                .map(node -> node.getCurrentBreakdownSubsection()).toList();
        List<CharRecursionNode> remainingNodeListCharacters = nodelistTrad_3500x.stream()
                .filter(node -> !nodeHasElement_onlyOneVersionPrChar("言", node)).collect(Collectors.toList());
        //create a new ids map with one key less
        Map<String, String> codeMapSansOneChar = removeKey("言", codeMap);
        List<CharRecursionNode> smallCharSample = getNodeList(
                CodeDecompositionType.CODE5_123zy_LIMMITBACKTRACK,
                relevantNodeListCharacters, null, codeMapSansOneChar);
        remainingNodeListCharacters.addAll(smallCharSample);
        Map<String, List<CharRecursionNode>> overlaps = overlapMapByNormalCode(remainingNodeListCharacters);

        List<CharRecursionNode> firstChar = remainingNodeListCharacters.stream()
                .filter(node -> relevantNodeListCharacters.contains(node.getCurrentBreakdownSubsection())).collect(Collectors.toList());

        CharRecursionNode leftSideHand = nodeMap.get("投");
        CharRecursionNode leftSideLeftFoot = nodeMap.get("役");
        assertNotEquals(leftSideHand.getNormalCode(), leftSideLeftFoot.getNormalCode());
    }

    private boolean nodeHasElement_onlyOneVersionPrChar(String element, CharRecursionNode node) {
        Set<String> allRecurNodeSubsections = getAllSubsequentRec_onlyOneVersPrChar(node, new HashSet<>());
        return allRecurNodeSubsections.contains(element);
    }

    private Set<String> getAllSubsequentRec_onlyOneVersPrChar(CharRecursionNode node, Set<String> acc) {
        if (node == null) {
            return acc;
        }
        acc.add(node.getCurrentBreakdownSubsection());
        if (node.getSubsequentSubsections() != null
                && !node.getSubsequentSubsections().isEmpty()
                && !node.getCurrentBreakdownSubsection().contains(" ")) {
            for (CharRecursionNode element : node.getSubsequentSubsections()) {
                getAllSubsequentRec_onlyOneVersPrChar(element, acc);
            }
        } else if (node.getSubsequentSubsections() != null
                && !node.getSubsequentSubsections().isEmpty() ) {
            getAllSubsequentRec_onlyOneVersPrChar(node.getSubsequentSubsections().get(0), acc);
        }
        return acc;
    }

    public static Map<String, Map<CharMetaInfo, String>> removeIdsKey(String keyStr, Map<String, Map<CharMetaInfo, String>> idsMap) {
        Map<String, Map<CharMetaInfo, String>> newMap = new HashMap<>();
        for (Map.Entry<String, Map<CharMetaInfo, String>> entry : idsMap.entrySet()) {
            if (!entry.getKey().equals(keyStr)) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        return newMap;
    }

    public static Map<String, String> removeKey(String key, Map<String, String> map) {
        Map<String, String> newMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!entry.getKey().equals(key)) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        return newMap;
    }


}
