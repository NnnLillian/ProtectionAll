package com.example.mappers;

import com.example.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentMapper {

    public List<Equipment> GetEquipmentByPlatoonIdAndType(@Param("platoon_id") Integer platoon_id, @Param("category_type") String category_type);

    public Integer GetEquipmentRepairCount(@Param("equipment_id") Integer equipment_id);

    public void AddSchemeEquipment(Scheme_Equipment scheme_equipment);

    public List<Element> GetElementByEquipmentId(Integer equipment_id);

    public List<Element_Maintain> GetElementMaintainByEquipmentId(Integer equipment_id);

    public String GetElementMaintainDate(Integer equipment_element_id);

    public List<Category> GetCategoryByArmyIdAndType(@Param("army_id") Integer army_id, @Param("category_type") String category_type);

    public List<Category> GetCategoryByPlatoonIdAndType(@Param("platoon_id") Integer platoon_id, @Param("category_type") String category_type);

    public void AddTeamCategory(Team_Category team_category);

    public Integer GetCategoryEquipmentCount(Integer category_id);

    public String GetSparePartName(Integer spare_part_id);

    public List<Supplier> GetSupplierByPosition(String position);

}
