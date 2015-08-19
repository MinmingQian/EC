package adeuni.group.ec.algorithm.component.evaluationfunction;

import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;
import adeuni.group.ec.algorithm.component.solution.Solution;
import adeuni.group.ec.algorithm.component.solution.SolutionSpace;

/**
 * Created by qianminming on 17/08/15.
 */
public abstract class AbstractEvaluationFunction<T extends InterfaceRepresentation> implements InterfaceEvaluationFunction<T>{
    private static final long serialVersionUID = -4146923709563162531L;

    @Override
    public void evaluateSolutionSpace(SolutionSpace<T> solutionSpace) {
        //write into line for debuggin, lambda can only be debugged this way
        solutionSpace.getSolutionList().forEach(this::evaluateSolution);
    }


    public void evaluateSolution(Solution<T> solution) {
        double fitness = evaluate(solution.getRepresentation());
        solution.setFitness(fitness);
    }
}
