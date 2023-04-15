package org.nuvolar.service;

import org.nuvolar.model.ArrivalLocation;
import org.nuvolar.model.DepartureLocation;
import org.nuvolar.model.FlightInfo;
import org.nuvolar.util.Haversine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.Scanner;

public class FlightService implements IFlightService {
    Scanner sc = new Scanner(System.in);

    String flightNumber;
    LocalTime localTime;
    int passengers;
//    private final Logger logger = LoggerFactory.getLogger(FlightService.class);

    @Override
    public String getFlightNumber() {
        System.out.println("Enter flight number");
        flightNumber = sc.next();
        return flightNumber;
    }

    @Override
    public LocalTime getTakeOffTime() {

        boolean isCorrectTimeFormat = false;
        while (!isCorrectTimeFormat) {
            try {
                System.out.println("Enter take off time");
                String takeOffTime = sc.next();
                localTime = LocalTime.parse(takeOffTime);
                isCorrectTimeFormat = true;
            } catch (Exception e) {
                System.err.println("Time format should be HH:mm");
            }
        }
        return localTime;
    }

    @Override
    public int getPassengers() {
        System.out.println("Enter number of passengers");
        passengers = sc.nextInt();
        return passengers;
    }

    @Override
    public double getDistance() {

        System.out.println("Enter departure location");
        String depLocation = sc.next();
        System.out.println("Enter " + depLocation + "´s latitude");
        double latitude1 = sc.nextDouble();
        System.out.println("Enter " + depLocation + "´s longitude");
        double longitude1 = sc.nextDouble();

        System.out.println("Enter arrival location");
        String arrLocation = sc.next();
        System.out.println("Enter " + arrLocation + "´s latitude");
        double latitude2 = sc.nextDouble();
        System.out.println("Enter " + arrLocation + "´s longitude");
        double longitude2 = sc.nextDouble();

        FlightInfo flight = new FlightInfo(flightNumber, localTime, passengers,
                new DepartureLocation(latitude1, longitude1),
                new ArrivalLocation(latitude2, longitude2));

        System.out.println(flight.toString());

        double flightDistance = Haversine.getDistance(latitude1, longitude1, latitude2, longitude2);
        System.out.printf("Distance between %s and %s = %.2f km.", depLocation, arrLocation, flightDistance);

        return flightDistance;
    }
}
