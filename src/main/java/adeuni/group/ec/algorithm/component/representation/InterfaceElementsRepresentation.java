package adeuni.group.ec.algorithm.component.representation;

import java.util.List;

/**
 * Created by qianminming on 14/08/15.
 */
public interface InterfaceElementsRepresentation<T> extends InterfaceRepresentation {

    /**
     * Get the size of the representation
     *
     * @return size
     */
    int size();


    /**
     * Add element e to the representation end
     *
     * @param e
     */
    void add(T e);

    /**
     * Add element e to the representation at position index
     *
     * @param index
     * @param e
     */
    void add(int index, T e);


    /**
     * Remove the element at position index
     *
     * @param index
     * @return removed element
     */
    T remove(int index);

    /**
     * Remove the element e in the representation
     * @param e
     * @return remove status
     */
    boolean remove(T e);

    /**
     * Set the element of specific position in the representation
     *
     * @param index
     * @param e
     * @return the old value
     */
    T set(int index, T e);

    /**
     * Get the element of specific position
     * @param index
     * @return the value
     */
    T get(int index);

    /**
     * Trun the list to array.
     * @return array of the list
     */
    Object[] toArray();

    /**
     * Return the list of elementData
     * @return the list
     */
    List<T> getElementData();
}
