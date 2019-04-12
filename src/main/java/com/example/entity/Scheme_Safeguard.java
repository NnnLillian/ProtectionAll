package com.example.entity;

public class Scheme_Safeguard {
    private Integer safeguard_id;
    private Integer scheme_id;
    private Integer safeguard_mode;
    private String safeguardMode_name;
    //    为了text.html中的页面判断
    private Integer safeguardMode_flag;
    private Integer base_id;
    private String base_name;
    private Integer platoon_id;
    private String platoon_name;
    private Integer carry_method;
    private String carryMethod_name;

    public Scheme_Safeguard() {

    }

    public Scheme_Safeguard(Integer safeguard_id, Integer scheme_id, Integer safeguard_mode, String safeguardMode_name, Integer safeguardMode_flag, Integer base_id, String base_name, Integer platoon_id, String platoon_name, Integer carry_method, String carryMethod_name) {
        this.safeguard_id = safeguard_id;
        this.scheme_id = scheme_id;
        this.safeguard_mode = safeguard_mode;
        this.safeguardMode_name = safeguardMode_name;
        this.safeguardMode_flag = safeguardMode_flag;
        this.base_id = base_id;
        this.base_name = base_name;
        this.platoon_id = platoon_id;
        this.platoon_name = platoon_name;
        this.carry_method = carry_method;
        this.carryMethod_name = carryMethod_name;
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

    public String getSafeguardMode_name() {
        switch (safeguard_mode) {
            case 1:
                safeguardMode_name = "自主保障";
                break;
            case 2:
                safeguardMode_name = "协同保障";
                break;
            case 3:
                safeguardMode_name = "自主保障、协同保障";
                break;
            case 4:
                safeguardMode_name = "支援保障";
                break;
            case 5:
                safeguardMode_name = "自主保障、支援保障";
                break;
            case 6:
                safeguardMode_name = "协同保障、支援保障";
                break;
            case 7:
                safeguardMode_name = "自主保障、支援保障、协同保障";
                break;
        }
        return safeguardMode_name;
    }

    public void setSafeguardMode_name(String safeguardMode_name) {
        this.safeguardMode_name = safeguardMode_name;
    }

    public Integer getSafeguardMode_flag() {
        switch (safeguard_mode) {
            case 1:
                safeguardMode_flag = 1;
                break;
            case 2:
            case 3:
                safeguardMode_flag = 2;
                break;
            case 4:
            case 5:
                safeguardMode_flag = 3;
                break;
            default:
                safeguardMode_flag = 4;
        }
        return safeguardMode_flag;
    }

    public void setSafeguardMode_flag(Integer safeguardMode_flag) {
        this.safeguardMode_flag = safeguardMode_flag;
    }

    public String getBase_name() {
        return base_name;
    }

    public void setBase_name(String base_name) {
        this.base_name = base_name;
    }

    public String getPlatoon_name() {
        return platoon_name;
    }

    public void setPlatoon_name(String platoon_name) {
        this.platoon_name = platoon_name;
    }

    public String getCarryMethod_name() {
        return carryMethod_name;
    }

    public void setCarryMethod_name(String carryMethod_name) {
        this.carryMethod_name = carryMethod_name;
    }
}

