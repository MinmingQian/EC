package adeuni.group.ec.algorithm.configuration.yml;

import java.util.HashMap;
import java.util.List;

/**
 * Created by qianminming on 19/08/15.
 */
public class YamlConfiguration {

    public List<HashMap<String,Object>> terminationCriteriaPool;
    public String representation;

    public List<HashMap<String,Object>> variationRouletteCellList;
    public List<HashMap<String,Object>> parentSelectionRouletteCellList;
    public List<HashMap<String,Object>> parentSurvivorSelectionRouletteCellList;
    public List<HashMap<String,Object>> offspringSurvivorSelectionRouletteCellList;

    public int eliteSize;
    public int parentSurvivorSize;
    public int offspringSize;
    public int offspringSurvivorSize;
    public int immigrateSize;

}
