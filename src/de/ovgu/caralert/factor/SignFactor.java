package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the current street law and whether the driver follows them. Is he
 * driving to fast(55 km/h in a 50 km/h zone?)
 */
public class SignFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.signFactor;
    }

}
