package adeuni.group.ec.algorithm.algorithms;

import adeuni.group.ec.algorithm.component.operator.OperatorException;
import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;
import adeuni.group.ec.algorithm.component.solution.SolutionSpace;
import adeuni.group.ec.algorithm.component.termination.TerminationCriteriaPool;
import adeuni.group.ec.algorithm.configuration.Configuration;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by qianminming on 16/08/15.
 */
public abstract class AbstractAlgorithm<T extends InterfaceRepresentation> implements InterfaceAlgorithm {
    private static final long serialVersionUID = -8302088516872563474L;

    protected  Configuration configuration;
    protected  AlgorithmState algorithmState;

    public  AbstractAlgorithm (Configuration configuration) {
        this.configuration = configuration;
        algorithmState = new AlgorithmState(this);
    }


    public AlgorithmResult<T> run() throws Exception {
        init();

        execute();

        return algorithmState.getAlgorithmResult();
    }


    public void init() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //init at the very beginning of the evalutionary update
        //here also init the algorithm result
        algorithmState.init();

        //the initSolutionSpace will implemented by
        SolutionSpace<T> initialSolutionSpace = initSolutionSpace();

        //set up the algorithm state,
        algorithmState.update(initialSolutionSpace);
    }



    public void execute() throws Exception {
        TerminationCriteriaPool terminationCriteriaPool = configuration.getTerminationCriteriaPool();

        while (!terminationCriteriaPool.meetAnyone(this,algorithmState)) {
            SolutionSpace<T> newSolutionSpace = iteration(algorithmState);
            algorithmState.update(newSolutionSpace);
        }
    }


    public Configuration getConfiguration() {
        return configuration;
    }


    public AlgorithmState getAlgorithmState() {
        return algorithmState;
    }
}
