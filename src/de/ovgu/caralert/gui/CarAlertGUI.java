package de.ovgu.caralert.gui;

import java.util.ArrayList;
import java.util.List;

import com.jme3.font.BitmapFont;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.system.AppSettings;
import com.jme3.ui.Picture;

import de.ovgu.caralert.gui.Blinkable.BlinkFrequency;
import eu.opends.main.Simulator;

public class CarAlertGUI {

    private Node guiNode;
    private BitmapFont font;

    private static String DEFAULT_FONT = "Interface/Fonts/Default.fnt";

    private List<Tickable> tickables;

    public CarAlertGUI(Simulator simulation) {
        this.guiNode = simulation.getGuiNode();
        this.font = simulation.getAssetManager().loadFont(DEFAULT_FONT);
        if (font == null)
            System.out.println("Can't find the font");

        this.tickables = new ArrayList<Tickable>();

        createGuis(simulation);
    }

    private void createGuis(Simulator simulator) {
        addTestBlinkables(simulator);
    }

    private void addTestBlinkables(Simulator simulator) {

        AppSettings settings = simulator.getSettings();

        // Test icons to blink in diffrent frequencies
        Picture warnIcon1 = new Picture("VerySlowWarndreick");
        warnIcon1.setImage(simulator.getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
        warnIcon1.setHeight(50);
        warnIcon1.setWidth(50);
        // Position them in the middle
        warnIcon1.setPosition((settings.getWidth() / 2) - 125, settings.getHeight() - 50);
        guiNode.attachChild(warnIcon1);
        addBlinkable(warnIcon1, BlinkFrequency.VERY_SLOW);

        Picture warnIcon2 = new Picture("SlowWarndreick");
        warnIcon2.setImage(simulator.getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
        warnIcon2.setHeight(50);
        warnIcon2.setWidth(50);
        warnIcon2.setPosition((settings.getWidth() / 2) - 75, settings.getHeight() - 50);
        guiNode.attachChild(warnIcon2);
        addBlinkable(warnIcon2, BlinkFrequency.SLOW);

        Picture warnIcon3 = new Picture("Warndreick");
        warnIcon3.setImage(simulator.getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
        warnIcon3.setHeight(50);
        warnIcon3.setWidth(50);
        warnIcon3.setPosition((settings.getWidth() / 2) - 25, settings.getHeight() - 50);
        guiNode.attachChild(warnIcon3);
        addBlinkable(warnIcon3, BlinkFrequency.NORMAL);

        Picture warnIcon4 = new Picture("FastWarndreick");
        warnIcon4.setImage(simulator.getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
        warnIcon4.setHeight(50);
        warnIcon4.setWidth(50);
        warnIcon4.setPosition((settings.getWidth() / 2) + 25, settings.getHeight() - 50);
        guiNode.attachChild(warnIcon4);
        addBlinkable(warnIcon4, BlinkFrequency.FAST);

        Picture warnIcon5 = new Picture("VeryFastWarndreick");
        warnIcon5.setImage(simulator.getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
        warnIcon5.setHeight(50);
        warnIcon5.setWidth(50);
        warnIcon5.setPosition((settings.getWidth() / 2) + 75, settings.getHeight() - 50);
        guiNode.attachChild(warnIcon5);
        addBlinkable(warnIcon5, BlinkFrequency.VERY_FAST);
    }

    private void addBlinkable(Spatial spatial, BlinkFrequency frequency) {
        tickables.add(new Blinkable(spatial, frequency));
    }

    public void update() {

        for (Tickable tickable : tickables) {
            tickable.update();
        }
    }

}