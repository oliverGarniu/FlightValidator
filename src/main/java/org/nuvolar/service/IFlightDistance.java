package org.nuvolar.service;

public interface IFlightDistance {
    String setDepartureLocation();
    double setDepartureLatitude();
    double setDepartureLongitude();
    String setArrivalLocation();
    double setArrivalLatitude();
    double setArrivalLongitude();
    double getDistance();
}
