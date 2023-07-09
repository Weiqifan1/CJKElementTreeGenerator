package org.example.InputMethods;

import java.util.*;
import java.util.zip.DataFormatException;

import static org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService.unicodeBreakup;
import static org.example.ObjectTypes.GenericTypes.CJKDescription.OVERLAP;

public enum CustomStrokeCollections {

    //Single Stroke Aliases
    DOTRIGHT("丶", true), //eg. 丶   eg. 飠	⿱人⿱丶⑤   丸 ⿻九丶[GJ] ⿵九丶[TKV]
    DOTLEFT("、", true), // eg. 、 自

    LEFTSlANT_VERT("㇓", true),
    //eg: 㷗 ⿱⿲㇓㠯巳火  𠗎 ⿰⿰冫㇓全  𥪐 ⿱立⿰⿰冫㇓⿺乚仌
    LEFTSLANT_SHARP("丿", true),
    // eg: 㢤 ⿹⿶弋十⿰丿𠃌  㻄 ⿰王⿱丿𤴓  䇖  ⿱竹⿹勹丿  万  ⿱一⿰丿𠃌   儿  ⿰丿乚
    // 䖝 ⿱丿虫 ⿱丿⿷虫丿  䘮 ⿱⿻土从⿰𠄌⿺乀丿  䣨 ⿰酉⿻丿七  丆 ⿱一丿  丌  ⿱一⿰丿丨

    LEFTSLANT_HORI("㇀", true),
    //刁 ⿹𠃌㇀    七	⿻㇀乚   𢏻	⿰⿹⿱𠂊③㇀⿹弓⿱丿丿


    DOUBLEBENT_25_WITHHOOK("㇉", true), //与 I need to make a decision regarding the 2nd stroke.
    DOUBLEBENT_25_NOHOOK("𠃑", true), //𠃑 from 誤
    BENTTOPHOOK_LARGE("𠃌", true),
    DOUBLEBENT_55("㇋", true),
    DOUBLEBENT_55_WITHHOOK("𠄎", true), //𠄎 eg 仍
    DOUBLEBENT_52WITHHOOK("乙", true),
    DOUBLEBENT_52NOHOOK("㇈", true), //㇈ eg 凹
    BENTTOP_SHARP("𠃍", true), // eg 過
    BENTTOP_ROUND("㇇", true), //㇇ from 樣
    RIGHTBENTBUTHOOK_LARGE("乚", true),
    RIGHTBENTBUT_SHARP("L", true), //eg. 我
    DOWNWITHHOOK("𠄌", true), //𠄌 eks: 長  丧  喪 𠅕
    RIGHTSLANT_SHARP("乀", true),
    RIGHTSLANT_WITHHOOK("㇂", true),
    //last strke of 民 //for the moment, I will use the stroke ㇂

    //Non unicode stroke collections
    //I will use non CJK codepoints as the string key

    OLAP7_SHUBUTTON("⿲"+OVERLAP.desc()+RIGHTBENTBUT_SHARP.val+"⿱"+DOTRIGHT.val+DOTRIGHT.val
            +OVERLAP.desc()+RIGHTBENTBUT_SHARP.val+"⿱"+DOTRIGHT.val+DOTRIGHT.val
            +RIGHTSLANT_SHARP.val, false),//button of 鼠
    OLAP4_BENTMOON_ALT("⿴𠂊⺀", false), //𠂊⺀ eg 㓘	⿵夙玉[G]	⿵几⿳一⿴𠂊⺀王[T]
    OLAP4_BENTMOON("⿴𠂊冫", false), //⿴𠂊冫 eg. upper left of 祭 from 察
    OLAP6_EXPANDEDPLANT(OVERLAP.desc()+"廿"+OVERLAP.desc() +LEFTSLANT_SHARP.val
            +RIGHTBENTBUTHOOK_LARGE.val,false),//top part of 帶
    OLAP3_BONESAW("⿺" + OVERLAP.desc()+RIGHTSLANT_WITHHOOK.val()+LEFTSLANT_SHARP.val()+DOTRIGHT.val()
            , false), //last 3 strokes of 戈
    LEFTSIDE5_FLAGWITHMIDDLE(OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()+OVERLAP.desc()
            +BENTTOP_SHARP.val+"一"+"一"+DOWNWITHHOOK.val+DOTRIGHT.val, false),//left side of 即
    OUTER2TOP_STRAIGHT("冂", false), //冂 // 冂 from 向 南
    OUTER2TOP_USEANDMOONE("⺆", false), //⺆ from 用 周
    OUTTOPLEFT2(OVERLAP.desc() + "乛" + LEFTSLANT_SHARP.val ,false), //enclosing shape from, 虍, from 號
    OLAP3LEFTSIDEOFPEOPLE(OVERLAP.desc()+BENTTOP_SHARP.val()
            +OVERLAP.desc()+"一"+RIGHTBENTBUT_SHARP.val(), false),//first 3 strokes of 民
    OLAP3WORIGHTSTROKES("⿻"+"⿻"+ RIGHTSLANT_WITHHOOK.val() + LEFTSLANT_SHARP.val() + DOTRIGHT.val() , false), //戊 我
    //customIdsSupplement.put("我", "⿻"+LEFTSLANT_SHARP.val()+"⿻扌⿻㇂⿻"+LEFTSLANT_SHARP.val()+DOTRIGHT.val());
    OLAP3HORIFORKLIKE("⿻コ一", false), //尹	⿻⿻コ一丿  eg. stroke 6,7,8 of of 事
    OLAP4TWOVERTTWOHORI(OVERLAP.desc()+"丨"+OVERLAP.desc()+"丨"+OVERLAP.desc()+"一"+"一", false), //example: 其 ⿱⿱⑤一八 and 面/囬
    OLAP4CHANGTOP(OVERLAP.desc()+"丨"+"⿳一一一", false), //ids 長 ⿳④一⿰𠄌⿺乀丿
    OLAP3ZHABUT(OVERLAP.desc()+ "丨二", false), //button side of 乍
    OLAP4NIENBUT("㐄", false), //button side of 年
    //㐄 from 舞 seen as alternative of 年
    //OLAP4NIENBUT(OVERLAP.desc()+ "一" + OVERLAP.desc() +"丨" +OVERLAP.desc() + "一" +  "丨", false), //button side of 年
    OLAP3RUSSIANCROSS(OVERLAP.desc() + "二丨", false),
    //middle side of 生, top side of 龶, top right of 請
    OLAP3YIANDCHANGBUTTOM("⿰𠄌⿺乀丿"
            , false), // DOWNWITHHOOK ⿰𠄌⿺乀丿 buoom part of 長  丧  喪 𠅕 (not including "一")
    OUTTOPRIGHT2(OVERLAP.desc()+"一"+"亅", false), //outer side of 寸
    OLAP3DOWNFORk("⿸"+LEFTSLANT_SHARP.val()+"卜", false),  //buttom side of 不
    OUTTOPLEFT3("⿻𠂇丨", false),//outer side of 在

    ;

    private final String val;

    CustomStrokeCollections(String value, boolean singleStroke) {
        if (singleStroke) {
            //For single strokes that needs an alias,
            //the key and the value must be the same
            //this.key = (char) 57344;
            //The stroke might be from the supplementary plane, so the function must handle multibyte characters.
            List<String> breakUpList = unicodeBreakup(value);
            this.val = breakUpList.get(0);
        }else {
            //For longer sequences, the key needs to be generated
            //from a static list of non-CJK unicode characters
            //this.key = (char) 57344;
            this.val = validateValue(value);
        }
    }

    private char generateKey() throws DataFormatException {
        //generate a char key from a unicode list that is not CJK and doesnt exist already
        int firstPrivateUseChar = 57344; //57.344 is the first ordinal number in the BMP private use unicode block
        int lastPrivateUseChar = 63743;  //63.743 is the last ordinal number in the BMP private use unicode block

        CustomStrokeCollections[] allValues = CustomStrokeCollections.values();
        Set<Integer> allHashCodes = generateHashcodesFromValues(allValues);
        int integerToUse = generateKeyCharacterOrdinal(firstPrivateUseChar, lastPrivateUseChar, allHashCodes);
        char charToUse = (char) integerToUse;
        return charToUse;
    }

    private int generateKeyCharacterOrdinal(int firstPrivateUseChar, int lastPrivateUseChar, Set<Integer> allHashCodes) throws DataFormatException {
        List<Integer> sortedHashCodes = allHashCodes.stream().sorted().toList();
        Integer currentValueHash = val().hashCode();
        int indexOfCurrentValue = sortedHashCodes.indexOf(currentValueHash);
        int integerToUse = firstPrivateUseChar + indexOfCurrentValue;
        if (integerToUse > lastPrivateUseChar) {
            throw new DataFormatException("The number of enums exceed the number of private use characters");
        }
        return integerToUse;
    }

    private static Set<Integer> generateHashcodesFromValues(CustomStrokeCollections[] allValues) throws DataFormatException {
        Set<Integer> allHashCodes = new HashSet<>();
        int numberOfValues = allValues.length;
        for (CustomStrokeCollections currentEnum : allValues) {
            String value = currentEnum.val();
            allHashCodes.add(value.hashCode());
        }
        if (numberOfValues != allHashCodes.size()) {
            throw new DataFormatException("some enum values are not unique");
        }
        return allHashCodes;
    }


    private static String validateValue(String value) {
        //TODO: validate value input
        return value;
    }

    public String key() throws DataFormatException {
        char key = generateKey();
        return String.valueOf(key);
    }

    public String val() {
        return val;
    }


}
