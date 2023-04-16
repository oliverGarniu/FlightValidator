package org.nuvolar.service;

public interface IFlightFeasibility {

    /*
     * rule 1: - The maximum flight range of the airplane is 12.000 km, however,
     *           the number of passengers reduces this flight range. If the flight has
     *           more than 250 passengers then it can travel a maximum of 8.000 km.
     *
     * rule 2: - Flights taking off after 2:00 pm can only travel 9.000 km.
     *         - And there shall be no take-offs after 8:00 pm.
     */

    boolean rule1(double flightDistance);
    boolean rule2(double flightDistance);
}
