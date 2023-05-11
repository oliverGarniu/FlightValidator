package org.nuvolar.service;

public class FeasibilityMessage {

    FlightService flightService;
    FlightFeasibilityRule1 feasibilityRule1;
    FlightFeasibilityRule2 feasibilityRule2;

    public FeasibilityMessage(FlightService flightService, FlightFeasibilityRule1 feasibilityRule1, FlightFeasibilityRule2 feasibilityRule2) {
        this.flightService = flightService;
        this.feasibilityRule1 = feasibilityRule1;
        this.feasibilityRule2 = feasibilityRule2;
    }

    public void checkFeasibility(double flightDistance) {

        String flight = "Flight number " + flightService.flightNumber;

        boolean isRule1 = feasibilityRule1.evaluateRule(flightDistance);
        if (!isRule1) {
            System.out.printf("%s IS NOT FEASIBLE, flight distance: %.2f is greater than max flight range: %.2f",
                    flight, flightDistance, feasibilityRule1.maxFlightRange);
        }

        boolean isRule2 = feasibilityRule2.evaluateRule(flightDistance);
        if (!isRule2) {
            System.out.println("\nTake off time: " + flightService.localTime);
            System.out.println(flight + " IS NOT FEASIBLE, take off time after " + feasibilityRule2.limitTakeOffTime);
        }

        String result = isRule1 && isRule2 ? flight + " IS FEASIBLE" : flight + " IS NOT FEASIBLE!!";

        System.out.println("\n" + "*".repeat(result.length()));
        System.out.println(result);
        System.out.println("*".repeat(result.length()));
    }
}
