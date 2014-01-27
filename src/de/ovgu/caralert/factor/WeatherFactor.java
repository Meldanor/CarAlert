package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the current weather. Is there rain, snow or sunshine at the
 * moment?
 */
public class WeatherFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.weatherFactor;
    }

}
