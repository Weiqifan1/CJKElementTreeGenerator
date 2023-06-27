package CustomDataGenerator;

import org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService;
import org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.RecursionObjectGeneratorService;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.junit.Test;

import java.util.List;
import java.util.zip.DataFormatException;

import static org.junit.Assert.assertEquals;

public class RecursionObjectGeneratorServiceTest {

    @Test
    public void testRecursionObjectGeneratorService_basic() throws DataFormatException {
        //的
        CharRecursionNode obj = new CharRecursionNode("的");

        assertEquals(1, obj.getSubsequentSubsections().size());
        assertEquals("⿰白勺", obj.getSubsequentSubsections().get(0).getCurrentBreakdownSubsection());

        assertEquals("白", obj.getSubsequentSubsections().get(0).getSubsequentSubsections().get(1).getCurrentBreakdownSubsection());
        assertEquals(0, obj.getSubsequentSubsections().get(0).getSubsequentSubsections().get(1).getSubsequentSubsections().size());

        assertEquals("勺", obj.getSubsequentSubsections().get(0).getSubsequentSubsections().get(2).getCurrentBreakdownSubsection());
        assertEquals(1, obj.getSubsequentSubsections().get(0).getSubsequentSubsections().get(2).getSubsequentSubsections().size());

        assertEquals("⿹勹丶 ⿹勹一", obj.getSubsequentSubsections()
                .get(0).getSubsequentSubsections()
                .get(2).getSubsequentSubsections()
                .get(0).getCurrentBreakdownSubsection());
        List<CharRecursionNode> highlyNested = obj.getSubsequentSubsections()
                .get(0).getSubsequentSubsections()
                .get(2).getSubsequentSubsections()
                .get(0).getSubsequentSubsections();

        assertEquals("⿹勹一", highlyNested.get(1).getCurrentBreakdownSubsection());
        assertEquals(3, highlyNested.get(1).getSubsequentSubsections().size());
        assertEquals("勹", highlyNested.get(1).getSubsequentSubsections().get(1).getCurrentBreakdownSubsection());
        assertEquals(0, highlyNested.get(1).getSubsequentSubsections().get(1).getSubsequentSubsections().size());

    }

    @Test
    public void testRecursionObjectGeneratorService_nestedCodes() throws DataFormatException {
        CharRecursionNode obj = new CharRecursionNode("𥵋");

        assertEquals("𥵋", obj.getCurrentBreakdownSubsection());
        assertEquals(1, obj.getSubsequentSubsections().size());
        assertEquals("⿱竹⿳亼罒册", obj.getSubsequentSubsections().get(0).getCurrentBreakdownSubsection());

        assertEquals("⿱", obj.getSubsequentSubsections().get(0).getSubsequentSubsections().get(0).getCurrentBreakdownSubsection());
        assertEquals(0, obj.getSubsequentSubsections().get(0).getSubsequentSubsections().get(0).getSubsequentSubsections().size());
        assertEquals("竹", obj.getSubsequentSubsections().get(0).getSubsequentSubsections().get(1).getCurrentBreakdownSubsection());
        assertEquals(1, obj.getSubsequentSubsections().get(0).getSubsequentSubsections().get(1).getSubsequentSubsections().size());

    }

    @Test
    public void testRecursionObjectGeneratorService_doubleCodes() throws DataFormatException {
        CharRecursionNode obj = new CharRecursionNode("㓘");

        assertEquals("㓘", obj.getCurrentBreakdownSubsection());
        assertEquals(1, obj.getSubsequentSubsections().size());
        assertEquals("⿵夙玉 ⿵几⿳一⿴𠂊⺀王", obj.getSubsequentSubsections().get(0).getCurrentBreakdownSubsection());

        CharRecursionNode res1 = obj.getSubsequentSubsections().get(0).getSubsequentSubsections().get(0);
        assertEquals("⿵夙玉", res1.getCurrentBreakdownSubsection());
        assertEquals(3, res1.getSubsequentSubsections().size());
        assertEquals("夙", res1.getSubsequentSubsections().get(1).getCurrentBreakdownSubsection());
        assertEquals(1, res1.getSubsequentSubsections().get(1).getSubsequentSubsections().size());
        assertEquals("⿵几歹", res1.getSubsequentSubsections()
                .get(1).getSubsequentSubsections()
                .get(0).getCurrentBreakdownSubsection());
        assertEquals("几", res1.getSubsequentSubsections()
                .get(1).getSubsequentSubsections()
                .get(0).getSubsequentSubsections().get(1).getCurrentBreakdownSubsection());


        CharRecursionNode res2 = obj.getSubsequentSubsections().get(0).getSubsequentSubsections().get(1);

        assertEquals(8, CharRecursionNodeService.unicodeBreakup(res2.getCurrentBreakdownSubsection()).size());
        assertEquals(3, res2.getSubsequentSubsections().size());
        assertEquals("⿵", res2.getSubsequentSubsections().get(0).getCurrentBreakdownSubsection());
        assertEquals("几", res2.getSubsequentSubsections().get(1).getCurrentBreakdownSubsection());
        assertEquals(0, res2.getSubsequentSubsections().get(1).getSubsequentSubsections().size());

        assertEquals("⿳一⿴𠂊⺀王", res2.getSubsequentSubsections().get(2).getCurrentBreakdownSubsection());
        assertEquals(4, res2.getSubsequentSubsections().get(2).getSubsequentSubsections().size());
        assertEquals("⿳", res2.getSubsequentSubsections().get(2).getSubsequentSubsections().get(0).getCurrentBreakdownSubsection());
        assertEquals("一", res2.getSubsequentSubsections().get(2).getSubsequentSubsections().get(1).getCurrentBreakdownSubsection());
        assertEquals("⿴𠂊⺀", res2.getSubsequentSubsections().get(2).getSubsequentSubsections().get(2).getCurrentBreakdownSubsection());

        assertEquals("王",
                res2.getSubsequentSubsections().get(2)
                        .getSubsequentSubsections().get(3).getCurrentBreakdownSubsection());
        assertEquals(1,
                res2.getSubsequentSubsections().get(2)
                        .getSubsequentSubsections().get(3)
                        .getSubsequentSubsections().size());
        assertEquals("⿱一土",
                res2.getSubsequentSubsections().get(2)
                        .getSubsequentSubsections().get(3)
                        .getSubsequentSubsections().get(0)
                        .getCurrentBreakdownSubsection());
        assertEquals(3, res2.getSubsequentSubsections().get(2)
                .getSubsequentSubsections().get(3)
                .getSubsequentSubsections().get(0)
                .getSubsequentSubsections().size());
    }
}
