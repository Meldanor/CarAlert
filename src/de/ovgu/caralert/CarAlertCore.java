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
import de.ovgu.caralert.scenario.AbstractScenario;
import de.ovgu.caralert.scenario.AirConditionerFailureScenario;
import de.ovgu.caralert.scenario.ESPAttackScenario;
import eu.opends.main.Simulator;

public class CarAlertCore {

    private Simulator simulator;

    private CarAlertGUI carAlertGUI;

    private FactorAnalyzer factorAnalyzer;

    private AbstractScenario scenario;

    public CarAlertCore(Simulator simulator) {
        this.simulator = simulator;

        this.factorAnalyzer = new SimpleFactorAnalyzer();
        addFactors();

        this.carAlertGUI = new CarAlertGUI(simulator);
        init();
    }

    private void init() {
        this.scenario = new ESPAttackScenario(this);
    }

    private long lastTimestamp = 0;

    public void update() {
        // Initial round
        if (lastTimestamp == 0) {
            lastTimestamp = System.currentTimeMillis();
            return;
        }

        long cur = System.currentTimeMillis();
        long diff = cur - lastTimestamp;
        lastTimestamp = cur;

        this.carAlertGUI.update();

        if (scenario != null && !this.scenario.update(diff)) {
            this.scenario = null;
        }

    }

    public Simulator getSimulator() {
        return simulator;
    }

    public FactorAnalyzer getFactorAnalyzer() {
        return factorAnalyzer;
    }

    public CarAlertGUI getCarAlertGUI() {
        return carAlertGUI;
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
