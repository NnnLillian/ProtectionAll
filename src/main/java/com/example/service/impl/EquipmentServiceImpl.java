package com.example.service.impl;

import com.example.entity.*;
import com.example.mappers.*;
import com.example.service.EquipmentService;
import com.example.util.Reliability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> GetEquipmentByPlatoonIdAndType(Integer Platoon_id, String type) {
        List<Equipment> list = equipmentMapper.GetEquipmentByPlatoonIdAndType(Platoon_id,type);
        return list;
    }

    @Override
    public void AddSchemeEquipment(Scheme_Equipment scheme_equipment) {
        equipmentMapper.AddSchemeEquipment(scheme_equipment);
    }

    @Override
    public List<Element> GetElementByEquipmentId(String equipment_id) {
        return equipmentMapper.GetElementByEquipmentId(equipment_id);
    }

    @Override
    public List<Element_Maintain> GetElementMaintainByEquipmentId(Integer equipment_id) {
        return equipmentMapper.GetElementMaintainByEquipmentId(equipment_id);
    }

    @Override
    public List<Category> GetCategoryByArmyIdAndType(Integer army_id, String category_type) {
        return equipmentMapper.GetCategoryByArmyIdAndType(army_id, category_type);
    }

    @Override
    public List<Category> RequestCategoryByType(String category_type) {
        return equipmentMapper.RequestCategoryByType(category_type);
    }

    @Override
    public List<Supplier> GetSupplierByPosition(String position) {
        return equipmentMapper.GetSupplierByPosition(position);
    }

    @Override
    public List<Category> GetCategoryByPlatoonIdAndType(Integer platoon_id, String category_type) {
        return equipmentMapper.GetCategoryByPlatoonIdAndType(platoon_id, category_type);
    }

    @Override
    public Integer IncreaseCategory(Category category) {
        int flag; // flag:1表示成功；0表示失败；
        Category category1 = equipmentMapper.GetCategoryByNameAndModel(category.getCategory_name(), category.getCategory_model());
        if (category1 != null) {
            flag = 0;
        } else {
            equipmentMapper.IncreaseCategory(category);
            flag = 1;
        }
        return flag;
    }

    @Override
    public Integer IncreaseEquipment(Equipment equipment) {
        equipmentMapper.IncreaseEquipment(equipment);
        return 1;
    }

    @Override
    public Integer IncreaseElement(Element element) {
        equipmentMapper.IncreaseElement(element);
        return 1;
    }

    @Override
    public Integer IncreaseDevice(Device device) {
        equipmentMapper.IncreaseDevice(device);
        return 1;
    }

}
