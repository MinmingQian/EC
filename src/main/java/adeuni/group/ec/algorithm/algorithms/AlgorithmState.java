package adeuni.group.ec.algorithm.algorithms;

import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;
import adeuni.group.ec.algorithm.component.solution.SolutionSpace;
import adeuni.group.ec.algorithm.configuration.Configuration;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by qianminming on 16/08/15.
 */
public class AlgorithmState<T extends InterfaceRepresentation> implements Serializable {

    private static final long serialVersionUID = 6693023644273208409L;

    protected int currentIterationNumber;

    protected long lastIterationDuration;

    protected long currentTime;

    protected long totalIterationDuration;

    protected SolutionSpace<T> currentSolutionSpace;

    protected Configuration configuration;

    protected AlgorithmResult<T> algorithmResult;

    protected InterfaceAlgorithm<T> algorithm;

    protected long totalExecutionTime;


    public  AlgorithmState (InterfaceAlgorithm<T> algorithm) {
        this.algorithm = algorithm;
    }


    public void init() {
        currentIterationNumber = 0;
        lastIterationDuration = 0;
        currentTime = GregorianCalendar.getInstance().getTimeInMillis();
        totalIterationDuration = 0;
        currentSolutionSpace = null;
        configuration = algorithm.getConfiguration();
        algorithmResult = new AlgorithmResult<>();
    }


    public AlgorithmResult<T> getAlgorithmResult(){
        return algorithmResult;
    }

    public SolutionSpace<T> getCurrentSolutionSpace() {
        return currentSolutionSpace;
    }

    public void setCurrentSolutionSpace(SolutionSpace<T> currentSolutionSpace) {
        this.currentSolutionSpace = currentSolutionSpace;
    }

    public void update(SolutionSpace<T> solutionSpace) {
        long tempCurrentTime = GregorianCalendar.getInstance().getTimeInMillis();
        lastIterationDuration = tempCurrentTime - currentTime;
        currentTime = tempCurrentTime;
        totalIterationDuration += lastIterationDuration;
        currentSolutionSpace = solutionSpace;

        algorithmResult.update(this);

        currentIterationNumber ++;
    }

    public int getCurrentIterationNumber() {
        return currentIterationNumber;
    }

    public long getTotalExecutionTime() {
        return totalExecutionTime;
    }


    public void setTotalExecutionTime(long totalExecutionTime) {
        this.totalExecutionTime = totalExecutionTime;
    }
}

