package de.ovgu.caralert.gui;

import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.DropDown;
import de.lessvoid.nifty.controls.DropDownSelectionChangedEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import eu.opends.main.Simulator;
import eu.opends.niftyGui.DrivingTaskSelectionGUIController;

public class FactorSelectController implements ScreenController {

    public static int brightnessFactor;
    public static int carClassFactor;
    public static int carSelectionFactor;
    public static int carStateFactor;
    public static int driverConditionFactor;
    public static int environmentFactor;
    public static int loadFactor;
    public static int passangerFactor;
    public static int placeKnowledgeFactor;
    public static int routeDurationFactor;
    public static int signFactor;
    public static int temperatureFactor;
    public static int timeFactor;
    public static int trafficIntensityFactor;
    public static int volumneFactor;
    public static int weatherFactor;

    private Simulator sim;
    private Nifty nifty;

    public FactorSelectController(Simulator sim, Nifty nifty) {
        this.sim = sim;
        this.nifty = nifty;

        AssetManager assetManager = sim.getAssetManager();
        assetManager.registerLocator("assets", FileLocator.class.getName());
    }

    public void clickOkButton() {
        // TODO: close the dialog and return to DrivingTaskSelection
        // sim.getCarAlertCore(). --> Settings
        nifty.fromXml("Interface/DrivingTaskSelectionGUI.xml", "start", new DrivingTaskSelectionGUIController(sim, nifty));
    }

    @NiftyEventSubscriber(id = "brightnessDropDown")
    public void onbrightnessDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        brightnessFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "carClassDropDown")
    public void onCarClassDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        carClassFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "carSelectionDropDown")
    public void onCarSelectionDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        carSelectionFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "carStateDropDown")
    public void onCarStateDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        carStateFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "driverConditionDropDown")
    public void onDriverConditionDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        driverConditionFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "environmentDropDown")
    public void onEnvironmentDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        environmentFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "loadDropDown")
    public void onLoadDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        loadFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "passangerDropDown")
    public void onPassangerDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        passangerFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "placeKnowledgeDropDown")
    public void onplaceKnowledgeDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        placeKnowledgeFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "routeDurationDropDown")
    public void onRouteDurationDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        routeDurationFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "signDropDown")
    public void onsignDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        signFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "temperatureDropDown")
    public void onTemperatureDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        temperatureFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "timeDropDown")
    public void onTimeDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        timeFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "trafficIntensityDropDown")
    public void onTrafficIntensityDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        trafficIntensityFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "volumneDropDown")
    public void onVolumneDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        volumneFactor = event.getSelection().getWeight();
    }

    @NiftyEventSubscriber(id = "weatherDropDown")
    public void onWeatherDropDown(final String id, final DropDownSelectionChangedEvent<FaktorItem> event) {
        weatherFactor = event.getSelection().getWeight();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void bind(Nifty nifty, Screen screen) {

        // populate the dropDownMenus
        DropDown<FaktorItem> brightnessDropDown = screen.findNiftyControl("brightnessDropDown", DropDown.class);
        brightnessDropDown.addItem(new FaktorItem(0, "Tageslicht"));
        brightnessDropDown.addItem(new FaktorItem(1, "Nacht"));
        brightnessDropDown.addItem(new FaktorItem(2, "Dämmerung"));

        DropDown<FaktorItem> carClassDropDown = screen.findNiftyControl("carClassDropDown", DropDown.class);
        carClassDropDown.addItem(new FaktorItem(0, "Mittel-/Oberklasse"));
        carClassDropDown.addItem(new FaktorItem(1, "Kompaktwagen"));
        carClassDropDown.addItem(new FaktorItem(2, "Sportwagen/LKW"));

        DropDown<FaktorItem> carStateDropDown = screen.findNiftyControl("carStateDropDown", DropDown.class);
        carStateDropDown.addItem(new FaktorItem(0, "Kein Mangel"));
        carStateDropDown.addItem(new FaktorItem(2, "1 Mangel"));
        carStateDropDown.addItem(new FaktorItem(3, "Mehrere Mängel"));

        DropDown<FaktorItem> driverConditionDropDown = screen.findNiftyControl("driverConditionDropDown", DropDown.class);
        driverConditionDropDown.addItem(new FaktorItem(0, "Entspannt"));
        driverConditionDropDown.addItem(new FaktorItem(3, "1 Zustand"));
        driverConditionDropDown.addItem(new FaktorItem(5, "Mehrere Zustände"));

        DropDown<FaktorItem> environmentDropDown = screen.findNiftyControl("environmentDropDown", DropDown.class);
        environmentDropDown.addItem(new FaktorItem(0, "Stadt"));
        environmentDropDown.addItem(new FaktorItem(1, "Autobahn"));
        environmentDropDown.addItem(new FaktorItem(2, "Gelände"));

        DropDown<FaktorItem> loadDropDown = screen.findNiftyControl("loadDropDown", DropDown.class);
        loadDropDown.addItem(new FaktorItem(0, "Wenig Beladung"));
        loadDropDown.addItem(new FaktorItem(1, "Beladung + Dachgepäck"));
        loadDropDown.addItem(new FaktorItem(3, "Beladung + Anhänger"));

        DropDown<FaktorItem> passangerDropDown = screen.findNiftyControl("passangerDropDown", DropDown.class);
        passangerDropDown.addItem(new FaktorItem(0, "1"));
        passangerDropDown.addItem(new FaktorItem(1, "2"));
        passangerDropDown.addItem(new FaktorItem(2, "Mehr als 2"));

        DropDown<FaktorItem> placeKnowledgeDropDown = screen.findNiftyControl("placeKnowledgeDropDown", DropDown.class);
        placeKnowledgeDropDown.addItem(new FaktorItem(0, "Häufig gefahren"));
        placeKnowledgeDropDown.addItem(new FaktorItem(1, "Bekannte Strecke"));
        placeKnowledgeDropDown.addItem(new FaktorItem(2, "Unbekannte Strecke"));

        DropDown<FaktorItem> routeDurationDropDown = screen.findNiftyControl("routeDurationDropDown", DropDown.class);
        routeDurationDropDown.addItem(new FaktorItem(0, "< 1 Stunde"));
        routeDurationDropDown.addItem(new FaktorItem(2, "1-2 Stunden"));
        routeDurationDropDown.addItem(new FaktorItem(4, "> 2 Stunden"));

        DropDown<FaktorItem> signDropDown = screen.findNiftyControl("signDropDown", DropDown.class);
        signDropDown.addItem(new FaktorItem(0, "Beachtet Schilder"));
        signDropDown.addItem(new FaktorItem(2, "Geringfügige Abweichung"));
        signDropDown.addItem(new FaktorItem(4, "Missachtung"));

        DropDown<FaktorItem> temperatureDropDown = screen.findNiftyControl("temperatureDropDown", DropDown.class);
        temperatureDropDown.addItem(new FaktorItem(0, "10-20 °C"));
        temperatureDropDown.addItem(new FaktorItem(1, "<10 °C / > 20 °C"));
        temperatureDropDown.addItem(new FaktorItem(2, "<3 °C / > 35 °C"));

        DropDown<FaktorItem> timeDropDown = screen.findNiftyControl("timeDropDown", DropDown.class);
        timeDropDown.addItem(new FaktorItem(0, "9 - 16 Uhr"));
        timeDropDown.addItem(new FaktorItem(2, "6-9 oder 16-21 Uhr"));
        timeDropDown.addItem(new FaktorItem(5, "21 - 6 Uhr"));

        DropDown<FaktorItem> trafficIntensityDropDown = screen.findNiftyControl("trafficIntensityDropDown", DropDown.class);
        trafficIntensityDropDown.addItem(new FaktorItem(0, "Kein/Kaum Verkehr"));
        trafficIntensityDropDown.addItem(new FaktorItem(1, "Normaler Verkehr"));
        trafficIntensityDropDown.addItem(new FaktorItem(2, "Viel Verkehr/Stau"));

        DropDown<FaktorItem> volumneDropDown = screen.findNiftyControl("volumneDropDown", DropDown.class);
        volumneDropDown.addItem(new FaktorItem(0, "< 55 dB"));
        volumneDropDown.addItem(new FaktorItem(1, "55 dB - 80 dB"));
        volumneDropDown.addItem(new FaktorItem(2, "> 80 dB"));

        DropDown<FaktorItem> weatherDropDown = screen.findNiftyControl("weatherDropDown", DropDown.class);
        weatherDropDown.addItem(new FaktorItem(0, "Gutes Wetter"));
        weatherDropDown.addItem(new FaktorItem(3, "Regen/Wind"));
        weatherDropDown.addItem(new FaktorItem(6, "Nebel/Glätte/Sturm"));
    }

    private class FaktorItem {
        private int weight;
        private String text;

        public FaktorItem(int weight, String text) {
            this.weight = weight;
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }

        public int getWeight() {
            return weight;
        }
    }

    @Override
    public void onEndScreen() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStartScreen() {

    }

}
