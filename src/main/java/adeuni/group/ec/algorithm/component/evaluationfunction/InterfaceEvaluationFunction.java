package adeuni.group.ec.algorithm.component.evaluationfunction;

import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;
import adeuni.group.ec.algorithm.component.solution.Solution;
import adeuni.group.ec.algorithm.component.solution.SolutionSpace;

import java.io.Serializable;

/**
 * Created by qianminming on 17/08/15.
 */
public interface InterfaceEvaluationFunction<T extends InterfaceRepresentation> extends Serializable {
    void evaluateSolutionSpace(SolutionSpace<T> solutionSpace);
    void evaluateSolution(Solution<T> solution);
    double evaluate(T representation);

}
