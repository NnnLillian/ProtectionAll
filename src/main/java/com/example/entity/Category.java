package com.example.entity;

public class Category {
    private Integer category_id;
    private String category_name;
    private String category_model;
    private String category_type;
    private String category_unit;
    private String category_comment;
    private Integer category_number;

    public Category() {
    }

    public Category(Integer category_id, String category_name, String category_model, String category_type, String category_unit, String category_comment, Integer category_number) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_model = category_model;
        this.category_type = category_type;
        this.category_unit = category_unit;
        this.category_comment = category_comment;
        this.category_number = category_number;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_type() {
        return category_type;
    }

    public void setCategory_type(String category_type) {
        this.category_type = category_type;
    }

    public String getCategory_unit() {
        return category_unit;
    }

    public void setCategory_unit(String category_unit) {
        this.category_unit = category_unit;
    }

    public String getCategory_comment() {
        return category_comment;
    }

    public void setCategory_comment(String category_comment) {
        this.category_comment = category_comment;
    }

    public String getCategory_model() {
        return category_model;
    }

    public void setCategory_model(String category_model) {
        this.category_model = category_model;
    }

    public Integer getCategory_number() {
        return category_number;
    }

    public void setCategory_number(Integer category_number) {
        this.category_number = category_number;
    }
}
