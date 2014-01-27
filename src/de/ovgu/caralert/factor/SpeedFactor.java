package de.ovgu.caralert.factor;

import eu.opends.main.Simulator;

/**
 * Represents the current speed of the car without any reflection about is this
 * ok or not. See for this questions the {@link SignFactor}
 */
public class SpeedFactor extends Factor {

    @Override
    public int getWeight() {
        float speed = Simulator.getCarAlertCore().getSimulator().getCar().getCurrentSpeedKmh();
        if (speed < 30)
            return 0;
        else if (speed < 100)
            return 1;
        else if (speed > 100)
            return 3;
        else
            return 0;
    }

}
