package org.checkmyflight.Main;

import org.checkmyflight.service.FeasibilityMessage;
import org.checkmyflight.service.FlightFeasibilityRule1;
import org.checkmyflight.service.FlightFeasibilityRule2;

public class FeasibilityData {

    FlightFeasibilityRule1 flightFeasibilityRule1;
    FlightFeasibilityRule2 flightFeasibilityRule2;
    FeasibilityMessage feasibilityMessage;

    public FeasibilityData(FlightFeasibilityRule1 flightFeasibilityRule1, FlightFeasibilityRule2 flightFeasibilityRule2, FeasibilityMessage feasibilityMessage) {
        this.flightFeasibilityRule1 = flightFeasibilityRule1;
        this.flightFeasibilityRule2 = flightFeasibilityRule2;
        this.feasibilityMessage = feasibilityMessage;
    }

    /**
     * This method allows to check if a flight is feasible by introducing the distance as parameter.
     *
     * @param distance
     */
    public void checkFeasibility(double distance) {
        boolean isRule1 = flightFeasibilityRule1.evaluateRule(distance);
        boolean isRule2 = flightFeasibilityRule2.evaluateRule(distance);
        feasibilityMessage.getFeasibilityMessage(isRule1, isRule2);
    }
}
