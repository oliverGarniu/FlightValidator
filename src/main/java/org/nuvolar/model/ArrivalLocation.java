package org.nuvolar.model;

public class ArrivalLocation {

    private double latitude2;
    private double longitude2;

    public ArrivalLocation(double latitude2, double longitude2) {
        this.latitude2 = latitude2;
        this.longitude2 = longitude2;
    }

    @Override
    public String toString() {
        return "ArrivalLocation{" +
                "latitude2=" + latitude2 +
                ", longitude2=" + longitude2 +
                '}';
    }
}
