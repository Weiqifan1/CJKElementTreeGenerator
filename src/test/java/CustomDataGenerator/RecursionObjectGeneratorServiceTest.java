package CustomDataGenerator;

import org.example.CharRecursionObjectGenerator.RecursionObjectGeneratorService;
import org.example.ObjectTypes.CharRecursionNode;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.CustomDataGenerator.CustomDataGeneratorService;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.example.CustomDataGenerator.CustomDataGeneratorService.getFileLinesFromPath;
import static org.example.GlobalConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RecursionObjectGeneratorServiceTest {

    @Test
    public void testRecursionObjectGeneratorService() {

        CharRecursionNode obj = RecursionObjectGeneratorService.generateRecursionObj("的");



        assertEquals(true, false);

    }
}
