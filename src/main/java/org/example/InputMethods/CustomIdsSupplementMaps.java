package org.example.InputMethods;

import org.example.ObjectTypes.GenericTypes.CJKDescription;
import org.example.ObjectTypes.GenericTypes.CharMetaInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.DataFormatException;

import static org.example.InputMethods.CustomStrokeCollections.*;
import static org.example.ObjectTypes.GenericTypes.CJKDescription.ENCIRTOP;

public class CustomIdsSupplementMaps {

    private Map<CharMetaInfo, String> tempMap = new HashMap<>();

    public static final HashMap<String, String> customIdsSupplement = new HashMap<>();
    static {
        try {
            //CustomStrokeCollections
            customIdsSupplement.put("白", "⿻"+LEFTSLANT_SHARP.val()+"日");
            customIdsSupplement.put("我", "⿻"+LEFTSLANT_SHARP.val()+"⿻扌⿻㇂⿻"+LEFTSLANT_SHARP.val()+"丶");
            customIdsSupplement.put("尢", "⿸𠂇"+BENTBUTHOOK_LARGE.val());
            customIdsSupplement.put("卜", "⿻丨丶");
            customIdsSupplement.put("⺊", "⿻丨一");
            customIdsSupplement.put("也", "⿻"+"𠃌"+"⿻丨"+BENTBUTHOOK_LARGE.val());//?
            //customIdsSupplement.put("丆", "⿱㇐㇓");
            customIdsSupplement.put("不", "⿱一" +OLAP3DOWNFORk.key());
            customIdsSupplement.put("在", "⿸"+OUTTOPLEFT3.key()+"土");
            //arrayInspiredElemsV1.put("月", "uq"); //o=9+1 q=1+1
            customIdsSupplement.put("月", ENCIRTOP.charVal()+"⿻"+LEFTSLANT_SHARP.val()+"𠃌"+"⿱一一");
            customIdsSupplement.put("门", "⿻丶⿻丨𠃌");
            customIdsSupplement.put("以", "⿻"+BENTBUTHOOK_LARGE.val()+"⿻丶人");
            customIdsSupplement.put("来", "⿻木⿻丷一");
            customIdsSupplement.put("为", "⿻丶⿻力丶");
            customIdsSupplement.put("欠", "⿱"+"𠂊"+"人");
            customIdsSupplement.put("𠂊", "⿻"+LEFTSLANT_SHARP.val()+"𠃌");//你欠
            customIdsSupplement.put("⺌", "⿻" + "丨" + "丷"); // 會
            customIdsSupplement.put("子", "⿻"+"𠃌"+"亅"+"一");
            customIdsSupplement.put("為", "⿻"+"丶"+"⿻"+LEFTSLANT_SHARP.val()+"⿻"+"𠃌"+"⿻"+"𠃌"+"⿻"+"𠃌"+"灬");//為

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
