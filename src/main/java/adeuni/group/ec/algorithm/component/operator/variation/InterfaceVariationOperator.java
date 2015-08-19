package adeuni.group.ec.algorithm.component.operator.variation;

import adeuni.group.ec.algorithm.component.operator.InterfaceOperator;
import adeuni.group.ec.algorithm.component.operator.OperatorException;
import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;
import adeuni.group.ec.algorithm.component.solution.Solution;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by qianminming on 14/08/15.
 */
public interface InterfaceVariationOperator<T extends InterfaceRepresentation> extends InterfaceOperator {
    List<Solution<T>> apply(List<Solution<T>> selectedSolutions) throws OperatorException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, Exception;
    int getInputSolutionNumber();
    int getOutputSolutionNumber();
}
