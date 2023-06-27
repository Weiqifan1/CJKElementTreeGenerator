package org.example.ObjectTypes.GenericTypes;

import org.example.CustomDataHandler.CustomDataReader;
import org.example.CustomDynamicDataGenerators.CharRecursionObjectGenerator.CharRecursionNodeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

import static org.example.GlobalConstants.customIdsJsonMapPath;

public class CharRecursionNode implements CharRecursionNodeInterface {
    private final String currentBreakdownSubsection;
    private final Map<CharMetaInfo, String> subsectionIdsMapResult;
    private final List<CharRecursionNode> subsequentSubsections;
    private static final Map<String, Map<CharMetaInfo, String>> idsMap;

    static {
        try {
            idsMap = CustomDataReader.getCustomIdsMap(customIdsJsonMapPath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CharRecursionNode(String currentBreakdownSubsection) throws DataFormatException {
        this.currentBreakdownSubsection = currentBreakdownSubsection;
        this.subsectionIdsMapResult = CharRecursionNodeService.generateIdsMapResult(currentBreakdownSubsection, idsMap);
        this.subsequentSubsections = CharRecursionNodeService.handleSubsectionPathways(
                currentBreakdownSubsection, idsMap);
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
        currentBreakdownSubsection = builder.currentBreakdownSubsection;
        subsectionIdsMapResult = builder.subsectionIdsMapResult;
        subsequentSubsections = builder.subsequentSubsections;
    }

    public static class Builder {
        private String currentBreakdownSubsection = "";
        private Map<CharMetaInfo, String> subsectionIdsMapResult = new HashMap<>();
        private List<CharRecursionNode> subsequentSubsections = new ArrayList<>();

        public Builder withCurrentBreakdownSubsection(String currentBreakdownSubsection) {
            this.currentBreakdownSubsection = currentBreakdownSubsection;
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
