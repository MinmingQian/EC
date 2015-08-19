package adeuni.group.ec.algorithm.toolset.factory;

import adeuni.group.ec.algorithm.component.representation.InterfaceRepresentation;
import adeuni.group.ec.algorithm.component.representation.permutation.PermutationRepresentation;

import java.util.ArrayList;

/**
 * Created by qianminming on 18/08/15.
 */
public class RepresentationFactory<T extends InterfaceRepresentation> {
    final Class<T> t;
    protected ArrayList<Number> inputList = new ArrayList<>();



    public RepresentationFactory(Class<T> t, Number... inputNumbers) {
        this.t = t;
        for (int i = 0; i < inputNumbers.length; i++) {
            inputList.add(i, inputNumbers[i]);
        }
    }


    public InterfaceRepresentation createRepresentation() {
        if (t == PermutationRepresentation.class) {
            return new PermutationRepresentation((int)inputList.get(0));
        }

        return null;
    }
}
