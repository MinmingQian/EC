package adeuni.group.ec.algorithm.component.operator.variation.permutation;

import adeuni.group.ec.algorithm.component.representation.permutation.PermutationRepresentation;

/**
 * Created by Joe on 19/08/15.
 */
public class PermutationSwapMutation extends AbstractPermutationMutationOperator{
    @Override
    public void genomeMutate(PermutationRepresentation mutantGenome) {
        int genomePos1 = (int)(mutantGenome.size()*Math.random());
        int genomePos2 = (int)(mutantGenome.size()*Math.random());

        while(genomePos1==genomePos2){
            genomePos2 = (int)(mutantGenome.size()*Math.random());
        }

        int firstAllel = mutantGenome.get(genomePos1);
        int secondAllel = mutantGenome.get(genomePos2);

        mutantGenome.set(genomePos1,secondAllel);
        mutantGenome.set(genomePos2,firstAllel);
    }
}
