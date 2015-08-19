package adeuni.group.ec.algorithm.algorithms;

import adeuni.group.ec.algorithm.component.operator.OperatorException;
import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;
import adeuni.group.ec.algorithm.component.solution.SolutionSpace;
import adeuni.group.ec.algorithm.configuration.Configuration;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by qianminming on 16/08/15.
 */
public interface InterfaceAlgorithm<T extends InterfaceRepresentation> extends Serializable {
    void init() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
    SolutionSpace<T> initSolutionSpace() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    AlgorithmResult<T> run() throws Exception;
    void execute() throws Exception;
    SolutionSpace<T> iteration(AlgorithmState<T> algorithmState) throws Exception;
    Configuration getConfiguration();
    AlgorithmState<T> getAlgorithmState();
}
