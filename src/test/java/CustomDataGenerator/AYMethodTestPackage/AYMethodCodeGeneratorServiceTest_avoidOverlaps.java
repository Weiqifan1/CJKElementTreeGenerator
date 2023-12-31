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
         nodelist = getNodeList(CodeDecompositionType.CODE5_123zy_LIMMITBACKTRACK, true);
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

    @Test
    public void smeltAndVariant() { //煉鍊 fire and metal must have different codes
        CharRecursionNode smelt = nodeMap.get("鍊");
        CharRecursionNode variant = nodeMap.get("煉");
        assertNotEquals(smelt.getNormalCode().get(0), variant.getNormalCode().get(0));
    }

    @Test
    public void onlyAndBa() {
        CharRecursionNode only = nodeMap.get("只");
        CharRecursionNode ba = nodeMap.get("叭");
        assertNotEquals(only.getNormalCode().get(0), ba.getNormalCode().get(0));
    }

    @Test
    public void returnAndGoods() { //固咕 回品 surround cant be mouth and cant be mouth x 2
        CharRecursionNode curve = nodeMap.get("回");
        CharRecursionNode goods = nodeMap.get("品");
        assertNotEquals(curve.getNormalCode().get(0), goods.getNormalCode().get(0));
        CharRecursionNode hard = nodeMap.get("固");
        CharRecursionNode birdsound = nodeMap.get("咕");
        assertNotEquals(hard.getNormalCode().get(0), birdsound.getNormalCode().get(0));
    }

    @Test //富幅
    public void richAndWidth() {
        CharRecursionNode rich = nodeMap.get("富");
        CharRecursionNode width = nodeMap.get("幅");
        assertNotEquals(rich.getNormalCode().get(0), width.getNormalCode().get(0));
    }

    @Test //隊遂
    public void teamAndSucceed() {
        CharRecursionNode team = nodeMap.get("隊");
        CharRecursionNode succeed = nodeMap.get("遂");
        assertNotEquals(team.getNormalCode().get(0), succeed.getNormalCode().get(0));
    }

    @Test
    public void extendAndShellAndReason() {  //申甲由
        CharRecursionNode reason = nodeMap.get("由");
        CharRecursionNode shell = nodeMap.get("甲");
        CharRecursionNode extend = nodeMap.get("申");
        assertNotEquals(reason.getNormalCode().get(0), shell.getNormalCode().get(0));
        assertNotEquals(reason.getNormalCode().get(0), extend.getNormalCode().get(0));
        assertNotEquals(shell.getNormalCode().get(0), extend.getNormalCode().get(0));
    }

    @Test //棘棗
    public void thornsAndDate() {
        CharRecursionNode date = nodeMap.get("棗");
        CharRecursionNode thorns = nodeMap.get("棘");
        assertNotEquals(thorns.getNormalCode().get(0), date.getNormalCode().get(0));
    }

    @Test
    public void dirtAndShi() {
        CharRecursionNode shi = nodeMap.get("士");
        CharRecursionNode dirt = nodeMap.get("土");
        assertNotEquals(shi.getNormalCode().get(0), dirt.getNormalCode().get(0));
    }

    @Test
    public void itAndAlready() {  //之已
        CharRecursionNode it = nodeMap.get("之");
        CharRecursionNode already = nodeMap.get("已");
        assertNotEquals(it.getNormalCode().get(0), already.getNormalCode().get(0));
    }

    @Test //  鸣鳴  呜嗚
    public void birds() {
        //島烏
        CharRecursionNode simpcry = nodeMap.get("鸣");
        CharRecursionNode tradcry = nodeMap.get("鳴");
        CharRecursionNode simphumm = nodeMap.get("呜");
        CharRecursionNode tradhumm = nodeMap.get("嗚");
        assertNotEquals(simpcry.getNormalCode().get(0), simphumm.getNormalCode().get(0));
        assertNotEquals(tradcry.getNormalCode().get(0), tradhumm.getNormalCode().get(0));
    }

    @Test
    public void weakAndFeather() {//弱羽 Bent stroke and Bow overlap
        CharRecursionNode weak = nodeMap.get("弱");
        CharRecursionNode feather = nodeMap.get("羽");
        assertNotEquals(weak.getNormalCode().get(0), feather.getNormalCode().get(0));
    }

    @Test
    public void workAndSpoon() {  //項頃
        CharRecursionNode work = nodeMap.get("項");
        CharRecursionNode spoon = nodeMap.get("頃");
        assertNotEquals(work.getNormalCode().get(0), spoon.getNormalCode().get(0));
    }

    @Test
    public void goldAndFire() {//欽炊
        CharRecursionNode gold = nodeMap.get("欽");
        CharRecursionNode fire = nodeMap.get("炊");
        assertNotEquals(gold.getNormalCode().get(0), fire.getNormalCode().get(0));
    }

    @Test
    public void fireAndSpoon() { //能熊
        CharRecursionNode spoon = nodeMap.get("能");
        CharRecursionNode fire = nodeMap.get("熊");
        assertNotEquals(spoon.getNormalCode().get(0), fire.getNormalCode().get(0));
    }

    @Test
    public void tinyAndScale() { //微徵
        CharRecursionNode tiny = nodeMap.get("微");
        CharRecursionNode scale = nodeMap.get("徵");
        assertNotEquals(tiny.getNormalCode().get(0), scale.getNormalCode().get(0));
    }

    //利刹 simp
    @Test
    public void sharpAndBreak() { //left slant and cross must have different starting letters - simp
        CharRecursionNode sharp = nodeMap.get("利");
        CharRecursionNode breaK = nodeMap.get("刹");
        assertNotEquals(sharp.getNormalCode().get(0), breaK.getNormalCode().get(0));
    }

    @Test //内贝
    public void insideAndCowrie() { //shell 贝 has to be a separate element --simp
        CharRecursionNode inside = nodeMap.get("内");
        CharRecursionNode shell = nodeMap.get("贝");
        assertNotEquals(inside.getNormalCode().get(0), shell.getNormalCode().get(0));
    }

    @Test
    public void swellAndBill() {  //胀账 -- simp
        CharRecursionNode swell = nodeMap.get("胀");
        CharRecursionNode bill = nodeMap.get("账");
        assertNotEquals(swell.getNormalCode().get(0), bill.getNormalCode().get(0));
    }

    @Test
    public void preferAndGaze() { //宁盯 -- simp
        CharRecursionNode prefer = nodeMap.get("宁");
        CharRecursionNode gaze = nodeMap.get("盯");
        assertNotEquals(prefer.getNormalCode().get(0), gaze.getNormalCode().get(0));
    }

    @Test
    public void hogAndExtravagant() { //奢猪 -- dog and dog radical -simp
        CharRecursionNode dog = nodeMap.get("猪");
        CharRecursionNode dograd = nodeMap.get("奢");
        assertNotEquals(dog.getNormalCode().get(0), dograd.getNormalCode().get(0));
    }

    @Test
    public void canopyAndBill() {   //帐账 -- simp
        CharRecursionNode canopy = nodeMap.get("帐");
        CharRecursionNode bill = nodeMap.get("账");
        assertNotEquals(canopy.getNormalCode().get(0), bill.getNormalCode().get(0));
    }

    @Test
    public void excuseAndRabbit() {   //免兔 -- simp
        CharRecursionNode excuse = nodeMap.get("免");
        CharRecursionNode rabbit = nodeMap.get("兔");
        assertNotEquals(excuse.getNormalCode().get(0), rabbit.getNormalCode().get(0));
    }

    @Test
    public void forceAndAbandon() { //势抛 //势执  -- simp
        CharRecursionNode force = nodeMap.get("势");
        CharRecursionNode abandon = nodeMap.get("抛");
        CharRecursionNode grasp = nodeMap.get("执");
        assertNotEquals(force.getNormalCode().get(0), abandon.getNormalCode().get(0));
        assertNotEquals(force.getNormalCode().get(0), grasp.getNormalCode().get(0));
        assertNotEquals(abandon.getNormalCode().get(0), grasp.getNormalCode().get(0));
    }

    @Test
    public void powerAndAgain() {  //力又
        CharRecursionNode power = nodeMap.get("力");
        CharRecursionNode again = nodeMap.get("又");
        assertNotEquals(power.getNormalCode().get(0), again.getNormalCode().get(0));
    }

    @Test
    public void darkAndBald() { // 黎禿  simp
        CharRecursionNode dark = nodeMap.get("黎");
        CharRecursionNode bald = nodeMap.get("禿");
        assertNotEquals(dark.getNormalCode().get(0), bald.getNormalCode().get(0));
    }

    @Test
    public void tinyAndDevil() { // 麼魔  trad
        CharRecursionNode tiny = nodeMap.get("麼");
        CharRecursionNode devil = nodeMap.get("魔");
        assertNotEquals(tiny.getNormalCode().get(0), devil.getNormalCode().get(0));
    }

    //昂
    @Test
    public void liftAndPleiades() { //昂昴
        CharRecursionNode toLift = nodeMap.get("昂");
        CharRecursionNode pleiades = nodeMap.get("昴");
        assertNotEquals(toLift.getNormalCode().get(0), pleiades.getNormalCode().get(0));
    }


    ///////////////////////////////////////////////////////////////////////
    /////////////////    coincidental overlaps
    ///////////////////////////////////////////////////////////////////////

    @Test
    public void disguiseAndBreakoff() { //扮掰
        CharRecursionNode disguise = nodeMap.get("扮");
        CharRecursionNode breakoff = nodeMap.get("掰");
        assertNotEquals(disguise.getNormalCode().get(0), breakoff.getNormalCode().get(0));
    }

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

    @Test
    public void obstructAndFoundation() { //礙礎 - 石 must be 1 or 2 codes, 丆 should probably be and element
        CharRecursionNode obstruct = nodeMap.get("礙");
        CharRecursionNode foundation = nodeMap.get("礎");
        assertNotEquals(obstruct.getNormalCode().get(0), foundation.getNormalCode().get(0));

        CharRecursionNode stone = nodeMap.get("石");
        CharRecursionNode right = nodeMap.get("右");
        assertNotEquals(stone.getNormalCode().get(0), right.getNormalCode().get(0));
    }
    //public void //礙礎

    @Test //靠甜
    public void leanAndSweet() {
        CharRecursionNode lean = nodeMap.get("靠");
        CharRecursionNode sweet = nodeMap.get("甜");
        assertNotEquals(lean.getNormalCode().get(0), sweet.getNormalCode().get(0));
    }

    @Test //用申
    public void yongAndReport() {
        CharRecursionNode use = nodeMap.get("用");
        CharRecursionNode report = nodeMap.get("申");
        assertNotEquals(use.getNormalCode().get(0), report.getNormalCode().get(0));
    }

    @Test //組繩
    public void formAndRope() {
        CharRecursionNode form = nodeMap.get("組");
        CharRecursionNode rope = nodeMap.get("繩");
        assertNotEquals(form.getNormalCode().get(0), rope.getNormalCode().get(0));
    }

    @Test //兄史
    public void brotherAndHistory() {
        CharRecursionNode brother = nodeMap.get("兄");
        CharRecursionNode history = nodeMap.get("史");
        assertNotEquals(brother.getNormalCode().get(0), history.getNormalCode().get(0));
    }

    @Test
    public void thereforeAndArtful() {
        CharRecursionNode therefore = nodeMap.get("乃");
        CharRecursionNode artful = nodeMap.get("刁");
        assertNotEquals(therefore.getNormalCode().get(0), artful.getNormalCode().get(0));
    }

    @Test
    public void touchAndCrab_simp() {//simplified
        CharRecursionNode touch = nodeMap.get("触");
        CharRecursionNode crab = nodeMap.get("蟹");
        assertNotEquals(touch.getNormalCode().get(0), crab.getNormalCode().get(0));
    }

    @Test
    public void dragonAndOutstanding() { //龙尤 -- simp
        CharRecursionNode dragon = nodeMap.get("龙");
        CharRecursionNode outs = nodeMap.get("尤");
        assertNotEquals(dragon.getNormalCode().get(0), outs.getNormalCode().get(0));
    }


}
