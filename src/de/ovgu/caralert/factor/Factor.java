package de.ovgu.caralert.factor;

import de.ovgu.caralert.FactorAnalyzer;

/**
 * Represents an analyzable factor the car can capture. Used by
 * {@link FactorAnalyzer}
 */
public abstract class Factor {

    /**
     * Evaluate the current state of the factor and reduce the complex state to
     * a positive or zero number. Low numbers are representing less dangerous
     * situation, higher numbers describte dangerous situations.
     * 
     * @return A positive or zero number representing how dangerous is the state
     *         of the factor
     */
    public abstract int getWeight();
}
