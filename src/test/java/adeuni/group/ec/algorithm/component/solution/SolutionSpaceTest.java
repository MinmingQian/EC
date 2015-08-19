package adeuni.group.ec.algorithm.component.solution;

import adeuni.group.ec.algorithm.component.representation.permutation.PermutationRepresentation;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qianminming on 15/08/15.
 */
public class SolutionSpaceTest {
    SolutionSpace<PermutationRepresentation> solutionSpace;

    @Test
    public void testSize() throws Exception {
        int size = 20;
        solutionSpace = new SolutionSpace<PermutationRepresentation>(size, PermutationRepresentation.class);
        for (int i = 0; i < size; i++) {
            solutionSpace.get(i).getRepresentation().encode(101);
            System.out.println(solutionSpace.get(i).getRepresentation().getElementData().toString());
        }

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.forEach(System.out::println);
        myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);

        //test creteria pool can contain different fish
        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add((int)1);
        numbers.add((double) 1.2);
        numbers.forEach(number -> System.out.println(number));
    }


}