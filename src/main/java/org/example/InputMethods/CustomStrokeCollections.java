package org.example.InputMethods;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum CustomStrokeCollections {

    //Single Stroke Aliases
    LEFTSlANT_SLEIGHT('㇓'),
    //eg: 㷗 ⿱⿲㇓㠯巳火  𠗎 ⿰⿰冫㇓全  𥪐 ⿱立⿰⿰冫㇓⿺乚仌
    LEFTSLANT_SHARP('丿');
    // eg: 㢤 ⿹⿶弋十⿰丿𠃌  㻄 ⿰王⿱丿𤴓  䇖  ⿱竹⿹勹丿  万  ⿱一⿰丿𠃌   儿  ⿰丿乚
    // 䖝 ⿱丿虫 ⿱丿⿷虫丿  䘮 ⿱⿻土从⿰𠄌⿺乀丿  䣨 ⿰酉⿻丿七  丆 ⿱一丿  丌  ⿱一⿰丿丨

    //Non unicode stroke collections
    //I will use non CJK codepoints as the string key

    private final char key;
    private final String val;

    CustomStrokeCollections(char value) {
        //For single strokes that needs an alias,
        //the key and the value must be the same
        this.key = value;
        this.val = String.valueOf(value);
    }

    CustomStrokeCollections(String value) {
        //For longer sequences, the key needs to be generated
        //from a static list of non-CJK unicode characters
        this.key = generateKey();
        this.val = value;
    }

    private Character generateKey() {
        Set<Character> existingKeys = Arrays.stream(CustomStrokeCollections.values())
                .map(currentEnum -> currentEnum.key().charAt(0)).collect(Collectors.toSet());
        //TODO: generate a char key from a unicode list that is not CJK and doesnt exist already
        return null;
    }

    public String key() {
        return String.valueOf(key);
    }

    public String val() {
        return val;
    }


}
