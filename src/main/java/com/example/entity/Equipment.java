package com.example.entity;

import java.sql.Timestamp;

public class Equipment {
    private String equipment_id;
    private Integer category_id;
    private Integer army_id;
    private String  equipment_name;
    private String category_modal;
    private String category_unit;
    private Integer  equipment_count;
    private String equipment_classis_name;
    private Integer maintain_whole_count;
    private String equipment_manufacturer;
    private Timestamp equipment_producted_time;
    private Timestamp equipment_entry_time;
    private String equipment_state;
    private String equipment_quality;
    private String equipment_technology;
    private String maintain_whole_element;
    private Integer upgrade_times;
    private String upgrade_element;
    private String maintain_part_time;
    private Integer maintain_part_count;
    private String maintain_part_element;
    private String first_maintain_whole_time;
    private Integer maintain_whole_boot_time;
    private Integer maintain_part_boot_time;
    private Integer total_length_time;
    private String total_specified_lfie;
    private String cumulative_working_time;
    private String post_extension_period;

    public Equipment() {
    }

    public Equipment(String equipment_id, Integer category_id, Integer army_id, String equipment_name, String category_modal, String category_unit, Integer equipment_count, String equipment_classis_name, Integer maintain_whole_count, String equipment_manufacturer, Timestamp equipment_producted_time, Timestamp equipment_entry_time, String equipment_state, String equipment_quality, String equipment_technology, String maintain_whole_element, Integer upgrade_times, String upgrade_element, String maintain_part_time, Integer maintain_part_count, String maintain_part_element, String first_maintain_whole_time, Integer maintain_whole_boot_time, Integer maintain_part_boot_time, Integer total_length_time, String total_specified_lfie, String cumulative_working_time, String post_extension_period) {
        this.equipment_id = equipment_id;
        this.category_id = category_id;
        this.army_id = army_id;
        this.equipment_name = equipment_name;
        this.category_modal = category_modal;
        this.category_unit = category_unit;
        this.equipment_count = equipment_count;
        this.equipment_classis_name = equipment_classis_name;
        this.maintain_whole_count = maintain_whole_count;
        this.equipment_manufacturer = equipment_manufacturer;
        this.equipment_producted_time = equipment_producted_time;
        this.equipment_entry_time = equipment_entry_time;
        this.equipment_state = equipment_state;
        this.equipment_quality = equipment_quality;
        this.equipment_technology = equipment_technology;
        this.maintain_whole_element = maintain_whole_element;
        this.upgrade_times = upgrade_times;
        this.upgrade_element = upgrade_element;
        this.maintain_part_time = maintain_part_time;
        this.maintain_part_count = maintain_part_count;
        this.maintain_part_element = maintain_part_element;
        this.first_maintain_whole_time = first_maintain_whole_time;
        this.maintain_whole_boot_time = maintain_whole_boot_time;
        this.maintain_part_boot_time = maintain_part_boot_time;
        this.total_length_time = total_length_time;
        this.total_specified_lfie = total_specified_lfie;
        this.cumulative_working_time = cumulative_working_time;
        this.post_extension_period = post_extension_period;
    }

    public String getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(String equipment_id) {
        this.equipment_id = equipment_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getArmy_id() {
        return army_id;
    }

    public void setArmy_id(Integer army_id) {
        this.army_id = army_id;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }

    public String getCategory_modal() {
        return category_modal;
    }

    public void setCategory_modal(String category_modal) {
        this.category_modal = category_modal;
    }

    public String getCategory_unit() {
        return category_unit;
    }

    public void setCategory_unit(String category_unit) {
        this.category_unit = category_unit;
    }

    public Integer getEquipment_count() {
        return equipment_count;
    }

    public void setEquipment_count(Integer equipment_count) {
        this.equipment_count = equipment_count;
    }

    public String getEquipment_classis_name() {
        return equipment_classis_name;
    }

    public void setEquipment_classis_name(String equipment_classis_name) {
        this.equipment_classis_name = equipment_classis_name;
    }

    public Integer getMaintain_whole_count() {
        return maintain_whole_count;
    }

    public void setMaintain_whole_count(Integer maintain_whole_count) {
        this.maintain_whole_count = maintain_whole_count;
    }

    public String getEquipment_manufacturer() {
        return equipment_manufacturer;
    }

    public void setEquipment_manufacturer(String equipment_manufacturer) {
        this.equipment_manufacturer = equipment_manufacturer;
    }

    public Timestamp getEquipment_producted_time() {
        return equipment_producted_time;
    }

    public void setEquipment_producted_time(Timestamp equipment_producted_time) {
        this.equipment_producted_time = equipment_producted_time;
    }

    public Timestamp getEquipment_entry_time() {
        return equipment_entry_time;
    }

    public void setEquipment_entry_time(Timestamp equipment_entry_time) {
        this.equipment_entry_time = equipment_entry_time;
    }

    public String getEquipment_state() {
        return equipment_state;
    }

    public void setEquipment_state(String equipment_state) {
        this.equipment_state = equipment_state;
    }

    public String getEquipment_quality() {
        return equipment_quality;
    }

    public void setEquipment_quality(String equipment_quality) {
        this.equipment_quality = equipment_quality;
    }

    public String getEquipment_technology() {
        return equipment_technology;
    }

    public void setEquipment_technology(String equipment_technology) {
        this.equipment_technology = equipment_technology;
    }

    public String getMaintain_whole_element() {
        return maintain_whole_element;
    }

    public void setMaintain_whole_element(String maintain_whole_element) {
        this.maintain_whole_element = maintain_whole_element;
    }

    public Integer getUpgrade_times() {
        return upgrade_times;
    }

    public void setUpgrade_times(Integer upgrade_times) {
        this.upgrade_times = upgrade_times;
    }

    public String getUpgrade_element() {
        return upgrade_element;
    }

    public void setUpgrade_element(String upgrade_element) {
        this.upgrade_element = upgrade_element;
    }

    public String getMaintain_part_time() {
        return maintain_part_time;
    }

    public void setMaintain_part_time(String maintain_part_time) {
        this.maintain_part_time = maintain_part_time;
    }

    public Integer getMaintain_part_count() {
        return maintain_part_count;
    }

    public void setMaintain_part_count(Integer maintain_part_count) {
        this.maintain_part_count = maintain_part_count;
    }

    public String getMaintain_part_element() {
        return maintain_part_element;
    }

    public void setMaintain_part_element(String maintain_part_element) {
        this.maintain_part_element = maintain_part_element;
    }

    public String getFirst_maintain_whole_time() {
        return first_maintain_whole_time;
    }

    public void setFirst_maintain_whole_time(String first_maintain_whole_time) {
        this.first_maintain_whole_time = first_maintain_whole_time;
    }

    public Integer getMaintain_whole_boot_time() {
        return maintain_whole_boot_time;
    }

    public void setMaintain_whole_boot_time(Integer maintain_whole_boot_time) {
        this.maintain_whole_boot_time = maintain_whole_boot_time;
    }

    public Integer getMaintain_part_boot_time() {
        return maintain_part_boot_time;
    }

    public void setMaintain_part_boot_time(Integer maintain_part_boot_time) {
        this.maintain_part_boot_time = maintain_part_boot_time;
    }

    public Integer getTotal_length_time() {
        return total_length_time;
    }

    public void setTotal_length_time(Integer total_length_time) {
        this.total_length_time = total_length_time;
    }

    public String getTotal_specified_lfie() {
        return total_specified_lfie;
    }

    public void setTotal_specified_lfie(String total_specified_lfie) {
        this.total_specified_lfie = total_specified_lfie;
    }

    public String getCumulative_working_time() {
        return cumulative_working_time;
    }

    public void setCumulative_working_time(String cumulative_working_time) {
        this.cumulative_working_time = cumulative_working_time;
    }

    public String getPost_extension_period() {
        return post_extension_period;
    }

    public void setPost_extension_period(String post_extension_period) {
        this.post_extension_period = post_extension_period;
    }
}
