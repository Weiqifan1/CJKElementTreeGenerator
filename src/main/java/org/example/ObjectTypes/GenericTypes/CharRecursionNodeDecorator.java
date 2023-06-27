package org.example.ObjectTypes.GenericTypes;

import java.util.List;
import java.util.Map;

public abstract class CharRecursionNodeDecorator implements CharRecursionNodeInterface{

    protected CharRecursionNodeInterface decoratedCharRecursionNode;

    public CharRecursionNodeDecorator(CharRecursionNodeInterface charRecursionNodeInterface) {
        this.decoratedCharRecursionNode = charRecursionNodeInterface;
    }

    @Override
    public String getCurrentBreakdownSubsection() {
        return this.decoratedCharRecursionNode.getCurrentBreakdownSubsection();
    }

    @Override
    public Map<CharMetaInfo, String> getSubsectionIdsMapResult() {
        return this.decoratedCharRecursionNode.getSubsectionIdsMapResult();
    }

    @Override
    public List<CharRecursionNode> getSubsequentSubsections() {
        return this.decoratedCharRecursionNode.getSubsequentSubsections();
    }
}
