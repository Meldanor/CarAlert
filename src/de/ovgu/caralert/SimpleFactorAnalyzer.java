package de.ovgu.caralert;

import java.util.Collection;
import java.util.Map;

import de.ovgu.caralert.factor.Factor;

/**
 * Creates the sum of all factor weights and rank them via the sum
 */
public class SimpleFactorAnalyzer extends FactorAnalyzer {

    private static final int BORDER_SAVE = 5;
    private static final int BORDER_LOW = 19;
    private static final int BORDER_HIGH = 34;
    private static final int BORDER_SEVERE = 52;

    @Override
    protected DangerRank onAnalyze(Map<String, Factor> factorMap) {
        int sum = 0;
        Collection<Factor> factors = factorMap.values();
        for (Factor factor : factors) {
            sum += factor.getWeight();
        }

        if (sum <= BORDER_SAVE)
            return DangerRank.SAVE;
        else if (sum <= BORDER_LOW)
            return DangerRank.LOW;
        else if (sum <= BORDER_HIGH)
            return DangerRank.HIGH;
        else if (sum <= BORDER_SEVERE)
            return DangerRank.SEVERE;
        else
            return DangerRank.SEVERE;

    }

}
