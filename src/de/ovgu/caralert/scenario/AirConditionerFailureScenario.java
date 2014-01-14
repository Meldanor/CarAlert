package de.ovgu.caralert.scenario;

import de.ovgu.caralert.CarAlertCore;

public class AirConditionerFailureScenario extends AbstractScenario {

	// Durch einen Softwarefehler stuerzt ein Softwaremodul der Klimasteuerung
	// ab, wodurch es unabhaengig von der am Bedienteil eingestellten
	// Zieltemperatur permanent eine maximale Kuehlung umgesetzt wird. Der
	// An-/Ausknopf der Klimasteuerung reagiert ebenfalls nicht, weshalb die
	// einzige Moeglichkeit zu einem Reset darin besteht, das Fahrzeug komplett
	// anzuhalten und die Zuendung auszuschalten und neu zu starten.
	protected AirConditionerFailureScenario(CarAlertCore core) {
		super(core, 15000L, 20000L);
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
