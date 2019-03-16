package com.example.util;

import com.example.entity.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonPaser {
    private void JsonArrayToList(JSONArray jsonArray, List<Object> list) throws JSONException {
        for (int i = 0; i < jsonArray.length(); i++)
            list.add(jsonArray.get(i));
    }
    private Object JsonObjToBeanObj(JSONObject jsonObj, Object bean) {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field: fields) {
            if (!jsonObj.has(field.getName()))
                continue;
            field.setAccessible(true);
            try {
                String type = field.getType().getName();
                switch (type) {
                    case "java.util.List":
                        List<Object> list = new ArrayList<>();
                        JsonArrayToList((JSONArray)jsonObj.get(field.getName()), list);
                        field.set(bean, list);
                        break;
                    case "java.lang.String":
                    case "java.lang.Integer":
                    case "int":
                    case "double":
                    case "long":
                    case "java.lang.Long":
                        field.set(bean, jsonObj.get(field.getName()));
                        break;
                    default:
                        Object obj = Class.forName(type).newInstance();
                        JsonObjToBeanObj((JSONObject)jsonObj.get(field.getName()), obj);
                        field.set(bean, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
    public Location ParseLocation(String jsonStr) throws JSONException
    {
        JSONObject jsonObj = new JSONObject(jsonStr);
        Location location = new Location();
        JsonObjToBeanObj(jsonObj.getJSONObject("location"),location);
        return location;
    }
    public Scheme ParseScheme(String jsonStr) throws JSONException
    {
        JSONObject jsonObj = new JSONObject(jsonStr);
        Scheme scheme = new Scheme();
        JsonObjToBeanObj(jsonObj.getJSONObject("scheme"),scheme);
        return scheme;
    }


    public List<Scheme_Army> ParseSchemeArmy(String jsonStr) throws JSONException
    {
        JSONObject jsonObj = new JSONObject(jsonStr);
        List<Scheme_Army> list = new ArrayList<>();
        JSONArray scheme_army_list_json = jsonObj.getJSONArray("scheme_army_list");
        for(int i=0;i<scheme_army_list_json.length();i++)
        {
            JSONObject id_json = scheme_army_list_json.getJSONObject(i);
            Scheme_Army scheme_army = new Scheme_Army();
            JsonObjToBeanObj(id_json.getJSONObject("scheme_army"),scheme_army);
            list.add(scheme_army);
        }
        return list;
    }
    public List<Scheme_Equipment> ParseSchemeEquipment(String jsonStr)
    {
        JSONObject jsonObj = new JSONObject(jsonStr);
        List<Scheme_Equipment> list = new ArrayList<>();
        JSONArray list_json = jsonObj.getJSONArray("scheme_equipment_list");
        for (int i=0;i<list_json.length();i++)
        {
            JSONObject equipment_id_json = list_json.getJSONObject(i);
            Scheme_Equipment scheme_equipment = new Scheme_Equipment();
            JsonObjToBeanObj(equipment_id_json.getJSONObject("scheme_equipment"),scheme_equipment);
            list.add(scheme_equipment);
        }
        return list;

    }

    public Integer ParseSchemeId(String jsonStr) throws JSONException
    {
        JSONObject jsonObj = new JSONObject(jsonStr);
        return  jsonObj.getInt("scheme_id");
    }
}
