package org.nuvolar.service;

public class FeasibilityMessage {

    FlightService flightService;

    public FeasibilityMessage(FlightService flightService) {
        this.flightService = flightService;
    }

    public void getFeasibilityMessage(boolean isRule1, boolean isRule2) {

        String flight = "Flight number " + flightService.flightNumber;

        String result = isRule1 && isRule2 ? flight + " IS FEASIBLE" : flight + " IS NOT FEASIBLE!!";

        System.out.println("\n" + "*".repeat(result.length()));
        System.out.println(result);
        System.out.println("*".repeat(result.length()));
    }
}
