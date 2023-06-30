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
            //Stroke collections that have unicode char representations
            //(for stroke collections that dont are in CustomStrokeCollection enums)
            customIdsSupplement.put("白", "⿻"+LEFTSLANT_SHARP.val()+"日");
            customIdsSupplement.put("我", "⿻"+LEFTSLANT_SHARP.val()+"⿻扌⿻㇂⿻"+LEFTSLANT_SHARP.val()+"丶");
            customIdsSupplement.put("尢", "⿸𠂇"+BENTBUTHOOK_LARGE.val());
            customIdsSupplement.put("卜", "⿻丨丶");
            customIdsSupplement.put("⺊", "⿻丨一");
            customIdsSupplement.put("也", "⿻"+BENTTOPHOOK_LARGE.val()+"⿻丨"+BENTBUTHOOK_LARGE.val());//?
            customIdsSupplement.put("不", "⿱一" +OLAP3DOWNFORk.key());
            customIdsSupplement.put("在", "⿸"+OUTTOPLEFT3.key()+"土");
            customIdsSupplement.put("月", ENCIRTOP.charVal()+"⿻"+LEFTSLANT_SHARP.val()+BENTTOPHOOK_LARGE.val()+"⿱一一");
            customIdsSupplement.put("门", "⿻丶⿻丨"+BENTTOPHOOK_LARGE.val());
            customIdsSupplement.put("以", "⿻"+BENTBUTHOOK_LARGE.val()+"⿻丶人");
            customIdsSupplement.put("来", "⿻木⿻丷一");
            customIdsSupplement.put("为", "⿻丶⿻力丶");
            customIdsSupplement.put("欠", "⿱"+"𠂊"+"人");
            customIdsSupplement.put("𠂊", "⿻"+LEFTSLANT_SHARP.val()+BENTTOPHOOK_LARGE.val());//你欠
            customIdsSupplement.put("⺌", "⿻" + "丨" + "丷"); // 會
            customIdsSupplement.put("子", "⿻"+BENTTOPHOOK_LARGE.val()+"亅"+"一");
            customIdsSupplement.put("為", "⿻"+"丶"+"⿻"+LEFTSLANT_SHARP.val()+"⿻"
                    +BENTTOPHOOK_LARGE.val()+"⿻"+BENTTOPHOOK_LARGE.val()+"⿻"+BENTTOPHOOK_LARGE.val()+"灬");//為

            //Custom String Replacements
            customIdsSupplement.put(CustomStrokeCollections.OLAP3DOWNFORk.key(), OLAP3DOWNFORk.val()); //buttom side of 不
            customIdsSupplement.put(CustomStrokeCollections.OUTTOPLEFT3.key(), OUTTOPLEFT3.val()); //outer side of 在

        } catch (DataFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
