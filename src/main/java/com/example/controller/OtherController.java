package com.example.controller;

import com.example.entity.Category;
import com.example.entity.Device;
import com.example.entity.Element;
import com.example.entity.Equipment;
import com.example.service.OtherService;
import com.example.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class OtherController {

    private ExcelUtil excelUtil = new ExcelUtil();
    @Autowired
    private OtherService otherService;
    @RequestMapping(value = "/Device", method = { RequestMethod.POST })
    public String addDevice(@RequestParam("pathName") String pathName,@RequestParam("platoonName") String platoon_name,@RequestParam("armyName") String army_name) throws Exception{
        List<Device> deviceList =excelUtil.GetDevice(pathName);
        otherService.AddDevice(deviceList,platoon_name,army_name);
        return "device_file";
    }
    @RequestMapping(value = "/Category", method = { RequestMethod.POST })
    public String addCategory(@RequestParam("pathName") String pathName) throws Exception{
        List<Category> categoryList =excelUtil.GetCategory(pathName);
        otherService.AddCategory(categoryList);
        return "category_file";
    }
    @RequestMapping(value = "/Element", method = { RequestMethod.POST })
    public String addElement(@RequestParam("pathName") String pathName,@RequestParam("platoonName") String platoon_name,@RequestParam("armyName") String army_name) throws Exception{
        List<Element> elementList = excelUtil.GetElement(pathName);
        otherService.AddElement(elementList,platoon_name,army_name);
        return "element_file";
    }
    @RequestMapping(value = "/Equipment", method = { RequestMethod.POST })
    public String addEquipment(@RequestParam("pathName") String pathName,@RequestParam("platoonName") String platoon_name) throws Exception{
        List<Equipment> equipmentList = excelUtil.GetEquipment(pathName);
        otherService.AddEquipment(equipmentList,platoon_name);
        return "equipment_file";
    }
}
