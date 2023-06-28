package CustomDataGenerator;


import org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import static org.junit.Assert.assertEquals;

public class AYMethodCodeGeneratorServiceTest {

    @Test
    public void testGenerateFullCodeFromCodeMap_basic() throws DataFormatException {
        //的 1
        CharRecursionNode de1 = new CharRecursionNode("的", null);
        assertEquals(Set.of("lplh", "lpla"), de1.getNormalCode().stream().collect(Collectors.toSet()));
        //TODO: implement the test
        /*
        //我 4
        CharRecursionNode wo4 = new CharRecursionNode("我", null);
        assertEquals(Set.of("lplh", "lpla"), wo4.getNormalCode().stream().collect(Collectors.toSet()));
        //就 26
        CharRecursionNode jiu26 = new CharRecursionNode("就", null);
        assertEquals(Set.of("lplh", "lpla"), jiu26.getNormalCode().stream().collect(Collectors.toSet()));
        //還 56
        CharRecursionNode hai56 = new CharRecursionNode("還", null);
        assertEquals(Set.of("lplh", "lpla"), hai56.getNormalCode().stream().collect(Collectors.toSet()));


        assertEquals(true, false);*/


    }


}
