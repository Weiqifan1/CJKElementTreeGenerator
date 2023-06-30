package org.example.InputMethods;

import java.util.*;
import java.util.zip.DataFormatException;

import static org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService.unicodeBreakup;
import static org.example.ObjectTypes.GenericTypes.CJKDescription.ENCTOPRIGHT;
import static org.example.ObjectTypes.GenericTypes.CJKDescription.OVERLAP;

public enum CustomStrokeCollections {

    //Single Stroke Aliases
    LEFTSlANT_VERT("㇓", true),
    //eg: 㷗 ⿱⿲㇓㠯巳火  𠗎 ⿰⿰冫㇓全  𥪐 ⿱立⿰⿰冫㇓⿺乚仌
    LEFTSLANT_SHARP("丿", true),
    // eg: 㢤 ⿹⿶弋十⿰丿𠃌  㻄 ⿰王⿱丿𤴓  䇖  ⿱竹⿹勹丿  万  ⿱一⿰丿𠃌   儿  ⿰丿乚
    // 䖝 ⿱丿虫 ⿱丿⿷虫丿  䘮 ⿱⿻土从⿰𠄌⿺乀丿  䣨 ⿰酉⿻丿七  丆 ⿱一丿  丌  ⿱一⿰丿丨

    LEFTSLANT_HORI("㇀", true),
    //刁 ⿹𠃌㇀    七	⿻㇀乚   𢏻	⿰⿹⿱𠂊③㇀⿹弓⿱丿丿

    BENTTOPHOOK_LARGE("𠃌", true),
    BENTBUTHOOK_LARGE("乚", true),

    //Non unicode stroke collections
    //I will use non CJK codepoints as the string key
    OUTTOPRIGHT2(OVERLAP.charVal()+"一"+"亅", false), //outer side of 寸
    OLAP3DOWNFORk("⿸"+LEFTSLANT_SHARP.val()+"卜", false),  //buttom side of 不
    OUTTOPLEFT3("⿻𠂇丨", false),//outer side of 在
        //customIdsSupplement.put("𒀀", "⿸"+LEFTSLANT_SHARP+"卜"); //buttom side of 不
        //customIdsSupplement.put("𒀁", "⿻𠂇丨"); //outer side of 在
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
