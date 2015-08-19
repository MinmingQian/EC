package adeuni.group.ec.algorithm.algorithms.ea;

import adeuni.group.ec.algorithm.algorithms.AbstractAlgorithm;
import adeuni.group.ec.algorithm.algorithms.AlgorithmState;
import adeuni.group.ec.algorithm.component.evaluationfunction.InterfaceEvaluationFunction;
import adeuni.group.ec.algorithm.component.operator.OperatorException;
import adeuni.group.ec.algorithm.component.operator.variation.InterfaceVariationOperator;
import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;
import adeuni.group.ec.algorithm.component.solution.Solution;
import adeuni.group.ec.algorithm.component.solution.SolutionSpace;
import adeuni.group.ec.algorithm.configuration.Configuration;
import adeuni.group.ec.algorithm.toolset.factory.RepresentationFactory;
import adeuni.group.ec.algorithm.toolset.roulette.operator.VariationRoulette;
import adeuni.group.ec.algorithm.toolset.roulette.selection.SelectionRoulette;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qianminming on 16/08/15.
 */
public class EvolutionaryAlgorithm<T extends InterfaceRepresentation> extends AbstractAlgorithm {
    private static final long serialVersionUID = 7383094011681959784L;


    public EvolutionaryAlgorithm(Configuration configuration) {
        super(configuration);
    }



    public SolutionSpace initSolutionSpace() {
        int solutionSpaceSize = configuration.getSolutionSpaceSize();
        RepresentationFactory<T> representationFactory = configuration.getRepresentationFactory();
        SolutionSpace<T> solutionSpace = new SolutionSpace<>();

        for (int i = 0; i < solutionSpaceSize; i++) {
            solutionSpace.add(new Solution(representationFactory.createRepresentation()));
        }

        return solutionSpace;
    }


    public SolutionSpace iteration(AlgorithmState algorithmState) throws Exception {
        int offspringSurvivorSize;
        int eliteSize;
        int parentSurvivorSize;

        SolutionSpace<T> newGeneration = new SolutionSpace<>();
        SolutionSpace<T> currentSolutionSpace = algorithmState.getCurrentSolutionSpace();
        InterfaceEvaluationFunction<T> evaluationFunction = configuration.getEvaluationFunction();
        List<Solution<T>> eliteList;


        //choose the elite, the elite is not to be chosen
        eliteSize = configuration.getEliteSize();
        eliteList = elitism(eliteSize, currentSolutionSpace);
        eliteList.forEach(newGeneration::add);

        //nextGeneration will be produced here.
        offspringSurvivorSize = configuration.getOffspringSurvivorSize();
        reproduce(offspringSurvivorSize, currentSolutionSpace).forEach(newGeneration::add);

        //compete to get parent survivors, these
        parentSurvivorSize = configuration.getParentSurvivorSize();
        currentSolutionSpace.remove(eliteList);
        compete(parentSurvivorSize, currentSolutionSpace).forEach(newGeneration::add);

        //evaluate new generation
        evaluationFunction.evaluateSolutionSpace(newGeneration);

        return newGeneration;
    }

    private List<Solution<T>> elitism(int eliteSize, SolutionSpace<T> currentSolutionSpace) {
        return currentSolutionSpace.getHighestSubList(eliteSize);
    }

    /**
     * Select the assigned size of survivors in the parent solution space. we call this compete because it is a comptetion between all parents
     * @param parentSurvivorSize
     * @param currentSolutionSpace
     */
    protected List<Solution<T>> compete(int parentSurvivorSize, SolutionSpace<T> currentSolutionSpace) {
        SelectionRoulette parentSurvivorSelectionRoulette = configuration.getParentSurvivorSelectionRoulette();

        return parentSurvivorSelectionRoulette.selectOperator().selection(parentSurvivorSize, currentSolutionSpace);
    }


    /**
     *
     * @param offspringSurvivorSize
     * @param currentSolutionSpace
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws OperatorException
     */
    protected List<Solution<T>> reproduce(int offspringSurvivorSize, SolutionSpace<T> currentSolutionSpace) throws Exception {
        int childrenNumber;
        int inputSolutionNumber;
        int offspringSize;

        InterfaceVariationOperator variationOperator;
        InterfaceEvaluationFunction<T> evaluationFunction = configuration.getEvaluationFunction();

        VariationRoulette variationRoulette = configuration.getVariationRoulette();
        SelectionRoulette parentSelectionRoulette = configuration.getParentSelectionRoulette();
        SelectionRoulette offspringSurvivorSelectionRoulette = configuration.getOffspringSurvivorSelectionRoulette();

        List<Solution<T>> candidateList;
        List<Solution<T>> variationList;
        List<Solution<T>> offspringList = new ArrayList<>();

        //offspring until meet the requirement offspring size
        childrenNumber = 0;
        offspringSize = configuration.getOffspringSize();
        while (childrenNumber < offspringSize) {
            variationOperator = variationRoulette.selectOperator();

            inputSolutionNumber = variationOperator.getInputSolutionNumber();

            //solution list selected for variation
            candidateList = parentSelectionRoulette.selectOperator().selection(inputSolutionNumber, currentSolutionSpace);

            //solution list after variation, these are newly created solutions, should evaluate these functions to set the fitnees
            variationList = variationOperator.apply(candidateList);
            variationList.forEach(evaluationFunction::evaluateSolution);

            //added to the total list, gather all candidates(parents), gather all variations
            variationList.forEach(offspringList::add);
        }

        //select the offspring according to the set selection
        return offspringSurvivorSelectionRoulette.selectOperator().selection(offspringSize, new SolutionSpace<T>(offspringList));
    }


}
