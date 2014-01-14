package de.ovgu.caralert.scenario;

import eu.opends.main.Simulator;

public class MotorControllFailureScenario extends AbstractScenario {

	// Durch einen Defekt Kurzschluss etc. faellt das Motorsteuergeraet
	// komplett aus. Der Motor geht in einen Notlauf, woraufhin der Wagen nur
	// noch in Schritttempo weiterbewegt werden kann.

	public MotorControllFailureScenario() {
		// Trigger in interval from 5 s to 15 s
		super(Simulator.getCarAlertCore(), 5000L, 15000L);
	}

	@Override
	public void onNoRisk() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLowRisk() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onHighRisk() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSevereRisk() {
		// TODO Auto-generated method stub

	}

}
