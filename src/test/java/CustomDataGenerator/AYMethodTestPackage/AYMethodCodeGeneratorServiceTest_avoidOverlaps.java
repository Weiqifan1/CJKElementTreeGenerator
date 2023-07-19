package CustomDataGenerator.AYMethodTestPackage;


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

    @Before
    public void setUp() {
         nodelist = getNodeList(CodeDecompositionType.CODE5_123zy_LIMMITBACKTRACK);
         nodeMap = nodeListToMap(nodelist);
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

}
