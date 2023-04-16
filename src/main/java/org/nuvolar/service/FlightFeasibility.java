package org.nuvolar.service;

import org.nuvolar.model.FlightInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;

public class FlightFeasibility implements IFlightFeasibility {

    //TODO
    @Autowired
    FlightInfo flightInfo;

    /**
     * rule 1: The maximum flight range of the airplane is 12.000 km, however,
     * the number of passengers reduces this flight range. If the flight has
     * more than 250 passengers then it can travel a maximum of 8.000 km.
     *
     * @return boolean
     */
    @Override
    public boolean rule1(double flightDistance) {

        int maxFlightRange = 12000;
        final int numPassengers = 250;
        int passengers = flightInfo.getPassengers();

        if (passengers > numPassengers) {
            maxFlightRange = 8000;
        }

        return flightDistance <= maxFlightRange ? true : false;
    }

    /**
     * rule 2: Flights taking off after 2:00 pm can only travel 9.000 km.
     * And there shall be no take-offs after 8:00 pm.
     *
     * @return boolean
     */
    @Override
    public boolean rule2(double flightDistance) {

        int maxFlightRange = 12000;
        LocalTime time = LocalTime.parse("14:00");
        LocalTime limitTakeOffTime = LocalTime.parse("20:00");
        LocalTime takeOffTime = flightInfo.getTakeOffTime();
        boolean isTakeOffTimeAfterLimit = false;

        if (takeOffTime.isAfter(time)) {
            maxFlightRange = 9000;
        }

        if (takeOffTime.isAfter(limitTakeOffTime)) {
            isTakeOffTimeAfterLimit = true;
        }

        return flightDistance <= maxFlightRange && !isTakeOffTimeAfterLimit ? true : false;
    }

    public String checkFeasibility(double flightDistance) {

        String flight = "Flight number " + flightInfo.getFlightNumber();
        boolean isRule1 = rule1(flightDistance);
        boolean isRule2 = rule2(flightDistance);

        return isRule1 && isRule2 ? flight + " IS FEASIBLE" : flight + " IS NOT FEASIBLE!!";
    }
}
