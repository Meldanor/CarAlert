package de.ovgu.caralert.factor;

import de.ovgu.caralert.gui.FactorSelectController;

/**
 * Represents the drivers knowlegde about the current place. Is this a daily
 * route or was the driver never at this location?
 */
public class PlaceKnowledgeFactor extends Factor {

    @Override
    public int getWeight() {
        return FactorSelectController.placeKnowledgeFactor;
    }

}
