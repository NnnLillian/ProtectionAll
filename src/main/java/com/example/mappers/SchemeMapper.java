package com.example.mappers;

import com.example.entity.Group;
import com.example.entity.Scheme;
import com.example.entity.Scheme_Army;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchemeMapper {

    public Scheme GetSchemeBySchemeName(String scheme_name);

    public Scheme GetSchemeBySchemeCode(String scheme_Code);

    public List<Scheme_Army> GetSchemeArmyBySchemeId(Integer scheme_id);

    public Scheme GetSchemeBySchemeID(Integer scheme_id);

    public Scheme_Army GetSchemeArmyNumber(Scheme_Army scheme_army);

    public void AddScheme(Scheme scheme);

    public void AddSchemeArmy(Scheme_Army scheme_army);

    public void AddSchemeEquipment(@Param("scheme_id") Integer scheme_id, @Param("equipment_id") Integer equipment_id);

    public void ModifyScheme(Scheme scheme);

    public void ModifySchemeArmy(Scheme_Army scheme_army);

    public void DeleteSchemeEquipment(@Param("scheme_id") Integer scheme_id, @Param("equipment_id") Integer equipment_id);

    public void DeleteScheme(@Param("scheme_id") Integer scheme_id);

    public void AddGroupIntoScheme(Group group);
}
