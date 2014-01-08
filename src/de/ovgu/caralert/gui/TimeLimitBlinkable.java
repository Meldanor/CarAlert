package de.ovgu.caralert.gui;

import com.jme3.scene.Spatial;

public class TimeLimitBlinkable extends Blinkable {

    private long blinkTime;
    private long lastTimestamp = 0;

    public TimeLimitBlinkable(Spatial spatial, BlinkFrequency blinkFrequency, long milliSeconds) {
        super(spatial, blinkFrequency);
        this.blinkTime = milliSeconds;
    }

    @Override
    public boolean update() {
        // Initial phase - can't do in constructor because of big difference
        // between constructor and update
        if (lastTimestamp == 0) {
            lastTimestamp = System.currentTimeMillis();
            return true;
        }
        long cur = System.currentTimeMillis();
        long diff = cur - lastTimestamp;
        lastTimestamp = cur;
        blinkTime -= diff;

        if (blinkTime <= 0)
            return false;
        else
            return super.update();
    }

}
