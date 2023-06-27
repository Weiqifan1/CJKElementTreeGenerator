package org.example.ObjectTypes.InputMethodSpecificTypes;

import org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.RecursionObjectGeneratorService;
import org.example.Data.InputMethodData.AYmethodInputData;
import org.example.ObjectTypes.GenericTypes.CharMetaInfo;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.GenericTypes.CharRecursionNodeDecorator;
import org.example.ObjectTypes.GenericTypes.CharRecursionNodeInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

public class AYmethodInput extends CharRecursionNodeDecorator {

    private final String codeLetters;
    private final List<AYmethodInput> nestedAYMethod;
    private static final HashMap<String, String> codeMap;

    static {
        try {
            codeMap = AYmethodInputData.arrayInspiredElemsV1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public AYmethodInput(CharRecursionNodeInterface decoratedCharRecursionNode) throws DataFormatException {
        super(decoratedCharRecursionNode);
        this.nestedAYMethod = RecursionObjectGeneratorService.generateNestedAYMethod(super.getSubsequentSubsections(), codeMap);
        this.codeLetters = RecursionObjectGeneratorService.generateCodeLettersFromNestedAY(nestedAYMethod);
    }

    @Override
    public String getCurrentBreakdownSubsection() {
        return super.getCurrentBreakdownSubsection();
    }

    @Override
    public Map<CharMetaInfo, String> getSubsectionIdsMapResult() {
        return super.getSubsectionIdsMapResult();
    }

    @Override
    public List<CharRecursionNode> getSubsequentSubsections() {
        return super.getSubsequentSubsections();
    }


}
