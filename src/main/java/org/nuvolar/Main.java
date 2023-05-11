package org.nuvolar;

import org.nuvolar.service.*;
import org.springframework.boot.SpringApplication;

public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

        FlightService flightService = new FlightService();
        FlightFeasibilityRule1 flightFeasibilityRule1 = new FlightFeasibilityRule1(flightService);
        FlightFeasibilityRule2 flightFeasibilityRule2 = new FlightFeasibilityRule2(flightService);
        FeasibilityMessage feasibilityMessage = new FeasibilityMessage(flightService, flightFeasibilityRule1, flightFeasibilityRule2);
        FlightDistance flightDistance = new FlightDistance(flightService);
        FeasibilityData feasibilityData = new FeasibilityData(flightFeasibilityRule1, flightFeasibilityRule2, feasibilityMessage);

        double distance = new FlightData(flightService, flightDistance).SetFlightInfo();

        feasibilityData.checkFeasibility(distance);
    }
}
