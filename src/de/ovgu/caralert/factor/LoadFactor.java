package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the current load of the car
 */
public class LoadFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.loadFactor;
    }

}
