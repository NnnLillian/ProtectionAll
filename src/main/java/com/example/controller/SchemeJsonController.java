package com.example.controller;

import com.example.entity.*;
import com.example.service.EnvironmentService;
import com.example.service.EquipmentService;
import com.example.service.SchemeService;
import com.example.util.JsonBuilder;
import com.example.util.JsonPaser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SchemeJsonController {

    @Autowired
    private SchemeService schemeService;

    @Autowired
    private EnvironmentService environmentService;

    @Autowired
    private EquipmentService equipmentService;

    private JsonBuilder jsonBuilder = new JsonBuilder();

    JsonPaser jsonPaser = new JsonPaser();

    @ResponseBody
    @RequestMapping(value = "/AddSchemeMsg", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String AddScheme(@RequestBody String jsonStr) {
        System.out.println(jsonStr);
        Scheme scheme = jsonPaser.ParseScheme(jsonStr);
        scheme.setScheme_name("方案");
        Location location = jsonPaser.ParseLocation(jsonStr);
        Integer locationID = schemeService.GetLocationID(location.getLongitude(), location.getLatitude());

        scheme.setLocation_id(locationID);
        Integer scheme_id = schemeService.AddScheme(scheme);

        if (scheme_id == null) {
            System.out.println("error");
            throw new AssertionError("任务代号已存在");
        } else {
            return "{\"scheme_id\":" + scheme_id + "}";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/AddSchemeArmy", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String AddSchemeArmy(@RequestBody String jsonStr) {
        Integer scheme_id = jsonPaser.ParseSchemeId(jsonStr);
        System.out.println(jsonStr);
        List<Scheme_Army> scheme_army_list = jsonPaser.ParseSchemeArmy(jsonStr);
        for (int i = 0; i < scheme_army_list.size(); i++) {
            scheme_army_list.get(i).setScheme_id(scheme_id);
            schemeService.AddSchemeArmy(scheme_army_list.get(i));
        }
        return null;

    }

    @ResponseBody
    @RequestMapping(value = "/AddSchemeGroup", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String AddSchemeGroup(@RequestBody String jsonStr) {
        Integer scheme_id = jsonPaser.ParseSchemeId(jsonStr);
        //增加scheme中的group
        Group group = new Group();
        group.setScheme_id(scheme_id);
        group.setGroup_name("保障机构编组");
        group.setGroup_type("protectionGroup");

        Integer group_id = schemeService.AddGroupIntoScheme(group);
        return "{\"group_id\":" + group_id + "}";
    }

    @ResponseBody
    @RequestMapping(value = "/AddSchemeEquipment", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String AddSchemeEquipment(@RequestBody String jsonStr) {
        System.out.println(jsonStr);
        Integer scheme_id = jsonPaser.ParseSchemeId(jsonStr);
        List<Scheme_Equipment> scheme_equipment_list = jsonPaser.ParseSchemeEquipment(jsonStr);
        for (int i = 0; i < scheme_equipment_list.size(); i++) {
            scheme_equipment_list.get(i).setScheme_id(scheme_id);
            equipmentService.AddSchemeEquipment(scheme_equipment_list.get(i));
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/AddTeam", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String AddRepairTeam(@RequestBody String jsonStr){
        Team team = jsonPaser.ParseTeam(jsonStr);
        List<Team_Category> team_categoryList = jsonPaser.ParseTeamCategory(jsonStr);
        List<Team_Department> team_departmentList = jsonPaser.ParseTeamDepartment(jsonStr);
        team.setTeam_category_list(team_categoryList);
        team.setTeam_department_list(team_departmentList);
        return schemeService.AddTeam(team);
    }

    @ResponseBody
    @RequestMapping(value = "/GetEnvironment", method = {RequestMethod.GET})
    public String RequestEnvironment(@Param("scheme_id") String scheme_id, @Param("month") String month, @Param("type") String type) {
        System.out.println(scheme_id + "......" + month + "........." + type);
        Scheme scheme = schemeService.GetSchemeBySchemeID(Integer.parseInt(scheme_id));
        Integer month_number = Integer.parseInt(month);
        System.out.println(scheme.getCombat_direction() + "......" + month_number + "........." + type);
        List<Environment> environment_list = environmentService.GetEnvironment(scheme.getLocation_id());
        Special_Case special_case = new Special_Case(null, scheme.getCombat_direction(), null, month_number, null);
        List<Special_Case> special_case_list = environmentService.GetSpecialCase(special_case);

        return jsonBuilder.buildEnvironmentCase(type, environment_list, special_case_list);
    }

    @ResponseBody
    @RequestMapping(value = "/GetArmyMsg", method = {RequestMethod.GET})
    public String GetArmyMsg(@Param("platoon_id") Integer platoon_id) {

        List<Army> army_list = schemeService.RequestArmy(platoon_id);
        System.out.println("ArmyMsg:" + army_list.size());
        return jsonBuilder.buildArmyList(army_list);
    }

    @ResponseBody
    @RequestMapping(value = "/GetEquipmentMsg", method = {RequestMethod.GET})
    public String GetEquipmentMsg(@Param("platoon_id") Integer platoon_id, @Param("type") String type) {
        List<Equipment> equipment_list = equipmentService.GetEquipmentByPlatoonIdAndType(platoon_id, type);

        return jsonBuilder.buildEquipmentList(equipment_list);
    }

    @ResponseBody
    @RequestMapping(value = "/GetElementMsg", method = {RequestMethod.GET})
    public String GetElementMsg(@Param("equipment_id") Integer equipment_id) {
        System.out.println("getElementMsg");
        List<Element> element_list = equipmentService.GetElementByEquipmentId(equipment_id);
        return jsonBuilder.buildElementList(element_list);
    }

    @ResponseBody
    @RequestMapping(value = "/GetMaintainMsg", method = {RequestMethod.GET})
    public String GetMaintainMsg(@Param("equipment_id") Integer equipment_id) {
        List<Element_Maintain> element_maintain_list = equipmentService.GetElementMaintainByEquipmentId(equipment_id);
        return jsonBuilder.buildMaintainList(element_maintain_list);
    }

    @ResponseBody
    @RequestMapping(value = "/GetCategoryMsg", method = {RequestMethod.GET})
    public String GetCategoryMsg(@Param("army_id") Integer army_id, @Param("type") String type) {
        List<Category> category_list = equipmentService.GetCategoryByArmyIdAndType(army_id, type);
        return jsonBuilder.buildCategoryList(category_list);
    }

    @ResponseBody
    @RequestMapping(value = "GetPlatoonCategoryMsg", method = {RequestMethod.GET})
    public String GetPlatoonCategoryMsg(@Param("platoon_id") Integer platoon_id, @Param("type") String type) {
        System.out.println("getPlatoonCategory");
        List<Category> categoryList = equipmentService.GetCategoryByPlatoonIdAndType(platoon_id, type);
        return jsonBuilder.buildPlatoonCategoryList(categoryList);
    }

    //    获得民用保障资源
    @ResponseBody
    @RequestMapping(value = "/GetSupplierMsg", method = {RequestMethod.GET})
    public String GetSupplierMsg(@Param("case_position") String case_position) {
        List<Supplier> supplier_list = equipmentService.GetSupplierByPosition(case_position);
        return jsonBuilder.buildSupplierList(supplier_list);
    }

    @ResponseBody
    @RequestMapping(value = "/DeleteTeam", method = {RequestMethod.POST})
    public String DeleteTeam(@RequestBody String jsonStr){
        System.out.println(jsonStr);
        Integer team_id = jsonPaser.ParseTeamId(jsonStr);
        schemeService.DeleteTeam(team_id);
        return "{}";
    }
}
