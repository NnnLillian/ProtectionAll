package com.example.entity;

public class Element_Maintain {
    private Integer element_maintain_id;
    private String equipment_id;
    private String element_id;
    private String spare_part_id;
    private String spare_part_name;
    private String  maintain_time;
    private String  malfunction_description;
    private String  reason_description;
    private Integer maintain_type;
    private String maintain_type_name;

    public Element_Maintain() {
    }

    public Element_Maintain(Integer element_maintain_id, String equipment_id, String element_id, String spare_part_id, String spare_part_name, String maintain_time, String malfunction_description, String reason_description, Integer maintain_type, String maintain_type_name) {
        this.element_maintain_id = element_maintain_id;
        this.equipment_id = equipment_id;
        this.element_id = element_id;
        this.spare_part_id = spare_part_id;
        this.spare_part_name = spare_part_name;
        this.maintain_time = maintain_time;
        this.malfunction_description = malfunction_description;
        this.reason_description = reason_description;
        this.maintain_type = maintain_type;
        this.maintain_type_name = maintain_type_name;
    }

    public Integer getElement_maintain_id() {
        return element_maintain_id;
    }

    public void setElement_maintain_id(Integer element_maintain_id) {
        this.element_maintain_id = element_maintain_id;
    }

    public String getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(String equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getElement_id() {
        return element_id;
    }

    public void setElement_id(String element_id) {
        this.element_id = element_id;
    }

    public String getSpare_part_id() {
        return spare_part_id;
    }

    public void setSpare_part_id(String spare_part_id) {
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

    public Integer getMaintain_type() {
        return maintain_type;
    }

    public void setMaintain_type(Integer maintain_type) {
        this.maintain_type = maintain_type;
    }

    public String getMaintain_type_name() {
        return maintain_type_name;
    }

    public void setMaintain_type_name(String maintain_type_name) {
        this.maintain_type_name = maintain_type_name;
    }
}
