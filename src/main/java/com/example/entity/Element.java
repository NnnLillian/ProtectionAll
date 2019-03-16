package com.example.entity;

public class Element {
    private Integer element_id;
    private Integer category_id;
    private Integer equipment_id;
    private Integer work_time;
    private String  maintenance_date;
    private String  element_name;
    private String  element_type;
    private double  reliability;

    public Element() {
    }

    public Element(Integer element_id, Integer category_id, Integer equipment_id, Integer work_time, String maintenance_date, String element_name, String element_type, double reliability) {
        this.element_id = element_id;
        this.category_id = category_id;
        this.equipment_id = equipment_id;
        this.work_time = work_time;
        this.maintenance_date = maintenance_date;
        this.element_name = element_name;
        this.element_type = element_type;
        this.reliability = reliability;
    }

    public Integer getElement_id() {
        return element_id;
    }

    public void setElement_id(Integer element_id) {
        this.element_id = element_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(Integer equipment_id) {
        this.equipment_id = equipment_id;
    }

    public Integer getWork_time() {
        return work_time;
    }

    public void setWork_time(Integer work_time) {
        this.work_time = work_time;
    }

    public String getMaintenance_date() {
        return maintenance_date;
    }

    public void setMaintenance_date(String maintenance_date) {
        this.maintenance_date = maintenance_date;
    }

    public String getElement_name() {
        return element_name;
    }

    public void setElement_name(String element_name) {
        this.element_name = element_name;
    }

    public String getElement_type() {
        return element_type;
    }

    public void setElement_type(String element_type) {
        this.element_type = element_type;
    }

    public double getReliability() {
        return reliability;
    }

    public void setReliability(double reliability) {
        this.reliability = reliability;
    }
}
