package de.ovgu.caralert.gui;

import com.jme3.scene.Spatial;

public class TimeLimitBlinkable extends Blinkable {

    private long blinkTime;

    public TimeLimitBlinkable(Spatial spatial, BlinkFrequency blinkFrequency, long milliSeconds) {
        super(spatial, blinkFrequency);
        this.blinkTime = milliSeconds;
    }

    @Override
    public boolean update(long diff) {

        blinkTime -= diff;
        if (blinkTime <= 0)
            return false;
        else
            return super.update(diff);
    }

}
