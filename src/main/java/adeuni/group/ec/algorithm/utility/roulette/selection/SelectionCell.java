package adeuni.group.ec.algorithm.utility.roulette.selection;

import adeuni.group.ec.algorithm.component.operator.selection.InterfaceSelection;
import adeuni.group.ec.algorithm.utility.roulette.AbstractRouletteCell;

/**
 * Created by qianminming on 17/08/15.
 */
public class SelectionCell extends AbstractRouletteCell<InterfaceSelection> {
    private static final long serialVersionUID = 4921944487583777646L;

    public SelectionCell(double probability, InterfaceSelection operator) {
        super(probability, operator);
    }
}
