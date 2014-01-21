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

/**
 * Class to store the settings that are made by the user
 * 
 */

public class CarAlertSettings {
	BrightnessFactor brightnessFactor;
	CarClassFactor carClassFactor;
	CarStateFactor carStateFactor;
	DriverConditionFactor driverConditionFactor;
	EnvironmentFactor environmentFactor;
	LoadFactor loadFactor;
	PassangerFactor passangerFactor;
	PlaceKnowledgeFactor placeKnowledgeFactor;
	RouteDurationFactor routeDurationFactor;
	SignFactor signFactor;
	TemperatureFactor temperatureFactor;
	TimeFactor timeFactor;
	TrafficIntensityFactor trafficIntensityFactor;
	VolumneFactor volumneFactor;
	WeatherFactor weatherFactor;
}
