package org.nuvolar.model;

public class DepartureLocation {

    private String depLocation;
    private double latitude1;
    private double longitude1;

    public DepartureLocation(String depLocation, double latitude1, double longitude1) {
        this.depLocation = depLocation;
        this.latitude1 = latitude1;
        this.longitude1 = longitude1;
    }

    //    public double getLatitude1() {
//        return latitude1;
//    }
//
//    public void setLatitude1(double latitude1) {
//        this.latitude1 = latitude1;
//    }
//
//    public double getLongitude1() {
//        return longitude1;
//    }
//
//    public void setLongitude1(double longitude1) {
//        this.longitude1 = longitude1;
//    }

    @Override
    public String toString() {
        return "DepartureLocation{" +
                "depLocation='" + depLocation + '\'' +
                ", latitude1=" + latitude1 +
                ", longitude1=" + longitude1 +
                '}';
    }
}
