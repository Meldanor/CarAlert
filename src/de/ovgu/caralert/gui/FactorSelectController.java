package de.ovgu.caralert.gui;

import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.RadioButtonGroupStateChangedEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import eu.opends.main.Simulator;

public class FactorSelectController implements ScreenController{
	
	int brightnessFactor = 1;
	int carClassFactor = 1;
	int carStateFactor = 1;
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


	@NiftyEventSubscriber(id="brightnessRadioButtonGroup")
	public void onBrightnessRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.brightnessFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="carClassRadioButtonGroup")
	public void onCarClassRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.carClassFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="carStateRadioButtonGroup")
	public void onCarStateRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.carStateFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="driverConditionRadioButtonGroup")
	public void onDriverConditionRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.driverConditionFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="environmentRadioButtonGroup")
	public void onEnvironmentRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.environmentFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="loadRadioButtonGroup")
	public void onLoadRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.loadFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="passangerRadioButtonGroup")
	public void onPassangerRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.passangerFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="placeKnowledgeRadioButtonGroup")
	public void onPlaceKnowledgeRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.placeKnowledgeFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="routeDurationRadioButtonGroup")
	public void onRouteDurationRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
	this.routeDurationFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="signRadioButtonGroup")
	public void onSignRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.signFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="temperatureRadioButtonGroup")
	public void onTemperatureRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.temperatureFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="timeRadioButtonGroup")
	public void onTimeRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.timeFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="trafficIntensityRadioButtonGroup")
	public void onTrafficIntensityRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.trafficIntensityFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="volumneRadioButtonGroup")
	public void onVolumneRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.volumneFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}

	@NiftyEventSubscriber(id="weatherRadioButtonGroup")
	public void onWeatherRadioButtonGroup(final String id, final RadioButtonGroupStateChangedEvent event){
		this.weatherFactor = Character.getNumericValue(event.getSelectedId().charAt(0));
	}
	
	
	
	@Override
	public void bind(Nifty nifty, Screen screen) {
		// TODO Auto-generated method stub
		
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
