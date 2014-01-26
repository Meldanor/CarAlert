package de.ovgu.caralert.gui;

import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.DropDown;
import de.lessvoid.nifty.controls.DropDownSelectionChangedEvent;
import de.lessvoid.nifty.controls.dropdown.DropDownControl;
import de.lessvoid.nifty.controls.label.builder.LabelBuilder;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import eu.opends.main.Simulator;
import eu.opends.niftyGui.DrivingTaskSelectionGUIController;

public class FactorSelectController implements ScreenController{
	
	int brightnessFactor = 1;
	int carClassFactor = 1;
	int carSelectionFactor = 1;
	int driverConditionFactor = 1;
	int environmentFactor = 1;
	int loadFactor = 1;
	int passangerFactor = 1;
	int placeKnowledgeFactor = 1;
	int routeDurationFactor = 1;
	int signFactor = 1;
	int temperatureFactor = 1;
	int timeFactor = 1;
	int trafficIntensityFactor = 1;
	int volumneFactor = 1;
	int weatherFactor = 1;
	

	private Simulator sim;
	private Nifty nifty;
	
	public FactorSelectController(Simulator sim, Nifty nifty)
	{
		this.sim = sim;
		this.nifty = nifty;
		
		AssetManager assetManager = sim.getAssetManager();
		assetManager.registerLocator("assets", FileLocator.class.getName());
	}
	
	public void clickOkButton(){
		//TODO: convert the factor-ints into factors and put them to the settings; close the dialog and return to DrivingTaskSelection
//		sim.getCarAlertCore(). --> Settings
		nifty.fromXml("Interface/DrivingTaskSelectionGUI.xml", "start", new DrivingTaskSelectionGUIController(sim, nifty));
	}


	@NiftyEventSubscriber(id="brightnessDropDown")
	public void onbrightnessDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.brightnessFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="carClassDropDown")
	public void onCarClassDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.carClassFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="carSelectionDropDown")
	public void onCarSelectionDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.carSelectionFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="driverConditionDropDown")
	public void onDriverConditionDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.driverConditionFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="environmentDropDown")
	public void onEnvironmentDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.environmentFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="loadDropDown")
	public void onLoadDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.loadFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="passangerDropDown")
	public void onPassangerDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.passangerFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="placeKnowledgeDropDown")
	public void onplaceKnowledgeDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.placeKnowledgeFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="routeDurationDropDown")
	public void onRouteDurationDropDown(final String id, final DropDownSelectionChangedEvent event){
	this.routeDurationFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="signDropDown")
	public void onsignDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.signFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="temperatureDropDown")
	public void onTemperatureDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.temperatureFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="timeDropDown")
	public void onTimeDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.timeFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="trafficIntensityDropDown")
	public void onTrafficIntensityDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.trafficIntensityFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="volumneDropDown")
	public void onVolumneDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.volumneFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}

	@NiftyEventSubscriber(id="weatherDropDown")
	public void onWeatherDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.weatherFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex()+1;
	}
	
	
	
	@Override
	public void bind(Nifty nifty, Screen screen) {
		//populate the dropDownMenus
				
		DropDown brightnessDropDown = screen.findNiftyControl("brightnessDropDown", DropDown.class);
		System.out.println("test:" + brightnessDropDown.toString());
		brightnessDropDown.addItem("Tageslicht");
		brightnessDropDown.addItem("Nacht");
		brightnessDropDown.addItem("Dämmerung");

		DropDown carClassDropDown = screen.findNiftyControl("carClassDropDown", DropDown.class);
		carClassDropDown.addItem("Mittel-/Oberklasse");
		carClassDropDown.addItem("Kompaktwagen");
		carClassDropDown.addItem("Sportwagen/LKW");

		DropDown carStateDropDown = screen.findNiftyControl("carStateDropDown", DropDown.class);
		carStateDropDown.addItem("keine Mängel");
		carStateDropDown.addItem("1 Mangel");
		carStateDropDown.addItem("mehrere Mängel");

		DropDown driverConditionDropDown = screen.findNiftyControl("driverConditionDropDown", DropDown.class);
		driverConditionDropDown.addItem("keine Faktoren");
		driverConditionDropDown.addItem("1 Faktor");
		driverConditionDropDown.addItem("mehrere Faktoren");

		DropDown environmentDropDown = screen.findNiftyControl("environmentDropDown", DropDown.class);
		environmentDropDown.addItem("Stadt");
		environmentDropDown.addItem("Autobahn");
		environmentDropDown.addItem("Gelände");

		DropDown loadDropDown = screen.findNiftyControl("loadDropDown", DropDown.class);
		loadDropDown.addItem("wenig Beladung");
		loadDropDown.addItem("Beladung + Dachgepäck");
		loadDropDown.addItem("Beladung + Anhänger");

		DropDown passangerDropDown = screen.findNiftyControl("passangerDropDown", DropDown.class);
		passangerDropDown.addItem("1");
		passangerDropDown.addItem("2");
		passangerDropDown.addItem(">2");

		DropDown placeKnowledgeDropDown = screen.findNiftyControl("placeKnowledgeDropDown", DropDown.class);
		placeKnowledgeDropDown.addItem("häufig gefahren");
		placeKnowledgeDropDown.addItem("bekannte Strecke");
		placeKnowledgeDropDown.addItem("unbekannte Strecke");

		DropDown routeDurationDropDown = screen.findNiftyControl("routeDurationDropDown", DropDown.class);
		routeDurationDropDown.addItem("<1h");
		routeDurationDropDown.addItem("1-2h");
		routeDurationDropDown.addItem(">2h");

		DropDown signDropDown = screen.findNiftyControl("signDropDown", DropDown.class);
		signDropDown.addItem("beachtet Schilder");
		signDropDown.addItem("geringfügige Abweichung");
		signDropDown.addItem("Missachtung");

		DropDown temperatureDropDown = screen.findNiftyControl("temperatureDropDown", DropDown.class);
		temperatureDropDown.addItem("10-25°C");
		temperatureDropDown.addItem("<10°C / >25°C");
		temperatureDropDown.addItem("<3°C / >35°C");

		DropDown timeDropDown = screen.findNiftyControl("timeDropDown", DropDown.class);
		timeDropDown.addItem("9-16 Uhr");
		timeDropDown.addItem("6-9 oder 16-21 Uhr");
		timeDropDown.addItem("21-6 Uhr");

		DropDown trafficIntensityDropDown = screen.findNiftyControl("trafficIntensityDropDown", DropDown.class);
		trafficIntensityDropDown.addItem("kein/kaum Verkehr");
		trafficIntensityDropDown.addItem("normaler Verkehr");
		trafficIntensityDropDown.addItem("viel Verkehr/Stau");

		DropDown volumneDropDown = screen.findNiftyControl("volumneDropDown", DropDown.class);
		volumneDropDown.addItem("<55dB");
		volumneDropDown.addItem("55-80dB");
		volumneDropDown.addItem(">80dB");

		DropDown weatherDropDown = screen.findNiftyControl("weatherDropDown", DropDown.class);
		weatherDropDown.addItem("gutes Wetter");
		weatherDropDown.addItem("Regen/Wind");
		weatherDropDown.addItem("Nebel/Glätte/Sturm");
	}

	@Override
	public void onEndScreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartScreen() {
		
		
	}
	
	
}
