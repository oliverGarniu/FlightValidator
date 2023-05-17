package org.nuvolar.service;

import java.time.LocalTime;

public class FeasibilityMessage {

    FlightService flightService;
    FlightDistance flightDistance;
    FlightFeasibilityRule2 flightFeasibilityRule2;

    public FeasibilityMessage(FlightService flightService, FlightDistance flightDistance, FlightFeasibilityRule2 flightFeasibilityRule2) {
        this.flightService = flightService;
        this.flightDistance = flightDistance;
        this.flightFeasibilityRule2 = flightFeasibilityRule2;
    }

    public void getFeasibilityMessage(boolean isRule1, boolean isRule2) {

        double maxFlightRange = flightFeasibilityRule2.getMaxFlightRange();
        String flight = "Flight number " + flightService.flightNumber;
        double distance = flightDistance.getFlightDistance();
        LocalTime takeOffTime = flightService.localTime;
        LocalTime limitTakeOffTime = LocalTime.parse("20:00");

        if (distance > maxFlightRange) {
            System.out.printf("%s IS NOT FEASIBLE, flight distance: %.2f is greater than max flight range: %.2f\n",
                    flight, distance, maxFlightRange);
        }

        if (takeOffTime.isAfter(limitTakeOffTime)) {
            System.out.println("\nTake off time: " + flightService.localTime);
            System.out.println(flight + " IS NOT FEASIBLE, take off time after " + limitTakeOffTime);
        }

        String result = isRule1 && isRule2 ? flight + " IS FEASIBLE" : flight + " IS NOT FEASIBLE!!";

        System.out.println("\n" + "*".repeat(result.length()));
        System.out.println(result);
        System.out.println("*".repeat(result.length()));
    }
}
