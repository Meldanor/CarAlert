package de.ovgu.caralert.scenario;

import java.util.Random;

import de.ovgu.caralert.CarAlertCore;
import de.ovgu.caralert.DangerRank;
import de.ovgu.caralert.gui.Tickable;

public abstract class AbstractScenario implements Tickable {

    private CarAlertCore carAlertCore;

    private long triggerTime;

    /**
     * Instant trigger scenario
     * 
     * @param core
     */
    protected AbstractScenario(CarAlertCore core) {
        this(core, 0L);
    }

    /**
     * Trigger after the trigger time is reached
     * 
     * @param core
     * @param triggerTime
     */
    protected AbstractScenario(CarAlertCore core, long triggerTime) {
        this.carAlertCore = core;
        this.triggerTime = triggerTime;
    }

    /**
     * Trigger in a random interval time
     * 
     * @param core
     * @param startInterval
     * @param endInterval
     */
    protected AbstractScenario(CarAlertCore core, long startInterval, long endInterval) {
        this(core);
        Random rand = new Random();
        this.triggerTime = rand.nextInt((int) (endInterval - startInterval)) + startInterval;
    }

    protected CarAlertCore getCore() {
        return carAlertCore;
    }

    @Override
    public boolean update(long diff) {
        if (triggerTime <= 0) {
            return false;
        }
        triggerTime -= diff;
        if (triggerTime <= 0) {
            trigger();
            return false;
        }
        return true;
    }

    protected void trigger() {

        DangerRank danger = getCore().getFactorAnalyzer().analyze();
        switch (danger) {
            case SAVE :
                onNoRisk();
                break;
            case LOW :
                onLowRisk();
                break;
            case HIGH :
                onHighRisk();
                break;
            case SEVERE :
                onSevereRisk();
                break;
            default :
                System.err.println("Unknown danger rank!");
                break;
        }
    }

    public abstract void onNoRisk();

    public abstract void onLowRisk();

    public abstract void onHighRisk();

    public abstract void onSevereRisk();
}
