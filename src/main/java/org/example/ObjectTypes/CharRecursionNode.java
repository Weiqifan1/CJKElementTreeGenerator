package org.example.ObjectTypes;

import org.example.CharRecursionObjectGenerator.CharRecursionNodeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;


public class CharRecursionNode {
    private final String currentBreakdownSubsection;
    private final String currentMetaBreakdown;
    private final Map<CharMetaInfo, String> subsectionIdsMapResult;
    private final List<CharRecursionNode> subsequentSubsections;

    public String getCurrentBreakdownSubsection() {
        return currentBreakdownSubsection;
    }

    public String getCurrentMetaBreakdown() {
        return currentMetaBreakdown;
    }

    public Map<CharMetaInfo, String> getSubsectionIdsMapResult() {
        return subsectionIdsMapResult;
    }

    public List<CharRecursionNode> getSubsequentSubsections() {
        return subsequentSubsections;
    }

    public CharRecursionNode(String currentBreakdownSubsection,
                             String currentMetaBreakdown,
                             Map<String, Map<CharMetaInfo, String>> customIds) throws DataFormatException {
        this.currentBreakdownSubsection = currentBreakdownSubsection;
        this.subsectionIdsMapResult = CharRecursionNodeService.generateIdsMapResult(currentBreakdownSubsection, customIds);
        this.currentMetaBreakdown = currentMetaBreakdown;
        this.subsequentSubsections = CharRecursionNodeService.handleSubsectionPathways(
                currentBreakdownSubsection, customIds);
    }

    private CharRecursionNode(Builder builder) {
        currentBreakdownSubsection = builder.currentBreakdownSubsection;
        currentMetaBreakdown = builder.currentMetaBreakdown;
        subsectionIdsMapResult = builder.subsectionIdsMapResult;
        subsequentSubsections = builder.subsequentSubsections;
    }

    public static class Builder {
        private String currentBreakdownSubsection = "";
        private String currentMetaBreakdown = "";
        private Map<CharMetaInfo, String> subsectionIdsMapResult = new HashMap<>();
        private List<CharRecursionNode> subsequentSubsections = new ArrayList<>();

        public Builder withCurrentBreakdownSubsection(String currentBreakdownSubsection) {
            this.currentBreakdownSubsection = currentBreakdownSubsection;
            return this;
        }
        public Builder withCurrentMetaBreakdown(String currentMetaBreakdown) {
            this.currentMetaBreakdown = currentMetaBreakdown;
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
