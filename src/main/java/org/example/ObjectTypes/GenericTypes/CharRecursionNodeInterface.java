package org.example.ObjectTypes.GenericTypes;

import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

public interface CharRecursionNodeInterface {

    //public CharRecursionNodeInterface generateRecursionObj(String input) throws DataFormatException;

    public String getCurrentBreakdownSubsection();
    public String getCurrentMetaBreakdown();
    public Map<CharMetaInfo, String> getSubsectionIdsMapResult();
    public List<CharRecursionNode> getSubsequentSubsections();
}
