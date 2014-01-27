package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the duration of this route (after the driver started the car
 * without any long breaks)
 */
public class RouteDurationFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.routeDurationFactor;
    }

}
