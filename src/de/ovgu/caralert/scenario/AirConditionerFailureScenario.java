package de.ovgu.caralert.scenario;

import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.system.AppSettings;

import de.ovgu.caralert.CarAlertCore;
import de.ovgu.caralert.gui.Blinkable;
import de.ovgu.caralert.gui.Blinkable.BlinkFrequency;

public class AirConditionerFailureScenario extends AbstractScenario {

	// Durch einen Softwarefehler stuerzt ein Softwaremodul der Klimasteuerung
	// ab, wodurch es unabhaengig von der am Bedienteil eingestellten
	// Zieltemperatur permanent eine maximale Kuehlung umgesetzt wird. Der
	// An-/Ausknopf der Klimasteuerung reagiert ebenfalls nicht, weshalb die
	// einzige Moeglichkeit zu einem Reset darin besteht, das Fahrzeug komplett
	// anzuhalten und die Zuendung auszuschalten und neu zu starten.
	private AppSettings settings;

	public AirConditionerFailureScenario(CarAlertCore core) {
		super(core, 5000L);
		settings = getCore().getSimulator().getSettings();
	}

	@Override
	public void onNoRisk() {
		System.out.println("Keine Gefahr!");
		// onSevereRisk();
		printText(BlinkFrequency.NORMAL);
		// Sollte nichts passieren
	}

	@Override
	public void onLowRisk() {
		System.out.println("Geringe gefahr!");

		printText(BlinkFrequency.NORMAL);
	}

	@Override
	public void onHighRisk() {
		System.out.println("Hohe Gefahr!");
		printText(BlinkFrequency.SLOW);
	}

	@Override
	public void onSevereRisk() {
		System.out.println("Sehr hohe Gefahr!");
		printText(BlinkFrequency.VERY_SLOW);

	}

	private void printText(BlinkFrequency frequency) {
		BitmapText warningText = getBitmapText();

		getCore().getCarAlertGUI().add(new Blinkable(warningText, frequency));
	}

	private BitmapText getBitmapText() {
		BitmapText warningText = new BitmapText(getCore().getCarAlertGUI()
				.getFont());
		warningText.setText("Klimaanlage ausgefallen");
		warningText.setColor(ColorRGBA.Orange);
		warningText.setLocalTranslation((settings.getWidth() / 2) - 75,
				settings.getHeight() - 50, 0);

		return warningText;
	}

}
