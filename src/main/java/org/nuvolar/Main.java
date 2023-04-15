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

//        Scanner sc = new Scanner(System.in);
//
////        DepartureLocation departureLocation;
////        ArrivalLocation arrivalLocation;
//
//        System.out.println("Enter flight number");
//        String flightNumber = sc.next();
//        System.out.println("Enter take off time");
//        String takeOffTime = sc.next();
//        LocalTime localTime = LocalTime.parse(takeOffTime);
//        System.out.println("Enter number of passengers");
//        int passengers = sc.nextInt();
//        System.out.println("Enter departure location");
//        String depLocation = sc.next();
//        System.out.println("Enter " + depLocation + "´s latitude");
//        double latitude1 = sc.nextDouble();
//        System.out.println("Enter " + depLocation + "´s longitude");
//        double longitude1 = sc.nextDouble();
//        System.out.println("Enter arrival location");
//        String arrLocation = sc.next();
//        System.out.println("Enter " + arrLocation + "´s latitude");
//        double latitude2 = sc.nextDouble();
//        System.out.println("Enter " + arrLocation + "´s longitude");
//        double longitude2 = sc.nextDouble();
//
//        Flight flight = new Flight(flightNumber, localTime, passengers,
//                new DepartureLocation(latitude1, longitude1),
//                new ArrivalLocation(latitude2, longitude2));
//
//        System.out.println(flight.toString());
//
//        System.out.println(Haversine.getDistance(latitude1, longitude1, latitude2, longitude2));
}
