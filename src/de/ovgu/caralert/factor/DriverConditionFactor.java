package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the condititon of the driver. Is the driver tidy, stressed,
 * aggressive, is he drunk or something else?
 * 
 */
public class DriverConditionFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.driverConditionFactor;
    }

}
