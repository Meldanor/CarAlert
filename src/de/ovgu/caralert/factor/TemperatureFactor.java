package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the temperature of the current environment. Is it cold, hot, has
 * the street frozen?
 */
public class TemperatureFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.temperatureFactor;
    }

}
