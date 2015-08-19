package adeuni.group.ec.algorithm.component.solution;

import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by qianminming on 14/08/15.
 */
public class Solution<T extends InterfaceRepresentation> {

    private static final long serialVersionUID = 6304762817303035868L;

    protected T representation;
    protected double fitness;

    public Solution(T representation) {
        this.representation = representation;
    }

    public Solution(Class<T> c) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        representation = c.getConstructor().newInstance();
    }

    /**
     * Get the representation of the solution
     *
     * @return
     */
    public T getRepresentation() {
        return this.representation;
    }

    /**
     * check if the solution equals to other.
     *
     * @param solution
     * @return
     */
    public boolean equals(Solution<T> solution) {
        return (this.representation == solution.getRepresentation());
    }

    /**
     * set the fitness of the solution
     *
     * @param fitness
     */
    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    /**
     * get the fitness of the solution
     *
     * @return
     */
    public double getFitness() {
        return this.fitness;
    }

}

