package com.example.entity;

public class Supplier {
    private Integer supplier_id;
    private Integer location_id;
    private double longitude;
    private double latitude;
    private String supplier_name;
    private String supplier_head;
    private String supplier_phone;
    private String case_position;
    private String position_name;
    private Integer supplier_type;
    private String supplier_type_name;
    private Integer supplier_belong;

    public Supplier() {
    }

    public Supplier(Integer supplier_id, Integer location_id, double longitude, double latitude, String supplier_name, String supplier_head, String supplier_phone, String case_position, String position_name, Integer supplier_type, String supplier_type_name, Integer supplier_belong) {
        this.supplier_id = supplier_id;
        this.location_id = location_id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.supplier_name = supplier_name;
        this.supplier_head = supplier_head;
        this.supplier_phone = supplier_phone;
        this.case_position = case_position;
        this.position_name = position_name;
        this.supplier_type = supplier_type;
        this.supplier_type_name = supplier_type_name;
        this.supplier_belong = supplier_belong;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public Integer getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_head() {
        return supplier_head;
    }

    public void setSupplier_head(String supplier_head) {
        this.supplier_head = supplier_head;
    }

    public String getSupplier_phone() {
        return supplier_phone;
    }

    public void setSupplier_phone(String supplier_phone) {
        this.supplier_phone = supplier_phone;
    }

    public String getCase_position() {
        return case_position;
    }

    public void setCase_position(String case_position) {
        this.case_position = case_position;
    }

    public Integer getSupplier_type() {
        return supplier_type;
    }

    public void setSupplier_type(Integer supplier_type) {
        this.supplier_type = supplier_type;
    }

    public String getSupplier_type_name() {
        return supplier_type_name;
    }

    public void setSupplier_type_name(String supplier_type_name) {
        this.supplier_type_name = supplier_type_name;
    }

    public Integer getSupplier_belong() {
        return supplier_belong;
    }

    public void setSupplier_belong(Integer supplier_belong) {
        this.supplier_belong = supplier_belong;
    }
}
