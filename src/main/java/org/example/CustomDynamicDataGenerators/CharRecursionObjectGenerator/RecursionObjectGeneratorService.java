package org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator;

import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.GenericTypes.CharRecursionNodeDecorator;
import org.example.ObjectTypes.GenericTypes.CharRecursionNodeInterface;

import java.lang.reflect.InvocationTargetException;
import java.util.zip.DataFormatException;

public class RecursionObjectGeneratorService {

    public static <T extends CharRecursionNodeDecorator> T createNode(String input, Class<T> clazz) throws DataFormatException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        CharRecursionNodeInterface standardNode = new CharRecursionNode(input);
        return clazz.getDeclaredConstructor(CharRecursionNodeInterface.class).newInstance(standardNode);
    }


}
