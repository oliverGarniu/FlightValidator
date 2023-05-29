package org.checkmyflight.service;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RULE 2:
 * Flights taking off after 2:00 pm can only travel 9.000 km. And there shall be no take-offs after 8:00 pm.
 */
class FlightFeasibilityRule2Test {

    /*
     * Testing Rule2 for flight between Paris and Los Angeles.
     * Distance between PARIS and LOS ANGELES = 9104,34 km.
     * takeOffTime = 12:44; lateTakeoffTime = 14:00; limitTakeOffTime = 20:00;
     * (takeOffTime < lateTakeoffTime) --> maxFlightRange = 12000;
     *
     * expected result = true.
     */
    @Test
    void evaluateRuleParisLosAngeles1() {

        FlightService flightService = new FlightService();
        FlightDistance flightDistance = new FlightDistance(flightService);
        FlightFeasibilityRule1 flightFeasibilityRule1 = new FlightFeasibilityRule1(flightService);

        flightService.flightNumber = "LoLA1231";
        flightService.localTime = LocalTime.of(12, 44);
        flightService.passengers = 202;

        flightDistance.depLocation = "Paris";
        flightDistance.latitude1 = 48.8566;
        flightDistance.longitude1 = 2.3522;
        flightDistance.arrLocation = "Los Angeles";
        flightDistance.latitude2 = 33.941;
        flightDistance.longitude2 = -118.4085;

        FlightFeasibilityRule2 feasibilityRule2 = new FlightFeasibilityRule2(flightService, flightFeasibilityRule1);

        assertEquals(true, feasibilityRule2.evaluateRule(flightDistance.getDistance()));
    }

    /*
     * Testing Rule2 for flight between Paris and Los Angeles.
     * Distance between PARIS and LOS ANGELES = 9104,34 km.
     * takeOffTime = 15:44; lateTakeoffTime = 14:00; limitTakeOffTime = 20:00;
     * (takeOffTime > lateTakeoffTime) --> maxFlightRange = 9000;
     *
     * expected result = false.
     */
    @Test
    void evaluateRuleParisLosAngeles2() {

        FlightService flightService = new FlightService();
        FlightDistance flightDistance = new FlightDistance(flightService);
        FlightFeasibilityRule1 flightFeasibilityRule1 = new FlightFeasibilityRule1(flightService);

        flightService.flightNumber = "LoLA1231";
        flightService.localTime = LocalTime.of(15, 44);
        flightService.passengers = 202;

        flightDistance.depLocation = "Paris";
        flightDistance.latitude1 = 48.8566;
        flightDistance.longitude1 = 2.3522;
        flightDistance.arrLocation = "Los Angeles";
        flightDistance.latitude2 = 33.941;
        flightDistance.longitude2 = -118.4085;

        FlightFeasibilityRule2 feasibilityRule2 = new FlightFeasibilityRule2(flightService, flightFeasibilityRule1);

        assertEquals(false, feasibilityRule2.evaluateRule(flightDistance.getDistance()));
    }

    /*
     * Testing Rule2 for flight between Dublin and Barcelona.
     * Distance between DUBLIN and BARCELONA = 1485 km.
     * takeOffTime = 21:44; lateTakeoffTime = 14:00; limitTakeOffTime = 20:00;
     * (takeOffTime > limitTakeOffTime) --> maxFlightRange = 0;
     *
     * expected result = false.
     */
    @Test
    void evaluateRuleDublinBarcelona() {

        FlightService flightService = new FlightService();
        FlightDistance flightDistance = new FlightDistance(flightService);
        FlightFeasibilityRule1 flightFeasibilityRule1 = new FlightFeasibilityRule1(flightService);

        flightService.flightNumber = "LoLA1231";
        flightService.localTime = LocalTime.of(21, 44);
        flightService.passengers = 202;

        flightDistance.depLocation = "Dublin";
        flightDistance.latitude1 = 53.4264;
        flightDistance.longitude1 = -6.2499;
        flightDistance.arrLocation = "Barcelona";
        flightDistance.latitude2 = 41.2974;
        flightDistance.longitude2 = 2.0832;

        FlightFeasibilityRule2 feasibilityRule2 = new FlightFeasibilityRule2(flightService, flightFeasibilityRule1);

        assertEquals(false, feasibilityRule2.evaluateRule(flightDistance.getDistance()));
    }
}