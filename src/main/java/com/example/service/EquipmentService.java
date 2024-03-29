package com.example.service;

import com.example.entity.*;

import java.util.List;

public interface EquipmentService {
    public List<Equipment> GetEquipmentByPlatoonIdAndType(Integer platoon_id, String type);

    public void AddSchemeEquipment(Scheme_Equipment scheme_equipment);

    public List<Element> GetElementByEquipmentId(String equipment_id);

    public List<Element_Maintain> GetElementMaintainByEquipmentId(String equipment_id);

    public List<Category> GetCategoryByArmyIdAndType(Integer army_id, String category_type);

    public List<Category> RequestCategoryByType(String category_type);

    public List<Supplier> GetSupplierByPosition(String position);

    public List<Supplier> GetSupplierByBase(Integer base_id);

    public List<Category> GetCategoryByPlatoonIdAndType(Integer platoon_id, String category_type);

    public Integer IncreaseCategory(Category category);

    public Integer IncreaseEquipment(Equipment equipment);

    public Integer IncreaseElement(Element element);

    public Integer IncreaseDevice(Device device);

    List<Spare_Part> GetSparePartsByElementId(String elementId);

}
