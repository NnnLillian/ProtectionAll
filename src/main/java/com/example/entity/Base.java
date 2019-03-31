package com.example.entity;

public class Base {
    private Integer base_id;
    private String base_name;
    private Integer location_id;

    public Base(){
    }

    public Base(Integer base_id, String base_name, Integer location_id) {
        this.base_id = base_id;
        this.base_name = base_name;
        this.location_id = location_id;
    }

    public Integer getBase_id() {
        return base_id;
    }

    public void setBase_id(Integer base_id) {
        this.base_id = base_id;
    }

    public String getBase_name() {
        return base_name;
    }

    public void setBase_name(String base_name) {
        this.base_name = base_name;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }
}
