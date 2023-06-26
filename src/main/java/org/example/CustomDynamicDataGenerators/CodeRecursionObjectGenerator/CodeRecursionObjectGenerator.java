package org.example.CustomDynamicDataGenerators.CodeRecursionObjectGenerator;

import org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.RecursionObjectGeneratorService;
import org.example.ObjectTypes.CharRecursionNode;

public class CodeRecursionObjectGenerator {

    public static void main(String[] args) throws Exception {
        System.out.println("Recursion Object Generator started!");

        CharRecursionNode obj = RecursionObjectGeneratorService.generateRecursionObj("的");

        System.out.println("Recursion Object Generator ended!");
    }

}
