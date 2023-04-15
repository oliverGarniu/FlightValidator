package org.nuvolar.model;

public class ArrivalLocation {

    private String arrLocation;
    private double latitude2;
    private double longitude2;

    public ArrivalLocation(String arrLocation, double latitude2, double longitude2) {
        this.arrLocation = arrLocation;
        this.latitude2 = latitude2;
        this.longitude2 = longitude2;
    }

    @Override
    public String toString() {
        return "ArrivalLocation{" +
                "arrLocation='" + arrLocation + '\'' +
                ", latitude2=" + latitude2 +
                ", longitude2=" + longitude2 +
                '}';
    }
}
