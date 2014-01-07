package de.ovgu.caralert;

/**
 * How dangerous is the current situation is described by one of this enum
 * constants. <br>
 * {@link #SAVE} <br>
 * {@link #LOW} <br>
 * {@link #HIGH} <br>
 * {@link #SEVERE}
 * 
 */
public enum DangerRank {
    // @formatter:off
    /**
     * There is no danger
     */
    SAVE,
    /**
     * We expect a low danger
     */
    LOW,
    /**
     * We expect high danger
     */
    HIGH,
    /**
     * We expect high danger in the next few moments
     */
    SEVERE;
    // @formatter:on
}
