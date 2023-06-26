package org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator;

import org.example.ObjectTypes.GenericTypes.CharRecursionNode;


public class RecursionObjectGeneratorMain {

    public static void main(String[] args) throws Exception {
        System.out.println("Recursion Object Generator started!");

        CharRecursionNode obj = RecursionObjectGeneratorService.generateRecursionObj("的");

        System.out.println("Recursion Object Generator ended!");
    }
}
