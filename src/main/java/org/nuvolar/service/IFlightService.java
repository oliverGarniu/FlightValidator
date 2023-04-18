package org.nuvolar.service;

import java.time.LocalTime;

public interface IFlightService {

    String setFlightNumber();
    LocalTime setTakeOffTime();
    int setPassengers();
//    double getDistance();
}
