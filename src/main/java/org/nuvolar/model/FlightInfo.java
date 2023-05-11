package org.nuvolar.model;

import java.time.LocalTime;

public class FlightInfo {

    private String flightNumber;
    private LocalTime takeOffTime;
    private int passengers;
    private AirportLocation airportLocation;

    public FlightInfo(String flightNumber, LocalTime takeOffTime, int passengers, AirportLocation airportLocation) {
        this.flightNumber = flightNumber;
        this.takeOffTime = takeOffTime;
        this.passengers = passengers;
        this.airportLocation = airportLocation;
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "flightNumber='" + flightNumber + '\'' +
                ", takeOffTime=" + takeOffTime +
                ", passengers=" + passengers +
                ", airportLocation=" + airportLocation +
                '}';
    }
}
