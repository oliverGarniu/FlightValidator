package org.nuvolar;

import org.nuvolar.service.FlightService;
import org.springframework.boot.SpringApplication;

public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

        FlightService flightService = new FlightService();

        flightService.getFlightNumber();
        flightService.getTakeOffTime();
        flightService.getPassengers();
        flightService.getDistance();
    }
}
