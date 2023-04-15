package org.nuvolar.service;

import org.nuvolar.model.ArrivalLocation;
import org.nuvolar.model.DepartureLocation;

import java.time.LocalTime;

public interface IFlightService {

String getFlightNumber();
LocalTime getTakeOffTime();
int getPassengers();
//DepartureLocation getDepartureLocation();
//ArrivalLocation getArrivalLocation();
double getDistance();
}
