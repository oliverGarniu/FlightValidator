package org.nuvolar.model;

import java.time.LocalTime;

public class FlightInfo {

    private String flightNumber;
    private LocalTime takeOffTime;
    private int passengers;
    private DepartureLocation departureLocation;
    private org.nuvolar.model.ArrivalLocation arrivalLocation;

    public FlightInfo(String flightNumber, LocalTime takeOffTime, int passengers, DepartureLocation departureLocation, ArrivalLocation arrivalLocation) {
        this.flightNumber = flightNumber;
        this.takeOffTime = takeOffTime;
        this.passengers = passengers;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
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
