package adeuni.group.ec.algorithm.component.representation.permutation;

import adeuni.group.ec.algorithm.component.representation.InterfaceElementsRepresentation;

import java.util.List;

/**
 * Created by qianminming on 14/08/15.
 * The implementation of List<T> is done by extends AbstractLit
 *
 */
public abstract class AbstractListRepresentation<T>   implements InterfaceElementsRepresentation<T> {

    private static final long serialVersionUID = 5832553610500243886L;

    /**
     * genome of list type representation
     */
    protected List<T> elementData;


    /**
     * Get the size of the representation
     *
     * @return size
     */
    @Override
    public int size() {
        return elementData.size();
    }

    /**
     * Add element e to the representation end
     *
     * @param e
     */
    @Override
    public void add(T e) {
        elementData.add(e);
    }

    /**
     * Add element e to the representation at position index
     *
     * @param index
     * @param e
     */
    @Override
    public void add(int index, T e) {
        elementData.add(index, e);
    }

    /**
     * Remove the element at position index
     *
     * @param index
     * @return removed element
     */
    @Override
    public T remove(int index) {
        return elementData.remove(index);
    }

    /**
     * Remove the element e in the representation
     *
     * @param e
     * @return remove status
     */
    @Override
    public boolean remove(T e) {
        return elementData.remove(e);
    }

    /**
     * Set the element of specific position in the representation
     *
     * @param index
     * @param e
     * @return the old value
     */
    @Override
    public T set(int index, T e) {
        return elementData.set(index, e);
    }

    /**
     * Get the element of specific position
     *
     * @param index
     * @return the value
     */
    @Override
    public T get(int index) {
        return elementData.get(index);
    }

    /**
     * Trun the list to array.
     *
     * @return array of the list
     */
    @Override
    public Object[] toArray() {
        return elementData.toArray();
    }

    /**
     * Return the list of elementData
     *
     * @return the list
     */
    @Override
    public List<T> getElementData() {
        return elementData;
    }

    /**
     * Check if contains the element
     * @param e
     * @return
     */
    @Override
    public boolean contains(T e) {
        return elementData.contains(e);
    }
}
