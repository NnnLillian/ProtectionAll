package com.example.entity;

import lombok.Data;

@Data
public class Army {

    private boolean state;
    private Integer army_id;
    private Integer platoon_id;
    private String army_name;
    private Integer army_people;
    private String army_type;

    public Army() {
    }

    public Army(boolean state, Integer army_id, Integer platoon_id, String army_name, Integer army_people, String army_type) {
        this.state = state;
        this.army_id = army_id;
        this.platoon_id = platoon_id;
        this.army_name = army_name;
        this.army_people = army_people;
        this.army_type = army_type;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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

    public String getArmy_type() {
        return army_type;
    }

    public void setArmy_type(String army_type) {
        this.army_type = army_type;
    }
}
