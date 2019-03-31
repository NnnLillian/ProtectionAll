package com.example.entity;

public class Scheme_Equipment {
    private Integer scheme_id;
    private String equipment_id;

    public Scheme_Equipment() {
    }

    public Scheme_Equipment(Integer scheme_id, String equipment_id) {
        this.scheme_id = scheme_id;
        this.equipment_id = equipment_id;
    }

    public Integer getScheme_id() {
        return scheme_id;
    }

    public void setScheme_id(Integer scheme_id) {
        this.scheme_id = scheme_id;
    }

    public String getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(String equipment_id) {
        this.equipment_id = equipment_id;
    }
}
