package org.example.ObjectTypes;

import org.example.CharRecursionObjectGenerator.CharRecursionNodeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CharRecursionNode {
    private final String currentBreakdownSubsection;
    private final Map<String, String> subsectionIdsMapResult;
    private final List<CharRecursionNode> subsequentSubsections;

    public CharRecursionNode(String currentBreakdownSubsection, Map<String, Map<String, String>> customIds) {
        this.currentBreakdownSubsection = currentBreakdownSubsection;
        this.subsectionIdsMapResult = CharRecursionNodeService.generateIdsMapResult(currentBreakdownSubsection, customIds);
        this.subsequentSubsections = CharRecursionNodeService.generateSubsections(currentBreakdownSubsection, subsectionIdsMapResult, customIds);
    }

    private CharRecursionNode(Builder builder) {
        currentBreakdownSubsection = builder.currentBreakdownSubsection;
        subsectionIdsMapResult = builder.subsectionIdsMapResult;
        subsequentSubsections = builder.subsequentSubsections;
    }

    public static class Builder {
        private String currentBreakdownSubsection = "";
        private Map<String, String> subsectionIdsMapResult = new HashMap<>();
        private List<CharRecursionNode> subsequentSubsections = new ArrayList<>();

        public Builder withCurrentBreakdownSubsection(String currentBreakdownSubsection) {
            this.currentBreakdownSubsection = currentBreakdownSubsection;
            return this;
        }
        public Builder withSubsectionIdsMapResult(Map<String, String> subsectionIdsMapResult) {
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
