package org.nuvolar.service;

import java.time.LocalTime;

public class FlightFeasibility implements IFlightFeasibility {

    double maxFlightRange;
    final int numPassengers = 250;
    int passengers;
    String flight;
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
    public boolean evaluateRule1(double flightDistance) {

        maxFlightRange = 12000;
        passengers = flightService.passengers;
        flight = "Flight number " + flightService.flightNumber;

        if (passengers > numPassengers) {
            maxFlightRange = 8000;
        }

        if (flightDistance > maxFlightRange) {
            System.out.printf("%s IS NOT FEASIBLE, flight distance: %.2f is greater than max flight range: %.2f",
                    flight, flightDistance, maxFlightRange);
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
    public boolean evaluateRule2(double flightDistance) {

        flight = "Flight number " + flightService.flightNumber;
        LocalTime time = LocalTime.parse("14:00");
        LocalTime limitTakeOffTime = LocalTime.parse("20:00");
        LocalTime takeOffTime = flightService.localTime;
        boolean isTakeOffTimeAfterLimit = false;

        if (takeOffTime.isAfter(time) && passengers < numPassengers) {
            maxFlightRange = 9000;
        }

        if (takeOffTime.isAfter(limitTakeOffTime)) {
            System.out.println("\nTake off time: " + takeOffTime);
            System.out.println(flight + " IS NOT FEASIBLE, take off time after " + limitTakeOffTime);
            isTakeOffTimeAfterLimit = true;
        }

        return flightDistance <= maxFlightRange && !isTakeOffTimeAfterLimit ? true : false;
    }

    public void checkFeasibility(double flightDistance) {

        boolean isRule1 = evaluateRule1(flightDistance);
        boolean isRule2 = evaluateRule2(flightDistance);

        String result = isRule1 && isRule2 ? flight + " IS FEASIBLE" : flight + " IS NOT FEASIBLE!!";

        System.out.println("\n" + "*".repeat(result.length()));
        System.out.println(result);
        System.out.println("*".repeat(result.length()));
    }
}
