package org.checkmyflight.service;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * RULE 1:
 * The maximum flight range of the airplane is 12.000 km, however, the number of passengers reduces this flight range.
 * If the flight has more than 250 passengers then it can travel a maximum of 8.000 km.
 */
class FlightFeasibilityRule1Test {

    /*
     * Testing Rule1 for flight between London and Los Angeles.
     * Distance between LONDON and LOS ANGELES = 8774.36 km.
     * passengers = 202; numPassengers = 250;
     * (passengers < numPassengers) --> maxFlightRange = 12000;
     *
     * expected result = true.
     */
    @Test
    void evaluateRuleLondonLosAngeles1() {

        FlightService flightService = new FlightService();
        FlightDistance flightDistance = new FlightDistance(flightService);

        flightService.flightNumber = "LoLA1231";
        flightService.localTime = LocalTime.of(15, 44);
        flightService.passengers = 202;

        flightDistance.depLocation = "London";
        flightDistance.latitude1 = 51.5073;
        flightDistance.longitude1 = -0.1277;
        flightDistance.arrLocation = "Los Angeles";
        flightDistance.latitude2 = 33.941;
        flightDistance.longitude2 = -118.4085;

        FlightFeasibilityRule1 feasibilityRule1 = new FlightFeasibilityRule1(flightService);

        assertEquals(true, feasibilityRule1.evaluateRule(flightDistance.getDistance()));
    }

    /*
     * Testing Rule1 for flight between London and Los Angeles.
     * Distance between LONDON and LOS ANGELES = 8774.36 km.
     * passengers = 251; numPassengers = 250;
     * (passengers > numPassengers) --> maxFlightRange = 8000;
     *
     * expected result = false.
     */
    @Test
    void evaluateRuleLondonLosAngeles2() {

        FlightService flightService = new FlightService();
        FlightDistance flightDistance = new FlightDistance(flightService);

        flightService.flightNumber = "LoLA2348";
        flightService.localTime = LocalTime.of(15, 44);
        flightService.passengers = 251;

        flightDistance.depLocation = "London";
        flightDistance.latitude1 = 51.5073;
        flightDistance.longitude1 = -0.1277;
        flightDistance.arrLocation = "Los Angeles";
        flightDistance.latitude2 = 33.941;
        flightDistance.longitude2 = -118.4085;

        FlightFeasibilityRule1 feasibilityRule1 = new FlightFeasibilityRule1(flightService);

        assertEquals(false, feasibilityRule1.evaluateRule(flightDistance.getDistance()));
    }
}