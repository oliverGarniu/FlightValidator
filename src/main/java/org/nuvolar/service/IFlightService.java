package org.nuvolar.service;

import java.time.LocalTime;

public interface IFlightService {

    String getFlightNumber();
    LocalTime getTakeOffTime();
    int getPassengers();
    double getDistance();
}
