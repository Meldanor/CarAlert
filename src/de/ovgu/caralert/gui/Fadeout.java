package de.ovgu.caralert.gui;

import com.jme3.scene.Spatial;

public class Fadeout implements GUITickable {

    private long visibleTime;

    private Spatial spatial;

    public Fadeout(Spatial spatial, long visibleTime) {
        this.visibleTime = visibleTime;
    }

    @Override
    public Spatial getSpatial() {
        return spatial;
    }

    @Override
    public boolean update(long diff) {

        visibleTime -= diff;
        return visibleTime > 0;
    }

}
