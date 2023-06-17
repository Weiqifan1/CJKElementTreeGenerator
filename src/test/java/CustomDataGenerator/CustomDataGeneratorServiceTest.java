package CustomDataGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.example.CustomDataGenerator.CustomDataGeneratorService.*;
import static org.example.GlobalConstants.publicIdsFilePath;
import static org.junit.Assert.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class CustomDataGeneratorServiceTest {

    @Test
    public void testGenerateIdsJsonData_fullIdsData() throws JsonProcessingException {
        Path path = Paths.get(publicIdsFilePath);
        List<String> lines = getFileLinesFromPath(path);
        Map<String, Map<String, String>> nestedMap = generateIdsJsonDataMapFromLines(lines);

        String jsonOutput = generateIdsJsonData(lines);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Map<String, String>> map = objectMapper.readValue(jsonOutput, new TypeReference<Map<String, Map<String, String>>>() {});

        assertEquals(88939, lines.size());
        assertEquals(88937, nestedMap.size());
        assertEquals(88937, map.size());

        // we expect that the 2 missing lines are the first 2 lines, starting with #
        List<String> teslist = new ArrayList<>();
        for (String line: lines) {
            List<String> splittet = Arrays.stream(line.split("\\s+")).toList();
            if (!nestedMap.containsKey(splittet.get(1))) {
                teslist.add(line);
            }
        }
        assertEquals(2, teslist.size());
        assertTrue(teslist.get(0).substring(0,1).equals("#"));
        assertTrue(teslist.get(1).substring(0,1).equals("#"));


        Map<String, String> exampleOld = nestedMap.get("亇");
        assertEquals(exampleOld.get("breakdownList"), "⿱𠂊亅 ⿱𠂉亅 ⿱𠂉丨 ⿰丿丁 ⿰丿𠄐");
        assertEquals(exampleOld.get("char"), "亇");
        assertEquals(exampleOld.get("unicode"), "U+4E87");
        assertEquals(exampleOld.get("breakdownMetadata"), "[GK] [T]   ");

        Map<String, String> exampleNew = map.get("亇");
        assertEquals(exampleNew.get("breakdownList"), "⿱𠂊亅 ⿱𠂉亅 ⿱𠂉丨 ⿰丿丁 ⿰丿𠄐");
        assertEquals(exampleNew.get("char"), "亇");
        assertEquals(exampleNew.get("unicode"), "U+4E87");
        assertEquals(exampleNew.get("breakdownMetadata"), "[GK] [T]   ");
    }

    @Test
    public void testGenerateIdsJsonData_smallTestData() throws JsonProcessingException {
        List<String> lines = idsTestData();
        String result = generateIdsJsonData(lines);
        String jsonTestData = jsonResultTestData();
        assertEquals(jsonTestData, result);
    }

    private String jsonResultTestData() {
        /*
        {"α": {"unicode": "U+03B1", "char": "α", "breakdownList": "α", breakdownMetadata: ""},
         "①": {"unicode": "U+2460", "char": "①", "breakdownList": "①", breakdownMetadata: ""},
         "光": {"unicode": "U+5149", "char": "光", "breakdownList": "⿱⺌兀", breakdownMetadata: ""},
         "免": {"unicode": "U+514D", "char": "免", "breakdownList": "⿱𠂊⑤ ⿳𠂊𫩏儿", breakdownMetadata: "[GTK] [J]"}}
        */
        return "{\"①\":{\"breakdownList\":\"①\",\"char\":\"①\",\"unicode\":\"U+2460\",\"breakdownMetadata\":\"\"}," +
                "\"α\":{\"breakdownList\":\"α\",\"char\":\"α\",\"unicode\":\"U+03B1\",\"breakdownMetadata\":\"\"}," +
                "\"光\":{\"breakdownList\":\"⿱⺌兀\",\"char\":\"光\",\"unicode\":\"U+5149\",\"breakdownMetadata\":\"\"}," +
                "\"免\":{\"breakdownList\":\"⿱\uD840\uDC8A⑤ ⿳\uD840\uDC8A\uD86E\uDE4F儿\",\"char\":\"免\",\"unicode\":\"U+514D\",\"breakdownMetadata\":\"[GTK] [J]\"}}";
    }

    private List<String> idsTestData() {
        List<String> lines = List.of(
                "# Copyright (c) 2014-2017 CJKVI Database",
                "# Based on CHISE IDS Database",
                "U+03B1\tα\tα",
                "U+2460\t①\t①",
                "U+5149\t光\t⿱⺌兀",
                "U+514D	免	⿱𠂊⑤[GTK]	⿳𠂊𫩏儿[J]");
        return lines;
    }




}
