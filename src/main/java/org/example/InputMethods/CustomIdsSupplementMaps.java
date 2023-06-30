package org.example.InputMethods;

import org.example.ObjectTypes.GenericTypes.CharMetaInfo;

import java.util.HashMap;
import java.util.Map;

public class CustomIdsSupplementMaps {

    private Map<CharMetaInfo, String> tempMap = new HashMap<>();

    public static String LEFTSlANT_SLEIGHT = "㇓";
    //eg: 㷗 ⿱⿲㇓㠯巳火  𠗎 ⿰⿰冫㇓全  𥪐 ⿱立⿰⿰冫㇓⿺乚仌

    public static String LEFTSLANT_SHARP = "丿";
    // eg: 㢤 ⿹⿶弋十⿰丿𠃌  㻄 ⿰王⿱丿𤴓  䇖  ⿱竹⿹勹丿  万  ⿱一⿰丿𠃌   儿  ⿰丿乚
    // 䖝 ⿱丿虫 ⿱丿⿷虫丿  䘮 ⿱⿻土从⿰𠄌⿺乀丿  䣨 ⿰酉⿻丿七  丆 ⿱一丿  丌  ⿱一⿰丿丨

    public static final HashMap<String, String> customIdsSupplement = new HashMap<>();
    static {/*
        tempMap = {"BREAKDOWN":"⿶凵㐅",
                "TZAIORDINAL":"2701",
                "BREAKDOWNMETA":"",
                "CHAR":"凶",
                "UNICODE":"U+51F6",
                "JUNDAORDINAL":"1378"};*/
        customIdsSupplement.put("白", "⿻"+LEFTSLANT_SHARP+"日");
        customIdsSupplement.put("我", "⿻"+LEFTSLANT_SHARP+"⿻扌⿻㇂⿻"+LEFTSLANT_SHARP+"丶");
        customIdsSupplement.put("尢", "⿸𠂇㇟");
        customIdsSupplement.put("卜", "⿻丨丶");
        customIdsSupplement.put("也", "⿻㇆⿻丨㇟");//?
        //customIdsSupplement.put("丆", "⿱㇐㇓");
        customIdsSupplement.put("不", "⿱一" +"𒀀");
        customIdsSupplement.put("在", "⿸𒀁土");
        //customIdsSupplement.put("欠", "⿵");
        //customIdsSupplement.put("人", "⿻"+LEFTSLANT_SHARP+"㇂");
        //customIdsSupplement.put("不", "⿸丆卜");
        //customIdsSupplement.put(, "");

        //Custom String Replacements

        customIdsSupplement.put("𒀀", "⿸"+LEFTSLANT_SHARP+"卜"); //buttom side of 不
        customIdsSupplement.put("𒀁", "⿻𠂇丨"); //outer side of 在


    }
}
