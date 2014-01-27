package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents how many other cars are there at the moment.
 */
public class TrafficIntensityFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.trafficIntensityFactor;
    }

}
