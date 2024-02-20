package it.unibo.model.impl;

import it.unibo.model.api.Oven;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Implementation of Oven interface.
 */
public class OvenImpl implements Oven {

    private static final long COOKNING_TIME_IN_SECONDS = 5;
    private static final long COOKNING_TIME_IN_MILLISECONDS = 5000;

    private static boolean emptyOven;
    private static boolean isCooked;
    private static Timer ovenTimer;
    private static LocalTime finishBakingTime;
    private static LocalTime currentTime;

    /**
     * Cunstructor, it calls resetOven method.
     */
    public OvenImpl() {
        resetOven();
    }

    /**
     * Reset the boolenas fields.
     * emptyOven is setted to true, so the oven is empty.
     * isCooked is setted to false, so the pizza is not cooked.
     */
    public static void resetOven() {
        emptyOven = true;
        isCooked = false;
    }

    /**
     * Returns if the oven is empty.
     */
    @Override
    public boolean isOvenEmpty() {
        return emptyOven;
    }

    /**
     * It starts the baking of the pizza.
     */
    @Override
    public void bakingPizza() {
        baking();
    }

    private void baking() {
        emptyOven = false;
        ovenTimer = new Timer();
        currentTime = LocalTime.now();
        finishBakingTime = currentTime.plusSeconds(COOKNING_TIME_IN_SECONDS);
        TimerTask ovenTask = new TimerTask() {
            @Override
            public void run() {
                if (currentTime.getSecond() >= finishBakingTime.getSecond()) {
                    isCooked = true;
                }
            }
        };
        ovenTimer.scheduleAtFixedRate(ovenTask, 0, COOKNING_TIME_IN_MILLISECONDS);
    }

    /**
     * Returns true if the pizza is cooked.
     */
    @Override
    public boolean isPizzaCooked() {
        return isCooked;
    }
}
