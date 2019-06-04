package com.example.util;


import com.example.entity.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JsonBuilder {
    private JSONObject getBeanJsonObj(Object bean) {
        JSONObject resObj = new JSONObject();

        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                String type = field.getType().getName();
                switch (type) {
                    case "java.util.List":
                    case "java.lang.String":
                    case "int":
                    case "java.lang.Integer":
                    case "long":
                    case "java.lang.Long":
                        resObj.put(field.getName(), field.get(bean));
                        break;
                    default:
                        resObj.put(field.getName(), getBeanJsonObj(field.get(bean)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resObj;
    }

    public String buildEnvironmentCase(String tip, List<Environment> environment_list, List<Special_Case> special_case_list) {
        JSONObject resObj = new JSONObject();
        resObj.put("data_number", environment_list.size());
        resObj.put("case_number", special_case_list.size());
        resObj.put("data_list", environment_list);
        resObj.put("case_list", special_case_list);
        return resObj.toString();

    }

    public String buildScheme(List<Scheme> schemeList) throws JSONException {
        JSONObject resObj = new JSONObject();
        resObj.put("scheme", schemeList);
        return resObj.toString();
    }

    public String buildArmyList(List<Army> army_list) throws JSONException {
        JSONObject resObj = new JSONObject();
        resObj.put("total", army_list.size());
        resObj.put("rows", army_list);
        return resObj.toString();
    }

    public String buildActionGroupList(List<Action_Group> action_groups) throws JSONException {
        JSONObject resObj = new JSONObject();
        resObj.put("total", action_groups.size());
        resObj.put("rows", action_groups);
        return resObj.toString();
    }

    public String buildEquipmentList(List<Equipment> equipment_list) throws JSONException {
        JSONObject resObj = new JSONObject();
        resObj.put("total", equipment_list.size());
        resObj.put("rows", equipment_list);
        return resObj.toString();
    }

    public String buildElementList(List<Element> element_list) throws JSONException {
        JSONObject resObj = new JSONObject();
        resObj.put("total", element_list.size());
        resObj.put("rows", element_list);
        return resObj.toString();
    }

    public String buildMaintainList(List<Element_Maintain> element_maintain_list) throws JSONException {
        JSONObject resObj = new JSONObject();
        resObj.put("total", element_maintain_list.size());
        resObj.put("rows", element_maintain_list);
        return resObj.toString();
    }

    public String buildCategoryList(List<Category> category_list) throws JSONException {
        JSONObject resObj = new JSONObject();
        resObj.put("total", category_list.size());
        resObj.put("rows", category_list);
        return resObj.toString();
    }

    public String buildPlatoonCategoryList(List<Category> category_list) throws JSONException {
        JSONObject resObj = new JSONObject();
        resObj.put("total", category_list.size());
        resObj.put("rows", category_list);
        return resObj.toString();
    }

    public String buildSupplierList(List<Supplier> supplier_list) throws JSONException {
        JSONObject resObj = new JSONObject();
        resObj.put("total", supplier_list.size());
        resObj.put("rows", supplier_list);
        return resObj.toString();
    }

    public String buildCategoryCase(List<Category_Case> category_case) throws JSONException {
        JSONObject resObj = new JSONObject();
        resObj.put("total", category_case.size());
        resObj.put("rows", category_case);
        return resObj.toString();
    }

    public String buildTeamStrList(List<TeamStr> teamStrs) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total", teamStrs.size());
        jsonObject.put("rows", teamStrs);
        return jsonObject.toString();
    }

    public String buildDepartmentList(List<Department> departments) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total", departments.size());
        jsonObject.put("rows", departments);
        return jsonObject.toString();
    }

    public String buildPeopleList(List<People> people_list) throws JSONException {
        JSONObject resPbj = new JSONObject();
        resPbj.put("total", people_list.size());
        resPbj.put("rows", people_list);
        return resPbj.toString();
    }

    public String buildSpecailCase(Special_Case special_case) throws JSONException {
        JSONObject resObj = new JSONObject();
        resObj.put("message", "success");
        resObj.put("case_position", special_case.getCase_position());
        resObj.put("case_type", special_case.getCase_type());
        resObj.put("description", special_case.getDescription());
        return resObj.toString();
    }
}
