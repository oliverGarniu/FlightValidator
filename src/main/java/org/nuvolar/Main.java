package org.nuvolar;

import org.nuvolar.model.FlightInfo;
import org.nuvolar.service.FlightFeasibility;
import org.nuvolar.service.FlightService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

        FlightService flightService = new FlightService();
        FlightFeasibility flightFeasibility = new FlightFeasibility(flightService);

        flightService.setFlightNumber();
        flightService.setTakeOffTime();
        flightService.setPassengers();
        double distance = flightService.getDistance();

        flightFeasibility.checkFeasibility(distance);
    }
}
