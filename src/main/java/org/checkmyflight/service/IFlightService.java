package org.checkmyflight.service;

import java.time.LocalTime;

public interface IFlightService {

    String setFlightNumber();
    LocalTime setTakeOffTime();
    int setPassengers();
}
