package org.example.CharRecursionObjectGenerator;

import org.example.CustomDataHandler.CustomDataReader;
import org.example.ObjectTypes.CharRecursionNode;
import java.util.Map;
import static org.example.GlobalConstants.customIdsJsonMapPath;

public class RecursionObjectGeneratorService {
    private static final Map<String, Map<String, String>> idsMap;

    static {
        try {
            idsMap = CustomDataReader.getCustomIdsMap(customIdsJsonMapPath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static CharRecursionNode generateRecursionObj(String input) {
        CharRecursionNode newObj = new CharRecursionNode(input, idsMap);
        return newObj;
    }
}
