package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the class (SUV, truck, personal car, motorbike) of the car
 */
public class CarClassFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.carClassFactor;
    }

}
