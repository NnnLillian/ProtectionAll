package com.example.entity;

public class Evaluate {
    private Integer evaluate_id;
    private String evaluate_item;
    private String evaluate_subtype;
    private String evaluate_main_type;
    private double evaluate_weight;

    public Evaluate() {
    }

    public Evaluate(Integer evaluate_id, String evaluate_item, String evaluate_subtype, String evaluate_main_type, double evaluate_weight) {
        this.evaluate_id = evaluate_id;
        this.evaluate_item = evaluate_item;
        this.evaluate_subtype = evaluate_subtype;
        this.evaluate_main_type = evaluate_main_type;
        this.evaluate_weight = evaluate_weight;
    }

    public Integer getEvaluate_id() {
        return evaluate_id;
    }

    public void setEvaluate_id(Integer evaluate_id) {
        this.evaluate_id = evaluate_id;
    }

    public String getEvaluate_item() {
        return evaluate_item;
    }

    public void setEvaluate_item(String evaluate_item) {
        this.evaluate_item = evaluate_item;
    }

    public String getEvaluate_subtype() {
        return evaluate_subtype;
    }

    public void setEvaluate_subtype(String evaluate_subtype) {
        this.evaluate_subtype = evaluate_subtype;
    }

    public String getEvaluate_main_type() {
        return evaluate_main_type;
    }

    public void setEvaluate_main_type(String evaluate_main_type) {
        this.evaluate_main_type = evaluate_main_type;
    }

    public double getEvaluate_weight() {
        return evaluate_weight;
    }

    public void setEvaluate_weight(double evaluate_weight) {
        this.evaluate_weight = evaluate_weight;
    }
}
