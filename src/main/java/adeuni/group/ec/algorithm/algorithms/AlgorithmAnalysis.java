package adeuni.group.ec.algorithm.algorithms;

import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;

/**
 * Created by qianminming on 16/08/15.
 */
public class AlgorithmAnalysis<T extends InterfaceRepresentation> {

    public void analyseAndStore(AlgorithmState<T> algorithmState) {
        System.out.println("iteration"+algorithmState.getCurrentIterationNumber());
    }
}
