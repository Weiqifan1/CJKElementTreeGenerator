package CustomDataGenerator;
import org.example.CustomDataHandler.CustomDataReader;
import org.example.ObjectTypes.GenericTypes.CharMetaInfo;
import org.junit.Test;

import java.util.Map;

import static org.example.GlobalConstants.customIdsJsonMapPath;
import static org.junit.Assert.*;

public class CustomDataReaderTest {

    @Test
    public void testGenerateIdsJsonData_smallTestData() throws Exception {
        Map<String, Map<CharMetaInfo, String>> map = CustomDataReader.getCustomIdsMap(customIdsJsonMapPath);
        assertEquals(88937, map.size());
        Map<CharMetaInfo, String> example = map.get("亇");
        assertEquals(example.get(CharMetaInfo.BREAKDOWN), "⿱𠂊亅 ⿱𠂉亅 ⿱𠂉丨 ⿰丿丁 ⿰丿𠄐");
        assertEquals(example.get(CharMetaInfo.CHAR), "亇");
        assertEquals(example.get(CharMetaInfo.UNICODE), "U+4E87");
        assertEquals(example.get(CharMetaInfo.BREAKDOWNMETA), "[GK] [T]   ");
        assertEquals(example.get(CharMetaInfo.JUNDAORDINAL), "");
        assertEquals(example.get(CharMetaInfo.TZAIORDINAL), "");

        Map<CharMetaInfo, String> example2 = map.get("巴");
        assertEquals(example2.get(CharMetaInfo.BREAKDOWN), "巴");
        assertEquals(example2.get(CharMetaInfo.CHAR), "巴");
        assertEquals(example2.get(CharMetaInfo.UNICODE), "U+5DF4");
        assertEquals(example2.get(CharMetaInfo.BREAKDOWNMETA), "");
        assertEquals(example2.get(CharMetaInfo.JUNDAORDINAL), "546");
        assertEquals(example2.get(CharMetaInfo.TZAIORDINAL), "850");
    }
}
