package CustomDataGenerator;

import org.example.CharRecursionObjectGenerator.RecursionObjectGeneratorService;
import org.example.ObjectTypes.CharRecursionNode;
import org.junit.Test;

import java.util.zip.DataFormatException;

import static org.junit.Assert.assertEquals;

public class RecursionObjectGeneratorServiceTest {

    @Test
    public void testRecursionObjectGeneratorService() throws DataFormatException {

        //CharRecursionNode obj = RecursionObjectGeneratorService.generateRecursionObj("的");
        //CharRecursionNode obj = RecursionObjectGeneratorService.generateRecursionObj("㒼");

        CharRecursionNode obj = RecursionObjectGeneratorService.generateRecursionObj("㓘");



        assertEquals(true, false);

    }
}
