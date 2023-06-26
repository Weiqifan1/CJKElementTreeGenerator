package org.example.ObjectTypes.InputMethodSpecificTypes;

import org.example.ObjectTypes.GenericTypes.CharMetaInfo;
import org.example.ObjectTypes.GenericTypes.CharRecursionNode;
import org.example.ObjectTypes.GenericTypes.CharRecursionNodeDecorator;
import org.example.ObjectTypes.GenericTypes.CharRecursionNodeInterface;

import java.util.List;
import java.util.Map;

public class AYmethodInput extends CharRecursionNodeDecorator {

    public String getCurrentBreakdownSubsection() {
        return super.getCurrentBreakdownSubsection();
    }

    public String getCurrentMetaBreakdown() {
        return super.getCurrentMetaBreakdown();
    }

    public Map<CharMetaInfo, String> getSubsectionIdsMapResult() {
        return super.getSubsectionIdsMapResult();
    }

    public List<CharRecursionNode> getSubsequentSubsections() {
        return super.getSubsequentSubsections();
    }
}
