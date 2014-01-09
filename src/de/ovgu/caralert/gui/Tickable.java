package de.ovgu.caralert.gui;

import com.jme3.scene.Spatial;

public interface Tickable {

    public boolean update(long diff);
    
    public Spatial getSpatial();
}
