package CustomDataGenerator;
import org.example.CustomDataHandler.CustomDataReader;
import org.junit.Test;

import java.util.Map;

import static org.example.GlobalConstants.customIdsJsonMapPath;
import static org.junit.Assert.*;

public class CustomDataReaderTest {

    @Test
    public void testGenerateIdsJsonData_smallTestData() throws Exception {
        Map<String, Map<String, String>> map = CustomDataReader.getCustomIdsMap(customIdsJsonMapPath);
        assertEquals(88937, map.size());
        Map<String, String> example = map.get("亇");
        assertEquals(example.get("breakdownList"), "⿱𠂊亅 ⿱𠂉亅 ⿱𠂉丨 ⿰丿丁 ⿰丿𠄐");
        assertEquals(example.get("char"), "亇");
        assertEquals(example.get("unicode"), "U+4E87");
        assertEquals(example.get("breakdownMetadata"), "[GK] [T]   ");
    }
}
