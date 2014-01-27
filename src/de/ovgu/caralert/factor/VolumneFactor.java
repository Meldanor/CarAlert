package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the current volumne of the enviroment.
 */
public class VolumneFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.volumneFactor;
    }

}
