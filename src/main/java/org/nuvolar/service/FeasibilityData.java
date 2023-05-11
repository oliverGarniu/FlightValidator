package org.nuvolar.service;

public class FeasibilityData {

    FlightFeasibilityRule1 flightFeasibilityRule1;
    FlightFeasibilityRule2 flightFeasibilityRule2;
    FeasibilityMessage feasibilityMessage;

    public FeasibilityData(FlightFeasibilityRule1 flightFeasibilityRule1, FlightFeasibilityRule2 flightFeasibilityRule2, FeasibilityMessage feasibilityMessage) {
        this.flightFeasibilityRule1 = flightFeasibilityRule1;
        this.flightFeasibilityRule2 = flightFeasibilityRule2;
        this.feasibilityMessage = feasibilityMessage;
    }

    public void checkFeasibility(double distance) {
        boolean isRule1 = flightFeasibilityRule1.evaluateRule(distance);
        boolean isRule2 = flightFeasibilityRule2.evaluateRule(distance);
        feasibilityMessage.getFeasibilityMessage(isRule1, isRule2);
    }
}
