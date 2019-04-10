package com.example.entity;

public class Device {
    private Integer device_id;
    private String device_name;
    private String device_product_id;
    private String device_modal;
    private Integer platoon_id;
    private Integer army_id;
    private String device_manufacturer;
    private String device_product_time;
    private String device_entry_time;
    private String device_source;
    private String device_state;
    private String device_quality;
    private String device_configuration_location;
    private String device_financing_division_of_labor;
    private String device_metering_cycle;
    private String comment;

    public Device(){}

    public Device(Integer device_id, String device_name, String device_product_id, String device_modal, Integer platoon_id, Integer army_id, String device_manufacturer, String device_product_time, String device_entry_time, String device_source, String device_state, String device_quality, String device_configuration_location, String device_financing_division_of_labor, String device_metering_cycle, String comment) {
        this.device_id = device_id;
        this.device_name = device_name;
        this.device_product_id = device_product_id;
        this.device_modal = device_modal;
        this.platoon_id = platoon_id;
        this.army_id = army_id;
        this.device_manufacturer = device_manufacturer;
        this.device_product_time = device_product_time;
        this.device_entry_time = device_entry_time;
        this.device_source = device_source;
        this.device_state = device_state;
        this.device_quality = device_quality;
        this.device_configuration_location = device_configuration_location;
        this.device_financing_division_of_labor = device_financing_division_of_labor;
        this.device_metering_cycle = device_metering_cycle;
        this.comment = comment;
    }

    public Integer getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Integer device_id) {
        this.device_id = device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public Integer getPlatoon_id() {
        return platoon_id;
    }

    public void setPlatoon_id(Integer platoon_id) {
        this.platoon_id = platoon_id;
    }

    public Integer getArmy_id() {
        return army_id;
    }

    public void setArmy_id(Integer army_id) {
        this.army_id = army_id;
    }

    public String getDevice_manufacturer() {
        return device_manufacturer;
    }

    public void setDevice_manufacturer(String device_manufacturer) {
        this.device_manufacturer = device_manufacturer;
    }

    public String getDevice_product_time() {
        return device_product_time;
    }

    public void setDevice_product_time(String device_product_time) {
        this.device_product_time = device_product_time;
    }

    public String getDevice_entry_time() {
        return device_entry_time;
    }

    public void setDevice_entry_time(String device_entry_time) {
        this.device_entry_time = device_entry_time;
    }

    public String getDevice_source() {
        return device_source;
    }

    public void setDevice_source(String device_source) {
        this.device_source = device_source;
    }

    public String getDevice_state() {
        return device_state;
    }

    public void setDevice_state(String device_state) {
        this.device_state = device_state;
    }

    public String getDevice_quality() {
        return device_quality;
    }

    public void setDevice_quality(String device_quality) {
        this.device_quality = device_quality;
    }

    public String getDevice_configuration_location() {
        return device_configuration_location;
    }

    public void setDevice_configuration_location(String device_configuration_location) {
        this.device_configuration_location = device_configuration_location;
    }

    public String getDevice_financing_division_of_labor() {
        return device_financing_division_of_labor;
    }

    public void setDevice_financing_division_of_labor(String device_financing_division_of_labor) {
        this.device_financing_division_of_labor = device_financing_division_of_labor;
    }

    public String getDevice_product_id() {
        return device_product_id;
    }

    public void setDevice_product_id(String device_product_id) {
        this.device_product_id = device_product_id;
    }

    public String getDevice_modal() {
        return device_modal;
    }

    public void setDevice_modal(String device_modal) {
        this.device_modal = device_modal;
    }

    public String getDevice_metering_cycle() {
        return device_metering_cycle;
    }

    public void setDevice_metering_cycle(String device_metering_cycle) {
        this.device_metering_cycle = device_metering_cycle;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
