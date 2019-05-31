package com.example.service.impl;

import com.example.entity.*;
import com.example.mappers.ArmyMapper;
import com.example.mappers.OtherMapper;
import com.example.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OtherServiceImpl implements OtherService {

    @Autowired
    OtherMapper otherMapper;
    @Autowired
    ArmyMapper armyMapper;
    @Override
    public void AddDevice(List<Device> list,String platoon_name,String army_name) {
        Platoon platoon = armyMapper.GetPlatoonByName(platoon_name);
        if (platoon == null)
            armyMapper.IncreasePlatoon(platoon_name);
        platoon = armyMapper.GetPlatoonByName(platoon_name);
        Army army = armyMapper.GetArmyByNameAndPlatooId(army_name,platoon.getPlatoon_id());
        if (army == null)
        {
            army = new Army(false,null,platoon.getPlatoon_id(),army_name,0,"normal");
            armyMapper.IncreaseArmy(army);
        }
        army = armyMapper.GetArmyByNameAndPlatooId(army_name,platoon.getPlatoon_id());
        for (int i=0;i<list.size();i++)
        {
            Device device = list.get(i);
            device.setPlatoon_id(platoon.getPlatoon_id());
            device.setArmy_id(army.getArmy_id());
            Category category = otherMapper.GetCategoryByName(device.getCategory_name());
            if (category == null)
            {
                category = new Category();
                category.setCategory_name(device.getCategory_name());
                otherMapper.AddCategory(category);
                category = otherMapper.GetCategoryByName(category.getCategory_name());
            }
            device.setCategory_id(category.getCategory_id());
            Device device1 = otherMapper.GetDeviceByNameAndModel(device.getDevice_name(),device.getDevice_modal());
            if (device1 == null)
            {

                otherMapper.AddDevice(device);
                System.out.println("Yes");

            }
        }

    }

    @Override
    public void AddCategory(List<Category> list) {
        for (int i=0;i<list.size();i++)
        {
            Category category = otherMapper.GetCategoryByName(list.get(i).getCategory_name());
            if (category == null)
            {
                otherMapper.AddCategory(list.get(i));
                System.out.println("Yes");
            }

        }
    }

    @Override
    public void AddElement(List<Element> list,String platoon_name,String army_name) {
        Platoon platoon = armyMapper.GetPlatoonByName(platoon_name);
        if (platoon == null)
            armyMapper.IncreasePlatoon(platoon_name);
        platoon = armyMapper.GetPlatoonByName(platoon_name);
        Army army = armyMapper.GetArmyByNameAndPlatooId(army_name,platoon.getPlatoon_id());
        if (army == null)
        {
            army = new Army(false,null,platoon.getPlatoon_id(),army_name,0,"normal");
            armyMapper.IncreaseArmy(army);
        }
        army = armyMapper.GetArmyByNameAndPlatooId(army_name,platoon.getPlatoon_id());
        for (int i=0;i<list.size();i++)
        {
            Element element = list.get(i);
            element.setArmy_id(army.getArmy_id());
            Category category = otherMapper.GetCategoryByName(element.getCategory_name());
            if (category == null)
            {
                category = new Category();
                category.setCategory_name(element.getCategory_name());
                otherMapper.AddCategory(category);
                category = otherMapper.GetCategoryByName(category.getCategory_name());
            }
            element.setCategory_id(category.getCategory_id());
            Element element1 = otherMapper.GetElementByElementAndCategoryId(element.getElement_name(),element.getCategory_id());
            if (element1 == null)
            {
                otherMapper.AddElement(element);
                System.out.println("Yes");
            }
        }
    }

    @Override
    public void AddEquipment(List<Equipment> list, String platoonName) {
        Platoon platoon = armyMapper.GetPlatoonByName(platoonName);
        if (platoon == null)
            armyMapper.IncreasePlatoon(platoonName);
        platoon = armyMapper.GetPlatoonByName(platoonName);
        for (int i=0;i<list.size();i++)
        {
            Equipment equipment = list.get(i);
            equipment.setPlatoon_id(platoon.getPlatoon_id());
            Category category = otherMapper.GetCategoryByName(equipment.getCategory_name());
            if (category == null)
            {
                category = new Category(null,equipment.getCategory_name(),equipment.getCategory_modal(),equipment.getEquipment_type(),equipment.getCategory_unit(),equipment.getComment(),0);
                otherMapper.AddCategory(category);
            }
            category = otherMapper.GetCategoryByName(equipment.getCategory_name());
            equipment.setCategory_id(category.getCategory_id());
            Army army = armyMapper.GetArmyByNameAndPlatooId(equipment.getArmy_name(),platoon.getPlatoon_id());
            if (army == null)
            {
                army = new Army(false,null,platoon.getPlatoon_id(),equipment.getArmy_name(),0,"normal");
                armyMapper.IncreaseArmy(army);
            }

            army = armyMapper.GetArmyByNameAndPlatooId(equipment.getArmy_name(),platoon.getPlatoon_id());
            equipment.setArmy_id(army.getArmy_id());
            Equipment equipment1 = otherMapper.GetEquipment(equipment.getEquipment_id());
            if (equipment1 == null)
            {
                otherMapper.AddEquipment(equipment);
            }
        }
    }
}
