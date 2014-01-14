package de.ovgu.caralert.scenario;

import de.ovgu.caralert.CarAlertCore;

public class ESPAttackScenario extends AbstractScenario {

	// Mittels eines Exploits (v3) nutzt der vorliegende Schadcode eine
	// Sicherheitsluecke in der Car-to-X Onboard-Unit aus. Dabei dringt er in
	// tiefer in das automotive Gesamtsystem ein und infiziert das
	// ESP-Steuergeraet. Er legt sich dort im Flash-Speicher (u3) ab traegt sich
	// so in die Systemkonfiguration ein, dass er fortab beim Starten des
	// Geraets automatisch mit geladen wird (a1). Der Schadcode kommuniziert
	// fortan nicht mehr mit dem Angreifer. Stattdessen ueberwacht er auf dem
	// Gerät permanent die aktuelle Geschwindigkeit des Fahrzeugs (f6.1) und
	// bremst ab dem Erreichen einer Geschwindigkeit über 200 km/h automatisch
	// das hintere rechte Rad abrupt ab (f13.14).

	// Der Schadcode ist bereits bekannt und kann anhand einer vorhandenen
	// Signatur erkannt werden (d.h. noch bevor die kritische Situation
	// eintritt). Da er sich mit wirksamen Rootkit-Mechanismen schuetzt, kann er
	// jedoch nicht automatisch entfernt werden, so dass der Fahrer geeignet zu
	// warnen ist. Die bekannte formale Tupelnotation dieses Schadcodes lautet
	// t3={v3|s2, a1, u3, w2, {}, {f6.1, f13.14}}
	protected ESPAttackScenario(CarAlertCore core) {
		super(core);
	}

	@Override
	public boolean update(long diff) {
		if (reachedSpeedLimit()) {
			trigger();
			return true;
		} else {
			return false;
		}
	}

	private static final float SPEED_LIMIT = 200.0f;

	private boolean reachedSpeedLimit() {
		return getCore().getSimulator().getCar().getCurrentSpeedKmh() < SPEED_LIMIT;
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
