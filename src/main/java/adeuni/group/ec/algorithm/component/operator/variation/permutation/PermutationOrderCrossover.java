package adeuni.group.ec.algorithm.component.operator.variation.permutation;

import adeuni.group.ec.algorithm.component.representation.permutation.PermutationRepresentation;

/**
 * Created by Joe on 19/08/15.
 */
public class PermutationOrderCrossover extends AbstractPermutationCrossoverOperator{
    private static final long serialVersionUID = -570352923107058006L;

    @Override
    public void genomeCrossover(PermutationRepresentation fatherGenome, PermutationRepresentation motherGenome, PermutationRepresentation childGenome1, PermutationRepresentation childGenome2) {
        executeCrossover(fatherGenome, motherGenome, childGenome1);
        executeCrossover(fatherGenome, motherGenome, childGenome2);
    }

    public void executeCrossover(PermutationRepresentation fatherGenome,PermutationRepresentation motherGenome,PermutationRepresentation childGenome1){

        for (int i = 0; i < fatherGenome.size(); i++) {
           childGenome1.add(null);
        }

        // Get start and end sub tour positions for parent1's tour
        int startPos = (int) (Math.random() * fatherGenome.size());
        int endPos = startPos;
        while (endPos == startPos) {
            endPos = (int) (Math.random() * fatherGenome.size());
        }

        int posStart = startPos<endPos?startPos:endPos;
        int posEnd = startPos>endPos?startPos:endPos;


        for (int i = posStart; i <= posEnd; i++) {
            childGenome1.set(i,fatherGenome.get(i));
        }

        int addPosition = (posEnd+1)%motherGenome.size();

        // Loop through parent2's city tour
        for (int i = (posEnd+1)%motherGenome.size(); i < posEnd+1+motherGenome.size();i++)
        {
            // If child doesn't have the city add it
            if (!childGenome1.getElementData().contains(motherGenome.get(i%motherGenome.size())))
            {
                // Loop to find a spare position in the child's tour
                childGenome1.set(addPosition,motherGenome.get(i%motherGenome.size()));
                addPosition = (addPosition+1)%motherGenome.size();
            }
        }
    }
}
