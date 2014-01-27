package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the current state of the car. Is the car or some modules of it
 * damaged or are there any defects?
 */
public class CarStateFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.carStateFactor;
    }

}
