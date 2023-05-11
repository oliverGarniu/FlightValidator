package org.nuvolar.model;

public class AirportLocation {

    private String depLocation, arrLocation;
    private double latitude1, longitude1, latitude2, longitude2;

    public AirportLocation(String depLocation, double latitude1, double longitude1, String arrLocation, double latitude2, double longitude2) {
        this.depLocation = depLocation;
        this.arrLocation = arrLocation;
        this.latitude1 = latitude1;
        this.longitude1 = longitude1;
        this.latitude2 = latitude2;
        this.longitude2 = longitude2;
    }

    @Override
    public String toString() {
        return "AirportLocation{" +
                "depLocation='" + depLocation + '\'' +
                ", arrLocation='" + arrLocation + '\'' +
                ", latitude1=" + latitude1 +
                ", longitude1=" + longitude1 +
                ", latitude2=" + latitude2 +
                ", longitude2=" + longitude2 +
                '}';
    }
}
