package org.nuvolar.service;

import java.time.LocalTime;

public class FlightFeasibility implements IFlightFeasibility {

    private double maxFlightRange;
    private final int numPassengers = 250;
    private int passengers;

    FlightService flightService;

    public FlightFeasibility(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * rule 1: The maximum flight range of the airplane is 12.000 km, however,
     * the number of passengers reduces this flight range. If the flight has
     * more than 250 passengers then it can travel a maximum of 8.000 km.
     *
     * @return boolean
     */
    @Override
    public boolean rule1(double flightDistance) {

        maxFlightRange = 12000;
        passengers = flightService.passengers;

        if (passengers > numPassengers) {
            maxFlightRange = 8000;
        }

        return flightDistance <= maxFlightRange ? true : false;
    }

    /**
     * rule 2: Flights taking off after 2:00 pm can only travel 9.000 km.
     * And there shall be no take-offs after 8:00 pm.
     *
     * @return boolean
     */
    @Override
    public boolean rule2(double flightDistance) {

        LocalTime time = LocalTime.parse("14:00");
        LocalTime limitTakeOffTime = LocalTime.parse("20:00");
        LocalTime takeOffTime = flightService.localTime;
        boolean isTakeOffTimeAfterLimit = false;

        if (takeOffTime.isAfter(time) && passengers < numPassengers) {
            maxFlightRange = 9000;
        }

        if (takeOffTime.isAfter(limitTakeOffTime)) {
            isTakeOffTimeAfterLimit = true;
        }

        return flightDistance <= maxFlightRange && !isTakeOffTimeAfterLimit ? true : false;
    }

    public void checkFeasibility(double flightDistance) {

        String flight = "Flight number " + flightService.flightNumber;
        boolean isRule1 = rule1(flightDistance);
        boolean isRule2 = rule2(flightDistance);

        String result = isRule1 && isRule2 ? flight + " IS FEASIBLE" : flight + " IS NOT FEASIBLE!!";

        System.out.println("\n" + "*".repeat(result.length()));
        System.out.println(result);
        System.out.println("*".repeat(result.length()));
    }
}
