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
	}


	@NiftyEventSubscriber(id="brightnessDropDown")
	public void onBrightnessDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.brightnessFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="carClassDropDown")
	public void onCarClassDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.carClassFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="carSelectionDropDown")
	public void onCarSelectionDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.carSelectionFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="driverConditionDropDown")
	public void onDriverConditionDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.driverConditionFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="environmentDropDown")
	public void onEnvironmentDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.environmentFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="loadDropDown")
	public void onLoadDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.loadFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="passangerDropDown")
	public void onPassangerDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.passangerFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="placeKnowledgeDropDown")
	public void onPlaceKnowledgeDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.placeKnowledgeFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="routeDurationDropDown")
	public void onRouteDurationDropDown(final String id, final DropDownSelectionChangedEvent event){
	this.routeDurationFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="signDropDown")
	public void onSignDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.signFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="temperatureDropDown")
	public void onTemperatureDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.temperatureFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="timeDropDown")
	public void onTimeDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.timeFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="trafficIntensityDropDown")
	public void onTrafficIntensityDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.trafficIntensityFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="volumneDropDown")
	public void onVolumneDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.volumneFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}

	@NiftyEventSubscriber(id="weatherDropDown")
	public void onWeatherDropDown(final String id, final DropDownSelectionChangedEvent event){
		this.weatherFactor = nifty.getScreen("factor").findNiftyControl(id, DropDown.class).getSelectedIndex();
	}
	
	
	
	@Override
	public void bind(Nifty nifty, Screen screen) {
		//populate the dropDownMenus
		DropDown dropdown = screen.findNiftyControl("brightnessDropDown", DropDown.class);
		dropdown.addItem("Daylight");
		dropdown.addItem("Night");
		dropdown.addItem("Dawn");
	}

	@Override
	public void onEndScreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartScreen() {
		// TODO Auto-generated method stub
		
	}
	
	
}
