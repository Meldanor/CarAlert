package de.ovgu.caralert.gui;

import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial.CullHint;

import eu.opends.main.Simulator;

public class CarAlertGUI {

	private Node guiNode;
	private BitmapFont font;
	private BitmapText test;

	private static String DEFAULT_FONT = "Interface/Fonts/Default.fnt";

	public CarAlertGUI(Simulator simulation) {
		this.guiNode = simulation.getGuiNode();
		this.font = simulation.getAssetManager().loadFont(DEFAULT_FONT);

		createGuis();
	}

	private void createGuis() {

		test = new BitmapText(font, false);
		test.setText("Testaaaa");
		test.setName("test");
		test.setCullHint(CullHint.Never); // Always
		test.setSize(font.getCharSet().getRenderedSize());
		test.setColor(ColorRGBA.Red);
		guiNode.attachChild(test);

		test.setLocalTranslation(0, 40, 0);

	}

}