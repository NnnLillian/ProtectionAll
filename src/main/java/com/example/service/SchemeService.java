package com.example.service;

import com.example.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchemeService {

    public List<Platoon> RequestPlatoon();

    public List<Army> RequestArmy(Integer platoon_id);

    public Scheme GetSchemeBySchemeID(Integer scheme_id);

    public List<Army> GetArmyBySchemeID(Integer scheme_id);

    //如果添加成功，则返回scheme_id；失败则返回null
    public Integer AddScheme(Scheme scheme);

    public Integer GetLocationID(double longitude,double latitude);

    public void AddSchemeArmy(Scheme_Army scheme_army);

    public List<Scheme_Army> GetSchemeArmyBySchemeId(Integer scheme_id);

    //如果添加成功，则返回group_id；失败则返回null
    public void AddGroupIntoScheme(Group group);
}
