package de.ovgu.caralert.scenario;

import de.ovgu.caralert.CarAlertCore;

public class NavigationSoftwareAttackScenario extends AbstractScenario {

	// Der Fahrzeugfuehrer laedt sich aus dem Internet eine manipulierte
	// Flash-Firmware für sein DVD-Navigationsgeraet, mit der sich das Anschauen
	// von DVD-Videos sowie TV-Programm (über den vorhandenen Video-Eingang)
	// auch waehrend der Fahrt freischalten lässt. Zur Installation in den
	// Flash-Speicher des Geraets (u3) brennt er das Firmware-Update auf eine CD
	// und spielt es durch Einlegen in das Geraet sowie Bestaetigung der
	// Update-Nachfrage ein (v5).

	// Ohne das Wissen des Nutzers hat der Entwickler der unautorisierten
	// TV-Freischaltungssoftware ein verstecktes schadhaftes Softwaremodul
	// implementiert. Dieses wertet permanent die aktuelle GPS-Position aus
	// (f6.2). Sobald gleichzeitig die letzten 2 (Nachkomma-)Stellen des
	// Breitengrads den Wert „13“ und die des Laengengrads den Wert „37“
	// annehmen, wird ein Angriff gestartet. Dabei werden wiederholt
	// CAN-Busnachrichten generiert, die die Lichtanlage anweisen, das Licht
	// auszuschalten (f13.15).

	// Der Schadcode ist bereits bekannt und kann anhand einer vorhandenen
	// Signatur erkannt werden (d.h. noch bevor die kritische Situation
	// eintritt). Da auch er sich mit wirksamen Rootkit-Mechanismen schuetzt,
	// kann er ebenfalls nicht automatisch entfernt werden, so dass der Fahrer
	// geeignet zu warnen ist. Die bekannte formale Tupelnotation dieses
	// Schadcodes lautet t4={v5, a1, u3, w2, {}, {f6.2, f13.15}}

	protected NavigationSoftwareAttackScenario(CarAlertCore core) {
		super(core);
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
