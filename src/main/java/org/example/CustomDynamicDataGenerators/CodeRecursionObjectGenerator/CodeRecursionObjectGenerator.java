package org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator;

import org.example.CustomStaticDataGenerators.CustomIdsJsonMapGeneratorService;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;

import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static org.example.CustomStaticDataGenerators.CustomIdsJsonMapGeneratorService.orderedFrequencyList;
import static org.example.GlobalConstants.publicJundaFilePath;
import static org.example.GlobalConstants.publicTzaiFilePath;
import static org.example.ObjectTypes.GenericTypes.CharMetaInfo.*;

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
            if (CJKchar.equals("體")) {
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
                getCurrentOverlapInfoFromMapForFullMap(overlappingNodes, "all characters:");
                Map<String, List<CharRecursionNode>> onlyTrad = getTop5000Trad(overlappingNodes);
                getCurrentOverlapInfoFromMapFromTzaiAndJunda(onlyTrad, "only traditional:", true);
                Map<String, List<CharRecursionNode>> onlySimp = getTop5000Simp(overlappingNodes);
                getCurrentOverlapInfoFromMapFromTzaiAndJunda(onlySimp, "only simplified:", false);
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
                    .filter(node -> node.getSubsectionIdsMapResult().get(TZAIORDINAL).length() > 0)
                    .filter(node -> Integer.parseInt(node.getSubsectionIdsMapResult().get(TZAIORDINAL)) < 5001).toList();
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
                    .filter(node -> node.getSubsectionIdsMapResult().get(JUNDAORDINAL).length() > 0)
                    .filter(node -> Integer.parseInt(node.getSubsectionIdsMapResult().get(JUNDAORDINAL)) < 5001).toList();
            returnMap.put(key, updated);
        }
        return returnMap;
    }

    public static void getCurrentOverlapInfoFromMapFromTzaiAndJunda(Map<String, List<CharRecursionNode>> oldMap, String printMessage, boolean isTzai) {
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
        //calculate frequency that endusers should expect: characters in normal code and elements in full code
        List<CharRecursionNode> allNodes = oldMap.values().stream().flatMap(Collection::stream).collect(Collectors.toSet()).stream().toList();
        Map<Character, Long> normalCodeCharToMap = generateNormalCodeCharToMap(allNodes, isTzai);

        //add all numbers from normalCodeCharToMap and devide by 30.
        List<Long> listOfLongs = normalCodeCharToMap.values().stream().sorted().toList();
        Double averageForEachKey = Double.valueOf(listOfLongs.stream().mapToLong(Long::longValue).sum())/30;

        List<Integer> sortedOverlapSize = overlapSize.keySet().stream().sorted().toList();
        System.out.println(printMessage);
        System.out.println("overlap Sizes: " + sortedOverlapSize);
        System.out.println("overlapMap: " + overlapMap.size());
        printOverlap("Sample Overlaps: ", keys, oldMap, overlapMap, overlapSize);

        System.out.println("Sorted key use frequency: ");

        List<Character> newMapOrder = List.of(
                'q','w','e','r','t','y','u','i','o','p',
                'a','s','d','f','g','h','j','k','l',
                'z','x','c','v','b','n','m');
        for (Character currentChar : newMapOrder) {
            Long entry = normalCodeCharToMap.get(currentChar);
            System.out.println("Char: " +currentChar + " " + (Double.valueOf(entry)/averageForEachKey));
        }
        //There should not be any printout of element use. just a map to debug
        Map<String, Long> fullCodeToMap = generateFullCodeToMap(allNodes, isTzai);

        System.out.println("end");
    }

    private static void printOverlap(String x, List<String> keys, Map<String, List<CharRecursionNode>> oldMap, Map<String, List<CharRecursionNode>> overlapMap, Map<Integer, String> overlapSize) {
        System.out.println(x);
        int printcounter = 0;
        for (String key : keys) {
            List<CharRecursionNode> oldEntry = oldMap.get(key);
            if (oldEntry.size() > 1) {
                overlapMap.put(key, oldEntry);
                overlapSize.put(oldEntry.size(), key);
                if (printcounter < 5) {
                    String entryline = "";
                    for (CharRecursionNode recurNode : oldEntry) {
                        entryline = entryline + recurNode.getOriginalInput() + " Normal: " +
                                recurNode.getNormalCodeString() + " Full: " +
                                recurNode.getFullCodeString();
                    }
                    System.out.println(key + " " + entryline);
                }
                printcounter++;
            }
        }
    }

    private static Map<String, Long> generateFullCodeToMap(List<CharRecursionNode> allNodes, boolean isTzai) {
        Map<String, Long> result = new HashMap<>();
        for (CharRecursionNode node: allNodes) {
            int cjkNumberToUse = 1;
            if (isTzai) {
                cjkNumberToUse = Integer.parseInt(node.getSubsectionIdsMapResult().get(TZAICHARCOUNT));
            } else {
                cjkNumberToUse = Integer.parseInt(node.getSubsectionIdsMapResult().get(JUNDACHARCOUNT));
            }
            Set<String> fullCodeSet = new HashSet<>();
            for (List<String> fullcode : node.getFullCode()) {
                for (String twoLetterCode : fullcode) {
                    fullCodeSet.add(twoLetterCode);
                }
            }
            for (String twoLetterCode : fullCodeSet) {
                Long setResult = result.get(twoLetterCode);
                if (Objects.isNull(setResult)) {
                    result.put(twoLetterCode, Long.valueOf(String.valueOf(cjkNumberToUse)));
                }else {
                    Long newNumber = setResult + Long.valueOf(String.valueOf(cjkNumberToUse));
                    result.put(twoLetterCode, newNumber);
                }
            }
        }
        return result;
    }

    private static Map<Character, Long> generateNormalCodeCharToMap(List<CharRecursionNode> allNodes, boolean isTzai) {
        Map<Character, Long> result = new HashMap<>();
        for (CharRecursionNode node: allNodes) {
            int cjkNumberToUse = 1;
            if (isTzai) {
                cjkNumberToUse = Integer.parseInt(node.getSubsectionIdsMapResult().get(TZAICHARCOUNT));
            } else {
                cjkNumberToUse = Integer.parseInt(node.getSubsectionIdsMapResult().get(JUNDACHARCOUNT));
            }
            Set<Character> fullCodeSet = new HashSet<>();
            for (String normalCode : node.getNormalCode()) {
                for (char ch : normalCode.toCharArray()) {
                    fullCodeSet.add(ch);
                }
            }
            for (Character chFromSet: fullCodeSet) {
                Long setResult = result.get(chFromSet);
                if (Objects.isNull(setResult)) {
                    result.put(chFromSet, Long.valueOf(String.valueOf(cjkNumberToUse)));
                }else {
                    Long newNumber = setResult + Long.valueOf(String.valueOf(cjkNumberToUse));
                    result.put(chFromSet, newNumber);
                }
            }
        }
        return result;
    }

    public static void getCurrentOverlapInfoFromMapForFullMap(Map<String, List<CharRecursionNode>> oldMap, String printMessage) {
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
        System.out.println("overlap Sizes: " + sortedOverlapSize);
        System.out.println("overlapMap: " + overlapMap.size());
        printOverlap("Test Overlaps: ", keys, oldMap, overlapMap, overlapSize);

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
