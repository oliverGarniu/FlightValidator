package org.nuvolar.util;

/**
 * Haversine formula is used to calculate the distance between airports,
 * given the latitudes and longitudes from the departure and arrival airports.
 */
public class Haversine {

    static final int R = 6371;

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

    public static double getDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
        double latDistance = toRad(latitude2 - latitude1);
        double lonDistance = toRad(longitude2 - longitude1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(toRad(latitude1)) *
                Math.cos(toRad(latitude2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
