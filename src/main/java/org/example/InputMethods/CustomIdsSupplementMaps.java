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
            //Stroke collections that have unicode char representations
            //(for stroke collections that dont are in CustomStrokeCollection enums)
            customIdsSupplement.put("白", "⿻"+LEFTSLANT_SHARP.val()+"日");
            customIdsSupplement.put("戊", OVERLAP.desc()+"厂" + OLAP3WORIGHTSTROKES.val());//ids 戊
            customIdsSupplement.put("我", OVERLAP.desc()+OVERLAP.desc()+LEFTSLANT_SHARP.val()+"扌"+OLAP3WORIGHTSTROKES.val()); //ids 我
            customIdsSupplement.put("尢", "⿸𠂇"+ RIGHTBENTBUTHOOK_LARGE.val());
            customIdsSupplement.put("卜", "⿻丨"+DOTRIGHT.val());
            customIdsSupplement.put("⺊", "⿻丨一");
            customIdsSupplement.put("也", "⿻"+BENTTOPHOOK_LARGE.val()+"⿻丨"+ RIGHTBENTBUTHOOK_LARGE.val());//?
            customIdsSupplement.put("不", "⿱一" +OLAP3DOWNFORk.key());
            customIdsSupplement.put("在", "⿸"+OUTTOPLEFT3.key()+"土");
            //customIdsSupplement.put("月", ENCIRTOP.charVal()+"⿻"+LEFTSLANT_SHARP.val()+BENTTOPHOOK_LARGE.val()+"⿱一一");
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
            customIdsSupplement.put("子", "⿻"+BENTTOPHOOK_LARGE.val()+"亅"+"一");
            customIdsSupplement.put("為", "⿻"+DOTRIGHT.val()+"⿻"+LEFTSLANT_SHARP.val()+"⿻"
                    +BENTTOPHOOK_LARGE.val()+"⿻"+BENTTOPHOOK_LARGE.val()+"⿻"+BENTTOPHOOK_LARGE.val()+"灬");//為
            customIdsSupplement.put("臼", "⿻"+LEFTSLANT_HORI.val()+"⿻"+"丨"+"⿻"+"一"+"⿻"+BENTTOPHOOK_LARGE.val()+"⿻"+"一"+"一");
            customIdsSupplement.put("𦥑", "⿻"+LEFTSLANT_HORI.val()+"⿻"+"丨"+"⿻"+"一"+"⿻"+"一"+"⿻"+BENTTOPHOOK_LARGE.val()+"⿻"+"一"+"一");
            customIdsSupplement.put("寸", ENCTOPRIGHT.desc()+OUTTOPRIGHT2.val()+DOTRIGHT.val());
            customIdsSupplement.put("于", "⿱"+"一"+OUTTOPRIGHT2.val()); //于
            customIdsSupplement.put("冎", "⿱⿵"+OUTER2TOP_STRAIGHT.val()+"𠃍"+OUTER2TOP_STRAIGHT.val()); //冎 eg. 過
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
            customIdsSupplement.put("犬", "⿺" + "大" + DOTRIGHT.val()); //犬 eg 然
            customIdsSupplement.put("豕", "⿱一𧰨"); //button side of  家, full ids: ⿱一𧰨 ⿸𬺻⿺乀丿
            customIdsSupplement.put("业", "⿱"+"⿻"+"丨"+"⿻"+"丨"+"丷"+"一"); //业  ids full code ⿱④一
            customIdsSupplement.put("尹", "⿻"+OLAP3HORIFORKLIKE+"丿"); // ids 尹 ⿻⿻コ一丿
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
            customIdsSupplement.put("馬", "馬"); //ids ⿹⑥灬
            customIdsSupplement.put("本", OVERLAP.desc()+"木"+"一"); //ids 本
            customIdsSupplement.put("最", "⿱日取"); //ids 最 ⿱日取 ⿱冃取
            //TODO: handle 且

            //Custom String Replacements
            customIdsSupplement.put(OLAP4TWOVERTTWOHORI.key(), OLAP4TWOVERTTWOHORI.val()); //example: 其 ⿱⿱⑤一八 and 面/囬
            customIdsSupplement.put(OLAP3HORIFORKLIKE.key(), OLAP3HORIFORKLIKE.val());
            customIdsSupplement.put(OLAP3ZHABUT.key(), OLAP3ZHABUT.val()); //button side of 乍 or left side of 耳
            customIdsSupplement.put(OLAP4NIENBUT.key(), OLAP4NIENBUT.val()); //buttom side of 年
            customIdsSupplement.put(OLAP3RUSSIANCROSS.key(), OLAP3RUSSIANCROSS.val()); //middle side of 生, top side of 龶, top right of 請
            customIdsSupplement.put(CustomStrokeCollections.OLAP3DOWNFORk.key(), OLAP3DOWNFORk.val()); //buttom side of 不
            customIdsSupplement.put(CustomStrokeCollections.OUTTOPLEFT3.key(), OUTTOPLEFT3.val()); //outer side of 在

        } catch (DataFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
