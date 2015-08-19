package adeuni.group.ec.algorithm.algorithms;

import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;

import java.io.Serializable;

/**
 * Created by qianminming on 16/08/15.
 * result is the latest state,
 */
public class AlgorithmResult<T extends InterfaceRepresentation> implements Serializable {
    AlgorithmAnalysis<T> algorithmAnalysis;


    /**
     * The algorithm analysis instance was created here, all others are an copy of it.
     */
    public AlgorithmResult() {
        this.algorithmAnalysis = new AlgorithmAnalysis<>();
    }

    AlgorithmAnalysis<T> getAlgorithmAnalysis() {
        return  this.algorithmAnalysis;
    }

    public void update(AlgorithmState<T> algorithmState) {
        this.algorithmAnalysis.analyseAndStore(algorithmState);
    }
}
