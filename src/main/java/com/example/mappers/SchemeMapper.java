package com.example.mappers;

import com.example.entity.*;
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

    public List<Equipment> GetSchemeEquipmentBySchemeId(Integer scheme_id);

    public List<Scheme_Safeguard> GetSchemeSafeguardBySchemeID(Integer scheme_id);

//    public Scheme_Safeguard GetOneSchemeSafeguardMsyBySchemeId(Integer scheme_id);

    public void AddScheme(Scheme scheme);

    public void AddSchemeArmy(Scheme_Army scheme_army);

    public void AddGroupIntoScheme(Group group);

    public void AddSchemeEquipment(@Param("scheme_id") Integer scheme_id, @Param("equipment_id") Integer equipment_id);

    public void ModifyScheme(Scheme scheme);

    public void ModifySchemeArmy(Scheme_Army scheme_army);

    public void AddSchemeSafeGuard(Scheme_Safeguard scheme_safeguard);

    public void DeleteSchemeEquipment(@Param("scheme_id") Integer scheme_id, @Param("equipment_id") Integer equipment_id);

    public void DeleteScheme(@Param("scheme_id") Integer scheme_id);

    public void DeleteSchemeActionGroup(@Param("action_group_id") Integer army_action_group);

    void AddSchemeCase(@Param("scheme_id") Integer scheme_id, @Param("caseId") Integer caseId);

    List<Integer> RequestSchemeId();
}
