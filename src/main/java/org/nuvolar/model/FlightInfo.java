package org.nuvolar.model;

import java.time.LocalTime;

public class FlightInfo {

    private String flightNumber;
    private LocalTime takeOffTime;
    private int passengers;
    private DepartureLocation departureLocation;
    private ArrivalLocation arrivalLocation;

    public FlightInfo(String flightNumber, LocalTime takeOffTime, int passengers, DepartureLocation departureLocation, ArrivalLocation arrivalLocation) {
        this.flightNumber = flightNumber;
        this.takeOffTime = takeOffTime;
        this.passengers = passengers;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public LocalTime getTakeOffTime() {
        return takeOffTime;
    }

    public int getPassengers() {
        return passengers;
    }

    public DepartureLocation getDepartureLocation() {
        return departureLocation;
    }

    public ArrivalLocation getArrivalLocation() {
        return arrivalLocation;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", takeOffTime=" + takeOffTime +
                ", passengers=" + passengers +
                ", departureLocation=" + departureLocation +
                ", arrivalLocation=" + arrivalLocation +
                '}';
    }
}
