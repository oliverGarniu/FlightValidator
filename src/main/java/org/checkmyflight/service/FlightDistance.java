package org.checkmyflight.service;

import org.checkmyflight.model.AirportLocation;
import org.checkmyflight.model.FlightInfo;
import org.checkmyflight.util.Haversine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class allows to get flight distance after setting departure and arrival information.
 */
public class FlightDistance implements IFlightDistance {

    // Logger class used to log application messages.
    private final Logger logger = LoggerFactory.getLogger(FlightService.class);

    String depLocation, arrLocation;
    double latitude1, longitude1, latitude2, longitude2, flightDistance;
    boolean isCorrectFormat = false;
    FlightService flightService;

    public FlightDistance(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public String setDepartureLocation() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter departure location");
        depLocation = sc.nextLine();
        logger.info("Departure location: " + depLocation.toUpperCase());

        return depLocation;
    }

    @Override
    public double setDepartureLatitude() {
        Scanner sc = new Scanner(System.in);
        isCorrectFormat = false;

        // Using try-catch to handle input exceptions.
        while (!isCorrectFormat) {
            try {
                System.out.println("Enter " + depLocation.toUpperCase() + " airport´s latitude");
                latitude1 = sc.nextDouble();
                logger.info(depLocation.toUpperCase() + "´s latitude: " + latitude1);
                isCorrectFormat = true;
            } catch (InputMismatchException e) {
                System.err.println("The input should be a number. If it has decimals it should be typed in with a dot, not a comma.");
                sc.next();
            }
        }

        return latitude1;
    }

    @Override
    public double setDepartureLongitude() {
        Scanner sc = new Scanner(System.in);
        isCorrectFormat = false;

        // Using try-catch to handle input exceptions.
        while (!isCorrectFormat) {
            try {
                System.out.println("Enter " + depLocation.toUpperCase() + " airport´s longitude");
                longitude1 = sc.nextDouble();
                logger.info(depLocation.toUpperCase() + "´s longitude: " + longitude1);
                isCorrectFormat = true;
            } catch (InputMismatchException e) {
                System.err.println("The input should be a number. If it has decimals it should be typed in with a dot, not a comma.");
                sc.next();
            }
        }

        return longitude1;
    }

    @Override
    public String setArrivalLocation() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter arrival location");
        arrLocation = sc.nextLine();
        logger.info("Arrival location: " + arrLocation.toUpperCase());

        return arrLocation;
    }

    @Override
    public double setArrivalLatitude() {
        Scanner sc = new Scanner(System.in);
        isCorrectFormat = false;

        // Using try-catch to handle input exceptions.
        while (!isCorrectFormat) {
            try {
                System.out.println("Enter " + arrLocation.toUpperCase() + " airport´s latitude");
                latitude2 = sc.nextDouble();
                logger.info(arrLocation.toUpperCase() + "´s latitude: " + latitude2);
                isCorrectFormat = true;
            } catch (InputMismatchException e) {
                System.err.println("The input should be a number. If it has decimals it should be typed in with a dot, not a comma.");
                sc.next();
            }
        }

        return latitude2;
    }

    @Override
    public double setArrivalLongitude() {
        Scanner sc = new Scanner(System.in);
        isCorrectFormat = false;

        // Using try-catch to handle input exceptions.
        while (!isCorrectFormat) {
            try {
                System.out.println("Enter " + arrLocation.toUpperCase() + " airport´s longitude");
                longitude2 = sc.nextDouble();
                logger.info(arrLocation.toUpperCase() + "´s longitude: " + longitude2);
                isCorrectFormat = true;
            } catch (InputMismatchException e) {
                System.err.println("The input should be a number. If it has decimals it should be typed in with a dot, not a comma.");
                sc.next();
            }
        }

        return longitude2;
    }

    @Override
    public double getDistance() {

        FlightInfo flight = new FlightInfo(flightService.flightNumber, flightService.localTime, flightService.passengers,
                new AirportLocation(depLocation, latitude1, longitude1, arrLocation, latitude2, longitude2));

        System.out.println(flight);

        flightDistance = Haversine.getDistance(latitude1, longitude1, latitude2, longitude2);
        System.out.printf("\nDistance between %s and %s = %.2f km.\n",
                depLocation.toUpperCase(), arrLocation.toUpperCase(), flightDistance);

        return flightDistance;
    }

    public double getFlightDistance() {

        return flightDistance;
    }
}
