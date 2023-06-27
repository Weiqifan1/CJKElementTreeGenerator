package org.example.ObjectTypes.GenericTypes;

import org.example.CustomDataHandler.CustomDataReader;
import org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService;
import org.example.CustomDynamicDataGenerators.InputMethodCodeGenerators.AYMethodCodeGeneratorService;
import org.example.Data.InputMethodData.AYmethodInputData;

import java.util.*;
import java.util.zip.DataFormatException;

import static org.example.GlobalConstants.customIdsJsonMapPath;

public class CharRecursionNode implements CharRecursionNodeInterface {
    private final String currentBreakdownSubsection;
    private String originalInput;
    private final Map<CharMetaInfo, String> subsectionIdsMapResult;
    private final List<CharRecursionNode> subsequentSubsections;
    private static final Map<String, Map<CharMetaInfo, String>> idsMap;
    private static final HashMap<String, String> codeMap;
    private final List<String> fullCode;
    private final String normalCode;

    static {
        try {
            idsMap = CustomDataReader.getCustomIdsMap(customIdsJsonMapPath);
            codeMap = AYmethodInputData.arrayInspiredElemsV1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CharRecursionNode(String currentBreakdownSubsection, String originalInput) throws DataFormatException {
        this.currentBreakdownSubsection = currentBreakdownSubsection;
        if (Objects.nonNull(originalInput)) {
            this.originalInput = originalInput;
        } else {
            this.originalInput = currentBreakdownSubsection;
        }

        this.subsectionIdsMapResult = CharRecursionNodeService.generateIdsMapResult(currentBreakdownSubsection, idsMap);
        this.subsequentSubsections = CharRecursionNodeService.handleSubsectionPathways(
                currentBreakdownSubsection, idsMap, this.originalInput);
        this.fullCode = AYMethodCodeGeneratorService.generateFullCodeFromCodeMap(
                currentBreakdownSubsection,
                subsequentSubsections,
                codeMap, this.originalInput);
        this.normalCode = AYMethodCodeGeneratorService.generateNormalCodeFromFullCode(fullCode);
    }

    public List<String> getFullCode() {
        return fullCode;
    }

    public String getNormalCode() {
        return normalCode;
    }

    public String getCurrentBreakdownSubsection() {
        return currentBreakdownSubsection;
    }

    public Map<CharMetaInfo, String> getSubsectionIdsMapResult() {
        return subsectionIdsMapResult;
    }

    public List<CharRecursionNode> getSubsequentSubsections() {
        return subsequentSubsections;
    }

    private CharRecursionNode(Builder builder) {
        normalCode = builder.normalCode;
        fullCode = builder.fullCode;
        currentBreakdownSubsection = builder.currentBreakdownSubsection;
        subsectionIdsMapResult = builder.subsectionIdsMapResult;
        subsequentSubsections = builder.subsequentSubsections;
    }

    public static class Builder {
        private String originalInput = null;
        private String normalCode = "";
        private List<String> fullCode = new ArrayList<>();
        private String currentBreakdownSubsection = "";
        private Map<CharMetaInfo, String> subsectionIdsMapResult = new HashMap<>();
        private List<CharRecursionNode> subsequentSubsections = new ArrayList<>();

        public Builder wihtNormalCode(String code) {
            this.normalCode = code;
            return this;
        }

        public Builder withFullCode(List<String> fullCode) {
            this.fullCode = fullCode;
            return this;
        }

        public Builder withCurrentBreakdownSubsection(String currentBreakdownSubsection, String originalInput) {
            this.currentBreakdownSubsection = currentBreakdownSubsection;
            this.originalInput = originalInput;
            return this;
        }
        public Builder withSubsectionIdsMapResult(Map<CharMetaInfo, String> subsectionIdsMapResult) {
            this.subsectionIdsMapResult = subsectionIdsMapResult;
            return this;
        }
        public Builder withSubsequentSubsections(List<CharRecursionNode> subsequentSubsections) {
            this.subsequentSubsections = subsequentSubsections;
            return this;
        }

        public CharRecursionNode build() {
            return new CharRecursionNode(this);
        }
    }

}
