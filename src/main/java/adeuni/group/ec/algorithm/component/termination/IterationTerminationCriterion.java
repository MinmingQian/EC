package adeuni.group.ec.algorithm.component.termination;

import adeuni.group.ec.algorithm.algorithms.AlgorithmState;
import adeuni.group.ec.algorithm.algorithms.InterfaceAlgorithm;

/**
 * Created by qianminming on 16/08/15.
 */
public class IterationTerminationCriterion<A extends InterfaceAlgorithm> implements InterfaceTerminationCriterion<A> {
    protected int maxIterationRound;

    public IterationTerminationCriterion(int maxIterationRound) {
        this.maxIterationRound = maxIterationRound;
    }

    @Override
    public boolean meet(A algorithm, AlgorithmState algorithmState) {
        return algorithmState.getCurrentIterationNumber() > maxIterationRound + 1;
    }
}
