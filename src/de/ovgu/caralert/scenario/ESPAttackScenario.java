package de.ovgu.caralert.scenario;

import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.system.AppSettings;
import com.jme3.ui.Picture;

import de.ovgu.caralert.CarAlertCore;
import de.ovgu.caralert.gui.Blinkable;
import de.ovgu.caralert.gui.Blinkable.BlinkFrequency;

public class ESPAttackScenario extends AbstractScenario {

    // Mittels eines Exploits (v3) nutzt der vorliegende Schadcode eine
    // Sicherheitsluecke in der Car-to-X Onboard-Unit aus. Dabei dringt er in
    // tiefer in das automotive Gesamtsystem ein und infiziert das
    // ESP-Steuergeraet. Er legt sich dort im Flash-Speicher (u3) ab traegt sich
    // so in die Systemkonfiguration ein, dass er fortab beim Starten des
    // Geraets automatisch mit geladen wird (a1). Der Schadcode kommuniziert
    // fortan nicht mehr mit dem Angreifer. Stattdessen ueberwacht er auf dem
    // Gerät permanent die aktuelle Geschwindigkeit des Fahrzeugs (f6.1) und
    // bremst ab dem Erreichen einer Geschwindigkeit über 200 km/h automatisch
    // das hintere rechte Rad abrupt ab (f13.14).

    // Der Schadcode ist bereits bekannt und kann anhand einer vorhandenen
    // Signatur erkannt werden (d.h. noch bevor die kritische Situation
    // eintritt). Da er sich mit wirksamen Rootkit-Mechanismen schuetzt, kann er
    // jedoch nicht automatisch entfernt werden, so dass der Fahrer geeignet zu
    // warnen ist. Die bekannte formale Tupelnotation dieses Schadcodes lautet
    // t3={v3|s2, a1, u3, w2, {}, {f6.1, f13.14}}
    private AppSettings settings;

    public ESPAttackScenario(CarAlertCore core) {
        super(core);
        settings = getCore().getSimulator().getSettings();
    }

    @Override
    public boolean update(long diff) {
        if (reachedSpeedLimit()) {
            trigger();
            return false;
        } else {
            return true;
        }
    }

    private static final float SPEED_LIMIT = 80.0f;

    private boolean reachedSpeedLimit() {
        return getCore().getSimulator().getCar().getCurrentSpeedKmh() > SPEED_LIMIT;
    }

    @Override
    public void onNoRisk() {
        System.out.println("Keine Gefahr!");
        BitmapText warning = getWarningText("ESP Fehlfunktion");
        BitmapText info = getInfoText("Geschwindigkeit reduzieren und Werkstatt aufsuchen!");

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.FAST));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.FAST));

    }

    @Override
    public void onLowRisk() {
        BitmapText warning = getWarningText("ESP Fehlfunktion");
        BitmapText info = getInfoText("Geschwindigkeit reduzieren und Werkstatt aufsuchen!");

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.VERY_FAST));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.VERY_FAST));
    }

    @Override
    public void onHighRisk() {
        BitmapText warning = getWarningText("ESP Fehlfunktion");
        BitmapText info = getInfoText("Geschwindigkeit reduzieren und Werkstatt aufsuchen!");
        Picture engineInfo = getWarningPicture();

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.SLOW));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.SLOW));
        getCore().getCarAlertGUI().add(engineInfo);
    }

    @Override
    public void onSevereRisk() {
        BitmapText warning = getWarningText("ESP Fehlfunktion");
        BitmapText info = getInfoText("Geschwindigkeit reduzieren und Werkstatt aufsuchen!");
        Picture engineInfo = getWarningPicture();

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.SLOW));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.SLOW));
        getCore().getCarAlertGUI().add(engineInfo);
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

    private Picture getWarningPicture() {
        Picture warningIcon = new Picture("warningtriangle");
        warningIcon.setImage(getCore().getSimulator().getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
        warningIcon.setHeight(50);
        warningIcon.setWidth(50);
        warningIcon.setPosition((settings.getWidth() / 2) - 25, settings.getHeight() - 50 - 100);

        return warningIcon;
    }
}
