package adeuni.group.ec.algorithm.component.solution;

import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;
import adeuni.group.ec.algorithm.component.solution.comparator.SolutionFitnessComparator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by qianminming on 15/08/15.
 * TODO: to findout why here need the comparator, and what is the comparator
 */
public class SolutionSpace<T extends InterfaceRepresentation> {

    List<Solution<T>> solutionList;

    /** The comparator. */
    protected Comparator<? super Solution<T>> comparator;

    /**
     * Create an empty solution space, for new generation use.
     */
    public SolutionSpace () {
        solutionList= new ArrayList<>();
        comparator = new SolutionFitnessComparator();
    }

    public SolutionSpace (List<Solution<T>> solutionList) {
        this.solutionList = solutionList;
        comparator = new SolutionFitnessComparator();
    }

    /**
     * Construct the solution space
     * @param size
     */
    public SolutionSpace (int size, Class<T> c) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        solutionList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            T presentation = c.getConstructor().newInstance();
            solutionList.add(new Solution<T>((T)presentation));
        }
        comparator = new SolutionFitnessComparator();
    }


    
    public int size() {
        return solutionList.size();
    }

    //Is there the need to avoid the same, recent discussion result, there is no need to avoid. or we can add options later

    /**
     * Need deep copy, use the add function, should not just pass the reference.
     * @param solutionSection
     */
    public void add(List<Solution<T>> solutionSection) {
        solutionSection.forEach(solutionList::add);
    }

    public Solution<T> remove(int index) {
        return solutionList.remove(index);
    }

    public void remove(Solution solution) {
        solutionList.remove(solution);
    }

    public void remove(List<Solution<T>> solutionSection) {
        solutionSection.forEach(solutionList::remove);
    }

    public void removeAll() {
        solutionList.clear();
    }

    public void sort() {
        Collections.sort(solutionList, comparator);
    }

    public void set(int index, Solution solution) {
        solutionList.set(index, solution);
    }


    public void add(int index, Solution solution) {
        solutionList.add(index, solution);
    }

    public void add(Solution solution) {
        solutionList.add(solution);
    }

    public Solution<T> get(int index) {
        return solutionList.get(index);
    }

    public List<Solution<T>> getSolutionList() {
        return solutionList;
    }

    public List<Solution<T>> getHighestSubList(int subListSize) {
        List<Solution<T>> subList = new ArrayList<>();

        this.sort();
        solutionList.subList(size()-subListSize,size()).forEach(subList::add);

        return subList;
    }

    public List<Solution<T>> getLowestSubList(int subListSize) {
        List<Solution<T>> subList = new ArrayList<>();

        this.sort();
        solutionList.subList(0,subListSize).forEach(subList::add);

        return subList;
    }
}
