package org.example.ObjectTypes.GenericTypes;

import org.example.CustomDataHandler.CustomDataReader;

import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

import static org.example.GlobalConstants.customIdsJsonMapPath;

public abstract class CharRecursionNodeDecorator implements CharRecursionNodeInterface{
    protected CharRecursionNodeInterface charRecursionNodeInterface;


    public String getCurrentBreakdownSubsection() {
        return this.charRecursionNodeInterface.getCurrentBreakdownSubsection();
    }

    public String getCurrentMetaBreakdown() {
        return this.charRecursionNodeInterface.getCurrentMetaBreakdown();
    }

    public Map<CharMetaInfo, String> getSubsectionIdsMapResult() {
        return this.charRecursionNodeInterface.getSubsectionIdsMapResult();
    }

    public List<CharRecursionNode> getSubsequentSubsections() {
        return this.charRecursionNodeInterface.getSubsequentSubsections();
    }
}
