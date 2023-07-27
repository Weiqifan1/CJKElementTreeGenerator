package CustomDataGenerator.AYMethodTestPackage;

import org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator.CodeRecursionObjectGenerator;
import org.example.InputMethods.InputMethodCodeGenerators.AYMethodCodeGeneratorService;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.GenericTypes.CodeDecompositionType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import static org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService.CJKDescElems;
import static org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService.unicodeBreakup;
import static org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator.CodeRecursionObjectGenerator.getNodeList;
import static org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator.CodeRecursionObjectGenerator.onlyNodesFromPath;
import static org.example.GlobalConstants.publicHtradFilePath;
import static org.example.InputMethods.InputMethodCodeGenerators.AYMethodCodeGeneratorService.nodeListToMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AYMethodCodeGeneratorServiceTest {

    private static List<CharRecursionNode> nodelist;
    private static Map<String, CharRecursionNode> nodeMap;

    @BeforeClass
    public static void setUp() {
        nodelist = getNodeList(CodeDecompositionType.CODE5_123zy_LIMMITBACKTRACK);
        nodeMap = nodeListToMap(nodelist);
    }

    @Test
    public void testRecursionCodes() {
        CharRecursionNode node1 = CodeRecursionObjectGenerator.getNodeByName("一", nodelist);
        CharRecursionNode node2 = CodeRecursionObjectGenerator.getNodeByName("二", nodelist);
        CharRecursionNode node3 = CodeRecursionObjectGenerator.getNodeByName("三", nodelist);

        CharRecursionNode test1 = CodeRecursionObjectGenerator.getNodeByName("撞", nodelist);

        assertTrue(nodelist.size() >= 7348);
    }

    @Test
    public void listOfFirstElementsAndDoubleNested() {
        Map<String, Long> firstElem = sortedFirstElem();
        Map<String, Long> doubleNestedAccumulated = sortedDoubleNested();

        //at time of writing the size of the map is 958,  but the size might change slightly and thats ok
        assertTrue(firstElem.size() >= 900);
        assertTrue(Objects.nonNull(firstElem.get("扌")));
        assertTrue(firstElem.get("扌") == 149l);
    }

    @Test
    public void trad3039HeisigOverlap() {
        List<CharRecursionNode> nodesFromPath = onlyNodesFromPath(nodelist, publicHtradFilePath);
        Set<String> nodeNormalSet = nodesFromPath.stream().map(node -> node.getNormalCode().get(0)).collect(Collectors.toSet());
        assertTrue(nodeNormalSet.size() == 3039);
        assertTrue(nodeNormalSet.size() == nodesFromPath.size());
    }
    
    private Map<String, Long> sortedFirstElem() {
        List<CharRecursionNode> nodesFromPath = onlyNodesFromPath(nodelist, publicHtradFilePath);
        //get only char with description elem as first char
        List<CharRecursionNode> firstDesc = nodesFromPath.stream().filter(node -> descFirst(node)).toList();
        List<String> firstElem = firstDesc.stream().map(node -> getSecondElem(node)).toList();
        Map<String, Long> groupBy = firstElem.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> sortedmap = reverseSortedFirstElements(groupBy);
        return sortedmap;
    }

    private Map<String, Long> sortedDoubleNested() {
        List<CharRecursionNode> nodesFromPath = onlyNodesFromPath(nodelist, publicHtradFilePath);
        //create a list of strings with all double nested elements
        List<List<String>> doubleNestedElements = nodesFromPath.stream().map(node -> getDoubleNestedElemsFromNode(node)).toList();
        List<String> flattened = flattenListOfListsImperatively(doubleNestedElements);
        Map<String, Long> groupBy = flattened.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> sortedmap = reverseSortedFirstElements(groupBy);
        return sortedmap;
    }

    private List<String> getDoubleNestedElemsFromNode(CharRecursionNode node) {
        List<CharRecursionNode> subs = node.getSubsequentSubsections(); 
        if (Objects.isNull(subs) || subs.size() == 0) {
            return List.of(node.getCurrentBreakdownSubsection());
        }else {
            List<List<CharRecursionNode>> nextnested = subs.stream()
                    .map(nextnode -> nextnode.getSubsequentSubsections())
                    .filter(nextsub -> Objects.nonNull(nextsub)).collect(Collectors.toList());
            List<CharRecursionNode> flattened = flattenListOfListsImperatively(nextnested);

            List<List<String>> convertToString = flattened.stream()
                    .map(nextnode -> getBreakdown(nextnode)).collect(Collectors.toList());
            List<String> firstGenConversion = flattenListOfListsImperatively(convertToString);

            //double nested
            List<List<CharRecursionNode>> doubleNested = flattened.stream()
                    .map(nextnode -> nextnode.getSubsequentSubsections())
                    .filter(nextsub -> Objects.nonNull(nextsub)).collect(Collectors.toList());
            List<CharRecursionNode> doubleFlattened = flattenListOfListsImperatively(doubleNested);

            List<List<String>> convertToStringDouble = doubleFlattened.stream()
                    .map(nextnode -> getBreakdown(nextnode)).collect(Collectors.toList());
            List<String> secondGenConversion = flattenListOfListsImperatively(convertToStringDouble);
            secondGenConversion.addAll(firstGenConversion);

            secondGenConversion.add(node.getCurrentBreakdownSubsection());
            Set<String> result = unicodeBreakup(String.join("", secondGenConversion)).stream().collect(Collectors.toSet());
            return result.stream().toList();
        }
    }

    private List<String> getBreakdown(CharRecursionNode node) {
        List<CharRecursionNode> subs = node.getSubsequentSubsections();
        if (Objects.isNull(subs)) {
            return List.of(node.getCurrentBreakdownSubsection());
        } else {
            return List.of(node.getCurrentBreakdownSubsection());
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> reverseSortedFirstElements(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    
    private String getSecondElem(CharRecursionNode node) {
        if (Objects.isNull(node.getSubsequentSubsections()) || node.getSubsequentSubsections().size() < 1) {
            return null;
        }
        CharRecursionNode secondSub = node.getSubsequentSubsections().get(0);
        if (Objects.isNull(secondSub.getSubsequentSubsections()) || secondSub.getSubsequentSubsections().size() < 2) {
            String test = "";
        }
        CharRecursionNode nestedSecSub = secondSub.getSubsequentSubsections().get(1);
        return nestedSecSub.getCurrentBreakdownSubsection();
    }

    private boolean descFirst(CharRecursionNode node) {
        if (Objects.isNull(node.getSubsequentSubsections()) || node.getSubsequentSubsections().size() < 1) {
            return false;
        }
        String subs = node.getSubsequentSubsections().get(0).getCurrentBreakdownSubsection();
        if (Objects.isNull(subs) || subs.length() < 1) {
            return false;
        }
        String firstSub = unicodeBreakup(subs).get(0);
        List<String> isDEsc = CJKDescElems(List.of(firstSub));
        if (isDEsc.size() > 0) {
            return true;
        }else {
            return false;
        }
    }
/*
    @Test
    public void countElements() {
        Map<String, Long> res = getWholeFullCodeSortedCount(publicHtradFilePath, CodeDecompositionType.CODE5_123zy_LIMMITBACKTRACK);
        Long withStr = res.get("oa");

        assertEquals(true, false);
    }*/
/*
    @Test
    public void testFullCodeContent() {
        List<CharRecursionNode> res = getNodesFromPath_noDesc_fullCodeWholeTextMatch(
                "laa", publicHtradFilePath,
                CodeDecompositionType.CODE4_123z_LIMMITBACKTRACK);
        String test = "";
        assertEquals(true, false);
    }*/
/*
    @Test
    public void testFirstLetterContent() {
        List<CharRecursionNode> res = CodeRecursionObjectGenerator.getNodesFromPath_noDesc_fullCodeFirstLettersMatch(
                "laa", publicHtradFilePath,
                CodeDecompositionType.CODE4_123z_LIMMITBACKTRACK);
        String test = "";
        assertEquals(true, false);
    }*/
/*
    @Test
    public void testFullCodeEntryContent() {
        List<CharRecursionNode> res = getNodesFromPath_exactFullCodeEntryMatch(
                "aa", publicHtradFilePath,
                CodeDecompositionType.CODE4_123z_LIMMITBACKTRACK);
        String test = "";
        assertEquals(true, false);
    }*/
/*
    @Test
    public void testGenerateFullCodeFromCodeMap_basic() throws DataFormatException {

        //的 1
        CharRecursionNode de1 = new CharRecursionNode(
                "的", null,
                CodeDecompositionType.CODE4_123z_LIMMITBACKTRACK);
        assertEquals(Set.of("lplh", "lpla"), de1.getNormalCode().stream().collect(Collectors.toSet()));

        //我 4
        CharRecursionNode wo4 = new CharRecursionNode(
                "我", null,
                CodeDecompositionType.CODE4_123z_LIMMITBACKTRACK);
        assertEquals(Set.of("lokh"), wo4.getNormalCode().stream().collect(Collectors.toSet()));
        //就 26
        CharRecursionNode jiu26 = new CharRecursionNode(
                "就", null,
                CodeDecompositionType.CODE4_123z_LIMMITBACKTRACK);
        assertEquals(Set.of("ha;h", "da;h"), jiu26.getNormalCode().stream().collect(Collectors.toSet()));

        //還 56
        CharRecursionNode hai56 = new CharRecursionNode(
                "還", null,
                CodeDecompositionType.CODE4_123z_LIMMITBACKTRACK);
        //n represent the 辶 stroke. For now, I will follow ids order, not stroke order for whole characters.
        //the codes for elements will still follow strokeorder, except for the normal array rules.
        assertEquals(Set.of("n/a."), hai56.getNormalCode().stream().collect(Collectors.toSet()));
    }*/



    @Test
    public void testGenerateNormalCodeFromFullCode_4code_DoubleLetters() throws DataFormatException {
        List<List<String>> fullCode = List.of(List.of(
                "kk", "ra", "jj", "⿻", "aa", "dd", "ff", "⿻", "⿱", "⿳", "v.", "⿰"));
        List<String> result = AYMethodCodeGeneratorService.generateNormalCodeFromFullCode_4code(fullCode, "横");
        assertEquals(List.of("vfdk"),result);
    }

    @Test
    public void testGenerateNormalCodeFromFullCode_4code_DoubleAndSingleLetters_2codes() throws DataFormatException {
        List<List<String>> fullCode = List.of(List.of(
                "k", "v.", "⿰"));
        List<String> result = AYMethodCodeGeneratorService.generateNormalCodeFromFullCode_4code(fullCode, "横");
        assertEquals(List.of("vk."),result);
    }

    @Test
    public void testGenerateNormalCodeFromFullCode_4code_DoubleAndSingleLetters_3codes() throws DataFormatException {
        List<List<String>> fullCode = List.of(List.of(
                "k", "ar", "⿱", "v.", "⿰"));
        List<String> result = AYMethodCodeGeneratorService.generateNormalCodeFromFullCode_4code(fullCode, "横");
        assertEquals(List.of("vakr"),result);
    }

    @Test
    public void testGenerateNormalCodeFromFullCode_5codeSecToLast_DoubleCodes() throws DataFormatException {
        List<List<String>> fullCode = List.of(List.of(
                "kr", "ra", "jj", "⿻", "aa", "dd", "ff", "⿻", "⿱", "⿳", "v.", "⿰"));
        List<String> result = AYMethodCodeGeneratorService.generateNormalCodeFromFullCode_5codeSecToLast(fullCode, "横");
        assertEquals(List.of("vfdrk"),result);
    }

    @Test
    public void testGenerateNormalCodeFromFullCode_5codeSecToLast_3single() throws DataFormatException {
        List<List<String>> fullCode = List.of(List.of(
                "k", "r", "v"));
        List<String> result = AYMethodCodeGeneratorService.generateNormalCodeFromFullCode_5codeSecToLast(fullCode, "横");
        assertEquals(List.of("vrk"),result);
    }

    @Test
    public void testGenerateNormalCodeFromFullCode_5codeSecToLast_4doublecode() throws DataFormatException {
        List<List<String>> fullCode = List.of(List.of(
                "ko", "ra", "fe", "⿻", "⿱", "v.", "⿰"));
        List<String> result = AYMethodCodeGeneratorService.generateNormalCodeFromFullCode_5codeSecToLast(fullCode, "横");
        assertEquals(List.of("vfrko"),result);
    }

    @Test
    public void testGenerateNormalCodeFromFullCode_5codeSecToLast_4doubleAndSingle() throws DataFormatException {
        List<List<String>> fullCode = List.of(List.of(
                "k", "r", "fe", "⿻", "⿱", "v.", "⿰"));
        List<String> result = AYMethodCodeGeneratorService.generateNormalCodeFromFullCode_5codeSecToLast(fullCode, "横");
        assertEquals(List.of("vfrke"),result);
    }

    @Test
    public void testGenerateNormalCodeFromFullCode_5codeSecToLast_4onlySingle() throws DataFormatException {
        List<List<String>> fullCode = List.of(List.of(
                "k", "r", "f", "⿻", "⿱", "v", "⿰"));
        List<String> result = AYMethodCodeGeneratorService.generateNormalCodeFromFullCode_5codeSecToLast(fullCode, "横");
        assertEquals(List.of("vfrk"),result);
    }

    @Test
    public void testGenerateNormalCodeFromFullCode_5codeSecToLast_4Oor5FirstCodeHas2() throws DataFormatException {
        List<List<String>> fullCode = List.of(List.of("k", "l", "⿻", ";", "⿱", "kk", "⿰")); //况竞兑
        List<String> result = AYMethodCodeGeneratorService.generateNormalCodeFromFullCode_5codeSecToLast(fullCode, "况");
        assertEquals(List.of("k;lkk"),result);
    }

    //况竞兑
    public <T> List<T> flattenListOfListsImperatively(
            List<List<T>> nestedList) {
        List<T> ls = new ArrayList<>();
        nestedList.forEach(ls::addAll);
        return ls;
    }
}
