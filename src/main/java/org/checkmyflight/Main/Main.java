package org.checkmyflight.Main;

import org.checkmyflight.service.*;
import org.springframework.boot.SpringApplication;

public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

        FlightService flightService = new FlightService();
        FlightDistance flightDistance = new FlightDistance(flightService);
        FlightFeasibilityRule1 flightFeasibilityRule1 = new FlightFeasibilityRule1(flightService);
        FlightFeasibilityRule2 flightFeasibilityRule2 = new FlightFeasibilityRule2(flightService, flightFeasibilityRule1);
        FeasibilityMessage feasibilityMessage = new FeasibilityMessage(flightService, flightDistance, flightFeasibilityRule2);
        FeasibilityData feasibilityData = new FeasibilityData(flightFeasibilityRule1, flightFeasibilityRule2, feasibilityMessage);

        double distance = new FlightData(flightService, flightDistance).setFlightInfo();

        feasibilityData.checkFeasibility(distance);
    }
}
