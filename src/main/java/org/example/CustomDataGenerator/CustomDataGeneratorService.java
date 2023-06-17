package org.example.CustomDataGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class CustomDataGeneratorService {

    public static String generateIdsJsonData(List<String> lines) {
        Map<String, Map<String, String>> nestedMap = generateIdsJsonDataMapFromLines(lines);
        String generatedJsonData = generatedJsonDataFromMap(nestedMap);
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

    public static Map<String, Map<String, String>> generateIdsJsonDataMapFromLines(List<String> lines) {
        Map<String, Map<String, String>> nestedMap = new HashMap<>();
        int lineNum = 0;
        for (String line : lines) {
            try {
                lineNum += 1;
                if (!line.startsWith("#")) {
                    nestedMap = updatedNestedMap(line, nestedMap);
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

    private static Map<String, Map<String, String>> updatedNestedMap(String line, Map<String, Map<String, String>> nestedMap) throws Exception {
        Map<String, String> newmap = new HashMap<>();
        List<String> list = Arrays.stream(line.split("\\s+")).toList();
        validateList(list);
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
}
