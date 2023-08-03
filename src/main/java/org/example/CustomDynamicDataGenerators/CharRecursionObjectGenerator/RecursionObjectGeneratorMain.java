package org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator;

import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.GenericTypes.CodeDecompositionType;


public class RecursionObjectGeneratorMain {

    public static void main(String[] args) throws Exception {
        System.out.println("Recursion Object Generator started!");

        CharRecursionNode obj = new CharRecursionNode(
                "才", null,
                CodeDecompositionType.CODE4_123z_LIMMITBACKTRACK, null);



        System.out.println("Recursion Object Generator ended!");
    }
}
