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
    public List<Element> GetElementByEquipmentId(Integer equipment_id) {
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
    public List<Supplier> GetSupplierByPosition(String position) {
        return equipmentMapper.GetSupplierByPosition(position);
    }

}
