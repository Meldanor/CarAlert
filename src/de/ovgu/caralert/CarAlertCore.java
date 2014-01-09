package de.ovgu.caralert;

import de.ovgu.caralert.gui.CarAlertGUI;
import eu.opends.main.Simulator;

public class CarAlertCore {

    private Simulator simulator;

    private CarAlertGUI carAlertGUI;

    public CarAlertCore(Simulator simulator) {
        this.simulator = simulator;

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

}
