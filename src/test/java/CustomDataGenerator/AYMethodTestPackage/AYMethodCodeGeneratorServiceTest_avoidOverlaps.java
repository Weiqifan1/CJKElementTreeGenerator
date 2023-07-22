package CustomDataGenerator.AYMethodTestPackage;


import org.example.InputMethods.InputMethodData.AYmethodInputData;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.GenericTypes.CodeDecompositionType;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator.CodeRecursionObjectGenerator.getNodeList;
import static org.example.InputMethods.InputMethodCodeGenerators.AYMethodCodeGeneratorService.nodeListToMap;
import static org.junit.Assert.assertNotEquals;

public class AYMethodCodeGeneratorServiceTest_avoidOverlaps {

    private List<CharRecursionNode> nodelist;
    private Map<String, CharRecursionNode> nodeMap;
    private Map<String, String> codeMap;

    @Before
    public void setUp() {
         nodelist = getNodeList(CodeDecompositionType.CODE5_123zy_LIMMITBACKTRACK);
         nodeMap = nodeListToMap(nodelist);
        codeMap = AYmethodInputData.arrayInspiredElemsV1;
    }

    @Test
    public void testtest() {
        CharRecursionNode test = nodeMap.get("逸");

        String test2 = "";
    }

    @Test
    public void leftSideHandAndLeftFoot() {
        CharRecursionNode leftSideHand = nodeMap.get("投");
        CharRecursionNode leftSideLeftFoot = nodeMap.get("役");
        assertNotEquals(leftSideHand.getNormalCode(), leftSideLeftFoot.getNormalCode());
    }

    @Test
    public void topPersonAndLeftsideHand() {
        CharRecursionNode topPerson = nodeMap.get("每");
        CharRecursionNode leftSideHand = nodeMap.get("拇");
        assertNotEquals(topPerson.getNormalCode(), leftSideHand.getNormalCode());
    }

    @Test
    public void topRoofAndLeftsideClothes() {
        CharRecursionNode topRoof = nodeMap.get("容");
        CharRecursionNode leftsideClothes = nodeMap.get("裕");
        assertNotEquals(topRoof.getNormalCode(), leftsideClothes.getNormalCode());
    }

    @Test
    public void topRooAndLeftCave() {
        String topRoof = codeMap.get("宀");
        String leftCave = codeMap.get("广");
        assertNotEquals(topRoof.substring(0,1), leftCave.substring(0,1));
    }

    //希  佈

    @Test
    public void xxxAndLeftMan() { //佈  希
        String leftMan = codeMap.get("亻");
        //arrayInspiredElemsV1.put("乂", ".k"); //ex. 文
        //arrayInspiredElemsV1.put("㐅", ".k"); //ex. 學
        String xxx1 = codeMap.get("乂");
        String xxx2 = codeMap.get("㐅");
        assertNotEquals(leftMan.substring(0,1), xxx1.substring(0,1));
        assertNotEquals(leftMan.substring(0,1), xxx2.substring(0,1));
    }

    @Test
    public void fireAndEat() {
        CharRecursionNode fire = nodeMap.get("炮");
        CharRecursionNode eat = nodeMap.get("飽");
        assertNotEquals(fire.getNormalCode(), eat.getNormalCode());
    }

}
