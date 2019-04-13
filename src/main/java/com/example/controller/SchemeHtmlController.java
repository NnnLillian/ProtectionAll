package com.example.controller;

import com.example.entity.*;
import com.example.entity.Scheme_Army;
import com.example.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class SchemeHtmlController {

    @Autowired
    private SchemeService schemeService;

    @GetMapping("/GetPlatoonMsg")
    public String GetPlatoonMsg(Model model) {
        List<Platoon> platoon_list = schemeService.RequestPlatoon();
        model.addAttribute("platoon_list", platoon_list);
        return "edit";
    }

    @RequestMapping(value = "/ShowMap", method = {RequestMethod.GET})
    public String ShowMap() {
        System.out.println("map...........");
        return "map_suggestions";
    }

    @GetMapping("/head")
    public String GetHead() {
        return "head";
    }

    @GetMapping("/left")
    public String GetLeft() {
        return "left";
    }

    @GetMapping("/geographic_temperature")
    public String GetTem() {
        return "geographic_temperature";
    }

    @GetMapping("/geographic_rainfall")
    public String GetRain() {
        return "geographic_rainfall";
    }

    @GetMapping("/geographic_snowfall")
    public String GetSnow() {
        return "geographic_snowfall";
    }

    @GetMapping("/geographic_sunshine")
    public String GetSunshine() {
        return "geographic_sunshine";
    }

    @GetMapping("/geographic_windLevel")
    public String GetWind() {
        return "geographic_windLevel";
    }

    @GetMapping("/geographic_AirPressure")
    public String GetPress() {
        return "geographic_AirPressure";
    }

    @GetMapping("/geographic_corrosion")
    public String GetCorrosion() {
        return "geographic_corrosion";
    }

    @GetMapping("/next")
    public String GetNext() {
        return "edit_step";
    }

    @GetMapping("/edit_action")
    public String GetAction(Model model) {
        List<Platoon> platoon_list = schemeService.RequestPlatoon();
        model.addAttribute("platoon_list", platoon_list);
        return "edit_action";
    }

    @GetMapping("/edit_people_Groups")
    public String GetEditPeopleGroups() {
        return "edit_people_Groups";
    }

    @GetMapping("/edit_people_oneGroup")
    public String GetEditPeopleOneGroup() {
        return "edit_people_oneGroup";
    }

    @GetMapping("/edit_protection")
    public String GetEditProtection(Model model) {
        List<Platoon> platoon_list = schemeService.RequestPlatoon();
        List<Base> baseList = schemeService.RequestBase();
        model.addAttribute("base_list", baseList);
        model.addAttribute("platoon_list", platoon_list);
        return "edit_protection";
    }

    @GetMapping("/edit_protection_group")
    public String GetEditPeople(@RequestParam("scheme_id") Integer scheme_id, Model model) {
        List<Army> armyList = schemeService.GetArmyBySchemeID(scheme_id);
        model.addAttribute("army_list", armyList);
        return "edit_protection_group";
    }

    @GetMapping("/protectionTeam_result")
    public String GetProtectionGroupResult() {
        return "protectionTeam_result";
    }

    @GetMapping("/edit_equipment")
    public String GetEditEquipment(@RequestParam("scheme_id") Integer scheme_id, Model model) {
        List<Scheme_Army> army_list = schemeService.GetSchemeArmyBySchemeId(scheme_id);
        System.out.println(scheme_id);
        model.addAttribute("army_list", army_list);
        return "edit_equipment";
    }

    @GetMapping("/edit_action_resource")
    public String GetEditActionResource(@RequestParam("scheme_id") Integer scheme_id, Model model) {
        return "edit_action_resource";
    }

    @GetMapping("/edit_special")
    public String GetEdiSpecialInfo() {
        return "edit_special";
    }

    @GetMapping("/edit_step")
    public String GetEditContent(@RequestParam("scheme_id") Integer scheme_id, Model model) {
        List<Scheme_Army> army_list = schemeService.GetSchemeArmyBySchemeId(scheme_id);
        System.out.println(scheme_id);
        model.addAttribute("army_list", army_list);
        return "edit_step";
    }

    @GetMapping("/scheme_show")
    public String GetSchemeShowContent(@RequestParam("scheme_id") Integer scheme_id, Model model) {
        Scheme scheme = schemeService.GetSchemeBySchemeID(scheme_id);
        model.addAttribute("schemeList", scheme);
        return "scheme_show";
    }

    @GetMapping("/text")
    public String GetTextContent(@RequestParam("scheme_id") Integer scheme_id, Model model) {
        List<Army> armyList = schemeService.GetArmyBySchemeID(scheme_id);
        List<Scheme_Army> scheme_armyList = schemeService.GetSchemeArmyBySchemeId(scheme_id);
        List<Action_Group> action_groupList = schemeService.GetActionGroups(scheme_id);
        List<Equipment> equipmentList = schemeService.GetEquipmentBySchemeId(scheme_id);
        List<TeamStr> repairTeamStrList = schemeService.RequestTeamBySchemeIdAndType(scheme_id, "repair");
        Integer repairTeamPeople = 0;
        String repairTeamCategory = "";
        for (TeamStr repairTeamStr : repairTeamStrList) {
            repairTeamPeople += repairTeamStr.getTeam_people_count();
            repairTeamCategory += repairTeamStr.getTeam_category_msg();
        }
        List<TeamStr> protectTeamList = schemeService.RequestTeamBySchemeIdAndType(scheme_id, "protect");
        Integer protectTeamPeople = 0;
        String protectTeamCategory = "";
        for (TeamStr protectTeamStr : protectTeamList) {
            protectTeamPeople += protectTeamStr.getTeam_people_count();
            repairTeamCategory += protectTeamStr.getTeam_category_msg();
        }
        List<TeamStr> supplyTeamList = schemeService.RequestTeamBySchemeIdAndType(scheme_id, "supply");
        Integer supplyTeamPeople = 0;
        String supplyTeamCategory = "";
        for (TeamStr supplyTeamStr : supplyTeamList) {
            supplyTeamPeople += supplyTeamStr.getTeam_people_count();
            repairTeamCategory += supplyTeamStr.getTeam_category_msg();
        }
        List<Scheme_Safeguard> scheme_safeguardList = schemeService.GetSchemeSafeguardBySchemeID(scheme_id);
        Scheme_Safeguard scheme_safeguard1 = scheme_safeguardList.get(0);
        model.addAttribute("army_list", armyList);
        model.addAttribute("action_group_list", action_groupList);
        model.addAttribute("scheme_army_list", scheme_armyList);
        model.addAttribute("scheme_safeguard", scheme_safeguardList);
        model.addAttribute("oneScheme_safeguard", scheme_safeguard1);
        model.addAttribute("equipment_list", equipmentList);
        model.addAttribute("repair_team_list", repairTeamStrList);
        model.addAttribute("repair_people_count", repairTeamPeople);
        model.addAttribute("repair_team_category", repairTeamCategory);
        model.addAttribute("protect_team_list", protectTeamList);
        model.addAttribute("protect_people_count", protectTeamPeople);
        model.addAttribute("protect_team_category", protectTeamCategory);
        model.addAttribute("supply_team_list", supplyTeamList);
        model.addAttribute("supply_people_count", supplyTeamPeople);
        model.addAttribute("supply_team_category", supplyTeamCategory);
        return "text";
    }

    @GetMapping("/special_info")
    public String GetSpecialInfo() {
        return "special_info";
    }

    @GetMapping("/people_directory")
    public String GetPeopleMsg() {
        return "people_directory";
    }

    @GetMapping("/try")
    public String Try() {
        return "try";
    }

}