package org.example.CustomDataHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ObjectTypes.GenericTypes.CharMetaInfo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.Data.CustomData.customIdsSupplementMaps.customIdsSupplement;


public class CustomDataReader {
    public static Map<String, Map<CharMetaInfo, String>> getCustomIdsMap(String customIdsPath) throws Exception {
        String content = "";
        try {
            Path path = Paths.get(customIdsPath);
            content = Files.readString(path);
        } catch (Exception e) {
            throw new Exception("Custom File Reading Error: " + e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Map<CharMetaInfo, String>> map = objectMapper.readValue(content, new TypeReference<Map<String, Map<CharMetaInfo, String>>>() {});
        HashMap<String, String> customIdsCodesMap = customIdsSupplement;
        List<String> keysFromCustom = customIdsCodesMap.keySet().stream().toList();
        for (String key : keysFromCustom) {
            String addInfo = customIdsCodesMap.get(key);
            Map<CharMetaInfo, String> subMap = map.get(key);
            subMap.put(CharMetaInfo.BREAKDOWN, addInfo);
            map.put(key, subMap);
        }
        return map;
    }



}
