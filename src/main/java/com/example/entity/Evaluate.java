package com.example.entity;

public class Evaluate {
    private Integer evaluate_id;
    private Integer scheme_id;
    private double evaluate_number;

    public Evaluate(){}

    public Evaluate(Integer evaluate_id, Integer scheme_id, double evaluate_number) {
        this.evaluate_id = evaluate_id;
        this.scheme_id = scheme_id;
        this.evaluate_number = evaluate_number;
    }

    public Integer getEvaluate_id() {
        return evaluate_id;
    }

    public void setEvaluate_id(Integer evaluate_id) {
        this.evaluate_id = evaluate_id;
    }

    public Integer getScheme_id() {
        return scheme_id;
    }

    public void setScheme_id(Integer scheme_id) {
        this.scheme_id = scheme_id;
    }

    public double getEvaluate_number() {
        return evaluate_number;
    }

    public void setEvaluate_number(double evaluate_number) {
        this.evaluate_number = evaluate_number;
    }
}
