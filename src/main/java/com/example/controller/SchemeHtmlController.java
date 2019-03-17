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

    @GetMapping("/next")
    public String GetNext() {
        return "edit_step";
    }

    @GetMapping("/edit_people")
    public String GetEditPeople() {
        return "edit_people";
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
        List<Equipment> equipmentList = schemeService.GetEquipmentBySchemeId(scheme_id);
        List<Team> repairTeamList = schemeService.GetTeamBySchemeIdAndTeamType(scheme_id, "repair");
        List<Team> protectTeamList = schemeService.GetTeamBySchemeIdAndTeamType(scheme_id, "protect");
        Integer repairTeamCount = repairTeamList.size();
        Integer protectTeamCount = protectTeamList.size();
        model.addAttribute("army_list",armyList);
        model.addAttribute("equipment_list",equipmentList);
        model.addAttribute("repair_team_list",repairTeamList);
        model.addAttribute("protect_team_list",protectTeamList);
        model.addAttribute("repairTeamCount", repairTeamCount);
        model.addAttribute("protectTeamCount",protectTeamCount);
        return "text";
    }

    @GetMapping("/special_info")
    public String GetSpecialInfo() {
        return "special_info";
    }

    @GetMapping("/try")
    public String Try() {
        return "try";
    }

}