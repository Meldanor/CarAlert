package de.ovgu.caralert.gui;

import com.jme3.scene.Spatial;

public class LimitedBlinkable extends Blinkable {

    private int blinkLimit;
    private int blinkCounter = 0;

    private boolean vanished = false;

    public LimitedBlinkable(Spatial spatial, BlinkFrequency frequency, int blinkLimit) {
        super(spatial, frequency);
        this.blinkLimit = blinkLimit * 2; // One blink = 2 changes!
    }

    @Override
    public boolean update(long diff) {
        super.update(diff);
        return !vanished;
    }

    @Override
    protected void swapViewable() {
        // blink
        super.swapViewable();

        if (++blinkCounter == blinkLimit) {
            // fade out
            vanished = true;
        }
    }

}
