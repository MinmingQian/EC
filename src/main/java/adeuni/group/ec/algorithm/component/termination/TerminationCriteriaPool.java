package adeuni.group.ec.algorithm.component.termination;

import adeuni.group.ec.algorithm.algorithms.AlgorithmState;
import adeuni.group.ec.algorithm.algorithms.InterfaceAlgorithm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qianminming on 16/08/15.
 */
public class TerminationCriteriaPool<A extends InterfaceAlgorithm> implements Serializable{
    List<InterfaceTerminationCriterion> elementCriterion;

    public TerminationCriteriaPool() {
        elementCriterion = new ArrayList<>();
    }

    public void add(InterfaceTerminationCriterion criterion) {
        elementCriterion.add(criterion);
    }

    public boolean meetAnyone(A algorithm, AlgorithmState algorithmState) {
        for (InterfaceTerminationCriterion criterion: elementCriterion) {
            if (criterion.meet(algorithm, algorithmState)) {
                return true;
            }
        }

        return false;
    }
}
