package com.example.entity;

public class Platoon {
    private Integer platoon_id;
    private String  platoon_name;

    public Platoon() {
    }

    public Platoon(Integer platoon_id, String platoon_name) {
        this.platoon_id = platoon_id;
        this.platoon_name = platoon_name;
    }

    public Integer getPlatoon_id() {
        return platoon_id;
    }

    public void setPlatoon_id(Integer platoon_id) {
        this.platoon_id = platoon_id;
    }

    public String getPlatoon_name() {
        return platoon_name;
    }

    public void setPlatoon_name(String platoon_name) {
        this.platoon_name = platoon_name;
    }
}
