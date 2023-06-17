package CustomDataGenerator;

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
public class CustomDataGeneratorServiceTest {

    @Test
    public void testGenerateJundaMap() {
        List<String> lines = getFileLinesFromPath(Paths.get(publicJundaFilePath));
        Map<String, String> jundaMap = CustomDataGeneratorService.generateJundaMap(lines);

        assertEquals(9933, jundaMap.size());
        assertEquals("的" + " " + "1", jundaMap.get("的"));
        assertEquals("鴒" + " " + "9933", jundaMap.get("鴒"));

    }

    @Test
    public void testGenerateTzaiMap() {
        List<String> lines = getFileLinesFromPath(Paths.get(publicTzaiFilePath));
        Map<String, String> tzaiMap = CustomDataGeneratorService.generateTzaiMap(lines);

        assertEquals(13060, tzaiMap.size());
        assertEquals("的" + " " + "1", tzaiMap.get("的"));
        assertEquals("鷍" + " " + "13060", tzaiMap.get("鷍"));
    }

    @Test
    public void testGenerateIdsJsonData_fullIdsData() throws JsonProcessingException {
        List<String> idsLines = getFileLinesFromPath(Paths.get(publicIdsFilePath));
        List<String> jundaLines = getFileLinesFromPath(Paths.get(publicJundaFilePath));
        Map<String, String> jundaMap = CustomDataGeneratorService.generateJundaMap(jundaLines);
        List<String> tzaiLines = getFileLinesFromPath(Paths.get(publicTzaiFilePath));
        Map<String, String> tzaiMap = CustomDataGeneratorService.generateTzaiMap(tzaiLines);
        Map<String, Map<String, String>> firstMap = CustomDataGeneratorService.generateIdsJsonDataMapFromLines(idsLines, jundaMap, tzaiMap);

        String jsonOutput = CustomDataGeneratorService.generateIdsJsonData(idsLines, jundaLines, tzaiLines);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Map<String, String>> secondMap = objectMapper.readValue(jsonOutput, new TypeReference<Map<String, Map<String, String>>>() {});

        assertEquals(88939, idsLines.size());
        assertEquals(88937, firstMap.size());
        assertEquals(88937, secondMap.size());

        // we expect that the 2 missing lines are the first 2 lines, starting with #
        List<String> teslist = new ArrayList<>();
        for (String line: idsLines) {
            List<String> splittet = Arrays.stream(line.split("\\s+")).toList();
            if (!firstMap.containsKey(splittet.get(1))) {
                teslist.add(line);
            }
        }
        assertEquals(2, teslist.size());
        assertTrue(teslist.get(0).substring(0,1).equals("#"));
        assertTrue(teslist.get(1).substring(0,1).equals("#"));

        testMap(firstMap);
        testMap(secondMap);

    }

    private static void testMap(Map<String, Map<String, String>> map) {
        Map<String, String> exampleOld = map.get("亇");
        assertEquals(exampleOld.get("breakdownList"), "⿱𠂊亅 ⿱𠂉亅 ⿱𠂉丨 ⿰丿丁 ⿰丿𠄐");
        assertEquals(exampleOld.get("char"), "亇");
        assertEquals(exampleOld.get("unicode"), "U+4E87");
        assertEquals(exampleOld.get("breakdownMetadata"), "[GK] [T]   ");

        assertEquals(map.get("的").get("jundaOrdinal"), "1");
        assertEquals(map.get("巴").get("jundaOrdinal"), "546");
        assertEquals(map.get("鴒").get("jundaOrdinal"), "9933");

        assertEquals(map.get("的").get("tzaiOrdinal"), "1");
        assertEquals(map.get("巴").get("tzaiOrdinal"), "850");
        assertEquals(map.get("鷍").get("tzaiOrdinal"), "13060");
    }

    @Test
    public void testGenerateIdsJsonData_smallTestData() throws JsonProcessingException {
        List<String> lines = idsTestData();
        String result = CustomDataGeneratorService.generateIdsJsonData(lines, new ArrayList<>(), new ArrayList<>());
        String jsonTestData = jsonResultTestData();
        assertEquals(jsonTestData, result);
    }

    private String jsonResultTestData() {
        /*
        {"①":{"tzaiOrdinal":"","jundaOrdinal":"","breakdownList":"①","char":"①","unicode":"U+2460","breakdownMetadata":""},
        "α":{"tzaiOrdinal":"","jundaOrdinal":"","breakdownList":"α","char":"α","unicode":"U+03B1","breakdownMetadata":""},
        "光":{"tzaiOrdinal":"","jundaOrdinal":"","breakdownList":"⿱⺌兀","char":"光","unicode":"U+5149","breakdownMetadata":""},
        "免":{"tzaiOrdinal":"","jundaOrdinal":"","breakdownList":"⿱𠂊⑤ ⿳𠂊𫩏儿","char":"免","unicode":"U+514D","breakdownMetadata":"[GTK] [J]"}}
        */
        return "{\"①\":{\"tzaiOrdinal\":\"\",\"jundaOrdinal\":\"\",\"breakdownList\":\"①\",\"char\":\"①\",\"unicode\":\"U+2460\",\"breakdownMetadata\":\"\"},\"α\":{\"tzaiOrdinal\":\"\",\"jundaOrdinal\":\"\",\"breakdownList\":\"α\",\"char\":\"α\",\"unicode\":\"U+03B1\",\"breakdownMetadata\":\"\"},\"光\":{\"tzaiOrdinal\":\"\",\"jundaOrdinal\":\"\",\"breakdownList\":\"⿱⺌兀\",\"char\":\"光\",\"unicode\":\"U+5149\",\"breakdownMetadata\":\"\"},\"免\":{\"tzaiOrdinal\":\"\",\"jundaOrdinal\":\"\",\"breakdownList\":\"⿱\uD840\uDC8A⑤ ⿳\uD840\uDC8A\uD86E\uDE4F儿\",\"char\":\"免\",\"unicode\":\"U+514D\",\"breakdownMetadata\":\"[GTK] [J]\"}}";
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
