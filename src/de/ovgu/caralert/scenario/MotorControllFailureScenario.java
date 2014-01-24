package de.ovgu.caralert.scenario;

import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.system.AppSettings;
import com.jme3.ui.Picture;

import de.ovgu.caralert.gui.Blinkable;
import de.ovgu.caralert.gui.Blinkable.BlinkFrequency;
import eu.opends.main.Simulator;

public class MotorControllFailureScenario extends AbstractScenario {

    // Durch einen Defekt Kurzschluss etc. faellt das Motorsteuergeraet
    // komplett aus. Der Motor geht in einen Notlauf, woraufhin der Wagen nur
    // noch in Schritttempo weiterbewegt werden kann.
    private AppSettings settings;

    public MotorControllFailureScenario() {
        // Trigger in interval from 5 s to 15 s
        super(Simulator.getCarAlertCore(), 5000L, 15000L);
        settings = getCore().getSimulator().getSettings();
    }

    @Override
    public void onNoRisk() {
        System.out.println("Keine Gefahr!");
        BitmapText warning = getWarningText("Motor im Notlauf");
        BitmapText info = getInfoText("Nur Schrittempo möglich. Werkstatt aufsuchen!");

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.NORMAL));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.NORMAL));

    }

    @Override
    public void onLowRisk() {
        BitmapText warning = getWarningText("Motor im Notlauf");
        BitmapText info = getInfoText("Nur Schrittempo möglich. Werkstatt aufsuchen!");

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.FAST));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.FAST));
    }

    @Override
    public void onHighRisk() {
        BitmapText warning = getWarningText("Motor im Notlauf");
        BitmapText info = getInfoText("Nur Schrittempo möglich. Werkstatt aufsuchen!");
        Picture engineInfo = getEnginePicture();

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.FAST));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.FAST));
        getCore().getCarAlertGUI().add(new Blinkable(engineInfo, BlinkFrequency.FAST));
    }

    @Override
    public void onSevereRisk() {
        BitmapText warning = getWarningText("Motor im Notlauf");
        BitmapText info = getInfoText("Nur Schrittempo möglich. Werkstatt aufsuchen!");
        Picture engineInfo = getEnginePicture();

        getCore().getCarAlertGUI().add(new Blinkable(warning, BlinkFrequency.VERY_FAST));
        getCore().getCarAlertGUI().add(new Blinkable(info, BlinkFrequency.VERY_FAST));
        getCore().getCarAlertGUI().add(new Blinkable(engineInfo, BlinkFrequency.VERY_FAST));
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
        infoText.setText("Bei der n�chsten M�glichkeit halten und Auto neustarten");
        infoText.setColor(ColorRGBA.White);
        infoText.setLocalTranslation((settings.getWidth() / 2) - (infoText.getLineWidth() / 2), settings.getHeight() - 50 - infoText.getLineHeight(), 0);

        return infoText;
    }

    private Picture getEnginePicture() {
        Picture engineIcon = new Picture();
        engineIcon.setImage(getCore().getSimulator().getAssetManager(), "CarAlert/Textures/Motorkontrollleuchte.png", true);
        engineIcon.setHeight(50);
        engineIcon.setWidth(50);
        engineIcon.setPosition((settings.getWidth() / 2) - 50, settings.getHeight() - 50 - 50);

        return engineIcon;
    }

}
