package com.example.entity;

public class Element_Maintain {
    private Integer element_maintain_id;
    private Integer equipment_id;
    private Integer element_id;
    private Integer spare_part_id;
    private String spare_part_name;
    private String  maintain_time;
    private String  malfunction_description;
    private String  reason_description;

    public Element_Maintain() {
    }

    public Element_Maintain(Integer element_maintain_id, Integer equipment_id, Integer element_id, Integer spare_part_id, String spare_part_name, String maintain_time, String malfunction_description, String reason_description) {
        this.element_maintain_id = element_maintain_id;
        this.equipment_id = equipment_id;
        this.element_id = element_id;
        this.spare_part_id = spare_part_id;
        this.spare_part_name = spare_part_name;
        this.maintain_time = maintain_time;
        this.malfunction_description = malfunction_description;
        this.reason_description = reason_description;
    }

    public Integer getElement_maintain_id() {
        return element_maintain_id;
    }

    public void setElement_maintain_id(Integer element_maintain_id) {
        this.element_maintain_id = element_maintain_id;
    }

    public Integer getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(Integer equipment_id) {
        this.equipment_id = equipment_id;
    }

    public Integer getElement_id() {
        return element_id;
    }

    public void setElement_id(Integer element_id) {
        this.element_id = element_id;
    }

    public Integer getSpare_part_id() {
        return spare_part_id;
    }

    public void setSpare_part_id(Integer spare_part_id) {
        this.spare_part_id = spare_part_id;
    }

    public String getSpare_part_name() {
        return spare_part_name;
    }

    public void setSpare_part_name(String spare_part_name) {
        this.spare_part_name = spare_part_name;
    }

    public String getMaintain_time() {
        return maintain_time;
    }

    public void setMaintain_time(String maintain_time) {
        this.maintain_time = maintain_time;
    }

    public String getMalfunction_description() {
        return malfunction_description;
    }

    public void setMalfunction_description(String malfunction_description) {
        this.malfunction_description = malfunction_description;
    }

    public String getReason_description() {
        return reason_description;
    }

    public void setReason_description(String reason_description) {
        this.reason_description = reason_description;
    }
}
