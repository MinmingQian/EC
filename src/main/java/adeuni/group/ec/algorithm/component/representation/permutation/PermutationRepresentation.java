package adeuni.group.ec.algorithm.component.representation.permutation;

import adeuni.group.ec.algorithm.utility.randomnumbergenerator.ECRandom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qianminming on 14/08/15.
 */
public class PermutationRepresentation extends AbstractListRepresentation<Integer> {


    private static final long serialVersionUID = 5879667907815038596L;


    public PermutationRepresentation(int length) {
        elementData = new ArrayList<>();
        encode(length);
    }

    /**
     * Construct the representation.
     *
     * @param elementData
     */
    public PermutationRepresentation(List<Integer> elementData){
        this.elementData = elementData;
    }


    public PermutationRepresentation() {
        this.elementData = new ArrayList<Integer>();
    }

    /**
     * shuffle an
     * @param length
     */
    public void encode(int length) {
        ArrayList<Integer> origin = new ArrayList<>();
        int i, j;
        for (i = 0; i < length; i++) {
            origin.add(i);
        }

        for (i = 0, j = length; j>0; i++, j--) {
            int p = (int)(ECRandom.nextDouble()*(j));
            this.elementData.add(origin.remove(p));
        }
    }

    /**
     * Get the representation in String format.
     *
     * @return String
     */
    @Override
    public String getRepresentationString() {
        String outputString = "";

        for(int i = 0; i < elementData.size();i++){
             outputString += " " + elementData.get(i).toString();
        }

        return outputString;
    }



    /**
     * Compare if two representation equals.
     *
     * @param representation
     * @return
     */
    public boolean equals(PermutationRepresentation representation) {
        return this.elementData.equals(representation.getElementData());
    }

}
