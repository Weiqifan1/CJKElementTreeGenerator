package org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator;

import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.InputMethodSpecificTypes.AYmethodInput;

import static org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.RecursionObjectGeneratorService.createNode;


public class RecursionObjectGeneratorMain {

    public static void main(String[] args) throws Exception {
        System.out.println("Recursion Object Generator started!");

        CharRecursionNode obj = new CharRecursionNode("的");

        AYmethodInput obj2 = createNode("的", AYmethodInput.class);

        System.out.println("Recursion Object Generator ended!");
    }
}
