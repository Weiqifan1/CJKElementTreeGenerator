package CustomDataGenerator;

import org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator.CodeRecursionObjectGenerator;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import static org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService.CJKDescElems;
import static org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService.unicodeBreakup;
import static org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator.CodeRecursionObjectGenerator.*;
import static org.example.GlobalConstants.publicHtradFilePath;
import static org.junit.Assert.assertEquals;

public class AYMethodCodeGeneratorServiceTest {

    @Test
    public void testRecursionCodes() {
        List<CharRecursionNode> nodelist = getNodeList();

        CharRecursionNode node1 = CodeRecursionObjectGenerator.getNodeByName("一", nodelist);
        CharRecursionNode node2 = CodeRecursionObjectGenerator.getNodeByName("二", nodelist);
        CharRecursionNode node3 = CodeRecursionObjectGenerator.getNodeByName("三", nodelist);

        assertEquals(16376, nodelist.size());
    }

    @Test
    public void listOfFirstElements() {
        List<CharRecursionNode> allnodes = getNodeList();
        List<CharRecursionNode> nodesFromPath = onlyNodesFromPath(allnodes, publicHtradFilePath);

        //get only char with description elem as first char
        List<CharRecursionNode> firstDesc = nodesFromPath.stream().filter(node -> descFirst(node)).toList();
        List<String> firstElem = firstDesc.stream().map(node -> getSecondElem(node)).toList();
        Map<String, Long> groupBy = firstElem.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> sortedmap = reverseSortedFirstElements(groupBy);

        String test = "";

        assertEquals(true, false);
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
        String subs = node.getSubsequentSubsections().get(0).getCurrentBreakdownSubsection();
        if (Objects.isNull(subs) || subs.length() < 1) {
            return null;
        }
        String firstSub = unicodeBreakup(subs).get(1);
        return firstSub;
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

    @Test
    public void countElements() {
        Map<String, Long> res = getWholeFullCodeSortedCount(publicHtradFilePath);
        Long withStr = res.get("oa");

        assertEquals(true, false);
    }

    @Test
    public void testFullCodeContent() {
        List<CharRecursionNode> res = getNodesFromPath_noDesc_fullCodeWholeTextMatch("laa", publicHtradFilePath);
        String test = "";
        assertEquals(true, false);
    }

    @Test
    public void testFirstLetterContent() {
        List<CharRecursionNode> res = CodeRecursionObjectGenerator.getNodesFromPath_noDesc_fullCodeFirstLettersMatch("laa", publicHtradFilePath);
        String test = "";
        assertEquals(true, false);
    }

    @Test
    public void testFullCodeEntryContent() {
        List<CharRecursionNode> res = getNodesFromPath_exactFullCodeEntryMatch("aa", publicHtradFilePath);
        String test = "";
        assertEquals(true, false);
    }

    @Test
    public void testGenerateFullCodeFromCodeMap_basic() throws DataFormatException {

        //的 1
        CharRecursionNode de1 = new CharRecursionNode("的", null);
        assertEquals(Set.of("lplh", "lpla"), de1.getNormalCode().stream().collect(Collectors.toSet()));

        //我 4
        CharRecursionNode wo4 = new CharRecursionNode("我", null);
        assertEquals(Set.of("lokh"), wo4.getNormalCode().stream().collect(Collectors.toSet()));
        //就 26
        CharRecursionNode jiu26 = new CharRecursionNode("就", null);
        assertEquals(Set.of("ha;h", "da;h"), jiu26.getNormalCode().stream().collect(Collectors.toSet()));

        //還 56
        CharRecursionNode hai56 = new CharRecursionNode("還", null);
        //n represent the 辶 stroke. For now, I will follow ids order, not stroke order for whole characters.
        //the codes for elements will still follow strokeorder, except for the normal array rules.
        assertEquals(Set.of("n/a."), hai56.getNormalCode().stream().collect(Collectors.toSet()));
    }



}
