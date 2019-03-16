package com.example.entity;

import java.util.List;

public class Scheme {
    private Integer scheme_id;
    private String scheme_name;
    private String scheme_code;
    private Integer location_id;
    private String scheme_begin_time;
    private String scheme_end_time;
    private String scheme_type;
    private String combat_direction;//作战方向
    private String safeguard_mode;//保障模式
    private String carry_method;//携装方式
    private List<Equipment> equipment_list;

    public Scheme() {
    }

    public Scheme(Integer scheme_id, String scheme_name, String scheme_code, Integer location_id, String scheme_begin_time, String scheme_end_time, String scheme_type, String combat_direction, String safeguard_mode, String carry_method, List<Equipment> equipment_list) {
        this.scheme_id = scheme_id;
        this.scheme_name = scheme_name;
        this.scheme_code = scheme_code;
        this.location_id = location_id;
        this.scheme_begin_time = scheme_begin_time;
        this.scheme_end_time = scheme_end_time;
        this.scheme_type = scheme_type;
        this.combat_direction = combat_direction;
        this.safeguard_mode = safeguard_mode;
        this.carry_method = carry_method;
        this.equipment_list = equipment_list;
    }

    public Integer getScheme_id() {
        return scheme_id;
    }

    public void setScheme_id(Integer scheme_id) {
        this.scheme_id = scheme_id;
    }

    public String getScheme_name() {
        return scheme_name;
    }

    public void setScheme_name(String scheme_name) {
        this.scheme_name = scheme_name;
    }

    public String getScheme_code() {
        return scheme_code;
    }

    public void setScheme_code(String scheme_code) {
        this.scheme_code = scheme_code;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public String getScheme_begin_time() {
        return scheme_begin_time;
    }

    public void setScheme_begin_time(String scheme_begin_time) {
        this.scheme_begin_time = scheme_begin_time;
    }

    public String getScheme_end_time() {
        return scheme_end_time;
    }

    public void setScheme_end_time(String scheme_end_time) {
        this.scheme_end_time = scheme_end_time;
    }

    public String getScheme_type() {
        return scheme_type;
    }

    public void setScheme_type(String scheme_type) {
        this.scheme_type = scheme_type;
    }

    public String getCombat_direction() {
        return combat_direction;
    }

    public void setCombat_direction(String combat_direction) {
        this.combat_direction = combat_direction;
    }

    public String getSafeguard_mode() {
        return safeguard_mode;
    }

    public void setSafeguard_mode(String safeguard_mode) {
        this.safeguard_mode = safeguard_mode;
    }

    public String getCarry_method() {
        return carry_method;
    }

    public void setCarry_method(String carry_method) {
        this.carry_method = carry_method;
    }

    public List<Equipment> getEquipment_list() {
        return equipment_list;
    }

    public void setEquipment_list(List<Equipment> equipment_list) {
        this.equipment_list = equipment_list;
    }
}
