package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the passanger in the car. How many and what passangers are they
 * (kids, the wife, a drunken friend)?
 */
public class PassangerFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.passangerFactor;
    }

}
