package org.nuvolar.service;

import org.nuvolar.model.ArrivalLocation;
import org.nuvolar.model.DepartureLocation;
import org.nuvolar.model.FlightInfo;
import org.nuvolar.util.Haversine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

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
        while (!isCorrectFormat) {
            try {
                System.out.println("Enter take off time");
                String takeOffTime = sc.next();
                localTime = LocalTime.parse(takeOffTime);
                logger.info("Take off time: " + takeOffTime);
                isCorrectFormat = true;
            } catch (Exception e) {
                System.err.println("Time format should be HH:mm");
                System.out.println(e.getCause());
//                sc.next();
//                logger.warn("Time format should be HH:mm");
            }
        }
        return localTime;
    }

    @Override
    public int setPassengers() {

        isCorrectFormat = false;
        while (!isCorrectFormat) {
            try {
                System.out.println("Enter number of passengers");
                passengers = sc.nextInt();
                logger.info("Number of passengers: " + passengers);
                isCorrectFormat = true;
            } catch (Exception e) {
                System.err.println("You have not typed in a numerical value");
                System.out.println(e.getCause());
                sc.next();
            }
        }
        return passengers;
    }
}

//    @Override
//    public double getDistance() {
//
////        double flightDistance = 0;
//
//
//        System.out.println("Enter departure location");
//        String depLocation = sc.next();
//
//        boolean isCorrectFormat = false;
//        while (!isCorrectFormat) {
//            try {
//                System.out.println("Enter " + depLocation + "´s latitude");
//                double latitude1 = sc.nextDouble();
//                logger.info(depLocation + "´s latitude: " + latitude1);
//                isCorrectFormat = true;
//            } catch (InputMismatchException e) {
//                System.err.println("The input should be a number. If it has decimals it should be typed in with a dot, not a comma.");
//                System.out.println(e.getCause());
//                sc.next(); //******** limpiar scanner
////            } catch (NumberFormatException exception) {
////
////                System.out.println(exception.getCause());
////                System.err.println("decimals for longitude and latitude should be a dot, not a comma");
////            }
////
//////    }
//                System.out.println("Enter " + depLocation + "´s longitude");
//                double longitude1 = sc.nextDouble();
//
//                System.out.println("Enter arrival location");
//                String arrLocation = sc.next();
//                System.out.println("Enter " + arrLocation + "´s latitude");
//                double latitude2 = sc.nextDouble();
//                System.out.println("Enter " + arrLocation + "´s longitude");
//                double longitude2 = sc.nextDouble();
////
//////                isCorrectFormat = true;
////
////            FlightInfo flight = new FlightInfo(flightNumber, localTime, passengers,
////                    new DepartureLocation(depLocation, latitude1, longitude1),
////                    new ArrivalLocation(arrLocation, latitude2, longitude2));
//
////            System.out.println(flight);
////
////            double flightDistance = Haversine.getDistance(latitude1, longitude1, latitude2, longitude2);
////            System.out.printf("Distance between %s and %s = %.2f km.", depLocation, arrLocation, flightDistance);
//
//////            }
//////        }
////            return flightDistance;
////    }
////                return latitude1;
//            }
//        }
//        return 0;
//    }
//}
