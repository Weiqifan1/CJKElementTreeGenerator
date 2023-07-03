package org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator;

import org.example.CustomStaticDataGenerators.CustomIdsJsonMapGeneratorService;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;

import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static org.example.CustomStaticDataGenerators.CustomIdsJsonMapGeneratorService.orderedFrequencyList;
import static org.example.GlobalConstants.publicJundaFilePath;
import static org.example.GlobalConstants.publicTzaiFilePath;

public class CodeRecursionObjectGenerator {

    public static void main(String[] args) throws Exception {
        System.out.println("Recursion Object Generator started!");

        CharRecursionNode obj = new CharRecursionNode("的", null);

        System.out.println("Recursion Object Generator ended!");
    }

    public static Map<String, List<CharRecursionNode>> getUpdatedMap(CharRecursionNode newNode, Map<String, List<CharRecursionNode>> oldMap) {
        List<String> codeList = newNode.getNormalCode().stream().collect(Collectors.toSet()).stream().toList();
        for (String code : codeList) {
            List<CharRecursionNode> existingNodeMapEntry = oldMap.get(code);
            if (Objects.nonNull(existingNodeMapEntry)) {
                List<CharRecursionNode> updated = new ArrayList<>();
                updated.addAll(existingNodeMapEntry);
                updated.add(newNode);
                oldMap.put(code, updated);
            } else {
                oldMap.put(code, List.of(newNode));
            }
        }
        return oldMap;
    }

    public static List<CharRecursionNode> getNodeList() {
        List<String> jundaLines = CustomIdsJsonMapGeneratorService.getFileLinesFromPath(Paths.get(publicJundaFilePath));
        List<String> tzaiLines = CustomIdsJsonMapGeneratorService.getFileLinesFromPath(Paths.get(publicTzaiFilePath));
        Map<String, String> jundaMap = CustomIdsJsonMapGeneratorService.generateJundaMap(jundaLines);
        Map<String, String> tzaiMap = CustomIdsJsonMapGeneratorService.generateTzaiMap(tzaiLines);
        List<String> sorted = getSortedCharList();
        List<CharRecursionNode> nodes = new ArrayList<>();
        Map<String, List<CharRecursionNode>> overlappingNodes = new HashMap<>();

        int currentOrdinal = 1;

        for (String CJKchar : sorted) {
            if (CJKchar.equals("最")) {
                String test = "";
            }
            CharRecursionNode node = null;
            try {
                node = new CharRecursionNode(CJKchar, null);
            } catch (Exception e) {
                System.out.println(CJKchar);
                System.out.println("tzai: " + tzaiMap.get(CJKchar));
                System.out.println("junda: "+ jundaMap.get(CJKchar));
                System.out.println("Ordinal " + currentOrdinal);
                getCurrentOverlapInfoFromMap(overlappingNodes, "all characters:");
                //Map<String, List<CharRecursionNode>> onlyTrad = getTop5000Trad(overlappingNodes);
                //getCurrentOverlapInfoFromMap(onlyTrad, "only traditional:");
                //Map<String, List<CharRecursionNode>> onlySimp = getTop5000Simp(overlappingNodes);
                //getCurrentOverlapInfoFromMap(onlySimp, "only simplified:");
            }
            nodes.add(node);
            overlappingNodes = getUpdatedMap(node, overlappingNodes);
            currentOrdinal++;
        }
        return nodes;
    }

    public static Map<String, List<CharRecursionNode>> getTop5000Trad(Map<String, List<CharRecursionNode>> oldMap) {
        List<String> keys = oldMap.keySet().stream().toList();
        Map<String, List<CharRecursionNode>> returnMap = new HashMap<>();

        for (String key : keys) {
            List<CharRecursionNode> oldEntry = oldMap.get(key);
            List<CharRecursionNode> updated = oldEntry.stream()
                    .filter(node -> node.getSubsectionIdsMapResult().get("TZAIORDINAL").length() > 0)
                    .filter(node -> Integer.parseInt(node.getSubsectionIdsMapResult().get("TZAIORDINAL")) < 5001).toList();
            returnMap.put(key, updated);
        }
        return returnMap;
    }

    public static Map<String, List<CharRecursionNode>> getTop5000Simp(Map<String, List<CharRecursionNode>> oldMap) {
        List<String> keys = oldMap.keySet().stream().toList();
        Map<String, List<CharRecursionNode>> returnMap = new HashMap<>();

        for (String key : keys) {
            List<CharRecursionNode> oldEntry = oldMap.get(key);
            List<CharRecursionNode> updated = oldEntry.stream()
                    .filter(node -> node.getSubsectionIdsMapResult().get("JUNDAORDINAL").length() > 0)
                    .filter(node -> Integer.parseInt(node.getSubsectionIdsMapResult().get("JUNDAORDINAL")) < 5001).toList();
            returnMap.put(key, updated);
        }
        return returnMap;
    }

    public static void getCurrentOverlapInfoFromMap(Map<String, List<CharRecursionNode>> oldMap, String printMessage) {
        //create a map with all overlaps
        Map<String, List<CharRecursionNode>> overlapMap = new HashMap<>();
        List<String> keys = oldMap.keySet().stream().toList();
        //find the largest overlaps
        Map<Integer, String> overlapSize = new HashMap<>();

        for (String key : keys) {
            List<CharRecursionNode> oldEntry = oldMap.get(key);
            if (oldEntry.size() > 1) {
                overlapMap.put(key, oldEntry);
                overlapSize.put(oldEntry.size(), key);
            }
        }
        List<Integer> sortedOverlapSize = overlapSize.keySet().stream().sorted().toList();
        System.out.println(printMessage);
        System.out.println("overlap Size: " + sortedOverlapSize);
        System.out.println("overlapMap: " + overlapMap.size());
        System.out.println("largest Overlaps: ");
        System.out.println("end");
    }

    private static List<String> getSortedCharList() {
        List<String> jundaLines = CustomIdsJsonMapGeneratorService.getFileLinesFromPath(Paths.get(publicJundaFilePath));
        List<String> tzaiLines = CustomIdsJsonMapGeneratorService.getFileLinesFromPath(Paths.get(publicTzaiFilePath));
        Map<String, String> jundaMap = CustomIdsJsonMapGeneratorService.generateJundaMap(jundaLines);
        Map<String, String> tzaiMap = CustomIdsJsonMapGeneratorService.generateTzaiMap(tzaiLines);
        List<String> tzai = orderedFrequencyList(tzaiMap);
        List<String> junda = orderedFrequencyList(jundaMap);

        int tzailengt = tzai.size();
        int jundalength = junda.size();
        int longest = tzailengt > jundalength ? tzailengt : jundalength;

        List<String> set = new ArrayList<>();

        for (int i = 0; i < longest; i++) {
            if (i < tzailengt) {
                String tzaiChar = tzai.get(i).trim();
                if (!set.contains(tzaiChar)) {
                    set.add(tzaiChar);
                }
            }
            if (i < jundalength) {
                String jundaChar = junda.get(i).trim();
                if (!set.contains(jundaChar)) {
                    set.add(jundaChar);
                }
            }
        }
        return set;
    }

}
