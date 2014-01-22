package de.ovgu.caralert.gui;

import com.jme3.scene.Spatial;
import com.jme3.scene.Spatial.CullHint;

public class Blinkable implements GUITickable {

    public enum BlinkFrequency {
        //@formatter:off
        VERY_SLOW(90),
        SLOW(75),
        NORMAL(50),
        FAST(25),
        VERY_FAST(10);
        //@formatter:on

        private int frequency;

        private BlinkFrequency(int frequency) {
            this.frequency = frequency;
        }

        private int getFrequency() {
            return frequency;
        }
    }

    private BlinkFrequency frequency;
    private Spatial spatial;
    private int counter = 0;

    public Blinkable(Spatial spatial, BlinkFrequency blinkFrequency) {
        this.frequency = blinkFrequency;
        this.spatial = spatial;
        spatial.setCullHint(CullHint.Never);
    }

    @Override
    public boolean update(long diff) {
        if (++counter == frequency.getFrequency()) {
            swapViewable();
            counter = 0;
        }
        return true;
    }

    protected void swapViewable() {
        if (spatial.getCullHint().equals(CullHint.Never)) {
            spatial.setCullHint(CullHint.Always);
        } else {
            spatial.setCullHint(CullHint.Never);
        }
    }

    @Override
    public Spatial getSpatial() {
        return spatial;
    }

}
