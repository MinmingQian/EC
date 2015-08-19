package adeuni.group.ec.algorithm.configuration;

import adeuni.group.ec.algorithm.algorithms.InterfaceAlgorithm;
import adeuni.group.ec.algorithm.component.evaluationfunction.InterfaceEvaluationFunction;
import adeuni.group.ec.algorithm.component.operator.selection.InterfaceSelection;
import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;
import adeuni.group.ec.algorithm.component.termination.InterfaceTerminationCriterion;
import adeuni.group.ec.algorithm.component.termination.TerminationCriteriaPool;
import adeuni.group.ec.algorithm.toolset.factory.RepresentationFactory;
import adeuni.group.ec.algorithm.toolset.roulette.operator.VariationRoulette;
import adeuni.group.ec.algorithm.toolset.roulette.selection.SelectionRoulette;

import java.io.Serializable;

/**
 * Created by qianminming on 14/08/15.
 */
public class Configuration<T extends InterfaceRepresentation> implements Serializable{
    private static final long serialVersionUID = -3352131548638992704L;

    protected TerminationCriteriaPool<? extends InterfaceAlgorithm> terminationCriteriaPool;
    protected InterfaceEvaluationFunction<T> evaluationFunction;
    private VariationRoulette variationRoulette;
    private SelectionRoulette parentSelectionRoulette;
    private boolean replaceCandidate;
    private int offspringSize;
    private int eliteSize;
    private int parentSurvivorSize;
    private int offspringSurvivorSize;
    private SelectionRoulette parentSurvivorSelectionRoulette;
    private SelectionRoulette offspringSurvivorSelectionRoulette;
    private RepresentationFactory<T> representationFactory;
    private int solutionSpaceSize;


    public  TerminationCriteriaPool getTerminationCriteriaPool() {
        return terminationCriteriaPool;
    }

    public void setTerminationCriteriaPool(TerminationCriteriaPool<? extends InterfaceAlgorithm> terminationCriteriaPool) {
        this.terminationCriteriaPool = terminationCriteriaPool;
    }

    public  InterfaceEvaluationFunction<T> getEvaluationFunction() {
        return evaluationFunction;
    }

    public void setEvaluationFunction(InterfaceEvaluationFunction<T> evaluationFunction) {
        this.evaluationFunction = evaluationFunction;
    }

    public VariationRoulette getVariationRoulette() {
        return variationRoulette;
    }

    public void setVariationRoulette(VariationRoulette variationRoulette) {
        this.variationRoulette = variationRoulette;
    }


    public SelectionRoulette getParentSelectionRoulette() {
        return parentSelectionRoulette;
    }

    public void setParentSelectionRoulette(SelectionRoulette parentSelectionRoulette) {
        this.parentSelectionRoulette = parentSelectionRoulette;
    }


    public boolean isReplaceCandidate() {
        return this.replaceCandidate;
    }

    public void setReplaceCandidate(boolean replaceCandidate) {
        this.replaceCandidate = replaceCandidate;
    }

    public int getOffspringSize() {
        return offspringSize;
    }

    public void setOffspringSize(int offspringSize) {
        this.offspringSize = offspringSize;
    }

    public int getEliteSize() {
        return eliteSize;
    }

    public void setEliteSize(int eliteSize) {
        this.eliteSize = eliteSize;
    }

    public int getParentSurvivorSize() {
        return parentSurvivorSize;
    }

    public void setParentSurvivorSize(int parentSurvivorSize) {
        this.parentSurvivorSize = parentSurvivorSize;
    }

    public int getOffspringSurvivorSize() {
        return offspringSurvivorSize;
    }

    public void setOffspringSurvivorSize(int offspringSurvivorSize) {
        this.offspringSurvivorSize = offspringSurvivorSize;
    }

    public SelectionRoulette getParentSurvivorSelectionRoulette() {
        return parentSurvivorSelectionRoulette;
    }

    public void setParentSurvivorSelectionRoulette(SelectionRoulette parentSurvivorSelectionRoulette) {
        this.parentSurvivorSelectionRoulette = parentSurvivorSelectionRoulette;
    }

    public SelectionRoulette getOffspringSurvivorSelectionRoulette() {
        return offspringSurvivorSelectionRoulette;
    }

    public void setOffspringSurvivorSelectionRoulette(SelectionRoulette offspringSurvivorSelectionRoulette) {
        this.offspringSurvivorSelectionRoulette = offspringSurvivorSelectionRoulette;
    }


    public RepresentationFactory<T> getRepresentationFactory() {
        return representationFactory;
    }

    public void setRepresentationFactory(RepresentationFactory<T> representationFactory) {
        this.representationFactory = representationFactory;
    }

    public int getSolutionSpaceSize() {
        return solutionSpaceSize;
    }

    public void setSolutionSpaceSize(int solutionSpaceSize) {
        this.solutionSpaceSize = solutionSpaceSize;
    }
}

