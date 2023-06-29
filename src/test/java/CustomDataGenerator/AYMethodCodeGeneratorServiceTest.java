package CustomDataGenerator;

import org.example.CustomStaticDataGenerators.CustomIdsJsonMapGeneratorService;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import static org.example.CustomStaticDataGenerators.CustomIdsJsonMapGeneratorService.orderedFrequencyList;
import static org.example.GlobalConstants.publicJundaFilePath;
import static org.example.GlobalConstants.publicTzaiFilePath;
import static org.junit.Assert.assertEquals;

public class AYMethodCodeGeneratorServiceTest {

    private List<String> getSortedCharList() {
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

    @Test
    public void testCreateCodesForTziaAndJunda_TzaiAndJunda(){
        List<String> jundaLines = CustomIdsJsonMapGeneratorService.getFileLinesFromPath(Paths.get(publicJundaFilePath));
        List<String> tzaiLines = CustomIdsJsonMapGeneratorService.getFileLinesFromPath(Paths.get(publicTzaiFilePath));
        Map<String, String> jundaMap = CustomIdsJsonMapGeneratorService.generateJundaMap(jundaLines);
        Map<String, String> tzaiMap = CustomIdsJsonMapGeneratorService.generateTzaiMap(tzaiLines);

        List<String> sorted = getSortedCharList();

        int currentOrdinal = 1;
        List<List<String>> ordCharsAndCodes = new ArrayList<>();

        for (String CJKchar : sorted) {
            if (CJKchar.equals("在")) {
                String test = "";
            }
            List<String> ordcharcode = new ArrayList<>();
            ordcharcode.add(String.valueOf(currentOrdinal));
            ordcharcode.add(CJKchar);
            CharRecursionNode node = null;
            try {
                node = new CharRecursionNode(CJKchar, null);
            } catch (Exception e) {
                System.out.println(CJKchar);
                System.out.println("tzai: " + tzaiMap.get(CJKchar));
                System.out.println("junda: "+ jundaMap.get(CJKchar));
                System.out.println("Ordinal " + currentOrdinal);
            }
            //add the tzai and junda numbers
            ordcharcode.add(tzaiMap.get(CJKchar));
            ordcharcode.add(jundaMap.get(CJKchar));
            ordcharcode.addAll(node.getNormalCode());
            ordCharsAndCodes.add(ordcharcode);
            currentOrdinal++;
        }

        assertEquals(sorted.size(), ordCharsAndCodes.size());
    }


    @Test
    public void testGenerateFullCodeFromCodeMap_basic() throws DataFormatException {

        //的 1
        CharRecursionNode de1 = new CharRecursionNode("的", null);
        assertEquals(Set.of("lplh", "lpla"), de1.getNormalCode().stream().collect(Collectors.toSet()));
        //TODO: implement the test
        //我 4
        CharRecursionNode wo4 = new CharRecursionNode("我", null);
        assertEquals(Set.of("lokh"), wo4.getNormalCode().stream().collect(Collectors.toSet()));
        //就 26
        CharRecursionNode jiu26 = new CharRecursionNode("就", null);
        assertEquals(Set.of("ha;h", "da;h"), jiu26.getNormalCode().stream().collect(Collectors.toSet()));

        //還 56
        CharRecursionNode hai56 = new CharRecursionNode("還", null);
        //n represent the 辶 stroke. For now, I will follow ids order, not stroke order for whole characters.
        //the codes for elements will still follow strokeorder, except for the normal array rules.
        assertEquals(Set.of("n/a."), hai56.getNormalCode().stream().collect(Collectors.toSet()));

    }


}
