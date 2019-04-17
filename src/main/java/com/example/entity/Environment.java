package com.example.entity;

public class Environment {
    private Integer environment_id;
    private String case_position;
    private Integer location_id;
    private Integer month_time;
    private double temperature;
    private double rainfall;
    private double snowfall;
    private double sunshine;
    private double wind_level;
    private double pressure;
    private double corrosion;
    private double humidity;

    public  Environment()
    {

    }

    public Environment(Integer environment_id, String case_position, Integer location_id, Integer month_time, double temperature, double rainfall, double snowfall, double sunshine, double wind_level, double pressure, double corrosion, double humidity) {
        this.environment_id = environment_id;
        this.case_position = case_position;
        this.location_id = location_id;
        this.month_time = month_time;
        this.temperature = temperature;
        this.rainfall = rainfall;
        this.snowfall = snowfall;
        this.sunshine = sunshine;
        this.wind_level = wind_level;
        this.pressure = pressure;
        this.corrosion = corrosion;
        this.humidity = humidity;
    }

    public Integer getEnvironment_id() {
        return environment_id;
    }

    public void setEnvironment_id(Integer environment_id) {
        this.environment_id = environment_id;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public Integer getMonth_time() {
        return month_time;
    }

    public void setMonth_time(Integer month_time) {
        this.month_time = month_time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getRainfall() {
        return rainfall;
    }

    public void setRainfall(double rainfall) {
        this.rainfall = rainfall;
    }

    public double getSnowfall() {
        return snowfall;
    }

    public void setSnowfall(double snowfall) {
        this.snowfall = snowfall;
    }

    public double getSunshine() {
        return sunshine;
    }

    public void setSunshine(double sunshine) {
        this.sunshine = sunshine;
    }

    public double getWind_level() {
        return wind_level;
    }

    public void setWind_level(double wind_level) {
        this.wind_level = wind_level;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getCorrosion() {
        return corrosion;
    }

    public void setCorrosion(double corrosion) {
        this.corrosion = corrosion;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getCase_position() {
        return case_position;
    }

    public void setCase_position(String case_position) {
        this.case_position = case_position;
    }
}
