package adeuni.group.ec.algorithm.utility.factory;

import adeuni.group.ec.algorithm.component.operator.variation.permutation.PermutationOrderCrossover;
import adeuni.group.ec.algorithm.component.operator.variation.permutation.PermutationPMXCrossover;
import adeuni.group.ec.algorithm.component.representation.permutation.PermutationRepresentation;
import adeuni.group.ec.algorithm.component.termination.ExecutionTimeTerminationCriterion;
import adeuni.group.ec.algorithm.component.termination.IterationTerminationCriterion;
import adeuni.group.ec.algorithm.component.termination.TerminationCriteriaPool;
import adeuni.group.ec.algorithm.configuration.Configuration;
import adeuni.group.ec.algorithm.configuration.yml.YamlConfiguration;
import adeuni.group.ec.algorithm.utility.roulette.RouletteException;
import adeuni.group.ec.algorithm.utility.roulette.operator.VariationCell;
import adeuni.group.ec.algorithm.utility.roulette.operator.VariationRoulette;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by qianminming on 19/08/15.
 */
public class ConfigurationFactory {
    public static Configuration createConfiguration() throws FileNotFoundException, RouletteException {
        Yaml yaml = new Yaml();
        InputStream input = new FileInputStream(new File("/Users/qianminming/IntelliJProjects/EC/resource/configuration.yml"));
        YamlConfiguration yamlConfiguration = (YamlConfiguration) yaml.load(input);
        Configuration configuration = null;

        //construct configuration
        if (yamlConfiguration.representation.equals("PermutationRepresentation")) {
            configuration = new Configuration<PermutationRepresentation>();
        }

        //configure population structure
        int population = yamlConfiguration.eliteSize + yamlConfiguration.parentSurvivorSize +
                         yamlConfiguration.offspringSurvivorSize + yamlConfiguration.immigrateSize;
        configuration.setSolutionSpaceSize(population);
        configuration.setEliteSize(yamlConfiguration.eliteSize);
        configuration.setParentSurvivorSize(yamlConfiguration.parentSurvivorSize);
        configuration.setOffspringSize(yamlConfiguration.offspringSize);
        configuration.setOffspringSurvivorSize(yamlConfiguration.offspringSurvivorSize);
        configuration.setImmigrateSize(yamlConfiguration.immigrateSize);


        //configure variation roulette section
        double totalVariationRouletteWeight = 0;
        for (Map<String, Object> variationCellMap : yamlConfiguration.variationRouletteCellList) {
            totalVariationRouletteWeight += (double)variationCellMap.get("weight");
        }
        VariationRoulette variationRoulette = new VariationRoulette();
        for (Map<String, Object> variationCellMap : yamlConfiguration.variationRouletteCellList) {
            double probability = (double)variationCellMap.get("weight") / totalVariationRouletteWeight;
            VariationCell variationCell = null;

            //construct each variation operator type
            String variationCellType = (String) variationCellMap.get("variation");
            if (variationCellType.equals("PermutationPMXCrossover")) {
                PermutationPMXCrossover permutationPMXCrossover = new PermutationPMXCrossover();
                variationCell = new VariationCell(probability, permutationPMXCrossover);
            } else if (variationCellType.equals("PermutationOrderCrossover")) {
                PermutationOrderCrossover permutationOrderCrossover = new PermutationOrderCrossover();
                variationCell = new VariationCell(probability, permutationOrderCrossover);
            }

            variationRoulette.addCell(variationCell);
        }
        configuration.setVariationRoulette(variationRoulette);



        //configure parent selection roulette todo
        double totalParentSelectionRouletteWeight = 0;


        //configure parent survivor selection roulette todo
        double totalParentSurvivorSelectionRouletteWeight = 0;


        //configure offspring survivor selection roulette todo
        double totalOffspringSurvivorSelectionRouletteWeight = 0;
        

        //configure termination criteria pool
        TerminationCriteriaPool terminationCriteriaPool = new TerminationCriteriaPool();
        for (Map<String,Object> criterionDrop: yamlConfiguration.terminationCriteriaPool) {
            if (criterionDrop.get("criterion").equals("IterationTerminationCriterion")){
                int maxIterationRound = (int) criterionDrop.get("maxIterationRound");
                IterationTerminationCriterion iterationTerminationCriterion = new IterationTerminationCriterion(maxIterationRound);
                terminationCriteriaPool.add(iterationTerminationCriterion);
            } else if(criterionDrop.get("criterion").equals("ExecutionTimeTerminationCriterion")) {
                int maxExecutionTime = (int) criterionDrop.get("maxExecutionTime");
                ExecutionTimeTerminationCriterion executionTimeTerminationCriterion = new ExecutionTimeTerminationCriterion(maxExecutionTime);
                terminationCriteriaPool.add(executionTimeTerminationCriterion);
            }
        }
        configuration.setTerminationCriteriaPool(terminationCriteriaPool);


        return configuration;
    }
}
