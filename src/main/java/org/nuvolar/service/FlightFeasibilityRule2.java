package org.nuvolar.service;

import java.time.LocalTime;

public class FlightFeasibilityRule2 implements IFlightFeasibility {

    double maxFlightRange;
    final int numPassengers = 250;
    int passengers;
    String flight;
    LocalTime takeOffTime;
    LocalTime time = LocalTime.parse("14:00");
    LocalTime limitTakeOffTime = LocalTime.parse("20:00");

    FlightService flightService;

    public FlightFeasibilityRule2(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * rule 2: Flights taking off after 2:00 pm can only travel 9.000 km.
     * And there shall be no take-offs after 8:00 pm.
     *
     * @return boolean
     */
    @Override
    public boolean evaluateRule(double flightDistance) {

        passengers = flightService.passengers;
        flight = "Flight number " + flightService.flightNumber;
        takeOffTime = flightService.localTime;
        boolean isTakeOffTimeAfterLimit = false;

        if (takeOffTime.isAfter(time) && passengers < numPassengers) {
            maxFlightRange = 9000;
        }

        if (flightDistance > maxFlightRange) {
            System.out.printf("%s IS NOT FEASIBLE, flight distance: %.2f is greater than max flight range: %.2f\n",
                    flight, flightDistance, maxFlightRange);
        }

        if (takeOffTime.isAfter(limitTakeOffTime)) {
            System.out.println("\nTake off time: " + flightService.localTime);
            System.out.println(flight + " IS NOT FEASIBLE, take off time after " + limitTakeOffTime);
            isTakeOffTimeAfterLimit = true;
        }

        return flightDistance <= maxFlightRange && !isTakeOffTimeAfterLimit;
    }
}
