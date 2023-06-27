package org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator;

import org.example.CustomDataHandler.CustomDataReader;
import org.example.ObjectTypes.GenericTypes.CharMetaInfo;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.GenericTypes.CharRecursionNodeDecorator;
import org.example.ObjectTypes.GenericTypes.CharRecursionNodeInterface;
import org.example.ObjectTypes.InputMethodSpecificTypes.AYmethodInput;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

import static org.example.GlobalConstants.customIdsJsonMapPath;

public class RecursionObjectGeneratorService {

    public static <T extends CharRecursionNodeDecorator> T createNode(String input, Class<T> clazz) throws DataFormatException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        CharRecursionNodeInterface standardNode = new CharRecursionNode(input);
        return clazz.getDeclaredConstructor(CharRecursionNodeInterface.class).newInstance(standardNode);
    }

    public static List<AYmethodInput> generateNestedAYMethod(List<CharRecursionNode> nestedRecur,
                                                             HashMap<String, String> codeMap){
        return null;

    }

    public static String generateCodeLettersFromNestedAY(List<AYmethodInput> nestedAYMethod) {
        return null;
    }


}
