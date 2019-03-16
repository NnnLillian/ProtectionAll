package com.example.service;

import com.example.entity.*;

import java.util.List;

public interface EquipmentService {
    public List<Equipment> GetEquipmentByPlatoonIdAndType(Integer platoon_id,String type);

    public  void AddSchemeEquipment(Scheme_Equipment scheme_equipment);

    public  List<Element> GetElementByEquipmentId(Integer equipment_id);

    public List<Element_Maintain> GetElementMaintainByEquipmentId(Integer equipment_id);

    public  List<Category> GetCategoryByArmyIdAndType(Integer army_id,String category_type);

    public  List<Supplier> GetSupplierByPosition(String position);

    public  List<Category> GetCategoryByPlatoonIdAndType(Integer platoon_id,String category_type);

}
