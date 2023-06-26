package CustomDataGenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.CustomStaticDataGenerators.CustomIdsJsonMapGeneratorService;
import org.example.ObjectTypes.GenericTypes.CharMetaInfo;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.example.CustomStaticDataGenerators.CustomIdsJsonMapGeneratorService.getFileLinesFromPath;
import static org.example.GlobalConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class CustomIdsJsonMapGeneratorServiceTest {

    @Test
    public void testGenerateJundaMap() {
        List<String> lines = getFileLinesFromPath(Paths.get(publicJundaFilePath));
        Map<String, String> jundaMap = CustomIdsJsonMapGeneratorService.generateJundaMap(lines);

        assertEquals(9933, jundaMap.size());
        assertEquals("的" + " " + "1", jundaMap.get("的"));
        assertEquals("鴒" + " " + "9933", jundaMap.get("鴒"));

    }

    @Test
    public void testGenerateTzaiMap() {
        List<String> lines = getFileLinesFromPath(Paths.get(publicTzaiFilePath));
        Map<String, String> tzaiMap = CustomIdsJsonMapGeneratorService.generateTzaiMap(lines);

        assertEquals(13060, tzaiMap.size());
        assertEquals("的" + " " + "1", tzaiMap.get("的"));
        assertEquals("鷍" + " " + "13060", tzaiMap.get("鷍"));
    }

    @Test
    public void testGenerateIdsJsonData_fullIdsData() throws JsonProcessingException {
        List<String> idsLines = getFileLinesFromPath(Paths.get(publicIdsFilePath));
        List<String> jundaLines = getFileLinesFromPath(Paths.get(publicJundaFilePath));
        Map<String, String> jundaMap = CustomIdsJsonMapGeneratorService.generateJundaMap(jundaLines);
        List<String> tzaiLines = getFileLinesFromPath(Paths.get(publicTzaiFilePath));
        Map<String, String> tzaiMap = CustomIdsJsonMapGeneratorService.generateTzaiMap(tzaiLines);
        Map<String, Map<CharMetaInfo, String>> firstMap = CustomIdsJsonMapGeneratorService.generateIdsJsonDataMapFromLines(idsLines, jundaMap, tzaiMap);

        String jsonOutput = CustomIdsJsonMapGeneratorService.generateIdsJsonData(idsLines, jundaLines, tzaiLines);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Map<CharMetaInfo, String>> secondMap = objectMapper.readValue(jsonOutput, new TypeReference<Map<String, Map<CharMetaInfo, String>>>() {});

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

    private static void testMap(Map<String, Map<CharMetaInfo, String>> map) {
        Map<CharMetaInfo, String> example = map.get("亇");
        assertEquals(example.get(CharMetaInfo.BREAKDOWN), "⿱𠂊亅 ⿱𠂉亅 ⿱𠂉丨 ⿰丿丁 ⿰丿𠄐");
        assertEquals(example.get(CharMetaInfo.CHAR), "亇");
        assertEquals(example.get(CharMetaInfo.UNICODE), "U+4E87");
        assertEquals(example.get(CharMetaInfo.BREAKDOWNMETA), "[GK] [T]   ");

        assertEquals(map.get("的").get(CharMetaInfo.JUNDAORDINAL), "1");
        assertEquals(map.get("巴").get(CharMetaInfo.JUNDAORDINAL), "546");
        assertEquals(map.get("鴒").get(CharMetaInfo.JUNDAORDINAL), "9933");

        assertEquals(map.get("的").get(CharMetaInfo.TZAIORDINAL), "1");
        assertEquals(map.get("巴").get(CharMetaInfo.TZAIORDINAL), "850");
        assertEquals(map.get("鷍").get(CharMetaInfo.TZAIORDINAL), "13060");
    }

    @Test
    public void testGenerateIdsJsonData_smallTestData() throws JsonProcessingException {
        List<String> lines = idsTestData();
        String result = CustomIdsJsonMapGeneratorService.generateIdsJsonData(lines, new ArrayList<>(), new ArrayList<>());
        String jsonTestData = jsonResultTestData();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Map<CharMetaInfo, String>> resultMap = objectMapper.readValue(result, new TypeReference<Map<String, Map<CharMetaInfo, String>>>() {});
        Map<String, Map<CharMetaInfo, String>> jsonTestDataMap = objectMapper.readValue(jsonTestData, new TypeReference<Map<String, Map<CharMetaInfo, String>>>() {});

        assertEquals(resultMap, jsonTestDataMap);
    }

    private String jsonResultTestData() {
        /*
        {"①":{"TZAIORDINAL":"","UNICODE":"U+2460","BREAKDOWNMETA":"","CHAR":"①","JUNDAORDINAL":"","BREAKDOWN":"①"},
        "α":{"TZAIORDINAL":"","UNICODE":"U+03B1","BREAKDOWNMETA":"","CHAR":"α","JUNDAORDINAL":"","BREAKDOWN":"α"},
        "光":{"TZAIORDINAL":"","UNICODE":"U+5149","BREAKDOWNMETA":"","CHAR":"光","JUNDAORDINAL":"","BREAKDOWN":"⿱⺌兀"},
        "免":{"TZAIORDINAL":"","UNICODE":"U+514D","BREAKDOWNMETA":"[GTK] [J]","CHAR":"免","JUNDAORDINAL":"","BREAKDOWN":"⿱𠂊⑤ ⿳𠂊𫩏儿"}}
        */
        return "{\"①\":{\"TZAIORDINAL\":\"\",\"UNICODE\":\"U+2460\",\"BREAKDOWNMETA\":\"\",\"CHAR\":\"①\",\"JUNDAORDINAL\":\"\",\"BREAKDOWN\":\"①\"},\"α\":{\"TZAIORDINAL\":\"\",\"UNICODE\":\"U+03B1\",\"BREAKDOWNMETA\":\"\",\"CHAR\":\"α\",\"JUNDAORDINAL\":\"\",\"BREAKDOWN\":\"α\"},\"光\":{\"TZAIORDINAL\":\"\",\"UNICODE\":\"U+5149\",\"BREAKDOWNMETA\":\"\",\"CHAR\":\"光\",\"JUNDAORDINAL\":\"\",\"BREAKDOWN\":\"⿱⺌兀\"},\"免\":{\"TZAIORDINAL\":\"\",\"UNICODE\":\"U+514D\",\"BREAKDOWNMETA\":\"[GTK] [J]\",\"CHAR\":\"免\",\"JUNDAORDINAL\":\"\",\"BREAKDOWN\":\"⿱\uD840\uDC8A⑤ ⿳\uD840\uDC8A\uD86E\uDE4F儿\"}}";
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
