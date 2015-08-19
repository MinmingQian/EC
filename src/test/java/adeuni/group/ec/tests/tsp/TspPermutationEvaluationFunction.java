package adeuni.group.ec.tests.tsp;

import adeuni.group.ec.algorithm.component.evaluationfunction.AbstractEvaluationFunction;
import adeuni.group.ec.algorithm.component.representation.permutation.PermutationRepresentation;

/**
 * Created by qianminming on 17/08/15.
 */
public class TspPermutationEvaluationFunction extends AbstractEvaluationFunction<PermutationRepresentation> {

    private static final long serialVersionUID = -628201028586531963L;

    TspProblem tspProblemInstance;

    public TspPermutationEvaluationFunction () {

    }

    @Override
    public double evaluate(PermutationRepresentation representation) {
        return 200;
    }
}
