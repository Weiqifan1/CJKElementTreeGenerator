package CustomDataGenerator.AYMethodTestPackage;


import org.example.InputMethods.InputMethodData.AYmethodInputData;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.GenericTypes.CodeDecompositionType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator.CodeRecursionObjectGenerator.getNodeList;
import static org.example.InputMethods.InputMethodCodeGenerators.AYMethodCodeGeneratorService.nodeListToMap;
import static org.junit.Assert.assertNotEquals;

public class AYMethodCodeGeneratorServiceTest_avoidOverlaps {

    private static List<CharRecursionNode> nodelist;
    private static Map<String, CharRecursionNode> nodeMap;
    private static Map<String, String> codeMap;

    @BeforeClass
    public static void setUp() {
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
    public void topPersonAndLeftPerson() {
        CharRecursionNode topPerson = nodeMap.get("朱");
        CharRecursionNode leftPerson = nodeMap.get("休");
        assertNotEquals(topPerson.getNormalCode(), leftPerson.getNormalCode());
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

    @Test
    public void treeSecAndGround() {
        String xxx1 = codeMap.get("木");
        String xxx2 = codeMap.get("土");
        assertNotEquals(xxx1.substring(1), xxx2.substring(0,1));
        CharRecursionNode treeSec = nodeMap.get("香");
        CharRecursionNode ground = nodeMap.get("程");
        assertNotEquals(treeSec.getNormalCode(), ground.getNormalCode());
    }

    @Test
    public void plantAndGround() {
        //plant radical and ground has to have different first letters
        CharRecursionNode plant = nodeMap.get("著");
        CharRecursionNode ground = nodeMap.get("堵");
        assertNotEquals(plant.getNormalCode(), ground.getNormalCode());
    }

    @Test
    public void charAndMouth() {
        CharRecursionNode car = nodeMap.get("車");
        CharRecursionNode mouth = nodeMap.get("口");
        assertNotEquals(car.getNormalCode().get(0).substring(0,1), mouth.getNormalCode().get(0).substring(0,1));
    }

    @Test
    public void ordinaryAndLaddle() {
        CharRecursionNode ordinary = nodeMap.get("凡");
        CharRecursionNode laddle = nodeMap.get("勺");
        assertNotEquals(ordinary.getNormalCode().get(0), laddle.getNormalCode().get(0));
    }

    @Test
    public void treeMouthOverlapAndTopButtom() {
        CharRecursionNode treeMouthOverlap = nodeMap.get("束");
        CharRecursionNode treeMouthTopDown = nodeMap.get("杏");
        assertNotEquals(treeMouthOverlap.getNormalCode().get(0), treeMouthTopDown.getNormalCode().get(0));
    }

    @Test
    public void saltAndSupervise() {
        //⺊ 丶
        String xxx1 = codeMap.get("⺊");
        String xxx2 = codeMap.get("丶");
        assertNotEquals(xxx1.substring(1), xxx2.substring(0,1));

        CharRecursionNode salt = nodeMap.get("鹽");
        CharRecursionNode supervise = nodeMap.get("監");
        assertNotEquals(salt.getNormalCode().get(0), supervise.getNormalCode().get(0));
    }

    @Test
    public void friendAndContrary() {
        CharRecursionNode friend = nodeMap.get("友");
        CharRecursionNode countrary = nodeMap.get("反");
        assertNotEquals(friend.getNormalCode().get(0), countrary.getNormalCode().get(0));
    }

    @Test
    public void teacherAndCommander() {
        CharRecursionNode commander = nodeMap.get("師");
        CharRecursionNode teacher = nodeMap.get("帥");
        assertNotEquals(teacher.getNormalCode().get(0), commander.getNormalCode().get(0));
    }

    @Test
    public void drinkAndRespect() {
        CharRecursionNode drink = nodeMap.get("飲");
        CharRecursionNode respect = nodeMap.get("欽");
        assertNotEquals(drink.getNormalCode().get(0), respect.getNormalCode().get(0));
    }

    @Test
    public void brilliantAndFear() {
        CharRecursionNode brillliant = nodeMap.get("煌");
        CharRecursionNode fear = nodeMap.get("惶");
        assertNotEquals(brillliant.getNormalCode().get(0), fear.getNormalCode().get(0));
    }

    @Test
    public void sayAndStandCantHaveSameCode() { //請靖
        CharRecursionNode ask = nodeMap.get("請");
        CharRecursionNode quit = nodeMap.get("靖");
        assertNotEquals(ask.getNormalCode().get(0), quit.getNormalCode().get(0));
    }

    @Test
    public void waterAndHorse() {
        CharRecursionNode water = nodeMap.get("注");
        CharRecursionNode horse = nodeMap.get("駐");
        assertNotEquals(water.getNormalCode().get(0), horse.getNormalCode().get(0));
    }


    @Test
    public void guideAndObey() { //導遵 --䒑 needs to be an element
        CharRecursionNode guide = nodeMap.get("導");
        CharRecursionNode obey = nodeMap.get("遵");
        assertNotEquals(guide.getNormalCode().get(0), obey.getNormalCode().get(0));
    }

    //疲瘦
    @Test
    public void wearyAndThin() { //疲瘦 -- 疒 needs to be at most 2 element
        CharRecursionNode weary = nodeMap.get("疲");
        CharRecursionNode thin = nodeMap.get("瘦");
        assertNotEquals(weary.getNormalCode().get(0), thin.getNormalCode().get(0));
    }

    @Test
    public void casingAndGrain() { //穀穀 - 殳 needs to be an element
        CharRecursionNode grain = nodeMap.get("穀");
        CharRecursionNode casing = nodeMap.get("殼");
        assertNotEquals(grain.getNormalCode().get(0), casing.getNormalCode().get(0));
    }

    @Test
    public void protectAndElbow() { //守肘 - 宀月 needs to have diffent codes
        CharRecursionNode protect = nodeMap.get("守");
        CharRecursionNode elbow = nodeMap.get("肘");
        assertNotEquals(protect.getNormalCode().get(0), elbow.getNormalCode().get(0));
    }

    @Test
    public void meetAndRecide() { //遇寓 - 辶宀 needs to have different codes
        CharRecursionNode meet = nodeMap.get("遇");
        CharRecursionNode recide = nodeMap.get("寓");
        assertNotEquals(meet.getNormalCode().get(0), recide.getNormalCode().get(0));
    }

    @Test
    public void emptyAndConfuse() { //謬寥 言宀 diff
        CharRecursionNode confuse = nodeMap.get("謬");
        CharRecursionNode empty = nodeMap.get("寥");
        assertNotEquals(empty.getNormalCode().get(0), confuse.getNormalCode().get(0));
    }

    @Test
    public void dilligentAndReinin勒勤() {  //龶十
        CharRecursionNode dilligent = nodeMap.get("勒");
        CharRecursionNode reinin = nodeMap.get("勤");
        assertNotEquals(dilligent.getNormalCode().get(0), reinin.getNormalCode().get(0));
    }

    @Test
    public void singAndGoods唱晶() {  //唱晶
        CharRecursionNode sing = nodeMap.get("唱");
        CharRecursionNode goods = nodeMap.get("晶");
        assertNotEquals(sing.getNormalCode().get(0), goods.getNormalCode().get(0));
    }

    @Test
    public void betAndObserve() {  //賭睹
        CharRecursionNode bet = nodeMap.get("賭");
        CharRecursionNode observe = nodeMap.get("睹");
        assertNotEquals(bet.getNormalCode().get(0), observe.getNormalCode().get(0));
    }

    @Test
    public void coldAndBell冷鈴() {  //冷鈴
        CharRecursionNode cold = nodeMap.get("冷");
        CharRecursionNode bell = nodeMap.get("鈴");
        assertNotEquals(cold.getNormalCode().get(0), bell.getNormalCode().get(0));
    }

    @Test
    public void actuallyParents_standMustBeOneElem() {  //竟親
        CharRecursionNode actually = nodeMap.get("竟");
        CharRecursionNode parents = nodeMap.get("親");
        assertNotEquals(actually.getNormalCode().get(0), parents.getNormalCode().get(0));

        CharRecursionNode x1 = nodeMap.get("辦"); //辦辯 - stand must be one element
        CharRecursionNode x2 = nodeMap.get("辯");
        assertNotEquals(x1.getNormalCode().get(0), x2.getNormalCode().get(0));
    }

    @Test
    public void standAndClothes() {//章裡童
        CharRecursionNode inside = nodeMap.get("裡");
        CharRecursionNode boy = nodeMap.get("童");
        assertNotEquals(inside.getNormalCode().get(0), boy.getNormalCode().get(0));
    }

    @Test
    public void standAndHeart() {//靖情
        CharRecursionNode emotion = nodeMap.get("情");
        CharRecursionNode quit = nodeMap.get("靖");
        assertNotEquals(emotion.getNormalCode().get(0), quit.getNormalCode().get(0));
    }

    @Test
    public void spokesAndBat() {//輻蝠 car and
        CharRecursionNode spokes = nodeMap.get("輻");
        CharRecursionNode bat = nodeMap.get("蝠");
        assertNotEquals(spokes.getNormalCode().get(0), bat.getNormalCode().get(0));
    }

    @Test
    public void frogAndWow() {//哇蛙 car and
        CharRecursionNode frog = nodeMap.get("哇");
        CharRecursionNode wow = nodeMap.get("蛙");
        assertNotEquals(frog.getNormalCode().get(0), wow.getNormalCode().get(0));
    }

    @Test
    public void treeAndOne() { //本末未
        CharRecursionNode root = nodeMap.get("本");
        CharRecursionNode finalChar = nodeMap.get("末");
        CharRecursionNode notyet = nodeMap.get("未");
        assertNotEquals(root.getNormalCode().get(0), finalChar.getNormalCode().get(0));
        assertNotEquals(root.getNormalCode().get(0), notyet.getNormalCode().get(0));
        assertNotEquals(notyet.getNormalCode().get(0), finalChar.getNormalCode().get(0));
    }

    ///////////////////////////////////////////////////////////////////////
    /////////////////    coincidental overlaps
    ///////////////////////////////////////////////////////////////////////

    @Test
    public void rudeAndCrocodile() {
        CharRecursionNode rude = nodeMap.get("魯");
        CharRecursionNode crocodile = nodeMap.get("鱷");
        assertNotEquals(rude.getNormalCode().get(0), crocodile.getNormalCode().get(0));
    }

    @Test
    public void motherAndToEnvy_nuShouldHaveCode() {  //娘妒
        CharRecursionNode mother = nodeMap.get("娘");
        CharRecursionNode toEnvy = nodeMap.get("妒");
        assertNotEquals(mother.getNormalCode().get(0), toEnvy.getNormalCode().get(0));
    }

    @Test
    public void rankAndToken() { //等籌   土士-cant start on same letters, or 寸 must be element
        CharRecursionNode rank = nodeMap.get("等");
        CharRecursionNode token = nodeMap.get("籌");
        assertNotEquals(rank.getNormalCode().get(0), token.getNormalCode().get(0));

    }

    //@Test
    //public void //拉撞攏


}
