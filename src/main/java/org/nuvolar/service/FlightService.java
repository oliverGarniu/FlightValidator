package org.nuvolar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.Scanner;

/**
 * This class allows to set the flight number, take off time and number of passengers.
 */
public class FlightService implements IFlightService {
    Scanner sc = new Scanner(System.in);
    private final Logger logger = LoggerFactory.getLogger(FlightService.class);

    String flightNumber;
    LocalTime localTime;
    int passengers;
    boolean isCorrectFormat;

    @Override
    public String setFlightNumber() {

        System.out.println("Enter flight number");
        flightNumber = sc.next();
        logger.info("Flight number: " + flightNumber);

        return flightNumber;
    }

    @Override
    public LocalTime setTakeOffTime() {

        isCorrectFormat = false;

        // Using try-catch to handle input exceptions.
        while (!isCorrectFormat) {
            try {
                System.out.println("Enter take off time");
                String takeOffTime = sc.next();
                localTime = LocalTime.parse(takeOffTime);
                logger.info("Take off time: " + takeOffTime);
                isCorrectFormat = true;
            } catch (Exception e) {
                // If an incorrect time format is entered then an error message will be displayed.
                System.err.println("Time format should be HH:mm");
            }
        }

        return localTime;
    }

    @Override
    public int setPassengers() {

        isCorrectFormat = false;

        // Using try-catch to handle input exceptions.
        while (!isCorrectFormat) {
            try {
                System.out.println("Enter number of passengers");
                passengers = sc.nextInt();
                logger.info("Number of passengers: " + passengers);
                isCorrectFormat = true;
            } catch (Exception e) {
                System.err.println("You have not typed in a numerical value");
                sc.next();
            }
        }

        return passengers;
    }
}

