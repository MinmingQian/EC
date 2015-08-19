package adeuni.group.ec.algorithm.algorithms.ea;

import adeuni.group.ec.algorithm.component.operator.selection.InterfaceSelection;
import adeuni.group.ec.algorithm.component.operator.selection.parent.BestSelection;
import adeuni.group.ec.algorithm.component.representation.permutation.PermutationRepresentation;
import adeuni.group.ec.algorithm.component.solution.Solution;
import adeuni.group.ec.algorithm.component.solution.SolutionSpace;
import adeuni.group.ec.algorithm.component.termination.IterationTerminationCriterion;
import adeuni.group.ec.algorithm.component.termination.TerminationCriteriaPool;
import adeuni.group.ec.algorithm.configuration.Configuration;
import adeuni.group.ec.algorithm.toolset.factory.RepresentationFactory;
import adeuni.group.ec.algorithm.toolset.roulette.selection.SelectionCell;
import adeuni.group.ec.algorithm.toolset.roulette.selection.SelectionRoulette;
import adeuni.group.ec.tests.tsp.TspPermutationEvaluationFunction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by qianminming on 18/08/15.
 */
public class EvolutionaryAlgorithmTest {
    public Configuration<PermutationRepresentation> configuration;
    public EvolutionaryAlgorithm<PermutationRepresentation> evolutionaryAlgorithm;

    @Test
    public void testCompete() throws Exception {
        SolutionSpace<PermutationRepresentation> solutionSpace = evolutionaryAlgorithm.initSolutionSpace();
        solutionSpace.getSolutionList().forEach(solution -> System.out.println(solution.getRepresentation().getRepresentationString()));

    }


    @Before
    public void setUp() throws Exception {
        int size = 200;
        configuration = new Configuration<>();
        configuration.setRepresentationFactory(new RepresentationFactory<PermutationRepresentation>(PermutationRepresentation.class, 10));
        configuration.setSolutionSpaceSize(size);

        TerminationCriteriaPool<EvolutionaryAlgorithm> terminationCriteriaPool = new TerminationCriteriaPool<>();
        terminationCriteriaPool.add(new IterationTerminationCriterion<>(200));
        configuration.setTerminationCriteriaPool(terminationCriteriaPool);


        BestSelection<PermutationRepresentation> bestSelection = new BestSelection<>();
        SelectionCell  selectionSelectionCell = new SelectionCell(1, bestSelection);
        SelectionRoulette selectionRoulette = new SelectionRoulette();
        selectionRoulette.addCell(selectionSelectionCell);


        configuration.setParentSelectionRoulette(selectionRoulette);
        configuration.setParentSurvivorSelectionRoulette(selectionRoulette);
        configuration.setOffspringSurvivorSelectionRoulette(selectionRoulette);

        TspPermutationEvaluationFunction permutationEvaluationFunction = new TspPermutationEvaluationFunction();
        configuration.setEvaluationFunction(permutationEvaluationFunction);

        evolutionaryAlgorithm = new EvolutionaryAlgorithm<>(configuration);


    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testRun() throws Exception {
        evolutionaryAlgorithm.run();
    }
}