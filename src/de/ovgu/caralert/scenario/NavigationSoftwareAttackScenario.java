package de.ovgu.caralert.scenario;

import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.system.AppSettings;
import com.jme3.ui.Picture;

import de.ovgu.caralert.CarAlertCore;
import de.ovgu.caralert.gui.Blinkable;
import de.ovgu.caralert.gui.Blinkable.BlinkFrequency;

public class NavigationSoftwareAttackScenario extends AbstractScenario {

    // Der Fahrzeugfuehrer laedt sich aus dem Internet eine manipulierte
    // Flash-Firmware für sein DVD-Navigationsgeraet, mit der sich das Anschauen
    // von DVD-Videos sowie TV-Programm (über den vorhandenen Video-Eingang)
    // auch waehrend der Fahrt freischalten lässt. Zur Installation in den
    // Flash-Speicher des Geraets (u3) brennt er das Firmware-Update auf eine CD
    // und spielt es durch Einlegen in das Geraet sowie Bestaetigung der
    // Update-Nachfrage ein (v5).

    // Ohne das Wissen des Nutzers hat der Entwickler der unautorisierten
    // TV-Freischaltungssoftware ein verstecktes schadhaftes Softwaremodul
    // implementiert. Dieses wertet permanent die aktuelle GPS-Position aus
    // (f6.2). Sobald gleichzeitig die letzten 2 (Nachkomma-)Stellen des
    // Breitengrads den Wert „13“ und die des Laengengrads den Wert „37“
    // annehmen, wird ein Angriff gestartet. Dabei werden wiederholt
    // CAN-Busnachrichten generiert, die die Lichtanlage anweisen, das Licht
    // auszuschalten (f13.15).

    // Der Schadcode ist bereits bekannt und kann anhand einer vorhandenen
    // Signatur erkannt werden (d.h. noch bevor die kritische Situation
    // eintritt). Da auch er sich mit wirksamen Rootkit-Mechanismen schuetzt,
    // kann er ebenfalls nicht automatisch entfernt werden, so dass der Fahrer
    // geeignet zu warnen ist. Die bekannte formale Tupelnotation dieses
    // Schadcodes lautet t4={v5, a1, u3, w2, {}, {f6.2, f13.15}}
    private AppSettings settings;

    public NavigationSoftwareAttackScenario(CarAlertCore core) {
        super(core);
        settings = getCore().getSimulator().getSettings();
    }

    @Override
    public void onNoRisk() {
        System.out.println("Keine Gefahr!");
        BitmapText warning = getWarningText("Navigation Fehlfunktion");
        BitmapText info = getInfoText("Lichtmaschine betroffen! Werkstatt aufsuchen!");

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.NORMAL));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.NORMAL));

    }

    @Override
    public void onLowRisk() {
        BitmapText warning = getWarningText("Navigation Fehlfunktion");
        BitmapText info = getInfoText("Lichtmaschine betroffen! Werkstatt aufsuchen!");

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.FAST));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.FAST));
    }

    @Override
    public void onHighRisk() {
        BitmapText warning = getWarningText("Navigation Fehlfunktion");
        BitmapText info = getInfoText("Lichtmaschine betroffen! Werkstatt aufsuchen!");
        Picture warningInfo = getWarningPicture();

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.FAST));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.FAST));
        getCore().getCarAlertGUI().add(new Blinkable(warningInfo, BlinkFrequency.FAST));
    }

    @Override
    public void onSevereRisk() {
        BitmapText warning = getWarningText("Navigation Fehlfunktion");
        BitmapText info = getInfoText("Lichtmaschine betroffen! Werkstatt aufsuchen!");
        Picture warningInfo = getWarningPicture();

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.VERY_FAST));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.VERY_FAST));
        getCore().getCarAlertGUI().add(new Blinkable(warningInfo, BlinkFrequency.VERY_FAST));
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
        Picture engineIcon = new Picture("warningtriangle");
        engineIcon.setImage(getCore().getSimulator().getAssetManager(), "CarAlert/Textures/Warndreieck.png", true);
        engineIcon.setHeight(50);
        engineIcon.setWidth(50);
        engineIcon.setPosition((settings.getWidth() / 2) - 25, settings.getHeight() - 50 - 100);

        return engineIcon;
    }

}
