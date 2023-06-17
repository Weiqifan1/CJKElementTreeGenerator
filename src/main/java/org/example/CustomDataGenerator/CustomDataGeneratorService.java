package org.example.CustomDataGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class CustomDataGeneratorService {

    public static String generateIdsJsonData(List<String> lines, List<String> jundaLines, List<String> tzaiLines) {
        Map<String, String> jundaMap = CustomDataGeneratorService.generateJundaMap(jundaLines);
        Map<String, String> tzaiMap = CustomDataGeneratorService.generateTzaiMap(tzaiLines);
        Map<String, Map<String, String>> nesteIdsMap = generateIdsJsonDataMapFromLines(lines, jundaMap, tzaiMap);

        String generatedJsonData = generatedJsonDataFromMap(nesteIdsMap);
        return generatedJsonData;
    }

    public static void writeToJsonFile(String filePath, String data) {
        //example:
        //String filePath = "/path/to/example.txt";
        //String data = "Hello, world!";
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static String generatedJsonDataFromMap(Map<String, Map<String, String>> nestedMap) {
        String result = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            result = objectMapper.writeValueAsString(nestedMap);
        } catch (Exception ex) {
            System.out.println("Data Generator: " + ex);
        }
        return result;
    }

    public static Map<String, Map<String, String>> generateIdsJsonDataMapFromLines(List<String> lines,
                                                                                   Map<String, String> jundaMap,
                                                                                   Map<String, String> tzaiMap) {
        Map<String, Map<String, String>> nestedMap = new HashMap<>();
        int lineNum = 0;
        for (String line : lines) {
            try {
                lineNum += 1;
                if (!line.startsWith("#")) {
                    nestedMap = updatedNestedMap(line, nestedMap, jundaMap, tzaiMap);
                }
            } catch (Exception ex) {
                System.out.println("failed on line: " + ex);
            }
        }
        return nestedMap;
    }

    public static List<String> getFileLinesFromPath(Path path) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.lines(path).toList();
        } catch (IOException e) {
            System.out.println(e);
        }
        return lines;
    }

    private static Map<String, Map<String, String>> updatedNestedMap(String line,
                                                                     Map<String, Map<String, String>> nestedMap,
                                                                     Map<String, String> jundaMap,
                                                                     Map<String, String> tzaiMap) throws Exception {
        Map<String, String> newmap = new HashMap<>();
        List<String> list = Arrays.stream(line.split("\\s+")).toList();
        validateList(list);
        String jundaResult = getFrequencyDataForIdsChar(list.get(1), jundaMap);
        newmap.put("jundaOrdinal", jundaResult);

        String tzaiResult = getFrequencyDataForIdsChar(list.get(1), tzaiMap);
        newmap.put("tzaiOrdinal", tzaiResult);

        newmap.put("unicode", list.get(0));
        newmap.put("char", list.get(1));
        if (list.get(1).equals("亇")) {
            String test = "";
        }
        String breakdownList = getBreakdownList(list.subList(2, list.size()));
        String breakdownMetadata = getBreakdownMetadata(list.subList(2, list.size()));
        newmap.put("breakdownList", breakdownList);
        newmap.put("breakdownMetadata", breakdownMetadata);

        nestedMap.put(list.get(1), newmap);
        return nestedMap;
    }

    private static String getFrequencyDataForIdsChar(String idsChar, Map<String, String> jundaMap) {
        if (idsChar.equals("我")) {
            String test = "";
        }

        String firstResult = jundaMap.get(idsChar);
        if (Objects.isNull(firstResult)) {
            return "";
        }
        List<String> splitResult = Arrays.stream(firstResult.split("\\s+")).toList();
        if (Objects.nonNull(splitResult)
                && splitResult.size() == 2
                && splitResult.get(1).matches("-?\\d+")) {
            return splitResult.get(1);
        } else {
            return "";
        }
    }

    private static String getBreakdownMetadata(List<String> strings) throws Exception {
        try {
            List<String> updated = strings.stream()
                .map(breakdownStr -> {
                    List<String> split = Arrays.stream(breakdownStr.split("\\[")).toList();
                    if (split.size() > 1) {
                        return split.get(1);
                    }else {
                        return "";
                    }
                })
                .collect(Collectors.toList());

            List<String> withBracket = new ArrayList<>();
            for (String elem : updated) {
                if (elem.length() > 0) {
                    withBracket.add("[" + elem);
                }else {
                    withBracket.add(elem);
                }
            }

            String withSpace = String.join(" ", withBracket);
            return withSpace;
        } catch (Exception e) {
            throw new Exception("BreakdownMetadata: " + strings);
        }
    }

    private static String getBreakdownList(List<String> strings) throws Exception {
        try {
            List<String> updated = strings.stream()
                    .map(breakdownStr -> Arrays.stream(breakdownStr.split("\\[")).toList().get(0))
                    .collect(Collectors.toList());
            String withSpace = String.join(" ", updated);
            return withSpace;
        } catch (Exception e) {
            throw new Exception("BreakdownList: " + strings);
        }
    }

    private static void validateList(List<String> list) throws Exception {
        String unicodeStr = list.get(0);
        boolean isUnicode = unicodeStr.length() == 6 || unicodeStr.length() == 7
                && unicodeStr.substring(0, 1).equals("U")
                && unicodeStr.substring(1, 2).equals("+");
        boolean isChar = list.get(1).codePoints().boxed().collect(Collectors.toList()).size() == 1;
        if (!isUnicode || !isChar) {
            throw new Exception("Unicode or char on line: " + list);
        }
    }

    public static Map<String, String> generateJundaMap(List<String> lines) {

        Map<String, String> jundaMap = new HashMap<>();
        for (String line : lines) {
            List<String> splitLine = Arrays.stream(line.split("\\s+")).toList();
            //remove zero With char 65279 From First Line
            if (splitLine.get(1).equals("的")) {
                splitLine = Arrays.stream(line.substring(1).split("\\s+")).toList();
            }
            jundaMap.put(splitLine.get(1), splitLine.get(1) + " " + splitLine.get(0));
        }
        return jundaMap;
    }

    public static Map<String, String> generateTzaiMap(List<String> lines) {

        Map<String, String> tzaiMap = new HashMap<>();
        int lineNum = 1;
        for (String line : lines) {
            List<String> splitLine = Arrays.stream(line.split("\\s+")).toList();
            //remove zero With char 65279 From First Line
            if (splitLine.get(1).equals("6538132")) {
                splitLine = Arrays.stream(line.substring(1).split("\\s+")).toList();
            }
            tzaiMap.put(splitLine.get(0), splitLine.get(0) + " " + lineNum);
            lineNum += 1;
        }

        return tzaiMap;
    }
}
