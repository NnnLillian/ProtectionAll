package com.example.entity;

public class Spare_Part {
    private Integer spare_part_id;
    private Integer element_id;
    private Integer supplier_id;
    private String  spare_part_name;
    private String  spare_part_model;
    private Integer spare_part_quantity;

    public Spare_Part() {
    }

    public Spare_Part(Integer spare_part_id, Integer element_id, Integer supplier_id, String spare_part_name, String spare_part_model, Integer spare_part_quantity) {
        this.spare_part_id = spare_part_id;
        this.element_id = element_id;
        this.supplier_id = supplier_id;
        this.spare_part_name = spare_part_name;
        this.spare_part_model = spare_part_model;
        this.spare_part_quantity = spare_part_quantity;
    }

    public Integer getSpare_part_id() {
        return spare_part_id;
    }

    public void setSpare_part_id(Integer spare_part_id) {
        this.spare_part_id = spare_part_id;
    }

    public Integer getElement_id() {
        return element_id;
    }

    public void setElement_id(Integer element_id) {
        this.element_id = element_id;
    }

    public Integer getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSpare_part_name() {
        return spare_part_name;
    }

    public void setSpare_part_name(String spare_part_name) {
        this.spare_part_name = spare_part_name;
    }

    public String getSpare_part_model() {
        return spare_part_model;
    }

    public void setSpare_part_model(String spare_part_model) {
        this.spare_part_model = spare_part_model;
    }

    public Integer getSpare_part_quantity() {
        return spare_part_quantity;
    }

    public void setSpare_part_quantity(Integer spare_part_quantity) {
        this.spare_part_quantity = spare_part_quantity;
    }
}
