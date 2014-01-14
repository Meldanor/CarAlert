package de.ovgu.caralert;

import de.ovgu.caralert.factor.BrightnessFactor;
import de.ovgu.caralert.factor.CarClassFactor;
import de.ovgu.caralert.factor.CarStateFactor;
import de.ovgu.caralert.factor.DriverConditionFactor;
import de.ovgu.caralert.factor.EnvironmentFactor;
import de.ovgu.caralert.factor.LoadFactor;
import de.ovgu.caralert.factor.PassangerFactor;
import de.ovgu.caralert.factor.PlaceKnowledgeFactor;
import de.ovgu.caralert.factor.RouteDurationFactor;
import de.ovgu.caralert.factor.SignFactor;
import de.ovgu.caralert.factor.TemperatureFactor;
import de.ovgu.caralert.factor.TimeFactor;
import de.ovgu.caralert.factor.TrafficIntensityFactor;
import de.ovgu.caralert.factor.VolumneFactor;
import de.ovgu.caralert.factor.WeatherFactor;
import de.ovgu.caralert.gui.CarAlertGUI;
import eu.opends.main.Simulator;

public class CarAlertCore {

	private Simulator simulator;

	private CarAlertGUI carAlertGUI;

	private FactorAnalyzer factorAnalyzer;

	public CarAlertCore(Simulator simulator) {
		this.simulator = simulator;

		this.factorAnalyzer = new SimpleFactorAnalyzer();
		addFactors();

		this.carAlertGUI = new CarAlertGUI(simulator);
		init();
	}

	private void init() {

	}

	public void update() {

		this.carAlertGUI.update();

	}

	public Simulator getSimulator() {
		return simulator;
	}

	public FactorAnalyzer getFactorAnalyzer() {
		return factorAnalyzer;
	}

	private void addFactors() {
		this.factorAnalyzer.registerFactor(new BrightnessFactor());
		this.factorAnalyzer.registerFactor(new CarClassFactor());
		this.factorAnalyzer.registerFactor(new CarStateFactor());
		this.factorAnalyzer.registerFactor(new DriverConditionFactor());
		this.factorAnalyzer.registerFactor(new EnvironmentFactor());
		this.factorAnalyzer.registerFactor(new LoadFactor());
		this.factorAnalyzer.registerFactor(new PassangerFactor());
		this.factorAnalyzer.registerFactor(new PlaceKnowledgeFactor());
		this.factorAnalyzer.registerFactor(new RouteDurationFactor());
		this.factorAnalyzer.registerFactor(new SignFactor());
		this.factorAnalyzer.registerFactor(new TemperatureFactor());
		this.factorAnalyzer.registerFactor(new TimeFactor());
		this.factorAnalyzer.registerFactor(new TrafficIntensityFactor());
		this.factorAnalyzer.registerFactor(new VolumneFactor());
		this.factorAnalyzer.registerFactor(new WeatherFactor());
	}

}
