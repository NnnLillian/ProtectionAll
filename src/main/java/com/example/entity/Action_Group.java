package com.example.entity;

public class Action_Group {
    private Integer action_group_id;
    private String action_group_name;
    private Integer location_id;
    private double longitude;
    private double latitude;
    private String location;

    public Action_Group(){}

    public Action_Group(Integer action_group_id, String action_group_name, Integer location_id, double longitude, double latitude) {
        this.action_group_id = action_group_id;
        this.action_group_name = action_group_name;
        this.location_id = location_id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.location = "经度："+longitude+", 纬度："+latitude;
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

    public Integer getAction_group_id() {
        return action_group_id;
    }

    public void setAction_group_id(Integer action_group_id) {
        this.action_group_id = action_group_id;
    }

    public String getAction_group_name() {
        return action_group_name;
    }

    public void setAction_group_name(String action_group_name) {
        this.action_group_name = action_group_name;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
