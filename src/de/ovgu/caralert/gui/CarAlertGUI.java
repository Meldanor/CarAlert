package de.ovgu.caralert.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.jme3.font.BitmapFont;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import eu.opends.main.Simulator;

public class CarAlertGUI {

    private Node guiNode;
    private BitmapFont font;

    private static String DEFAULT_FONT = "Interface/Fonts/Default.fnt";

    private List<GUITickable> tickables;

    public CarAlertGUI(Simulator simulation) {

        this.guiNode = simulation.getGuiNode();
        this.font = simulation.getAssetManager().loadFont(DEFAULT_FONT);
        if (font == null)
            System.out.println("Can't find the font");

        this.tickables = Collections.synchronizedList(new ArrayList<GUITickable>());

        createGuis(simulation);
    }

    private void createGuis(Simulator simulator) {
//        addTestBlinkables(simulator);
//        addTestLimitedBlinkables(simulator);
//        addTestTimeLimitedBlinkables(simulator);
    }

//    private void addTestBlinkables(Simulator simulator) {
//
//        AppSettings settings = simulator.getSettings();
//
//        // Test icons to blink in diffrent frequencies
//        Picture warnIcon1 = new Picture("VerySlowWarndreick");
//        warnIcon1.setImage(simulator.getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
//        warnIcon1.setHeight(50);
//        warnIcon1.setWidth(50);
//        // Position them in the middle
//        warnIcon1.setPosition((settings.getWidth() / 2) - 125, settings.getHeight() - 50);
//        guiNode.attachChild(warnIcon1);
//        addBlinkable(warnIcon1, BlinkFrequency.VERY_SLOW);
//
//        Picture warnIcon2 = new Picture("SlowWarndreick");
//        warnIcon2.setImage(simulator.getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
//        warnIcon2.setHeight(50);
//        warnIcon2.setWidth(50);
//        warnIcon2.setPosition((settings.getWidth() / 2) - 75, settings.getHeight() - 50);
//        guiNode.attachChild(warnIcon2);
//        addBlinkable(warnIcon2, BlinkFrequency.SLOW);
//
//        Picture warnIcon3 = new Picture("Warndreick");
//        warnIcon3.setImage(simulator.getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
//        warnIcon3.setHeight(50);
//        warnIcon3.setWidth(50);
//        warnIcon3.setPosition((settings.getWidth() / 2) - 25, settings.getHeight() - 50);
//        guiNode.attachChild(warnIcon3);
//        addBlinkable(warnIcon3, BlinkFrequency.NORMAL);
//
//        Picture warnIcon4 = new Picture("FastWarndreick");
//        warnIcon4.setImage(simulator.getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
//        warnIcon4.setHeight(50);
//        warnIcon4.setWidth(50);
//        warnIcon4.setPosition((settings.getWidth() / 2) + 25, settings.getHeight() - 50);
//        guiNode.attachChild(warnIcon4);
//        addBlinkable(warnIcon4, BlinkFrequency.FAST);
//
//        Picture warnIcon5 = new Picture("VeryFastWarndreick");
//        warnIcon5.setImage(simulator.getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
//        warnIcon5.setHeight(50);
//        warnIcon5.setWidth(50);
//        warnIcon5.setPosition((settings.getWidth() / 2) + 75, settings.getHeight() - 50);
//        guiNode.attachChild(warnIcon5);
//        addBlinkable(warnIcon5, BlinkFrequency.VERY_FAST);
//    }
//
//    private void addTestLimitedBlinkables(Simulator simulator) {
//        AppSettings settings = simulator.getSettings();
//
//        Picture warnIcon = new Picture("VeryFastWarndreick");
//        warnIcon.setImage(simulator.getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
//        warnIcon.setHeight(50);
//        warnIcon.setWidth(50);
//        warnIcon.setPosition((settings.getWidth() / 2) - 25, settings.getHeight() - 110);
//        guiNode.attachChild(warnIcon);
//        tickables.add(new LimitedBlinkable(warnIcon, BlinkFrequency.NORMAL, 5));
//    }
//
//    private void addTestTimeLimitedBlinkables(Simulator simulator) {
//        AppSettings settings = simulator.getSettings();
//
//        Picture warnIcon = new Picture("VeryFastWarndreick");
//        warnIcon.setImage(simulator.getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
//        warnIcon.setHeight(50);
//        warnIcon.setWidth(50);
//        warnIcon.setPosition((settings.getWidth() / 2) - 25, settings.getHeight() - 170);
//        guiNode.attachChild(warnIcon);
//        tickables.add(new TimeLimitBlinkable(warnIcon, BlinkFrequency.NORMAL, 10000L));
//    }

//    private void addBlinkable(Spatial spatial, BlinkFrequency frequency) {
//        tickables.add(new Blinkable(spatial, frequency));
//    }

    private long lastTimestamp = 0;

    public void update() {
        // Initial round
        if (lastTimestamp == 0) {
            lastTimestamp = System.currentTimeMillis();
            return;
        }

        long cur = System.currentTimeMillis();
        long diff = cur - lastTimestamp;
        lastTimestamp = cur;

        synchronized (tickables) {
            // Update all tickables
            Iterator<GUITickable> iter = tickables.iterator();

            while (iter.hasNext()) {
                GUITickable tickable = iter.next();
                // Tickable is outdated or error happend
                if (!tickable.update(diff)) {
                    // remove from gui and tick list
                    iter.remove();
                    guiNode.detachChild(tickable.getSpatial());
                }
            }
        }

    }

    public void add(GUITickable tickable) {
        this.guiNode.attachChild(tickable.getSpatial());
        this.tickables.add(tickable);
    }

    public void add(Spatial spatial) {
        this.guiNode.attachChild(spatial);
    }

    public BitmapFont getFont() {
        return font;
    }

}