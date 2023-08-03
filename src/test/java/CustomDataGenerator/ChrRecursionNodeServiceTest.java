package CustomDataGenerator;

import org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService;
import org.example.CustomDataHandler.CustomDataReader;
import org.example.ObjectTypes.GenericTypes.CharMetaInfo;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.GenericTypes.CodeDecompositionType;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService.handleSubsectionPathways;
import static org.example.GlobalConstants.customIdsJsonMapPath;
import static org.junit.Assert.assertEquals;

public class ChrRecursionNodeServiceTest {

    @Test
    public void testGetNestedSubstrings_noDescriptionCharacters() throws Exception {
        //Given
        Map<String, Map<CharMetaInfo, String>> customIds = CustomDataReader.getCustomIdsMap(customIdsJsonMapPath);
        List<String> input = List.of("几", "一", "𠂊" , "⺀", "王");
        String inputToOne = String.join("", input);

        //When
        List<CharRecursionNode> res = handleSubsectionPathways(
                inputToOne,  null, CodeDecompositionType.CODE4_123z_LIMMITBACKTRACK);

        //Then
        assertEquals(5, res.size());
    }

    @Test
    public void testRecursionObjectGeneratorService() throws Exception {

        Map<String, Map<CharMetaInfo, String>> customIds = CustomDataReader.getCustomIdsMap(customIdsJsonMapPath);
        List<String> input = List.of("⿵", "几", "⿳", "一", "⿴", "𠂊" , "⺀", "王");

        CharRecursionNode res = CharRecursionNodeService.getNestedSubstrings(
                input, customIds, null,
                CodeDecompositionType.CODE4_123z_LIMMITBACKTRACK);

        assertEquals(8, CharRecursionNodeService.unicodeBreakup(res.getCurrentBreakdownSubsection()).size());
        assertEquals(3, res.getSubsequentSubsections().size());
        assertEquals("⿵", res.getSubsequentSubsections().get(0).getCurrentBreakdownSubsection());
        assertEquals("几", res.getSubsequentSubsections().get(1).getCurrentBreakdownSubsection());
        assertEquals(0, res.getSubsequentSubsections().get(1).getSubsequentSubsections().size());

        assertEquals("⿳一⿴𠂊⺀王", res.getSubsequentSubsections().get(2).getCurrentBreakdownSubsection());
        assertEquals(4, res.getSubsequentSubsections().get(2).getSubsequentSubsections().size());
        assertEquals("⿳", res.getSubsequentSubsections().get(2).getSubsequentSubsections().get(0).getCurrentBreakdownSubsection());
        assertEquals("一", res.getSubsequentSubsections().get(2).getSubsequentSubsections().get(1).getCurrentBreakdownSubsection());
        assertEquals("⿴𠂊⺀", res.getSubsequentSubsections().get(2).getSubsequentSubsections().get(2).getCurrentBreakdownSubsection());

        assertEquals("王",
                res.getSubsequentSubsections().get(2)
                .getSubsequentSubsections().get(3).getCurrentBreakdownSubsection());
        assertEquals(1,
                res.getSubsequentSubsections().get(2)
                        .getSubsequentSubsections().get(3)
                        .getSubsequentSubsections().size());
        assertEquals("⿱一土",
                res.getSubsequentSubsections().get(2)
                .getSubsequentSubsections().get(3)
                .getSubsequentSubsections().get(0)
                .getCurrentBreakdownSubsection());
        assertEquals(3, res.getSubsequentSubsections().get(2)
                .getSubsequentSubsections().get(3)
                .getSubsequentSubsections().get(0)
                .getSubsequentSubsections().size());
    }
}
