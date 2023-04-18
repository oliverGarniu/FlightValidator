package org.nuvolar.service;

import org.nuvolar.model.ArrivalLocation;
import org.nuvolar.model.DepartureLocation;
import org.nuvolar.model.FlightInfo;
import org.nuvolar.service.FlightService;
import org.nuvolar.util.Haversine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlightDistance implements IFlightDistance {

    //    //    public double getDistance() {
////
//////        double flightDistance = 0;
////
////
//
//////        boolean isCorrectFormat = false;
//////        while (!isCorrectFormat) {
//////            try {
////
////        System.out.println("Enter " + depLocation + "´s longitude");
////        double longitude1 = sc.nextDouble();
////
////        System.out.println("Enter arrival location");
////        String arrLocation = sc.next();
////        System.out.println("Enter " + arrLocation + "´s latitude");
////        double latitude2 = sc.nextDouble();
////        System.out.println("Enter " + arrLocation + "´s longitude");
////        double longitude2 = sc.nextDouble();
////
//////                isCorrectFormat = true;
////
////        FlightInfo flight = new FlightInfo(flightNumber, localTime, passengers,
////                new DepartureLocation(depLocation, latitude1, longitude1),
////                new ArrivalLocation(arrLocation, latitude2, longitude2));
////
////        System.out.println(flight);
////
////        double flightDistance = Haversine.getDistance(latitude1, longitude1, latitude2, longitude2);
////        System.out.printf("Distance between %s and %s = %.2f km.", depLocation, arrLocation, flightDistance);
////
//////            }
//////        }
////        return flightDistance;
////    }
//
////    Scanner sc = new Scanner(System.in);
    private final Logger logger = LoggerFactory.getLogger(FlightService.class);
    String depLocation, arrLocation;
    double latitude1, longitude1, latitude2, longitude2;
    boolean isCorrectFormat = false;
    FlightService flightService;

    public FlightDistance(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public String setDepartureLocation() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter departure location");
        depLocation = sc.next();

        logger.info("Departure location: " + depLocation);

        return depLocation;
    }

    @Override
    public double setDepartureLatitude() {
        Scanner sc = new Scanner(System.in);

        isCorrectFormat = false;
        while (!isCorrectFormat) {
            try {
                System.out.println("Enter " + depLocation + "´s latitude");
                latitude1 = sc.nextDouble();
                logger.info(depLocation + "´s latitude: " + latitude1);
                isCorrectFormat = true;
            } catch (InputMismatchException e) {
                System.err.println("The input should be a number. If it has decimals it should be typed in with a dot, not a comma.");
                System.out.println(e.getCause());
                sc.next();
////            } catch (NumberFormatException exception) {
////                System.out.println(exception.getCause());
////                System.err.println("decimals for longitude and latitude should be a dot, not a comma");
////            }

            }

        }
        return latitude1;
    }


    @Override
    public double setDepartureLongitude() {
        Scanner sc = new Scanner(System.in);

        isCorrectFormat = false;
        while (!isCorrectFormat) {
            try {
                System.out.println("Enter " + depLocation + "´s longitude");
                longitude1 = sc.nextDouble();
                logger.info(depLocation + "´s longitude: " + longitude1);
                isCorrectFormat = true;
            } catch (InputMismatchException e) {
                System.err.println("The input should be a number. If it has decimals it should be typed in with a dot, not a comma.");
                System.out.println(e.getCause());
                sc.next();
////            } catch (NumberFormatException exception) {
////                System.out.println(exception.getCause());
////                System.err.println("decimals for longitude and latitude should be a dot, not a comma");
////            }

            }

        }
        return longitude1;
    }

    @Override
    public String setArrivalLocation() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter arrival location");
        arrLocation = sc.next();

        logger.info("Arrival location: " + arrLocation);

        return arrLocation;
    }

    @Override
    public double setArrivalLatitude() {
        Scanner sc = new Scanner(System.in);

        isCorrectFormat = false;
        while (!isCorrectFormat) {
            try {
                System.out.println("Enter " + arrLocation + "´s latitude");
                latitude2 = sc.nextDouble();
                logger.info(arrLocation + "´s latitude: " + latitude2);
                isCorrectFormat = true;
            } catch (InputMismatchException e) {
                System.err.println("The input should be a number. If it has decimals it should be typed in with a dot, not a comma.");
                System.out.println(e.getCause());
                sc.next();
//            } catch (NumberFormatException exception) {
//                System.out.println(exception.getCause());
//                System.err.println("decimals for longitude and latitude should be a dot, not a comma");
//            }

            }

        }
        return latitude2;
    }

    @Override
    public double setArrivalLongitude() {
        Scanner sc = new Scanner(System.in);

        isCorrectFormat = false;
        while (!isCorrectFormat) {
            try {
                System.out.println("Enter " + arrLocation + "´s longitude");
                longitude2 = sc.nextDouble();
                logger.info(arrLocation + "´s longitude: " + longitude2);
                isCorrectFormat = true;
            } catch (InputMismatchException e) {
                System.err.println("The input should be a number. If it has decimals it should be typed in with a dot, not a comma.");
                System.out.println(e.getCause());
                sc.next();
//            } catch (NumberFormatException exception) {
//                System.out.println(exception.getCause());
//                System.err.println("decimals for longitude and latitude should be a dot, not a comma");
//            }

            }

        }
        return longitude2;
    }

        @Override
        public double getDistance () {

//        FlightService flightService = null;
//        String flightNumber = flightService.setFlightNumber();
            FlightInfo flight = new FlightInfo(flightService.flightNumber, flightService.localTime, flightService.passengers,
                new DepartureLocation(depLocation, latitude1, longitude1),
                new ArrivalLocation(arrLocation, latitude2, longitude2));

        System.out.println(flight);

        double flightDistance = Haversine.getDistance(latitude1, longitude1, latitude2, longitude2);
        System.out.printf("Distance between %s and %s = %.2f km.", depLocation, arrLocation, flightDistance);

//            }
//        }
        return flightDistance;
        }
}
