package com.example.entity;

public class Scheme_Safeguard {
    private Integer safeguard_id;
    private Integer scheme_id;
    private Integer safeguard_mode;
    private Integer base_id;
    private Integer platoon_id;
    private Integer carry_method;

    public Scheme_Safeguard(){

    }

    public Scheme_Safeguard(Integer safeguard_id, Integer scheme_id, Integer safeguard_mode, Integer base_id, Integer platoon_id, Integer carry_method) {
        this.safeguard_id = safeguard_id;
        this.scheme_id = scheme_id;
        this.safeguard_mode = safeguard_mode;
        this.base_id = base_id;
        this.platoon_id = platoon_id;
        this.carry_method = carry_method;
    }

    public Integer getSafeguard_id() {
        return safeguard_id;
    }

    public void setSafeguard_id(Integer safeguard_id) {
        this.safeguard_id = safeguard_id;
    }

    public Integer getScheme_id() {
        return scheme_id;
    }

    public void setScheme_id(Integer scheme_id) {
        this.scheme_id = scheme_id;
    }

    public Integer getSafeguard_mode() {
        return safeguard_mode;
    }

    public void setSafeguard_mode(Integer safeguard_mode) {
        this.safeguard_mode = safeguard_mode;
    }

    public Integer getBase_id() {
        return base_id;
    }

    public void setBase_id(Integer base_id) {
        this.base_id = base_id;
    }

    public Integer getPlatoon_id() {
        return platoon_id;
    }

    public void setPlatoon_id(Integer platoon_id) {
        this.platoon_id = platoon_id;
    }

    public Integer getCarry_method() {
        return carry_method;
    }

    public void setCarry_method(Integer carry_method) {
        this.carry_method = carry_method;
    }
}

