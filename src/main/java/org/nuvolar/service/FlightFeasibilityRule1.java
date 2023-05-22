package org.nuvolar.service;

/**
 * This class checks the feasibility of flight after evaluating rule 1.
 */
public class FlightFeasibilityRule1 implements IFlightFeasibility {

    double maxFlightRange = 12000;
    final int numPassengers = 250;
    int passengers;
    String flight;

    FlightService flightService;

    public FlightFeasibilityRule1(FlightService flightService) {
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
    public boolean evaluateRule(double flightDistance) {

        passengers = flightService.passengers;
        flight = "Flight number " + flightService.flightNumber;

        if (passengers > numPassengers) {
            maxFlightRange = 8000;
        }

        return flightDistance <= maxFlightRange;
    }

    public double getMaxFlightRange() {

        return maxFlightRange;
    }
}
