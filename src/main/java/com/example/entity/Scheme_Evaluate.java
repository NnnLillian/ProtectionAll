package com.example.entity;

public class Scheme_Evaluate {
    private Integer scheme_id;
    private String scheme_name;
    //    表示该专家的评估结果
    private double evaluate_result;
    private String evaluate_proficient;
    //    表示实际评估次数
    private Integer evaluate_count;

    public Scheme_Evaluate() {
    }

    public Scheme_Evaluate(Integer scheme_id, String scheme_name, double evaluate_result, String evaluate_proficient, Integer evaluate_count) {
        this.scheme_id = scheme_id;
        this.scheme_name = scheme_name;
        this.evaluate_result = evaluate_result;
        this.evaluate_proficient = evaluate_proficient;
        this.evaluate_count = evaluate_count;
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

    public double getEvaluate_result() {
        return evaluate_result;
    }

    public void setEvaluate_result(double evaluate_result) {
        this.evaluate_result = evaluate_result;
    }

    public String getEvaluate_proficient() {
        return evaluate_proficient;
    }

    public void setEvaluate_proficient(String evaluate_proficient) {
        this.evaluate_proficient = evaluate_proficient;
    }

    public Integer getEvaluate_count() {
        return evaluate_count;
    }

    public void setEvaluate_count(Integer evaluate_count) {
        this.evaluate_count = evaluate_count;
    }
}
