package CustomDataGenerator;

import org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator.CodeRecursionObjectGenerator;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import static org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator.CodeRecursionObjectGenerator.*;
import static org.example.GlobalConstants.publicHtradFilePath;
import static org.junit.Assert.assertEquals;

public class AYMethodCodeGeneratorServiceTest {

    @Test
    public void testRecursionCodes() {
        List<CharRecursionNode> nodelist = getNodeList();
        assertEquals(16376, nodelist.size());
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
