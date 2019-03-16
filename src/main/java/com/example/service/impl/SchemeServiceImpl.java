package com.example.service.impl;

import com.example.entity.*;
import com.example.mappers.ArmyMapper;
import com.example.mappers.GroupMapper;
import com.example.mappers.LocationMapper;
import com.example.mappers.SchemeMapper;
import com.example.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemeServiceImpl implements SchemeService {
    @Autowired
    private ArmyMapper armyMapper;
    @Autowired
    private SchemeMapper schemeMapper;
    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public List<Platoon> RequestPlatoon() {
        return armyMapper.GetPlatoon();
    }

    @Override
    public List<Army> RequestArmy(Integer platoon_id) {
        return armyMapper.GetArmyByPlatoonId(platoon_id);
    }

    @Override
    public Scheme GetSchemeBySchemeID(Integer scheme_id) {
        return schemeMapper.GetSchemeBySchemeID(scheme_id);
    }

    @Override
    public List<Army> GetArmyBySchemeID(Integer scheme_id) {
        return armyMapper.GetArmyBySchemeId(scheme_id);
    }

    @Override
    public Integer AddScheme(Scheme scheme) {
        Scheme scheme1 = schemeMapper.GetSchemeBySchemeCode(scheme.getScheme_code());
        if (scheme1 != null) {
            return null;
        } else {
            schemeMapper.AddScheme(scheme);
            return schemeMapper.GetSchemeBySchemeCode(scheme.getScheme_code()).getScheme_id();
        }
    }

    @Override
    public Integer GetLocationID(double longitude, double latitude) {
        Integer locationID = locationMapper.GetLocationID(longitude, latitude);
        if (locationID != null)
            return locationID;
        else {
            Location location = new Location(null, longitude, latitude);
            locationMapper.AddLocation(location);
            locationID = locationMapper.GetLocationID(longitude, latitude);
            return locationID;
        }
    }

    @Override
    public void AddSchemeArmy(Scheme_Army scheme_army) {
        Scheme_Army schemeArmy = schemeMapper.GetSchemeArmyNumber(scheme_army);
        if (schemeArmy != null) {
            schemeMapper.ModifySchemeArmy(scheme_army);
        } else {
            schemeMapper.AddSchemeArmy(scheme_army);
        }
    }

    @Override
    public List<Scheme_Army> GetSchemeArmyBySchemeId(Integer scheme_id) {
        return schemeMapper.GetSchemeArmyBySchemeId(scheme_id);
    }

    @Override
    public void AddGroupIntoScheme(Group group) {

            schemeMapper.AddGroupIntoScheme(group);

    }
}
