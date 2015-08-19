package adeuni.group.ec.algorithm.component.solution;

import adeuni.group.ec.algorithm.component.representation.permutation.PermutationRepresentation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by qianminming on 15/08/15.
 */
public class SolutionTest {
    Solution<PermutationRepresentation> solution;

    @Before
    public void setUp() throws Exception {
        System.out.println("Seting up");
        PermutationRepresentation permutationRepresentation = new PermutationRepresentation();
        permutationRepresentation.encode(50);
        solution = new Solution(permutationRepresentation);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing down");
        solution = null;
    }

    @Test
    public void testGetRepresentation() throws Exception {
        System.out.println(solution.getRepresentation().getElementData());
    }

    @Test
    public void testEquals() throws Exception {
        Assert.assertTrue(solution.equals(solution));
    }

    @Test
    public void testSetFitness() throws Exception {
        solution.setFitness(100.000);
        Assert.assertTrue(solution.getFitness() == 100.00);
    }

    @Test
    public void testGetFitness() throws Exception {
        solution.setFitness(100.000);
        Assert.assertTrue("true", solution.getFitness() == 100.00);
    }
}