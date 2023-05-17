package org.nuvolar.Main;

import org.nuvolar.service.FlightDistance;
import org.nuvolar.service.FlightService;

public class FlightData {
    FlightService flightService;
    FlightDistance flightDistance;

    public FlightData(FlightService flightService, FlightDistance flightDistance) {
        this.flightService = flightService;
        this.flightDistance = flightDistance;
    }

    public double setFlightInfo() {

        flightService.setFlightNumber();
        flightService.setTakeOffTime();
        flightService.setPassengers();

        flightDistance.setDepartureLocation();
        flightDistance.setDepartureLatitude();
        flightDistance.setDepartureLongitude();
        flightDistance.setArrivalLocation();
        flightDistance.setArrivalLatitude();
        flightDistance.setArrivalLongitude();

        return flightDistance.getDistance();
    }
}
