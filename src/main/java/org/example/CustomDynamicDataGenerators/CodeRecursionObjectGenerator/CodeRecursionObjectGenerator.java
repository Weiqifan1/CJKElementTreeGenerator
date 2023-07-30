package org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator;

import org.example.CustomStaticDataGenerators.CustomIdsJsonMapGeneratorService;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.GenericTypes.CodeDecompositionType;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.example.CustomStaticDataGenerators.CustomIdsJsonMapGeneratorService.orderedFrequencyList;
import static org.example.GlobalConstants.*;
import static org.example.ObjectTypes.GenericTypes.CharMetaInfo.*;

public class CodeRecursionObjectGenerator {

    public static void main(String[] args) throws Exception {
        System.out.println("Recursion Object Generator started!");

        CharRecursionNode obj = new CharRecursionNode("的", null,
                CodeDecompositionType.CODE5_123zy_LIMMITBACKTRACK);

        System.out.println("Recursion Object Generator ended!");
    }

    public static CharRecursionNode getNodeByName(String name, List<CharRecursionNode> nodes) {
        for (CharRecursionNode node : nodes) {
            if (node.getCurrentBreakdownSubsection().equals(name)) {
                return node;
            }
        }
        return null;
    }
/*
    public static Map<String, Long> getWholeFullCodeSortedCount(String path, CodeDecompositionType codeDecom) {
        List<CharRecursionNode> allnodes = getNodeList(codeDecom);
        List<CharRecursionNode> nodesFromPath = onlyNodesFromPathAndBelowNumber(allnodes, path);
        Map<String, Long> allCodes = nodesFromPath.stream()
                .map(node -> node.getFullCode())
                .flatMap(Collection::stream)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return allCodes;
    }*/
/*
    public static List<CharRecursionNode> getNodesFromPath_noDesc_fullCodeWholeTextMatch(String inputToMatch, String path,
                                                                                         CodeDecompositionType codeDecom) {
        List<CharRecursionNode> allnodes = getNodeList(codeDecom);
        List<CharRecursionNode> nodesFromPath = onlyNodesFromPathAndBelowNumber(allnodes, path);
        List<CharRecursionNode> res = noDesc_fullCodeWholeTextMatch(nodesFromPath, inputToMatch);
        return res;
    }*/
/*
    public static List<CharRecursionNode> getNodesFromPath_noDesc_fullCodeFirstLettersMatch(String inputToMatch, String path,
                                                                                            CodeDecompositionType codeDecom) {
        List<CharRecursionNode> allnodes = getNodeList(codeDecom);
        List<CharRecursionNode> nodesFromPath = onlyNodesFromPathAndBelowNumber(allnodes, path);
        List<CharRecursionNode> res = noDesc_fullCodeFirstLettersMatch(nodesFromPath, inputToMatch);
        return res;
    }*/
/*
    public static List<CharRecursionNode> getNodesFromPath_exactFullCodeEntryMatch(String inputToMatch, String path,
                                                                                   CodeDecompositionType codeDecom) {
        List<CharRecursionNode> allnodes = getNodeList(codeDecom);
        List<CharRecursionNode> nodesFromPath = onlyNodesFromPathAndBelowNumber(allnodes, path);
        List<CharRecursionNode> res = nodesFromPath.stream().filter(node -> nodeHasFullCodeEntry(node, inputToMatch)).toList();
        return res;
    }*/

    private static boolean nodeHasFullCodeEntry(CharRecursionNode node, String inputToMatch) {
        for (List<String> fullCode : node.fullCode) {
            for (String code : fullCode) {
                if (code.equals(inputToMatch)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<CharRecursionNode> noDesc_fullCodeWholeTextMatch(List<CharRecursionNode> nodes, String input) {
        List<CharRecursionNode> results = nodes.stream().filter(node -> noDesc_fullCodeWholeTextMatch(node, input)).toList();
        return results;
    }

    private static List<CharRecursionNode> noDesc_fullCodeFirstLettersMatch(List<CharRecursionNode> nodes, String input) {
        List<CharRecursionNode> results = nodes.stream().filter(node -> noDesc_fullCodeFirstLetterMatch(node, input)).toList();
        return results;
    }

    private static boolean noDesc_fullCodeFirstLetterMatch(CharRecursionNode node, String input) {
        //find match with no description chars
        for (List<String> code : node.fullCode) {
            List<String> noShape = code.stream().filter(multicode -> isAscii(multicode)).toList();
            List<String> resultToJoin = reverseList(noShape);
            List<String> onlyFirstLetters = resultToJoin.stream()
                    .filter(shape -> shape.length() > 0)
                    .map(shape -> shape.substring(0,1)).toList();
            String joined = String.join("", onlyFirstLetters);
            if (joined.contains(input)) {
                return true;
            }
        }
        return false;
    }

    private static boolean noDesc_fullCodeWholeTextMatch(CharRecursionNode node, String input) {
        //find match with no description chars
        for (List<String> code : node.fullCode) {
            List<String> noShape = code.stream().filter(multicode -> isAscii(multicode)).toList();
            List<String> resultToJoin = reverseList(noShape);
            String joined = String.join("", resultToJoin);
            if (joined.contains(input)) {
                return true;
            }
        }
        return false;
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

    public static List<CharRecursionNode> getNodeList(CodeDecompositionType codeDecom){
        List<String> jundaLines = CustomIdsJsonMapGeneratorService.getFileLinesFromPath(Paths.get(publicJundaFilePath));
        List<String> tzaiLines = CustomIdsJsonMapGeneratorService.getFileLinesFromPath(Paths.get(publicTzaiFilePath));
        Map<String, String> jundaMap = CustomIdsJsonMapGeneratorService.generateJundaMap(jundaLines);
        Map<String, String> tzaiMap = CustomIdsJsonMapGeneratorService.generateTzaiMap(tzaiLines);
        List<String> sorted = getSortedCharList();
        List<CharRecursionNode> nodes = new ArrayList<>();
        Map<String, List<CharRecursionNode>> overlappingNodes = new HashMap<>();

        int currentOrdinal = 1;

        for (String CJKchar : sorted) {
            if (CJKchar.equals("龜")) {
                String test = "";
            }
            CharRecursionNode node = null;
            try {
                if (CJKchar.equals("得")) {
                    String test = "";
                }
                node = new CharRecursionNode(CJKchar, null, codeDecom);
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
            //2023-07-09 kl. 1624 - testing character code overlap for ordinals less than 7349
            if (currentOrdinal == 7348) {//7348) { //7348
                //Integer contentSize = overlappingNodes.values().stream().flatMap(Collection::stream)
                //        .collect(Collectors.toList()).size();
                //System.out.println("all codes: " + contentSize);
                //System.out.println("Ordinal reached: " + currentOrdinal);

                //create a list of only heisig trad
                Map<String, List<CharRecursionNode>> onlyTrad = getTop5000Trad(overlappingNodes);
                Map<String, List<CharRecursionNode>> onlyHtrad = getOverlapsFromList(overlappingNodes, publicHtradFilePath);
                getCurrentOverlapInfoFromMapFromTzaiAndJunda(onlyHtrad, "Heisig Trad:", true);

                //create a list of only heisig simp
                Map<String, List<CharRecursionNode>> onlySimp = getTop5000Simp(overlappingNodes);
                Map<String, List<CharRecursionNode>> onlyHsimp = getOverlapsFromList(overlappingNodes, publicHsimpFilePath);
                getCurrentOverlapInfoFromMapFromTzaiAndJunda(onlyHsimp, "Heisig Simp:", false);

                getCurrentOverlapInfoFromMapFromTzaiAndJunda(onlyTrad, "only traditional:", true);
                getCurrentOverlapInfoFromMapFromTzaiAndJunda(onlySimp, "only simplified:", false);

                //all characters:
                getCurrentOverlapInfoFromMapForFullMap(overlappingNodes, "all characters:");
            }
            if (currentOrdinal > 7348) {
                return nodes;
            }
        }
        return nodes;
    }

    private static Map<String, List<CharRecursionNode>> getOverlapsFromList(Map<String, List<CharRecursionNode>> oldMap,
                                                                            String filePath){
        Set<String> charsFromFile = new HashSet<>();
        try {
            charsFromFile = getCharsFromFile(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Set<String> charsFromFile2 = charsFromFile;

        List<String> keys = oldMap.keySet().stream().toList();
        Map<String, List<CharRecursionNode>> returnMap = new HashMap<>();

        for (String key : keys) {
            List<CharRecursionNode> oldEntry = oldMap.get(key);
            List<CharRecursionNode> updated = oldEntry.stream()
                    .filter(node -> charsFromFile2.contains(node.getCurrentBreakdownSubsection().trim()))
                    .toList();
            if (updated.size() > 0) {
                returnMap.put(key, updated);
            }
        }
        return returnMap;
    }

    private static Set<String> getCharsFromFile(String filePath) throws Exception {
        Set<Integer> codePoints = Files.lines(Paths.get(filePath))
                .flatMapToInt(CharSequence::codePoints)
                .boxed()
                .filter(codePoint -> codePoint > 11900)
                .collect(Collectors.toSet());

        Set<String> stringSet = new HashSet<>();
        for (int i : codePoints) {
            if (i <= 0xFFFF) {
                stringSet.add(Character.toString((char) i));
            } else {
                char[] chars = new char[2];
                Character.toChars(i, chars, 0);
                stringSet.add(new String(chars));
            }
        }
        return stringSet;
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

    public static void getCurrentOverlapInfoFromMapFromTzaiAndJunda(Map<String, List<CharRecursionNode>> oldMap,
                                                                    String printMessage,
                                                                    boolean isTzai) {
        Integer contentSize = oldMap.values().stream().flatMap(Collection::stream)
                .collect(Collectors.toList()).size();
        System.out.println("all values in map: " + contentSize);
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
        List<CharRecursionNode> allNodes = oldMap.values().stream()
                .flatMap(Collection::stream).collect(Collectors.toSet()).stream().toList();
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
                'a','s','d','f','g','h','j','k','l', ';',
                'z','x','c','v','b','n','m', ',', '.', '/');
        for (Character currentChar : newMapOrder) {
            Long entry = normalCodeCharToMap.get(currentChar);
            if (Objects.isNull(entry)) {
                entry = 0l;
            }
            System.out.println("Char: " +currentChar + " " + (Double.valueOf(entry)/averageForEachKey));
        }
        //There should not be any printout of element use. just a map to debug
        Map<String, Long> fullCodeToMap = generateFullCodeToMap(allNodes, isTzai);

        System.out.println("end");
    }

    private static void printOverlap(String x,
                                     List<String> keys,
                                     Map<String, List<CharRecursionNode>> oldMap,
                                     Map<String, List<CharRecursionNode>> overlapMap,
                                     Map<Integer, String> overlapSize) {
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
            if (isTzai && !node.getSubsectionIdsMapResult().get(TZAICHARCOUNT).isEmpty()) {
                cjkNumberToUse = Integer.parseInt(node.getSubsectionIdsMapResult().get(TZAICHARCOUNT));
            } else if (!node.getSubsectionIdsMapResult().get(JUNDACHARCOUNT).isEmpty()) {
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
            try {
                if (node.getCurrentBreakdownSubsection().equals("数")) {
                    String test2 = "";
                }
                int cjkNumberToUse = 1;
                if (isTzai && !node.getSubsectionIdsMapResult().get(TZAICHARCOUNT).isEmpty()) {
                    cjkNumberToUse = Integer.parseInt(node.getSubsectionIdsMapResult().get(TZAICHARCOUNT));
                } else if (!node.getSubsectionIdsMapResult().get(JUNDACHARCOUNT).isEmpty()) {
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
            }catch (Exception e) {
                String test = "";
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

    public static List<CharRecursionNode> onlyNodesFromPathAndBelowNumber(List<CharRecursionNode> nodes, String filePath, int minimumNumber) {
        Set<String> charsFromFile = new HashSet<>();
        try {
            charsFromFile = getCharsFromFile(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Set<String> charsFromFile2 = charsFromFile;
        List<CharRecursionNode> result = nodes.stream()
                .filter(node -> charsFromFile2.contains(node.getCurrentBreakdownSubsection())).toList();
        return result;
    }

    private static boolean isAscii(String str) {
        for (int i = 0; i < str.length(); i++) {
            if ((int) str.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }

    private static List<String> reverseList(List<String> list) {
        List<String> result = new ArrayList<>();
        int size = list.size();
        for (int i = list.size()-1; i > -1; i--) {
            String temp = list.get(i);
            result.add(temp);
        }
        return result;
    }

}
