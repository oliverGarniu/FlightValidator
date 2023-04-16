package org.nuvolar;

import org.nuvolar.service.FlightFeasibility;
import org.nuvolar.service.FlightService;
import org.springframework.boot.SpringApplication;

public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

        FlightService flightService = new FlightService();
        FlightFeasibility flightFeasibility = new FlightFeasibility();

        flightService.getFlightNumber();
        flightService.getTakeOffTime();
        flightService.getPassengers();
        double distance = flightService.getDistance();

        flightFeasibility.checkFeasibility(distance);
    }
}
