package de.ovgu.caralert.scenario;

import java.util.concurrent.TimeUnit;

import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.system.AppSettings;

import de.ovgu.caralert.CarAlertCore;
import de.ovgu.caralert.gui.Blinkable;
import de.ovgu.caralert.gui.Blinkable.BlinkFrequency;
import de.ovgu.caralert.gui.Fadeout;

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

    // Keine Gefahr - viele Informationen, da Quelle unkritisch ist
    @Override
    public void onNoRisk() {
        BitmapText warning = getWarningText("Klimaanlage ausgefallen");
        BitmapText info = getInfoText("Bei der n�chsten M�glichkeit halten und Auto neustarten");

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.NORMAL));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.NORMAL));
    }

    // Kleine Gefahr - Informationen unaufdringlicher
    @Override
    public void onLowRisk() {
        BitmapText warning = getWarningText("Klimaanlage ausgefallen");
        BitmapText info = getInfoText("Bei der nächsten Möglichkeit halten und Auto neustarten");

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.SLOW));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.SLOW));
    }

    // Kleine Gefahr - Informationen unaufdringlicher
    @Override
    public void onHighRisk() {
        BitmapText warning = getWarningText("Klimaanlage ausgefallen");
        BitmapText info = getInfoText("Bei der nächsten Möglichkeit halten und Auto neustarten");

        getCore().getCarAlertGUI().add(new Fadeout(warning, TimeUnit.SECONDS.toMillis(20)));
        getCore().getCarAlertGUI().add(new Fadeout(info, TimeUnit.SECONDS.toMillis(20)));
    }

    @Override
    public void onSevereRisk() {
        BitmapText warning = getWarningText("Klimaanlage ausgefallen");
        BitmapText info = getInfoText("Bei der nächsten Möglichkeit halten und Auto neustarten");

        getCore().getCarAlertGUI().add(new Fadeout(warning, TimeUnit.SECONDS.toMillis(10)));
        getCore().getCarAlertGUI().add(new Fadeout(info, TimeUnit.SECONDS.toMillis(10)));

    }

    private BitmapText getWarningText(String text) {
        BitmapText warningText = new BitmapText(getCore().getCarAlertGUI().getFont());
        warningText.setText(text);
        warningText.setColor(ColorRGBA.Orange);
        warningText.setLocalTranslation((settings.getWidth() / 2) - (warningText.getLineWidth() / 2), settings.getHeight() - 50, 0);
        return warningText;
    }

    private BitmapText getInfoText(String text) {
        BitmapText infoText = new BitmapText(getCore().getCarAlertGUI().getFont());
        infoText.setText(text);
        infoText.setColor(ColorRGBA.White);
        infoText.setLocalTranslation((settings.getWidth() / 2) - (infoText.getLineWidth() / 2), settings.getHeight() - 50 - infoText.getLineHeight(), 0);

        return infoText;
    }

}
