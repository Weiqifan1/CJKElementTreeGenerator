package org.example.InputMethods;

import org.example.ObjectTypes.GenericTypes.CharMetaInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.DataFormatException;

import static org.example.InputMethods.CustomStrokeCollections.*;
import static org.example.ObjectTypes.GenericTypes.CJKDescription.*;

public class CustomIdsSupplementMaps {

    private Map<CharMetaInfo, String> tempMap = new HashMap<>();

    public static final HashMap<String, String> customIdsSupplement = new HashMap<>();
    static {
        try {
            //Stroke collections that have unicode char representations  ⿱立日
            //(for stroke collections that dont are in CustomStrokeCollection enums)
            customIdsSupplement.put("立", "⿱"+"亠"+"䒑");
            customIdsSupplement.put("彳", "⿱"+LEFTSLANT_SHARP.val() + "亻" ); //彳
            customIdsSupplement.put("女", OVERLAP.desc() + OVERLAP.desc() + RIGHTBENTBUT_SHARP.val()+LEFTSLANT_SHARP.val()+"一"); //女
            customIdsSupplement.put("勹", OVERLAP.desc()+LEFTSLANT_SHARP.val()+BENTTOPHOOK_LARGE.val()); //勹
            customIdsSupplement.put("白", "⿻"+LEFTSLANT_SHARP.val()+"日");
            customIdsSupplement.put("噩", "⿻王㗊");
            customIdsSupplement.put("戊", OVERLAP.desc()+"厂" + OLAP3WORIGHTSTROKES.val());//ids 戊
            customIdsSupplement.put("我", OVERLAP.desc()+OVERLAP.desc()+LEFTSLANT_SHARP.val()+"扌"+OLAP3WORIGHTSTROKES.val()); //ids 我
            customIdsSupplement.put("尢", "⿸𠂇"+ RIGHTBENTBUTHOOK_LARGE.val());
            customIdsSupplement.put("卜", "⿻丨"+DOTRIGHT.val());
            customIdsSupplement.put("⺊", "⿻丨一");
            customIdsSupplement.put("也", "⿻"+BENTTOPHOOK_LARGE.val()+"⿻丨"+ RIGHTBENTBUTHOOK_LARGE.val());//?
            customIdsSupplement.put("不", "⿱一" +OLAP3DOWNFORk.key());
            customIdsSupplement.put("在", "⿸"+OUTTOPLEFT3.key()+"土");
            customIdsSupplement.put("存", "⿸"+OUTTOPLEFT3.key()+"子"); //存 ids ⿸③子
            customIdsSupplement.put("月", ENCIRTOP.desc()+OUTER2TOP_USEANDMOONE.val()+"⿱一一"); //月 shoud have the same enclosure as 用
            customIdsSupplement.put("门", "⿻"+DOTRIGHT.val()+"⿻丨"+BENTTOPHOOK_LARGE.val());
            customIdsSupplement.put("以", "⿻"+ RIGHTBENTBUTHOOK_LARGE.val()+"⿻"+DOTRIGHT.val()+"人");
            customIdsSupplement.put("来", "⿻木⿻丷一");
            customIdsSupplement.put("为", "⿻"+DOTRIGHT.val()+"⿻力"+DOTRIGHT.val());
            customIdsSupplement.put("欠", "⿱"+"𠂊"+"人");
            customIdsSupplement.put("𠂊", "⿻"+LEFTSLANT_SHARP.val()+BENTTOPHOOK_LARGE.val());//你欠
            customIdsSupplement.put("⺌", "⿻" + "丨" + "丷"); // 會
            customIdsSupplement.put("龰", ENCBUTLEFT.desc()+"人⺊"); //eg. 㧿 ⿰扌⿱从龰
            //arrayInspiredElemsV1.put("龰", "cz"); //c=3+8 z=a+9
            customIdsSupplement.put("為", "⿻"+DOTRIGHT.val()+"⿻"+LEFTSLANT_SHARP.val()+"⿻"
                    +BENTTOPHOOK_LARGE.val()+"⿻"+BENTTOPHOOK_LARGE.val()+"⿻"+BENTTOPHOOK_LARGE.val()+"灬");//為
            customIdsSupplement.put("臼", "⿻"+LEFTSLANT_HORI.val()+"⿻"+"丨"+"⿻"+"一"+"⿻"+BENTTOPHOOK_LARGE.val()+"⿻"+"一"+"一");
            customIdsSupplement.put("𦥑", "⿻"+LEFTSLANT_HORI.val()+"⿻"+"丨"+"⿻"+"一"+"⿻"+"一"+"⿻"+BENTTOPHOOK_LARGE.val()+"⿻"+"一"+"一");
            customIdsSupplement.put("與", "⿶"+"⿳𦥑"+OVERLAP.desc()+"一"+ DOUBLEBENT_25_WITHHOOK.val()+"丨"
                    + OVERLAP.desc()+"一"+"八"); //ids 與 ⿶⿳𦥑一八⿹②丿
            customIdsSupplement.put("子", "⿻"+BENTTOPHOOK_LARGE.val()+OUTTOPRIGHT2.val());
            customIdsSupplement.put("孑", "⿻"+"⿻"+BENTTOPHOOK_LARGE.val()+"亅"+"一"); //孑 ids 孑
            customIdsSupplement.put("孓", "⿻"+"⿻"+BENTTOPHOOK_LARGE.val()+"亅"+RIGHTSLANT_SHARP.val()); //孓
            customIdsSupplement.put("寸", ENCTOPRIGHT.desc()+OUTTOPRIGHT2.val()+DOTRIGHT.val());
            customIdsSupplement.put("才", ""+ENCTOPRIGHT.desc()+OUTTOPRIGHT2.val()+LEFTSLANT_SHARP.val()); //ids 才
            customIdsSupplement.put("于", "⿱"+"一"+OUTTOPRIGHT2.val()); //于
            customIdsSupplement.put("冎", "⿱⿵"+OUTER2TOP_STRAIGHT.val()+"𠃍"+OUTER2TOP_STRAIGHT.val()); //冎 eg. 過
            customIdsSupplement.put("骨", "⿱冎⿵"+OUTER2TOP_USEANDMOONE.val()+"⿱"+DOTRIGHT.val()+DOTLEFT.val()); //骨 from 體
            customIdsSupplement.put("自", "⿻"+DOTLEFT.val()+"目"); //eg. 、 自

            customIdsSupplement.put("凵", "⿻"+ RIGHTBENTBUTHOOK_LARGE.val()+"丨"); //出
            customIdsSupplement.put("生", "⿻"+LEFTSLANT_SHARP.val() +"⿻"+OLAP3RUSSIANCROSS.key()+"一");//生 compare 用 ⿵冂⿻二丨
            customIdsSupplement.put("龶", "⿻"+OLAP3RUSSIANCROSS.key()+"一"); //eg. 請
            customIdsSupplement.put("円", ENCIRTOP.desc()+OUTER2TOP_STRAIGHT.val()+OVERLAP.desc() +"丨"+ "一"); // 請 buttom right alternative
            customIdsSupplement.put("之", "⿱丶" + OVERLAP.desc() + BENTTOPHOOK_LARGE.val() + "乀"); //之 ⿱丶②
            customIdsSupplement.put("𠂉", OVERLAP.desc() + LEFTSLANT_SHARP.val() + "一"); //=  = //𠂉 //from 知  or 年
            customIdsSupplement.put("年", "⿱" + "𠂉" + OLAP4NIENBUT.key()); //年 年
            customIdsSupplement.put("发", "⿺" + "⿸" + "⿻" + RIGHTBENTBUTHOOK_LARGE.val() + LEFTSLANT_SHARP.val() +"又" + DOTRIGHT.val()); // 发
            customIdsSupplement.put("幺", OVERLAP.desc() + RIGHTBENTBUTHOOK_LARGE.val() + "厶"); //幺 from 麼
            customIdsSupplement.put("厶", OVERLAP.desc() + RIGHTBENTBUTHOOK_LARGE.val() + DOTRIGHT.val()); //厶
            customIdsSupplement.put("乍", "⿱" + OVERLAP.desc() + LEFTSLANT_SHARP.val() + "一" + OLAP3ZHABUT.key() );// 乍
            customIdsSupplement.put("耳", OVERLAP.desc()+"一"+OVERLAP.desc()+OLAP3ZHABUT.key()+"十"); //ids 耳
            customIdsSupplement.put("大", OVERLAP.desc()+"一"+"人"); //大
            customIdsSupplement.put("犬", "⿺" + "大" + DOTRIGHT.val()); //犬 eg 然
            customIdsSupplement.put("豕", "⿱一𧰨"); //button side of  家, full ids: ⿱一𧰨 ⿸𬺻⿺乀丿
            customIdsSupplement.put("豖", "⿻豕丶"); //豖 ids ⿻豕丶 ⿸⿻𬺻丶⿺乀丿 from 冢
            customIdsSupplement.put("业", "⿱"+"⿻"+"丨"+"⿻"+"丨"+"丷"+"一"); //业  ids full code ⿱④一
            customIdsSupplement.put("尹", "⿻"+OLAP3HORIFORKLIKE.key()+"丿"); // ids 尹 ⿻⿻コ一丿
            customIdsSupplement.put("事", "⿻"+"⿱"+"一" + "口" + "⿻" + OLAP3HORIFORKLIKE.key() + "亅"); //事
            customIdsSupplement.put("コ", "⿻"+BENTTOP_SHARP.val()+"一"); //from 事
            customIdsSupplement.put("耂", "⿻"+"土"+LEFTSLANT_SHARP.val()); //eg. 都
            customIdsSupplement.put("ス", "⿻"+BENTTOP_SHARP.val() + "乀"); //ス from 经
            customIdsSupplement.put("儿", "⿻"+LEFTSLANT_SHARP.val()+"乀"); //儿 from 现 and 见
            customIdsSupplement.put("见", "⿵"+OUTER2TOP_STRAIGHT.val()+"儿"); // 见 from 现 //arrayInspiredElemsV1.put("", "⿵"+""); //    //见
            customIdsSupplement.put("彐", OVERLAP.desc()+OVERLAP.desc()+BENTTOP_SHARP.val()+"一"+"一"); //彐 from 当
            customIdsSupplement.put("囬", "⿴囗"+OLAP4TWOVERTTWOHORI.key()); //囬  from 面, 囬 ids ⿴囗④
            customIdsSupplement.put("癶", "⿰"+OVERLAP.desc()+BENTTOPHOOK_LARGE.val()
                    +RIGHTSLANT_SHARP.val()+OVERLAP.desc()+LEFTSLANT_SHARP.val()
                    +OVERLAP.desc()+LEFTSLANT_SHARP.val()+RIGHTSLANT_SHARP.val()); //ids 癶 ⿰②③ from 發
            customIdsSupplement.put("井", OVERLAP.desc()+"一"+OVERLAP.desc()+"一"+OVERLAP.desc()+"丨"+"丨"); //井 from 进
            customIdsSupplement.put("卌", OVERLAP.desc()+"一"+OVERLAP.desc()+"丨"+OVERLAP.desc()+"丨"+OVERLAP.desc()+"丨"+"丨"); //卌 from 無
            customIdsSupplement.put("其", "⿱⿱"+OVERLAP.desc()+"一"+OLAP4TWOVERTTWOHORI.key()+"一八"); //其 ⿱⿱⑤一八
            customIdsSupplement.put("此", "⿰止匕"); //此 from 些, ids ⿰止匕 ⿰③匕
            customIdsSupplement.put("馬", "⿹"+OVERLAP.desc()+
                    OVERLAP.desc()+"一丨"
                    +OVERLAP.desc()
                    +OVERLAP.desc()+OVERLAP.desc()+"一一丨"
                    +BENTTOPHOOK_LARGE.val()
                    +"灬"); //ids ⿹⑥灬
            customIdsSupplement.put("马", "马"); //马 ids ②
            customIdsSupplement.put("与", OVERLAP.desc()+"一"+OVERLAP.desc()+ DOUBLEBENT_25_WITHHOOK.val()+"一"); //ids 与
            customIdsSupplement.put("本", OVERLAP.desc()+"木"+"一"); //ids 本
            customIdsSupplement.put("最", "⿱日取"); //ids 最 ⿱日取 ⿱冃取
            customIdsSupplement.put("且", OVERLAP.desc()+OUTER2TOP_STRAIGHT.val()+OVERLAP.desc()+"一"+OVERLAP.desc()+"一"+"一");
            customIdsSupplement.put("头", OVERLAP.desc()+OVERLAP.desc()+DOTRIGHT.val()+DOTRIGHT.val()+"大");//头 eg. 实
            customIdsSupplement.put("斗", OVERLAP.desc()+OVERLAP.desc()+DOTRIGHT.val()+DOTRIGHT.val()+"十"); //斗 eg. 科
            customIdsSupplement.put("里", OVERLAP.desc()+"日"+"土");
            customIdsSupplement.put("黑", "⿱"+OVERLAP.desc()+"四"+"土"+"灬"); //might have to be refactored later //top side of 黑 ⿱⑧灬 eg. 點
            customIdsSupplement.put("頁", "⿱"+OVERLAP.desc()+"一"+DOTLEFT.val()+"貝"); //ids 頁
            customIdsSupplement.put("长", OVERLAP.desc()+LEFTSLANT_SHARP.val()
                    +OVERLAP.desc()+"一"+OVERLAP.desc()+RIGHTBENTBUTHOOK_LARGE.val()+RIGHTSLANT_SHARP.val()); //长
            customIdsSupplement.put("巴", OVERLAP.desc()+"巳" + "丨"); //ids 巴
            customIdsSupplement.put("永", OVERLAP.desc()+DOTRIGHT.val() + OVERLAP.desc()+BENTTOP_ROUND.val()
                    +OVERLAP.desc()+BENTTOP_SHARP.val()+OVERLAP.desc()+LEFTSLANT_SHARP.val()+RIGHTSLANT_SHARP.val()); //永 from 樣
            customIdsSupplement.put("民", OVERLAP.desc()+OVERLAP.desc()+OLAP3LEFTSIDEOFPEOPLE.val()+"一"+RIGHTSLANT_WITHHOOK.val()); //ids 民
            customIdsSupplement.put("史", OVERLAP.desc()+"口"+"乂"); //史
            customIdsSupplement.put("糹", "糹"); //ids 糹 ⿱幺③ from 經
            customIdsSupplement.put("丝", "⿱⿰"+OVERLAP.desc()+RIGHTBENTBUT_SHARP.val()+RIGHTBENTBUT_SHARP.val()
                    +OVERLAP.desc()+RIGHTBENTBUT_SHARP.val()+RIGHTBENTBUT_SHARP.val()+"一"); //丝 ids ⿱⿰②②一
            customIdsSupplement.put("身", OVERLAP.desc()+DOTLEFT.val()+OVERLAP.desc()
                    +OUTER2TOP_STRAIGHT.val()+OVERLAP.desc()+"⿳"+"一一一"+LEFTSLANT_SHARP.val()); //身 from 謝
            customIdsSupplement.put("正", "⿱一止"); //ids 正 ⿱一止 ⿱④一
            customIdsSupplement.put("止", OVERLAP.desc()+OVERLAP.desc()+"⺊丨一"); //止
            customIdsSupplement.put("⺊", OVERLAP.desc()+"丨一");
            customIdsSupplement.put("干", "⿱一十"); //ids 干 ⿱一止
            customIdsSupplement.put("冉", OVERLAP.desc()+OUTER2TOP_STRAIGHT.val()+"土"); //冉from 再
            customIdsSupplement.put("比", "⿰匕匕");//ids 比
            customIdsSupplement.put("由", OVERLAP.desc()+OUTER2TOP_STRAIGHT.val()+"土"); //ids 由
            customIdsSupplement.put("申", OVERLAP.desc()+OUTER2TOP_STRAIGHT.val()+OLAP3RUSSIANCROSS.key()); //申
            customIdsSupplement.put("牛", OVERLAP.desc()+LEFTSLANT_SHARP.val()+OLAP3RUSSIANCROSS.key()); //牛
            customIdsSupplement.put("攵", "⿱"+"𠂉"+"乂"); //攵 //ids 攵
            customIdsSupplement.put("長", "⿳" + OLAP4CHANGTOP.key() + "一" + OLAP3YIANDCHANGBUTTOM.key()); ////ids 長 ⿳④一⿰𠄌⿺乀丿
            customIdsSupplement.put("镸", "⿳" + OLAP4CHANGTOP.key()+ "一" + "厶"); //镸 ids ⿱④𠫔  from 套
            customIdsSupplement.put("𧘇", OVERLAP.desc()+LEFTSLANT_SHARP.val()+OLAP3YIANDCHANGBUTTOM.key()); //from 還
            customIdsSupplement.put("旅", "⿰方⿱𠂉" + OVERLAP.desc()+LEFTSLANT_SHARP.val()+OLAP3YIANDCHANGBUTTOM.key()); //旅 ids ⿰方⿱𠂉④
            customIdsSupplement.put("皮", "⿸"+OVERLAP.desc()+OVERLAP.desc()+"乛"+LEFTSLANT_SHARP.val()+"丨"+"又"); //ids 皮 from 被
            customIdsSupplement.put("鳥", "⿹"
                    //the bird part
                    +OVERLAP.desc()+DOTLEFT.val()+"𠁣"
                    +OVERLAP.desc()+"一"
                    +OVERLAP.desc()+BENTTOPHOOK_LARGE.val()+"灬"); //鳥 from 鳳 , ids 鳥 ⿹⑦灬
            customIdsSupplement.put("世", OVERLAP.desc()+"廿"+RIGHTBENTBUT_SHARP.val()); //世 //it be 廿 + └
            customIdsSupplement.put("曲", OVERLAP.desc()+"囗"+"艹"); //曲 from 體
            customIdsSupplement.put("𠂒", OVERLAP.desc()+LEFTSLANT_SHARP.val()+"土"); //𠂒 from 先
            customIdsSupplement.put("母", OVERLAP.desc()+OVERLAP.desc()+RIGHTBENTBUT_SHARP.val()+BENTTOPHOOK_LARGE.val()
                    +OVERLAP.desc()+OVERLAP.desc()+DOTRIGHT.val()+"一"+DOTRIGHT.val()); //母 ids 母 from 海
            customIdsSupplement.put("毋", "母"); //毋 from 海
            customIdsSupplement.put("龴", OVERLAP.desc()+BENTTOP_SHARP.val()+DOTRIGHT.val());//龴 from 通
            customIdsSupplement.put("东", OVERLAP.desc()+OVERLAP.desc()+"一"+RIGHTBENTBUT_SHARP.val()+"小"); //东 downside:  OLAP3DOWNFORk.key()
            customIdsSupplement.put("及", OVERLAP.desc()+OVERLAP.desc()+LEFTSLANT_SHARP.val()+BENTTOP_SHARP.val()+"又"); //及
            customIdsSupplement.put("龍", "⿰𦚏"
                    +OVERLAP.desc()+OVERLAP.desc()+"一"+ DOUBLEBENT_25_WITHHOOK.val()+OVERLAP.desc()+"一"+OVERLAP.desc()
                    +RIGHTBENTBUTHOOK_LARGE.val()+"⿳"+"一"+"一"+"一"); //龍 ids ⿰𦚏⑦
            customIdsSupplement.put("豆", "⿳"+"一"+"口"+"⿱"+"丷"+"一"); //豆 from 體
            customIdsSupplement.put("贝", "⿵"+OUTER2TOP_STRAIGHT.val()+"人"); //贝 from 员
            customIdsSupplement.put("页", "⿱" +OVERLAP.desc() +"一"+DOTLEFT.val() + "贝"); //页 from 题
            customIdsSupplement.put("㥑", "⿱"+"⿱"+OVERLAP.desc()+OVERLAP.desc() +"一"+DOTLEFT.val()+"⿵"+OUTER2TOP_STRAIGHT.val()
                    +"⿱一一"+"冖"+"心"); //㥑 from 優
            customIdsSupplement.put("角", "⿱"+OVERLAP.desc()+LEFTSLANT_SHARP.val()+BENTTOP_SHARP.val()
                    +"⿵"+OUTER2TOP_USEANDMOONE.val()+"土"); //角 from 解
            customIdsSupplement.put("㠯", OVERLAP.desc()
                    + OVERLAP.desc() + OVERLAP.desc() + BENTTOP_SHARP.val() + "一" + "丨"
                    + OVERLAP.desc() + BENTTOP_SHARP.val() + "一"); //㠯 from 管
            customIdsSupplement.put("变", "⿱"+"⿱"+ "亠"
                    + OVERLAP.desc() + OVERLAP.desc() + "丨" + "丨" +"八"
                    + "又"); //变 ids ⿱亠④ //变
            customIdsSupplement.put("婁", "⿱毌女"); //婁 from 數, ids ⿱⑧女
            customIdsSupplement.put("ユ", OVERLAP.desc()+BENTTOP_SHARP.val() + "一"); //ユ from 快
            customIdsSupplement.put("𠃓", OVERLAP.desc()+ DOUBLEBENT_55.val()
                    +OVERLAP.desc()+LEFTSLANT_SHARP.val()+LEFTSLANT_SHARP.val());//𠃓 from 场
            customIdsSupplement.put("彡", "⿳" + LEFTSLANT_SHARP.val()+ LEFTSLANT_SHARP.val()+ LEFTSLANT_SHARP.val()); //彡 from 形
            customIdsSupplement.put("虍", "⿸⿱⺊"+OUTTOPLEFT2.key()+"七"); //虍 from 號, ids ⿸⿱⺊②七
            customIdsSupplement.put("𫝀", "丨" + BENTTOP_SHARP.val()+"一"); //𫝀 from 五
            customIdsSupplement.put("书", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +"丨"+BENTTOP_SHARP.val()+BENTTOPHOOK_LARGE.val()+DOTRIGHT.val());//书 ids 书, simple form of 書
            customIdsSupplement.put("非", "⿰" + OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    + "丨" + "一"+"一"+"一" + OVERLAP.desc()+OLAP3ZHABUT.key()+"一"); //非
            customIdsSupplement.put("即","⿰"+LEFTSIDE5_FLAGWITHMIDDLE.key()+"卩" ); //即 ids ⿰⑤卩
            customIdsSupplement.put("既", "⿰"+LEFTSIDE5_FLAGWITHMIDDLE.key()+"旡"); //既 ids ⿰⑤旡 from 概
            customIdsSupplement.put("飠", "⿱人⿱丶"+LEFTSIDE5_FLAGWITHMIDDLE.key()); //飠 ids ⿱人⿱丶⑤ from 館
            customIdsSupplement.put("𩙿", "⿱人⿱丶"+LEFTSIDE5_FLAGWITHMIDDLE.key()); //𩙿 from 館
            customIdsSupplement.put("饣" ,"飠"); //饣 from 饭, simplified form of 飠
            customIdsSupplement.put("節", "⿱竹即"); //即 ids ⿱竹即 ⿱竹即
            customIdsSupplement.put("鄕", "⿲乡皀阝"); //鄕 ids ⿲乡皀阝 ⿲乡⑦阝 from 響
            customIdsSupplement.put("郷", "⿲乡"+LEFTSIDE5_FLAGWITHMIDDLE.key()+"阝"); //郷 from 響
            customIdsSupplement.put("郎", "⿰"+"⿱丶"+LEFTSIDE5_FLAGWITHMIDDLE.key()+"阝"); // 郎 ids ⿰⿱丶⑤阝from 響
            customIdsSupplement.put("朗", "⿰"+"⿱丶"+LEFTSIDE5_FLAGWITHMIDDLE.key()+"月"); //朗 ids ⿰⿱丶⑤月 ⿰良月
            customIdsSupplement.put("𡬠", "⿰"+LEFTSIDE5_FLAGWITHMIDDLE.key()+"寸"); //𡬠 ids ⿰⑤寸 from 爵
            customIdsSupplement.put("卿", "⿲𠂎"+LEFTSIDE5_FLAGWITHMIDDLE.key()+"卩"); //卿 ids ⿲𠂎⑤卩 ⿲𠂎⑦卩 ⿲𠂎⑥卩
            customIdsSupplement.put("㐆", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +LEFTSLANT_SHARP.val()+LEFTSLANT_SHARP.val()+BENTTOP_SHARP.val()+"一一"+BENTTOPHOOK_LARGE.val()); //㐆 from 殷 ids ⿰㐆殳
            customIdsSupplement.put("北", "⿰"+OVERLAP.desc()+"丨"+OVERLAP.desc()+"一"+"一"+"匕"); //北 ids ⿰③匕
            customIdsSupplement.put("专", OVERLAP.desc()+OVERLAP.desc()+"一"+"一"+OVERLAP.desc()
                    + DOUBLEBENT_25_WITHHOOK.val()+DOTRIGHT.val()); //专 ids 专 from 传
            customIdsSupplement.put("师", "⿰⿰丨丿帀"); //师 ids ⿰⿰丨丿帀 ⿰②帀
            customIdsSupplement.put("辨", "⿲辛⿰丨丿辛"); //辨 ids ⿲辛②辛
            customIdsSupplement.put("谷", "⿱"+"八"+"㕣"); //谷 ids 谷 from 卻
            customIdsSupplement.put("未", OVERLAP.desc()+"一"+"木"); //top stroke smallest, take this as 一 followed by  //未 from 業
            customIdsSupplement.put("末", OVERLAP.desc()+"木"+"一"); //末 ids 末
            customIdsSupplement.put("朱", OVERLAP.desc()+"𠂉"+"木"); //朱 ids 朱
            customIdsSupplement.put("束", OVERLAP.desc()+"木"+"口"); //束 from 整
            customIdsSupplement.put("川", "⿲丨丨丨"); //川 from 带
            customIdsSupplement.put("飞", OVERLAP.desc()+"⺄"+OVERLAP.desc()+DOTLEFT.val()+DOTRIGHT.val()); //飞 ids 飞
            customIdsSupplement.put("丩", OVERLAP.desc()+RIGHTBENTBUT_SHARP.val()+"丨"); //丩 from 收
            customIdsSupplement.put("央", OVERLAP.desc()+OUTER2TOP_STRAIGHT.val()+"大"); //央 ids 央
            customIdsSupplement.put("九", OVERLAP.desc()+LEFTSLANT_SHARP.val()+DOUBLEBENT_52WITHHOOK.val()); //九 from 究
            customIdsSupplement.put("禺", OVERLAP.desc()+OVERLAP.desc()
                    +"日"+OUTER2TOP_STRAIGHT.val()+OVERLAP.desc()+"丨"+OVERLAP.desc()+"一"+DOTRIGHT.val()); //禺 ids 禺 from 萬
            customIdsSupplement.put("丘", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +LEFTSLANT_SHARP.val()+"丨"+"一"+"丨"+"一"); //丘 from 兵
            customIdsSupplement.put("舟", "⿱"+DOTLEFT.val()+'⿵'+OUTER2TOP_USEANDMOONE.val()
                    +OVERLAP.desc()+OVERLAP.desc()+DOTRIGHT.val()+"一"+DOTRIGHT.val()); //舟 from 般
            customIdsSupplement.put("疒",OVERLAP.desc()+"广"+"冫"); //疒 from 病
            customIdsSupplement.put("彑", OVERLAP.desc()+OVERLAP.desc()
                    +RIGHTBENTBUT_SHARP.val()+BENTTOP_SHARP.val()+"一"); //彑 from 錄
            customIdsSupplement.put("戈", OVERLAP.desc()+"一"+OLAP3_BONESAW.key());
            customIdsSupplement.put("戉", "⿸"+OVERLAP.desc()+"一"+DOWNWITHHOOK.val() + OLAP3_BONESAW.key()); //戉 from 越
            customIdsSupplement.put("戊", OVERLAP.desc()+"厂"+OLAP3_BONESAW.key());
            customIdsSupplement.put("羲", "⿱𦍌⿻⿱禾丂"+OLAP3_BONESAW.val()); //羲 ids ⿱𦍌⿻⿱禾丂③ from 犧
            customIdsSupplement.put("帶", "⿳"+OLAP6_EXPANDEDPLANT.key()+"冖巾"); //ids 帶 ⿳⑤冖巾
            customIdsSupplement.put("乎", LEFTSLANT_SHARP.val()+"丷"+OUTTOPRIGHT2.key()); //ids 乎 乎
            customIdsSupplement.put("久", OVERLAP.desc()+"𠂊"+RIGHTSLANT_SHARP.val()); //久 ids 久
            customIdsSupplement.put("班", "⿲王"+OVERLAP.desc()+DOTRIGHT.val()+LEFTSLANT_SHARP.val()+"王"); //班 ids ⿲王②王
            customIdsSupplement.put("尺", "⿸尸"+RIGHTSLANT_SHARP.val()); //尺 from 尽
            customIdsSupplement.put("飛", "⿹飞"+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +LEFTSLANT_SHARP.val()+LEFTSLANT_SHARP.val()+"飞"+"丨"); //飛 ids 飛
            customIdsSupplement.put("留", "⿱⿰"+OVERLAP.desc()+OVERLAP.desc()
                    +LEFTSLANT_SHARP.val()+RIGHTBENTBUT_SHARP.val()+DOTRIGHT.val()+"刀田"); //留 ids ⿱⿰③刀田
            customIdsSupplement.put("氏", "⿸"+OVERLAP.desc()+OVERLAP.desc()
                    +LEFTSLANT_SHARP.val()+RIGHTBENTBUT_SHARP.val()+"一"+RIGHTSLANT_WITHHOOK.val());//氏 ids 底
            customIdsSupplement.put("叚", "⿰"+OVERLAP.desc()+"コ"+OLAP3ZHABUT.key()+"⿱コ又"); //叚 ids ⿰⑤⿱コ又 from 假
            customIdsSupplement.put("甘",OVERLAP.desc()+"廿"+"一");//甘 from 某
            customIdsSupplement.put("革", "⿱廿"+OVERLAP.desc()+"口"+"十"); //革 ids 革
            customIdsSupplement.put("𠂢", "⿸𠂆"+OVERLAP.desc()+LEFTSLANT_SHARP.val()+OLAP3YIANDCHANGBUTTOM.key()); //𠂢 ids ⿸𠂆④ from 派
            customIdsSupplement.put("免", "⿳𠂊口儿"); //免 ids ⿱𠂊⑤ ⿳𠂊𫩏儿 from 晚
            customIdsSupplement.put("段", "⿰"+OVERLAP.desc()+OVERLAP.desc()
                    +LEFTSLANT_SHARP.val()+OLAP3ZHABUT.key()+"一"+"殳"); //段 ids ⿰⑤殳
            customIdsSupplement.put("严", "⿳一"+OVERLAP.desc()+OVERLAP.desc()
                    +"丨"+"丨"+"丷"+"厂"); //严 ids ⿳一④厂
            customIdsSupplement.put("甚", "⿱"+OVERLAP.desc()+"一"+OLAP4TWOVERTTWOHORI.key()+"匹"); //甚 ids ⿱⑤匹
            customIdsSupplement.put("旡", OVERLAP.desc()+"一"+RIGHTBENTBUT_SHARP.val()+"儿"); //旡 from 概
            customIdsSupplement.put("祭", "⿱⿰"+OLAP4_BENTMOON.key()+OVERLAP.desc()
                    +BENTTOP_SHARP.val()+RIGHTSLANT_SHARP.val()+"示"); //祭 ids ⿱⿰⿴𠂊冫②示 from 察
            customIdsSupplement.put("豋", "⿱⿰"+OLAP4_BENTMOON.key()+OVERLAP.desc()
                    +BENTTOP_SHARP.val()+RIGHTSLANT_SHARP.val()+"豆"); //豋 ids ⿱⿰⿴𠂊冫②豆
            customIdsSupplement.put("韦", OVERLAP.desc()+"⿳"
                    +"一"+"一"+BENTTOPHOOK_LARGE.val()+"丨"); //韦 ids from 围
            customIdsSupplement.put("禹", "⿱"+LEFTSLANT_SHARP.val()+OVERLAP.desc()+"虫"+OUTER2TOP_STRAIGHT.val());//禹 ids 禹 from 属
            customIdsSupplement.put("惠", "⿱"+OVERLAP.desc()+"⿱一"+"日"+OVERLAP.desc()+OVERLAP.desc()+"丨"+"一"+DOTRIGHT.val()+"心"); //惠 ids ⿱⑧心
            customIdsSupplement.put("專", "⿱"+ OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+
                    "一"+"日"+"丨"+"一"+DOTRIGHT.val() +"寸"); //專 from 轉, ids ⿱⑧寸
            customIdsSupplement.put("畢", "⿱" +"田"+OVERLAP.desc()+"艹"+OLAP3RUSSIANCROSS.val() ); //畢 ids ⿻⑨一
            customIdsSupplement.put("乐", OVERLAP.desc()+OVERLAP.desc()+LEFTSLANT_SHARP.val()+"丨"+"朩"); //乐 ids 乐
            customIdsSupplement.put("缶", OVERLAP.desc()+"⿱"+"𠂉"+"十"+OVERLAP.desc()+RIGHTBENTBUT_SHARP.val()+"丨"); //缶 from 寶
            customIdsSupplement.put("印", "⿰"+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +LEFTSLANT_SHARP.val()+"丨"+"一"+"一"+"卩"); //印 ids ⿰③卩
            customIdsSupplement.put("卬", "⿰"+OVERLAP.desc()
                    +LEFTSLANT_SHARP.val()+RIGHTBENTBUT_SHARP.val()+"卩"); //卬 ids ⿰②卩 from 迎
            customIdsSupplement.put("兜", "⿱⿲"+"白"+OVERLAP.desc()+LEFTSLANT_SHARP.val()+RIGHTBENTBUT_SHARP.val()+"コ儿"); //兜 ids ⿱⿲②白コ儿
            customIdsSupplement.put("齊", "⿱⿱亠⿲刀丫"+OVERLAP.desc()+OVERLAP.desc()
                    +LEFTSLANT_SHARP.val()+RIGHTBENTBUT_SHARP.val()+RIGHTSLANT_SHARP.val()+"⿲丿二丨"); //齊 ids ⿱⿱亠⿲刀丫③⿲丿二丨 from 濟
            customIdsSupplement.put("𠂎", OVERLAP.desc()+OVERLAP.desc()+LEFTSLANT_SHARP.val()+RIGHTBENTBUT_SHARP.val()
                    +LEFTSLANT_SHARP.val()); //𠂎 from 聊
            customIdsSupplement.put("劉", "⿰⿱⿰𠂎刀金刂"); //劉 ids ⿰⿱⿰③刀金刂
            customIdsSupplement.put("贸", "⿱⿰𠂎刀贝"); //贸 ids ⿱⿰③刀贝
            customIdsSupplement.put("貿", "⿱⿰"+"𠂎"+"刀貝"); //貿 ids ⿱⿰③刀貝
            customIdsSupplement.put("㔾", OVERLAP.desc()+BENTTOPHOOK_LARGE.val()+RIGHTBENTBUTHOOK_LARGE.val());//㔾 from 创
            customIdsSupplement.put("承", "⿱"+BENTTOP_SHARP.val()+OVERLAP.desc()+"水"+"⿳一一一"); //承 ids 承
            customIdsSupplement.put("華", "⿱艹𠦒"); //ids 華 ⿱艹⑦
            customIdsSupplement.put("垂", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +LEFTSLANT_SHARP.val()+"十"+"艹"+"一一"); //垂 ids ⿳丿⑥一 from 睡
            customIdsSupplement.put("重", "⿳"+LEFTSLANT_SHARP.val()+"車"+"一"); // ids 重
            customIdsSupplement.put("熏", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +LEFTSLANT_SHARP.val()+"一"+OVERLAP.desc()+"口"+"丷"+"土"+"灬"); //熏 from 勳
            customIdsSupplement.put("東", "束"+"一");//東 束丷
            customIdsSupplement.put("柬", OVERLAP.desc()+"束" + "丷"); //柬 from 練
            customIdsSupplement.put("疋", "⿱"+"乛"+"龰"); //疋 from 疑
            customIdsSupplement.put("褱", "⿳亠⿱罒⿻丨⿱丷八𧘇"); //褱 ids ⿳亠眔𧘇 ⿳亠⿱罒⿻丨⿱丷八𧘇 from 壞
            customIdsSupplement.put("牙", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +"一"+RIGHTBENTBUT_SHARP.val()+"亅"+LEFTSLANT_SHARP.val()); //牙 from 呀
            customIdsSupplement.put("眾", "⿱罒"+OVERLAP.desc()+OVERLAP.desc()+"亻"+"人"+"人"); //乑 from 眾
            customIdsSupplement.put("乑", OVERLAP.desc()+OVERLAP.desc()+"亻"+"人"+"人"); //乑 from 聚
            customIdsSupplement.put("州", OVERLAP.desc()+"⿲"+DOTLEFT.val()+DOTRIGHT.val()+DOTRIGHT.val()
                    +"川"); //州 from 洲
            customIdsSupplement.put("酉", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +"一"+"囗"+"儿"+"一"); //酉 from 配
            customIdsSupplement.put("烏", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +DOTLEFT.val()+"丨"+BENTTOP_SHARP.val()+"一"+"一"+BENTTOPHOOK_LARGE.val()+"灬"); //  烏 from 嗚
            customIdsSupplement.put("朿", OVERLAP.desc()+"木"+OUTER2TOP_STRAIGHT.val()); //朿 from 策
            customIdsSupplement.put("隶", OVERLAP.desc()+OVERLAP.desc()+OLAP3HORIFORKLIKE.key()+"亅"+OVERLAP.desc()+OVERLAP.desc()+
                    OVERLAP.desc()+DOTRIGHT.val()+"一"+DOTLEFT.val()+RIGHTSLANT_SHARP.val()); //隶 from 康
            customIdsSupplement.put("兼", "⿱䒑⿻"+OLAP3HORIFORKLIKE.key()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +"丨"+"丨"+LEFTSLANT_SHARP.val()+RIGHTSLANT_SHARP.val()); //兼 ids ⿱䒑⿻⿻コ一④ ⿳八一⿻⿻コ一④ from 歉
            customIdsSupplement.put("兆", OVERLAP.desc()+"儿"+OVERLAP.desc()+OVERLAP.desc()+
                    OVERLAP.desc()+DOTRIGHT.val()+"一"+DOTLEFT.val()+RIGHTSLANT_SHARP.val()); //兆 from 跳
            customIdsSupplement.put("爪", "⿸"+"𠂆"+OVERLAP.desc()+"丨"+RIGHTSLANT_SHARP.val()); //爪 from 抓
            customIdsSupplement.put("瓜", "⿸"+"𠂆"+"⿰"+OVERLAP.desc()
                    +RIGHTBENTBUT_SHARP.val()+DOTRIGHT.val()+RIGHTSLANT_SHARP.val()); //瓜 from 孤
            customIdsSupplement.put("亞", "⿳一"+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +"丨"+"一"+DOUBLEBENT_25_NOHOOK.val()+DOUBLEBENT_25_NOHOOK.val()+"一"+"丨"+"一"); //亞 ids ⿳一⑥一 from 惡
            customIdsSupplement.put("壺", "⿱士⿳冖"+
                    OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +"丨"+"一"+DOUBLEBENT_25_NOHOOK.val()+DOUBLEBENT_25_NOHOOK.val()+"一"+"丨"+"一"); //壺 ids ⿱士⿳冖⑥一
            customIdsSupplement.put("島", "⿹"+
                    //The bird part
                    OVERLAP.desc()+DOTLEFT.val()+OVERLAP.desc()+"丨"+OVERLAP.desc()+BENTTOP_SHARP.val()
                    +OVERLAP.desc()+"一"+OVERLAP.desc()+"一"+OVERLAP.desc()+"一"+BENTTOPHOOK_LARGE.val()
                            +"山"); //島 ids ⿹⑦山
            customIdsSupplement.put("裊", "⿹"+
                    //The bird part
                    OVERLAP.desc()+DOTLEFT.val()+OVERLAP.desc()+"丨"+OVERLAP.desc()+BENTTOP_SHARP.val()
                    +OVERLAP.desc()+"一"+OVERLAP.desc()+"一"+OVERLAP.desc()+"一"+BENTTOPHOOK_LARGE.val()
                    +"衣");//裊 ids ⿹⑦衣
            customIdsSupplement.put("梟", "⿹"+
                    //The bird part
                    OVERLAP.desc()+DOTLEFT.val()+OVERLAP.desc()+"丨"+OVERLAP.desc()+BENTTOP_SHARP.val()
                    +OVERLAP.desc()+"一"+OVERLAP.desc()+"一"+OVERLAP.desc()+"一"+BENTTOPHOOK_LARGE.val()
                    +"木");//梟
            customIdsSupplement.put("岛", "⿹"+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +DOTLEFT.val()+BENTTOPHOOK_LARGE.val()+DOTRIGHT.val()+DOUBLEBENT_25_WITHHOOK.val()+"山"); //岛 ids ⿹④山
            customIdsSupplement.put("鸟", "⿹"+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +DOTLEFT.val()+BENTTOPHOOK_LARGE.val()+DOTRIGHT.val()+DOUBLEBENT_25_WITHHOOK.val()+"一"); //鸟
            customIdsSupplement.put("乌", "⿹"+OVERLAP.desc()+OVERLAP.desc()
                    +DOTLEFT.val()+BENTTOPHOOK_LARGE.val()+DOUBLEBENT_25_WITHHOOK.val()+"一"); //乌 ids 乌
            customIdsSupplement.put("袅", "⿹"+OVERLAP.desc()+OVERLAP.desc()
                    +DOTLEFT.val()+BENTTOPHOOK_LARGE.val()+DOUBLEBENT_25_WITHHOOK.val()+"衣"); //袅 ids ⿹④衣
            customIdsSupplement.put("枭", "⿹"+OVERLAP.desc()+OVERLAP.desc()
                    +DOTLEFT.val()+BENTTOPHOOK_LARGE.val()+DOUBLEBENT_25_WITHHOOK.val()+"木");//枭

            customIdsSupplement.put("廌", "⿸⿸广⿻コ⿰丨丨⿹"+OVERLAP.desc()+"一"+DOUBLEBENT_25_WITHHOOK.val()+"灬"); //廌 from 薦 ids ⿸⿸广⿻コ⿰丨丨⿹②灬
            customIdsSupplement.put("焉", "⿱正⿹"+OVERLAP.desc()+"一"+DOUBLEBENT_25_WITHHOOK.val()+"灬"); //焉 ids ⿱正⿹②灬
            customIdsSupplement.put("典", "⿱"+OVERLAP.desc()+OVERLAP.desc()+OUTER2TOP_STRAIGHT.val()+"艹" +"一" +"八"); //典 ids ⿱⑥八
            customIdsSupplement.put("肉", OVERLAP.desc()+OUTER2TOP_STRAIGHT.val()+"⿱"+"人人"); // 肉 ids 肉
            customIdsSupplement.put("臣", "⿷"+"匚"+OVERLAP.desc()+OVERLAP.desc()
                    +"丨"+OVERLAP.desc()+BENTTOP_SHARP.val()+"一"+"丨"); //臣 ids 臣 from 藏
            customIdsSupplement.put("巨", "⿷"+"匚"+OVERLAP.desc()+BENTTOP_SHARP.val()+"一");
            customIdsSupplement.put("𦣞", "⿷匚"+OVERLAP.desc()+OVERLAP.desc()+"丨口丨"); //𦣞 from 熙,
            customIdsSupplement.put("𦣝", "𦣞"); //巸 ids ⿰𦣞巳 ⿰𦣝巳  or 姬 ids ⿰女𦣞 ⿰女𦣝
            customIdsSupplement.put("练", "⿰纟"+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +"一"+RIGHTBENTBUT_SHARP.val()+BENTTOPHOOK_LARGE.val()+"八"); //练 ids ⿰纟𫠣  compare 东 and 練
            customIdsSupplement.put("棄", "⿱𠫓⿻廿木"); //棄 ids ⿱𠫓⿻廿木 ⿱𠫓𭩠
            customIdsSupplement.put("鬥", "⿰"+OVERLAP.desc()+"丨"+OVERLAP.desc()+"一"+"土"
                    +OVERLAP.desc()+OVERLAP.desc()+"一"+"土"+"亅"); //鬥 ids ⿰𩰋𩰊
            customIdsSupplement.put("延", "⿺廴⿱丿止"); //延 ids ⿺廴⿱丿③ ⿺廴⿱丿止
            customIdsSupplement.put("𤴔", "⿱"+"乛"+"止"); //𤴔 from 疏
            customIdsSupplement.put("虛", "⿸虍"+OVERLAP.desc()+"丱"+"一"); //虛 ids ⿸虍⑥
            customIdsSupplement.put("碰", "⿰石並"); //碰 ids ⿰石並 ⿰石並
            customIdsSupplement.put("瓦", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +"一"+RIGHTBENTBUT_SHARP.val()+DOUBLEBENT_52WITHHOOK.val()+DOTRIGHT.val()); //瓦 ids 瓦
            customIdsSupplement.put("丈", OVERLAP.desc()+"一"+"乂"); //丈 ids 丈
            customIdsSupplement.put("丹", "⿵"+OUTER2TOP_USEANDMOONE.val()+OVERLAP.desc()+DOTRIGHT.val()+"一"); //丹 ids 丹
            customIdsSupplement.put("鼠", "⿱臼"+OLAP7_SHUBUTTON.key()); //鼠 ids ⿱臼⑦
            customIdsSupplement.put("巤", "⿳巛龱"+OLAP7_SHUBUTTON.key()); //巤 ids ⿳巛龱⑦ ⿳巛囚⑦ from 獵
            customIdsSupplement.put("肅", OVERLAP.desc()+OVERLAP.desc()+OLAP3HORIFORKLIKE.key()+"十"+"⿰"+"爿"+"爿"); //肅 from 蕭
            customIdsSupplement.put("鼎", "⿱目"+"⿰爿"+"爿"); //鼎 ids 鼎
            customIdsSupplement.put("冘", OVERLAP.desc()+OUTER2TOP_USEANDMOONE.val()+"儿"); //冘 from 沈
            customIdsSupplement.put("龜", "⿱𠂊"+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +OUTER2TOP_STRAIGHT.val()+"一一丨"+RIGHTBENTBUTHOOK_LARGE.val()
                    +OVERLAP.desc()
                    +"⿱"+OLAP3HORIFORKLIKE.key()+OLAP3HORIFORKLIKE.key()
                    +OVERLAP.desc()+OVERLAP.desc()+BENTTOP_SHARP.val()+"㐅一"); //龜 ids 龜
            customIdsSupplement.put("黽", OVERLAP.desc()+OVERLAP.desc()
                    +OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OUTER2TOP_STRAIGHT.val()+"一一丨"+RIGHTBENTBUTHOOK_LARGE.val()
                    +OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+"一丨一一"
                    +OVERLAP.desc()+OVERLAP.desc()+BENTTOP_SHARP.val()+"一一"); //黽 from 蠅
            customIdsSupplement.put("亦", "⿱亠"+OVERLAP.desc()+OVERLAP.desc()+LEFTSLANT_SHARP.val()+"亅"+"八");//亦 ⿱亠④
            customIdsSupplement.put("赤", "⿱土"+OVERLAP.desc()+OVERLAP.desc()+LEFTSLANT_SHARP.val()+"亅"+"八"); //赤 ids ⿱土④ from 赫
            customIdsSupplement.put("肃", OVERLAP.desc()+OVERLAP.desc()+OLAP3HORIFORKLIKE.key()+"小"
                    +OVERLAP.desc()+LEFTSLANT_SHARP.val()+"丨"); //肃ids 肃
            customIdsSupplement.put("𦈢", "⿱𠂉⿻一止"); //𦈢 ids ⿱𠂉⿻一③ ⿱𠂉⿻一止 from 御
            customIdsSupplement.put("疌", OVERLAP.desc()+OVERLAP.desc()+"一"+OLAP3HORIFORKLIKE.key()+"龰"); //疌 from 捷
            customIdsSupplement.put("齿", "⿱止⿶"+OVERLAP.desc()+RIGHTBENTBUT_SHARP.val()+"丨人"); //齿 from 龄
            customIdsSupplement.put("逸", "⿺辶⿷免丶"); //逸 ids ⿷免丶 ⿷免丶
            customIdsSupplement.put("册", OVERLAP.desc()+"⿰"+OUTER2TOP_USEANDMOONE.val()+OUTER2TOP_USEANDMOONE.val()+"一"); //册 ids 册
            customIdsSupplement.put("兂", OVERLAP.desc()+OVERLAP.desc()+"一"+RIGHTBENTBUT_SHARP.val()+"儿"); //兂 from 潛
            customIdsSupplement.put("曰", OVERLAP.desc()+"口"+"一"); //曰 ids 曰
            customIdsSupplement.put("亙", "⿳"+"一"+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +LEFTSLANT_SHARP.val()+BENTTOP_SHARP.val()+DOTRIGHT.val()+DOTRIGHT.val()+"一");//亙 ids ⿳一④一
            customIdsSupplement.put("恆", "⿰"+"忄"+"亙"); // 亙 ids ⿳一④一 from 恆
            customIdsSupplement.put("炼", "⿰火"+OVERLAP.desc()+OVERLAP.desc()+"一"+RIGHTBENTBUT_SHARP.val()
                    +OVERLAP.desc()+BENTTOPHOOK_LARGE.val()+"八"); //炼 ids ⿰火𫠣
            customIdsSupplement.put("拣", "⿰扌"+OVERLAP.desc()+OVERLAP.desc()+"一"+RIGHTBENTBUT_SHARP.val()
                    +OVERLAP.desc()+BENTTOPHOOK_LARGE.val()+"八");//拣 ids ⿰扌𫠣
            customIdsSupplement.put("丑", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+BENTTOP_SHARP.val()+"丨一一"); //丑 from 纽
            customIdsSupplement.put("兔", "⿷免丶"); //免 ids ⿱刀⑤ from  兔 ids ⿷免丶 ⿷免丶
            customIdsSupplement.put("曳", OVERLAP.desc()+OVERLAP.desc()+"日"+RIGHTSLANT_WITHHOOK.val()+LEFTSLANT_SHARP.val()); //曳 from 洩
            customIdsSupplement.put("襾", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+"一口丨丨"); //襾 from 遷
            customIdsSupplement.put("歧", "⿰止支"); //歧 ids ⿰止支 ⿰③支
            customIdsSupplement.put("慨", "⿰忄既"); //慨 ids ⿰忄既 ⿰忄既
            customIdsSupplement.put("丐", OVERLAP.desc()+OVERLAP.desc()
                    +"一"+OLAP2_STRAIGHTWAND.key()+DOUBLEBENT_25_WITHHOOK.val()); //丐 ids 丐
            customIdsSupplement.put("凸", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+"丨一丨"+DOUBLEBENT_55.val()+"一"); //凸 ids 凸
            customIdsSupplement.put("凹", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +"丨"+DOUBLEBENT_52NOHOOK.val()+"丨"+BENTTOP_SHARP.val()+"一"); //凹 ids 凹
            customIdsSupplement.put("雋", "⿱隹"+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
                    +"丨"+DOUBLEBENT_52NOHOOK.val()+"丨"+BENTTOPHOOK_LARGE.val()); //雋 ids ⿱隹④
            customIdsSupplement.put("卍", OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+"一十丨丨一"); //卍 ids 卍



            ///TODO: handle 逸

            //Custom String Replacements
            customIdsSupplement.put(OLAP2_STRAIGHTWAND.key(), OLAP2_STRAIGHTWAND.val()); //first 2 strokes of 止
            customIdsSupplement.put(OLAP7_SHUBUTTON.key(), OLAP7_SHUBUTTON.val()); //button of 鼠
            customIdsSupplement.put(LEFTSIDE5_FLAGWITHMIDDLE.key(), LEFTSIDE5_FLAGWITHMIDDLE.val()); //eg. 既 ids ⿰⑤旡 from 概
            customIdsSupplement.put(OLAP4_BENTMOON_ALT.key(), OLAP4_BENTMOON_ALT.val()); //𠂊⺀ eg 㓘	⿵夙玉[G]	⿵几⿳一⿴𠂊⺀王[T]
            customIdsSupplement.put(OLAP4_BENTMOON.key(), OLAP4_BENTMOON.val()); //⿴𠂊⺀ eg. upper left of 祭 from 察
            customIdsSupplement.put(OLAP6_EXPANDEDPLANT.key(), OLAP6_EXPANDEDPLANT.val()); //top part of 帶
            customIdsSupplement.put(OLAP3_BONESAW.key(), OLAP3_BONESAW.val()); //last 3 stroeks of 戈
            customIdsSupplement.put(OUTTOPLEFT2.key(), OUTTOPLEFT2.val()); //OUTTOPLEFT2 //enclosing shape from, 虍, from 號
            customIdsSupplement.put(OLAP4CHANGTOP.key(), OLAP4CHANGTOP.val()); //OLAP4CHANGTOP //top part of 長, ids 長 ⿳④一⿰𠄌⿺乀丿
            customIdsSupplement.put(OLAP3YIANDCHANGBUTTOM.key(), OLAP3YIANDCHANGBUTTOM.val()); // buttom part of 長 ⿳④一⿰𠄌⿺乀丿  丧  喪 𠅕
            customIdsSupplement.put(OLAP3LEFTSIDEOFPEOPLE.key(), OLAP3LEFTSIDEOFPEOPLE.val()); //first 3 strokes of 民
            customIdsSupplement.put(OLAP4TWOVERTTWOHORI.key(), OLAP4TWOVERTTWOHORI.val()); //example: 其 ⿱⿱⑤一八 and 面/囬
            customIdsSupplement.put(OLAP3HORIFORKLIKE.key(), OLAP3HORIFORKLIKE.val()); //button of 事
            customIdsSupplement.put(OLAP3ZHABUT.key(), OLAP3ZHABUT.val()); //button side of 乍 or left side of 耳
            customIdsSupplement.put(OLAP4NIENBUT.key(), OLAP4NIENBUT.val()); //buttom side of 年
            customIdsSupplement.put(OLAP3RUSSIANCROSS.key(), OLAP3RUSSIANCROSS.val()); //middle side of 生, top side of 龶, top right of 請
            customIdsSupplement.put(CustomStrokeCollections.OLAP3DOWNFORk.key(), OLAP3DOWNFORk.val()); //buttom side of 不
            customIdsSupplement.put(CustomStrokeCollections.OUTTOPLEFT3.key(), OUTTOPLEFT3.val()); //outer side of 在
            customIdsSupplement.put(OUTTOPRIGHT2.key(), OUTTOPRIGHT2.val()); //outer side of 寸

        } catch (DataFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
