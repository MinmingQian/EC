package adeuni.group.ec.algorithm.component.operator.variation;

import adeuni.group.ec.algorithm.component.operator.OperatorException;
import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;
import adeuni.group.ec.algorithm.component.solution.Solution;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by qianminming on 16/08/15.
 */
public abstract class AbstractMutationOperator<T extends InterfaceRepresentation> implements InterfaceVariationOperator<T> {

    protected static final int INPUT_SOLUTION_NUMBER = 1;
    protected static final int OUTPUT_SOLUTION_NUMBER = INPUT_SOLUTION_NUMBER;
    private static final long serialVersionUID = -8240441828905511817L;

    public List<Solution<T>> apply(List<Solution<T>> selectedSolutions) throws OperatorException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        OperatorException inputException = new OperatorException("Invalid number of mutation input solutions: " + selectedSolutions.size() +
                ". Should be: "+INPUT_SOLUTION_NUMBER+".");
        if (selectedSolutions.size() != INPUT_SOLUTION_NUMBER) {
            throw inputException;
        }

        List<Solution<T>> outputSolutions;
        outputSolutions = solutionMutate(selectedSolutions);

        OperatorException outputException = new OperatorException("Invalid number of mutation output solutions: " + outputSolutions.size() +
                ". Should be: "+OUTPUT_SOLUTION_NUMBER+".");
        if (outputSolutions.size() != OUTPUT_SOLUTION_NUMBER) {
            throw outputException;
        }

        return outputSolutions;
    }

    public abstract List<Solution<T>> solutionMutate(List<Solution<T>> selectedSolutions) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    @Override
    public int getInputSolutionNumber() {
        return INPUT_SOLUTION_NUMBER;
    }

    @Override
    public int getOutputSolutionNumber() {
        return OUTPUT_SOLUTION_NUMBER;
    }
}
