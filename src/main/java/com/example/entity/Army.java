package com.example.entity;

import lombok.Data;

@Data
public class Army {

    private Integer army_id;
    private Integer platoon_id;
    private String army_name;
    private Integer army_people;

    public Army() {
    }

    public Army(Integer army_id, Integer platoon_id, String army_name, Integer army_people) {
        this.army_id = army_id;
        this.platoon_id = platoon_id;
        this.army_name = army_name;
        this.army_people = army_people;
    }

    public Integer getArmy_id() {
        return army_id;
    }

    public void setArmy_id(Integer army_id) {
        this.army_id = army_id;
    }

    public Integer getPlatoon_id() {
        return platoon_id;
    }

    public void setPlatoon_id(Integer platoon_id) {
        this.platoon_id = platoon_id;
    }

    public String getArmy_name() {
        return army_name;
    }

    public void setArmy_name(String army_name) {
        this.army_name = army_name;
    }

    public Integer getArmy_people() {
        return army_people;
    }

    public void setArmy_people(Integer army_people) {
        this.army_people = army_people;
    }
}
