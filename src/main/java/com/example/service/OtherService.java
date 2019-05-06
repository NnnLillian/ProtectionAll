package com.example.service;

import com.example.entity.Category;
import com.example.entity.Device;
import com.example.entity.Element;
import com.example.entity.Equipment;

import java.util.List;

public interface OtherService {
    public void AddDevice(List<Device> list, String platoon_name, String army_name);
    public void AddCategory(List<Category> list);
    public void AddElement(List<Element> list, String platoon_name, String army_name);
    public void AddEquipment(List<Equipment> list, String platoonName);
}
