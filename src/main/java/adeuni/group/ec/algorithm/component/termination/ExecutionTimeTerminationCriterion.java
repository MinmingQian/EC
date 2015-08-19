package adeuni.group.ec.algorithm.component.termination;

import adeuni.group.ec.algorithm.algorithms.AlgorithmState;
import adeuni.group.ec.algorithm.algorithms.InterfaceAlgorithm;

/**
 * Created by qianminming on 19/08/15.
 */
public class ExecutionTimeTerminationCriterion<A extends InterfaceAlgorithm> implements InterfaceTerminationCriterion<A> {
    private static final long serialVersionUID = -2506082282312308395L;

    protected int maxExecutionTime;

    public ExecutionTimeTerminationCriterion(int maxExecutionTime) {
        this.maxExecutionTime = maxExecutionTime;
    }


    @Override
    public boolean meet(A algorithm, AlgorithmState algorithmState) {
        return algorithmState.getTotalExecutionTime() > maxExecutionTime ;
    }
}
