package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the current environment of the car like dessert, city, highway or
 * cold regions.
 */
public class EnvironmentFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.environmentFactor;
    }

}
