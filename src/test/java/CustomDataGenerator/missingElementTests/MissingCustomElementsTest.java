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
import static org.example.InputMethods.CustomStrokeCollections.*;
import static org.example.InputMethods.InputMethodCodeGenerators.AYMethodCodeGeneratorService.nodeListToMap;
import static org.example.InputMethods.InputMethodData.AYmethodInputData.*;
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
        nodelist = getNodeList(CodeDecompositionType.CODE5_123zy_LIMMITBACKTRACK, false);
        nodeMap = nodeListToMap(nodelist);
        codeMap = AYmethodInputData.arrayInspiredElemsV1;
        idsMap = CustomDataReader.getCustomIdsMap(customIdsJsonMapPath);
        nodelistTrad_3500x = onlyNodesFromPathAndBelowNumber(nodelist, publicHtradFilePath, 3500, CharacterSet.MANDARINTRADITIONAL);
        nodelistSimp_3500x = onlyNodesFromPathAndBelowNumber(nodelist, publicHsimpFilePath, 3500, CharacterSet.MANDARINSIMPLIFIED);
    }

    @Test
    public void leftSideHandAndLeftFoot() {
        List<String> elemsThatCanBeRemoved = findElemsWithSameOrLessOverlap(
                CodeDecompositionType.CODE5_123zy_LIMMITBACKTRACK,
                nodelistTrad_3500x, false);

        CharRecursionNode leftSideHand = nodeMap.get("投");
        CharRecursionNode leftSideLeftFoot = nodeMap.get("役");
        assertNotEquals(leftSideHand.getNormalCode(), leftSideLeftFoot.getNormalCode());
    }

    //CodeDecompositionType.CODE5_123zy_LIMMITBACKTRACK //nodelistTrad_3500x
    private List<String> findElemsWithSameOrLessOverlap(CodeDecompositionType decom,
                                                        List<CharRecursionNode> nodeListTypeWithNumber,
                                                        boolean showOverlapInfo) {
        List<String> codeElemsThatCanBeRemoved = new ArrayList<>();
        Map<String, List<CharRecursionNode>> overlapNoMising = overlapMapByNormalCode(nodeListTypeWithNumber);
        int baseOverlaps = overlapNoMising.size();
        Set<String> codeElementList = codeMap.keySet();
        for (String codeElement : codeElementList) {
            List<CharRecursionNode> nodesForMissingElem = getNodesWithItemRemoved(codeElement, decom, nodeListTypeWithNumber, showOverlapInfo);
            Map<String, List<CharRecursionNode>> overlapWithMissingChar = overlapMapByNormalCode(nodesForMissingElem);
            int missingCharOverlap = overlapWithMissingChar.size();
            if (baseOverlaps <= missingCharOverlap) {
                codeElemsThatCanBeRemoved.add(codeElement);
            }
        }
        return codeElemsThatCanBeRemoved;
    }

    //CodeDecompositionType.CODE5_123zy_LIMMITBACKTRACK //nodelistTrad_3500x
    private List<CharRecursionNode> getNodesWithItemRemoved(String elementToRemove,
                                                            CodeDecompositionType decom,
                                                            List<CharRecursionNode> nodeListTypeWithNumber,
                                                            boolean showOverlapInfo) {
        List<String> relevantNodeListCharacters = nodeListTypeWithNumber.stream()
                .filter(node -> nodeHasElement_onlyOneVersionPrChar(elementToRemove, node))
                .map(node -> node.getCurrentBreakdownSubsection()).toList();
        List<CharRecursionNode> remainingNodeListCharacters = nodeListTypeWithNumber.stream()
                .filter(node -> !nodeHasElement_onlyOneVersionPrChar(elementToRemove, node)).collect(Collectors.toList());
        //create a new ids map with one key less
        Map<String, String> codeMapSansOneChar = removeKey(elementToRemove, codeMap);
        codeMapSansOneChar.putAll(coreElements());

        List<CharRecursionNode> smallCharSample = getNodeList(
                decom, relevantNodeListCharacters, null, codeMapSansOneChar, showOverlapInfo);
        remainingNodeListCharacters.addAll(smallCharSample);
        return remainingNodeListCharacters;
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

    private Map<String, String> coreElements() {

        HashMap<String, String> core = new HashMap<>();
        core.put("一", arrayInspiredElemsV1.get("一"));
        core.put("⺄", arrayInspiredElemsV1.get("⺄"));
        core.put("乁", arrayInspiredElemsV1.get("乁"));
        core.put("𡿨", arrayInspiredElemsV1.get("𡿨"));
        core.put("𠃋", arrayInspiredElemsV1.get("𠃋"));
        core.put("𠃊", arrayInspiredElemsV1.get("𠃊"));
        core.put(RIGHTBENTBUTHOOK_LARGE.val(), arrayInspiredElemsV1.get(RIGHTBENTBUTHOOK_LARGE.val()));
        core.put(RIGHTBENTBUT_SHARP.val(), arrayInspiredElemsV1.get(RIGHTBENTBUT_SHARP.val()));
        core.put(DOWNWITHHOOK.val(), arrayInspiredElemsV1.get(DOWNWITHHOOK.val()));
        core.put(DOUBLEBENT_25_WITHHOOK.val(), arrayInspiredElemsV1.get(DOUBLEBENT_25_WITHHOOK.val()));
        core.put(DOUBLEBENT_25_NOHOOK.val(), arrayInspiredElemsV1.get(DOUBLEBENT_25_NOHOOK.val()));

        core.put("丨", arrayInspiredElemsV1.get("丨"));
        core.put("亅", arrayInspiredElemsV1.get("亅"));
        //core.put("刂", arrayInspiredElemsV1.get("刂"));

        core.put("十", arrayInspiredElemsV1.get("十"));
        //core.put("𠂇", arrayInspiredElemsV1.get("𠂇"));

        core.put("乛", arrayInspiredElemsV1.get("乛"));
        core.put(BENTTOPHOOK_LARGE.val(), arrayInspiredElemsV1.get(BENTTOPHOOK_LARGE.val()));//"𠃌" g=5 有万令
        core.put(BENTTOP_SHARP.val(), arrayInspiredElemsV1.get(BENTTOP_SHARP.val()));//𠃍 eg.過
        core.put(BENTTOP_ROUND.val(), arrayInspiredElemsV1.get(BENTTOP_ROUND.val()));//㇇ from 永

        core.put(DOUBLEBENT_55.val(), arrayInspiredElemsV1.get(DOUBLEBENT_55.val()));// ㇋ DOUBLEBENT_52
        core.put(DOUBLEBENT_55_WITHHOOK.val(), arrayInspiredElemsV1.get(DOUBLEBENT_55_WITHHOOK.val())); //DOUBLEBENT_55_WITHHOOK("𠄎", true), //𠄎 eg 仍
        core.put(DOUBLEBENT_52NOHOOK.val(), arrayInspiredElemsV1.get(DOUBLEBENT_52NOHOOK.val()));//㇈ eg 凹
        core.put(DOUBLEBENT_52WITHHOOK.val(), arrayInspiredElemsV1.get(DOUBLEBENT_52WITHHOOK.val()));//㇠

        core.put(DOTLEFT.val(), arrayInspiredElemsV1.get(DOTLEFT.val()));//、 eg. 自
        core.put(DOTRIGHT.val(), arrayInspiredElemsV1.get(DOTRIGHT.val())); //h=6  // 兎 ⿱丿⿷⑤丶  匆 ⿻勿丶 ⿹勹⿻⿱丿丿丶
        core.put("冖", arrayInspiredElemsV1.get("冖"));
        core.put(OUTER2TOP_STRAIGHT.val(), arrayInspiredElemsV1.get(OUTER2TOP_STRAIGHT.val()));//j=5 冂 from 向 南 or mine: 身
        core.put(OUTER2TOP_USEANDMOONE.val(), arrayInspiredElemsV1.get(OUTER2TOP_USEANDMOONE.val()));//j=5 ⺆  from 用 周

        core.put("㇂", arrayInspiredElemsV1.get("㇂"));
        core.put("乀", arrayInspiredElemsV1.get("乀"));
        core.put(RIGHTSLANT_WITHHOOK.val(), arrayInspiredElemsV1.get(RIGHTSLANT_WITHHOOK.val()));

        core.put("八", arrayInspiredElemsV1.get("八"));
        core.put("丷", arrayInspiredElemsV1.get("丷"));
        core.put("入", arrayInspiredElemsV1.get("入"));
        core.put(LEFTSLANT_HORI.val(), arrayInspiredElemsV1.get(LEFTSLANT_HORI.val()));
        core.put(LEFTSLANT_SHARP.val(), arrayInspiredElemsV1.get(LEFTSLANT_SHARP.val()));
        core.put(LEFTSlANT_VERT.val(), arrayInspiredElemsV1.get(LEFTSlANT_VERT.val()));
        core.put("口", arrayInspiredElemsV1.get("口"));
        core.put("囗", arrayInspiredElemsV1.get("囗"));

        return core;
    }


}
