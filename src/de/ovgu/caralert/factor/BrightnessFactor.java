package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the current brightness of the place around the car
 */
public class BrightnessFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.brightnessFactor;
    }

}
