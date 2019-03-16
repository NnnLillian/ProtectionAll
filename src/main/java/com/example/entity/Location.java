package com.example.entity;

public class Location {

    private Integer location_id;
    private double longitude;
    private double latitude;

    public Location() {
    }

    public Location(Integer location_id, double longitude, double latitude) {
        this.location_id = location_id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
