package adeuni.group.ec.algorithm.toolset.roulette;

import adeuni.group.ec.algorithm.component.operator.InterfaceOperator;
import adeuni.group.ec.algorithm.toolset.randomnumbergenerator.ECRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoublePredicate;

/**
 * Created by qianminming on 17/08/15.
 */
public abstract class AbstractRoulette<T extends InterfaceOperator> implements InterfaceRoulette {
    List<AbstractRouletteCell<T>> cellList;

    protected double totalProbability;



    public  AbstractRoulette() {
        cellList = new ArrayList<>();
    }

    public T selectOperator() {
        double random = ECRandom.nextDouble();
        for (AbstractRouletteCell<T> cell: cellList) {
            random -= cell.getProbability();
            if (random < 0 ) {
                return cell.getOperator();
            }
        }

        return null;
    }

    public void addCell(AbstractRouletteCell<T> cell) throws RouletteException {
        totalProbability += cell.getProbability();
        checkProbability();
        cellList.add(cell);
    }

    public void checkProbability() throws RouletteException {
        if (totalProbability > 1) throw new RouletteException("The total probability is bigger than one, current is: "+totalProbability);
    }
}
