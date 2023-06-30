package org.example.InputMethods;

import org.example.ObjectTypes.GenericTypes.CharMetaInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.DataFormatException;

import static org.example.InputMethods.CustomStrokeCollections.*;

public class CustomIdsSupplementMaps {

    private Map<CharMetaInfo, String> tempMap = new HashMap<>();

    public static final HashMap<String, String> customIdsSupplement = new HashMap<>();
    static {
        try {
            //CustomStrokeCollections
            customIdsSupplement.put("白", "⿻"+LEFTSLANT_SHARP.val()+"日");
            customIdsSupplement.put("我", "⿻"+LEFTSLANT_SHARP.val()+"⿻扌⿻㇂⿻"+LEFTSLANT_SHARP.val()+"丶");
            customIdsSupplement.put("尢", "⿸𠂇㇟");
            customIdsSupplement.put("卜", "⿻丨丶");
            customIdsSupplement.put("也", "⿻㇆⿻丨㇟");//?
            //customIdsSupplement.put("丆", "⿱㇐㇓");
            customIdsSupplement.put("不", "⿱一" +OLAP3DOWNFORk.key());
            customIdsSupplement.put("在", "⿸"+OUTTOPLEFT3.key()+"土");
            //customIdsSupplement.put("欠", "⿵");
            //customIdsSupplement.put("人", "⿻"+LEFTSLANT_SHARP+"㇂");
            //customIdsSupplement.put("不", "⿸丆卜");
            //customIdsSupplement.put(, "");

            //Custom String Replacements
            customIdsSupplement.put(CustomStrokeCollections.OLAP3DOWNFORk.key(), OLAP3DOWNFORk.val()); //buttom side of 不
            customIdsSupplement.put(CustomStrokeCollections.OUTTOPLEFT3.key(), OUTTOPLEFT3.val()); //outer side of 在

        } catch (DataFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
