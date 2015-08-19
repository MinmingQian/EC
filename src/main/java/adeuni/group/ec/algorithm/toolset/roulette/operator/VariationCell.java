package adeuni.group.ec.algorithm.toolset.roulette.operator;

import adeuni.group.ec.algorithm.component.operator.variation.InterfaceVariationOperator;
import adeuni.group.ec.algorithm.toolset.roulette.AbstractRouletteCell;

/**
 * Created by qianminming on 16/08/15.
 */
public  class VariationCell extends AbstractRouletteCell<InterfaceVariationOperator> {
    private static final long serialVersionUID = -9223263064070520158L;

    public VariationCell(double probability, InterfaceVariationOperator operator) {
        super(probability, operator);
    }
}
