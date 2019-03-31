package com.example.entity;

public class Element {
    private String element_id;
    private Integer category_id;
    private String equipment_id;
    private String  element_modal;
    private String  element_product_identification;
    private String  element_unit;
    private float  reference_unit_price;
    private float  contract_unit_price;
    private Integer units_installed_number;
    private String  installed_location;
    private String  element_manufacutrer;
    private String  element_supplier;
    private String  element_financing_division_of_labor;
    private String  updateOrNot;
    private Integer  maintenance_type;
    private Integer  army_reserve_standard;
    private Integer  platoon_reserve_standard;
    private Integer  random_number;
    private Integer  army_initial_number;
    private Integer  platoon_initial_number;
    private String  element_name;
    private String  element_type;
    private String  repairOrNot;
    private String  secretOrNot;
    private String  repair_factory;
    private Integer detection_cycle;
    private String  importantOrNot;
    private String  importOrNot;
    private String  comment;
    private double  reliability;

    public Element() {
    }

    public Element(String element_id, Integer category_id, String equipment_id, String element_modal, String element_product_identification, String element_unit, float reference_unit_price, float contract_unit_price, Integer units_installed_number, String installed_location, String element_manufacutrer, String element_supplier, String element_financing_division_of_labor, String updateOrNot, Integer maintenance_type, Integer army_reserve_standard, Integer platoon_reserve_standard, Integer random_number, Integer army_initial_number, Integer platoon_initial_number, String element_name, String element_type, String repairOrNot, String secretOrNot, String repair_factory, Integer detection_cycle, String importantOrNot, String importOrNot, String comment, double reliability) {
        this.element_id = element_id;
        this.category_id = category_id;
        this.equipment_id = equipment_id;
        this.element_modal = element_modal;
        this.element_product_identification = element_product_identification;
        this.element_unit = element_unit;
        this.reference_unit_price = reference_unit_price;
        this.contract_unit_price = contract_unit_price;
        this.units_installed_number = units_installed_number;
        this.installed_location = installed_location;
        this.element_manufacutrer = element_manufacutrer;
        this.element_supplier = element_supplier;
        this.element_financing_division_of_labor = element_financing_division_of_labor;
        this.updateOrNot = updateOrNot;
        this.maintenance_type = maintenance_type;
        this.army_reserve_standard = army_reserve_standard;
        this.platoon_reserve_standard = platoon_reserve_standard;
        this.random_number = random_number;
        this.army_initial_number = army_initial_number;
        this.platoon_initial_number = platoon_initial_number;
        this.element_name = element_name;
        this.element_type = element_type;
        this.repairOrNot = repairOrNot;
        this.secretOrNot = secretOrNot;
        this.repair_factory = repair_factory;
        this.detection_cycle = detection_cycle;
        this.importantOrNot = importantOrNot;
        this.importOrNot = importOrNot;
        this.comment = comment;
        this.reliability = reliability;
    }

    public String getElement_id() {
        return element_id;
    }

    public void setElement_id(String element_id) {
        this.element_id = element_id;
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


    public String getElement_name() {
        return element_name;
    }

    public void setElement_name(String element_name) {
        this.element_name = element_name;
    }

    public String getElement_type() {
        return element_type;
    }

    public void setElement_type(String element_type) {
        this.element_type = element_type;
    }

    public double getReliability() {
        return reliability;
    }

    public void setReliability(double reliability) {
        this.reliability = reliability;
    }

    public String getElement_modal() {
        return element_modal;
    }

    public void setElement_modal(String element_modal) {
        this.element_modal = element_modal;
    }

    public String getElement_product_identification() {
        return element_product_identification;
    }

    public void setElement_product_identification(String element_product_identification) {
        this.element_product_identification = element_product_identification;
    }

    public String getElement_unit() {
        return element_unit;
    }

    public void setElement_unit(String element_unit) {
        this.element_unit = element_unit;
    }

    public float getReference_unit_price() {
        return reference_unit_price;
    }

    public void setReference_unit_price(float reference_unit_price) {
        this.reference_unit_price = reference_unit_price;
    }

    public float getContract_unit_price() {
        return contract_unit_price;
    }

    public void setContract_unit_price(float contract_unit_price) {
        this.contract_unit_price = contract_unit_price;
    }

    public Integer getUnits_installed_number() {
        return units_installed_number;
    }

    public void setUnits_installed_number(Integer units_installed_number) {
        this.units_installed_number = units_installed_number;
    }

    public String getInstalled_location() {
        return installed_location;
    }

    public void setInstalled_location(String installed_location) {
        this.installed_location = installed_location;
    }

    public String getElement_manufacutrer() {
        return element_manufacutrer;
    }

    public void setElement_manufacutrer(String element_manufacutrer) {
        this.element_manufacutrer = element_manufacutrer;
    }

    public String getElement_supplier() {
        return element_supplier;
    }

    public void setElement_supplier(String element_supplier) {
        this.element_supplier = element_supplier;
    }

    public String getElement_financing_division_of_labor() {
        return element_financing_division_of_labor;
    }

    public void setElement_financing_division_of_labor(String element_financing_division_of_labor) {
        this.element_financing_division_of_labor = element_financing_division_of_labor;
    }

    public String getUpdateOrNot() {
        return updateOrNot;
    }

    public void setUpdateOrNot(String updateOrNot) {
        this.updateOrNot = updateOrNot;
    }

    public Integer getMaintenance_type() {
        return maintenance_type;
    }

    public void setMaintenance_type(Integer maintenance_type) {
        this.maintenance_type = maintenance_type;
    }

    public Integer getArmy_reserve_standard() {
        return army_reserve_standard;
    }

    public void setArmy_reserve_standard(Integer army_reserve_standard) {
        this.army_reserve_standard = army_reserve_standard;
    }

    public Integer getPlatoon_reserve_standard() {
        return platoon_reserve_standard;
    }

    public void setPlatoon_reserve_standard(Integer platoon_reserve_standard) {
        this.platoon_reserve_standard = platoon_reserve_standard;
    }

    public Integer getRandom_number() {
        return random_number;
    }

    public void setRandom_number(Integer random_number) {
        this.random_number = random_number;
    }

    public Integer getArmy_initial_number() {
        return army_initial_number;
    }

    public void setArmy_initial_number(Integer army_initial_number) {
        this.army_initial_number = army_initial_number;
    }

    public Integer getPlatoon_initial_number() {
        return platoon_initial_number;
    }

    public void setPlatoon_initial_number(Integer platoon_initial_number) {
        this.platoon_initial_number = platoon_initial_number;
    }

    public String getRepairOrNot() {
        return repairOrNot;
    }

    public void setRepairOrNot(String repairOrNot) {
        this.repairOrNot = repairOrNot;
    }

    public String getSecretOrNot() {
        return secretOrNot;
    }

    public void setSecretOrNot(String secretOrNot) {
        this.secretOrNot = secretOrNot;
    }

    public String getRepair_factory() {
        return repair_factory;
    }

    public void setRepair_factory(String repair_factory) {
        this.repair_factory = repair_factory;
    }

    public Integer getDetection_cycle() {
        return detection_cycle;
    }

    public void setDetection_cycle(Integer detection_cycle) {
        this.detection_cycle = detection_cycle;
    }

    public String getImportantOrNot() {
        return importantOrNot;
    }

    public void setImportantOrNot(String importantOrNot) {
        this.importantOrNot = importantOrNot;
    }

    public String getImportOrNot() {
        return importOrNot;
    }

    public void setImportOrNot(String importOrNot) {
        this.importOrNot = importOrNot;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
