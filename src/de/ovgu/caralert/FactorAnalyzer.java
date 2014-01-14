package de.ovgu.caralert;

import java.util.HashMap;
import java.util.Map;

import de.ovgu.caralert.factor.Factor;

/**
 * Class to cover and evaluate the different factors (see {@link Factor} ) and
 * categorize the danger as an {@link DangerRank} <br>
 * Sample implementation is the {@link SimpleFactorAnalyzer} without any own
 * weighting of the factors.
 */
public abstract class FactorAnalyzer {

	/**
	 * Every registred factor to the analyzer
	 */
	private Map<String, Factor> factorMap = new HashMap<String, Factor>();

	/**
	 * Register a {@link Factor} to the analyzer. Only registered are used for
	 * evaluation of the current situation.
	 * 
	 * @param factorName
	 *            The unique factor name, case sensitive!
	 * @param factor
	 *            The factor itself
	 */
	public void registerFactor(String factorName, Factor factor) {
		this.factorMap.put(factorName, factor);
	}

	/**
	 * Register a {@link Factor} to the analyzer. Only registered are used for
	 * evaluation of the current situation. The name of the factor is the name
	 * of the class
	 * 
	 * @param factor
	 *            The factor itself
	 */
	public void registerFactor(Factor factor) {
		this.registerFactor(factor.getClass().getName(), factor);
	}

	/**
	 * Start the analyzation of the current situation. Calls the method
	 * {@link #onAnalyze(Map)}
	 * 
	 * @return The current situation analyzed and reduced in this category
	 */
	public DangerRank analyze() {
		return onAnalyze(factorMap);
	}

	/**
	 * This method must analyze the given factors and return a result of the
	 * current situation using the {@link DangerRank}
	 * 
	 * @param factorMap
	 *            The registred factors
	 * @return See {@link DangerRank} for possible results
	 */
	protected abstract DangerRank onAnalyze(Map<String, Factor> factorMap);

}
