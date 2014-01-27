package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the current day time. Is it night, when the driver is in avarage
 * asleep and tidy?
 */
public class TimeFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.timeFactor;
    }

}
