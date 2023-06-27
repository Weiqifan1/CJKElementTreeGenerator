package org.example.ObjectTypes.GenericTypes;

import java.util.List;
import java.util.Map;

public interface CharRecursionNodeInterface {

    public String getCurrentBreakdownSubsection();
    public Map<CharMetaInfo, String> getSubsectionIdsMapResult();
    public List<CharRecursionNode> getSubsequentSubsections();
}
