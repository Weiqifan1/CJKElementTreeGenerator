package org.example.InputMethods;

import org.example.ObjectTypes.GenericTypes.CharMetaInfo;

import java.util.HashMap;
import java.util.Map;

public class customIdsSupplementMaps {

    private Map<CharMetaInfo, String> tempMap = new HashMap<>();
    public static final HashMap<String, String> customIdsSupplement = new HashMap<>();
    static {/*
        tempMap = {"BREAKDOWN":"⿶凵㐅",
                "TZAIORDINAL":"2701",
                "BREAKDOWNMETA":"",
                "CHAR":"凶",
                "UNICODE":"U+51F6",
                "JUNDAORDINAL":"1378"};*/
        customIdsSupplement.put("白", "⿻㇓日");
        customIdsSupplement.put("我", "⿻㇓⿻扌⿻㇂⿻㇓丶");
        customIdsSupplement.put("尢", "⿸𠂇㇟");
        //customIdsSupplement.put(, "");

    }
}
