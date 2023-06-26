package org.example.CustomDataHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ObjectTypes.GenericTypes.CharMetaInfo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


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
        return map;
    }



}
