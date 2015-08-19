package adeuni.group.ec.algorithm.component.operator.variation.permutation;

import adeuni.group.ec.algorithm.component.representation.permutation.PermutationRepresentation;
import adeuni.group.ec.algorithm.component.operator.variation.AbstractMutationOperator;
import adeuni.group.ec.algorithm.component.solution.Solution;
import adeuni.group.ec.algorithm.utility.deepcopy.DeepCopy;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qianminming on 16/08/15.
 */
public abstract  class AbstractPermutationMutationOperator extends AbstractMutationOperator<PermutationRepresentation> {

    private static final long serialVersionUID = -2850597823530755467L;


    @Override
    public List<Solution<PermutationRepresentation>> solutionMutate(List<Solution<PermutationRepresentation>> selectedSolutions) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<Solution<PermutationRepresentation>> outputSolutions = new ArrayList<>(OUTPUT_SOLUTION_NUMBER);

        Solution<PermutationRepresentation> normalSolution = selectedSolutions.get(0);
        Solution<PermutationRepresentation> mutantSolution = (Solution<PermutationRepresentation>)DeepCopy.copy(normalSolution);

        //Crossover happenes inside, this is not hard copy, the result will shown out.
        genomeMutate(mutantSolution.getRepresentation());

        outputSolutions.add(mutantSolution);

        return outputSolutions;
    }

    public abstract void genomeMutate(PermutationRepresentation mutantGenome);
}
