package adeuni.group.ec.algorithm.toolset.roulette;

import adeuni.group.ec.algorithm.component.operator.InterfaceOperator;

/**
 * Created by qianminming on 17/08/15.
 */
public abstract class AbstractRouletteCell<T extends InterfaceOperator> implements InterfaceRouletteCell{
    protected double probability;
    protected T operator;

    public AbstractRouletteCell(double probability, T operator) {
        this.probability = probability;
        this.operator = operator;
    }

    public  void setProbability(double probability) {
        this.probability = probability;
    }

    public double getProbability() {
        return probability;
    }


    public T getOperator() {
        return operator;
    }

    public void setOperator(T operator) {
        this.operator = operator;
    }
}
