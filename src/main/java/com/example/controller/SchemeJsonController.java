package com.example.controller;

import com.example.entity.*;
import com.example.mappers.Similar_SchemeMapper;
import com.example.service.*;
import com.example.util.JsonBuilder;
import com.example.util.JsonPaser;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class SchemeJsonController {

    @Autowired
    private SchemeService schemeService;

    @Autowired
    private EnvironmentService environmentService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private SimilarSchemeService similarSchemeService;

    @Autowired
    private ClassifyService classifyService;

    private JsonBuilder jsonBuilder = new JsonBuilder();

    JsonPaser jsonPaser = new JsonPaser();

    @ResponseBody
    @RequestMapping(value = "/AddSchemeMsg", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String AddScheme(@RequestBody String jsonStr) {
        System.out.println(jsonStr);
        Scheme scheme = jsonPaser.ParseScheme(jsonStr);
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
    @RequestMapping(value = "/AddActionGroupMsg", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String AddActionGroup(@RequestBody String jsonStr) {
        System.out.println(jsonStr);
        String actionGroupName = jsonPaser.ParseActionGroup(jsonStr);
        Location location = jsonPaser.ParseLocation(jsonStr);
        Integer locationID = schemeService.GetLocationID(location.getLongitude(), location.getLatitude());
        Action_Group actionGroup = new Action_Group(null, actionGroupName, locationID, 0, 0);
        schemeService.AddActionGroup(actionGroup);
        Integer action_group_id = schemeService.GetActionGroupId(actionGroup);
        return "{\"action_group_id\":" + action_group_id + "}";
    }

    @ResponseBody
    @RequestMapping(value = "/AddSchemeArmy", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String AddSchemeArmy(@RequestBody String jsonStr) {

        Integer scheme_id = jsonPaser.ParseSchemeId(jsonStr);
        Integer platoon_id = jsonPaser.ParsePlatoonId(jsonStr);
        System.out.println("AddSchemeArmy:" + jsonStr);
        List<Scheme_Army> scheme_army_list = jsonPaser.ParseSchemeArmy(jsonStr);
        for (int i = 0; i < scheme_army_list.size(); i++) {
            scheme_army_list.get(i).setScheme_id(scheme_id);
            scheme_army_list.get(i).setPlatoon_id(platoon_id);
            schemeService.AddSchemeArmy(scheme_army_list.get(i));
        }
        return null;

    }

    @ResponseBody
    @RequestMapping(value = "/AddSchemeSafeguard", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String AddSchemeSafe(@RequestBody String jsonStr) {
        Integer scheme_id = jsonPaser.ParseSchemeId(jsonStr);
        Integer safeguard_mode = jsonPaser.ParseSafeguardMode(jsonStr);
        Integer carry_method = jsonPaser.ParseCarryMethod(jsonStr);
        Integer base_id = jsonPaser.ParseBaseId(jsonStr);
        List<Platoon> platoons = jsonPaser.ParseSafeguardPlatoon(jsonStr);
        for (int i = 0; i < platoons.size(); i++) {
            Scheme_Safeguard scheme_safeguard = new Scheme_Safeguard(null, scheme_id, safeguard_mode, null, null, base_id, null, platoons.get(i).getPlatoon_id(), null, carry_method, null);
            schemeService.AddSchemeSafeGuard(scheme_safeguard);
            System.out.println("Add a scheme safe success");
        }
        List<Integer> similarSchemeIds = similarSchemeService.GetSimilarSchemeService(scheme_id);
        if (similarSchemeIds.size() == 0) {
            return "{\"similarExist\":" + "\"no\"" + "}";
        }
        return "{\"similarExist\":" + "\"yes\"" + "}";
    }


    //        完成scheme_Safeguard的填写后，返回推荐内容
    @ResponseBody
    @RequestMapping(value = "/GetSimilarScheme", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String GetSimilarScheme(@RequestBody Integer scheme_id) {
        System.out.println("schemeId:" + scheme_id);
        List<Integer> similarSchemeIds = similarSchemeService.GetSimilarSchemeService(scheme_id);
        List<Scheme> similarSchemeList = new ArrayList<>();
        for (Integer m : similarSchemeIds) {
            similarSchemeList.add(schemeService.GetSchemeBySchemeID(m));
        }
        System.out.println("similarSchemeIds:" + similarSchemeIds);
        return jsonBuilder.buildScheme(similarSchemeList);
    }

    @ResponseBody
    @RequestMapping(value = "/AddSimilarProtectionGroup/{id}", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String AddSimilarScheme(@PathVariable("id") Integer id,
                                   @RequestBody Integer scheme_id) {
        System.out.println("SimilarSchemeId: " + id);
        System.out.println("SchemeId: " + scheme_id);
        similarSchemeService.AddSimilarScheme(scheme_id, id);
//        得到三种保障小分队的人员List
        List<Team_People> repairTeamPeopleList = schemeService.RequestTeamPeopleBySchemeIdAndType(scheme_id, "repair");
        List<Team_People> protectTeamPeopleList = schemeService.RequestTeamPeopleBySchemeIdAndType(scheme_id, "protect");
        List<Team_People> supplyTeamPeopleList = schemeService.RequestTeamPeopleBySchemeIdAndType(scheme_id, "supply");
//        进行去重合并
        Set<Team_People> set = new HashSet<Team_People>();
        set.addAll(repairTeamPeopleList);
        set.addAll(protectTeamPeopleList);
        set.addAll(supplyTeamPeopleList);
        List<Team_People> teamStrList = new ArrayList<Team_People>(set);
        for (Team_People str : teamStrList) {
            schemeService.SetPeopleSelectState(str.getDepartment_id(), true);
        }
        return "{\"message\":" + "\"success\"" + "}";
    }

    @ResponseBody
    @RequestMapping(value = "/AddSchemeGroup", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String AddSchemeGroup(@RequestBody String jsonStr) {
        Group group = jsonPaser.ParseGroup(jsonStr);
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
    public String AddTeam(@RequestBody String jsonStr) {
        Team team = jsonPaser.ParseTeam(jsonStr);
        List<Team_Category> team_categoryList = jsonPaser.ParseTeamCategory(jsonStr);
        List<Team_Department> team_departmentList = jsonPaser.ParseTeamDepartment(jsonStr);
        List<Department> departmentList = jsonPaser.ParseDepartment(jsonStr);
        team.setTeam_category_list(team_categoryList);
        team.setTeam_department_list(team_departmentList);
        team.setDepartmentList(departmentList);
        Integer teamId = schemeService.AddTeam(team);
        if (teamId == 0) {
            return "{\"message\":" + "\"failed\"" + "}";
        }
//        通过TeamId查找DepartmentList
        List<Department> teamDepartmentListResults = schemeService.RequestTeamDepartmentByTeamId(teamId);
        for (Department d : teamDepartmentListResults) {
            schemeService.SetPeopleSelectState(d.getDepartment_id(), true);
        }
        return "{\"message\":" + "\"success\"" + "}";
    }

    @ResponseBody
    @RequestMapping(value = "/GetEnvironment", method = {RequestMethod.GET})
    public String RequestEnvironment(@Param("scheme_id") String scheme_id, @Param("month") String month, @Param("type") String type) {
        System.out.println(scheme_id + "......" + month + "........." + type);
        Scheme scheme = schemeService.GetSchemeBySchemeID(Integer.parseInt(scheme_id));
        Integer month_number = Integer.parseInt(month);
        System.out.println(scheme.getCombat_direction() + "......" + month_number + "........." + type);
//        List<Environment> environment_list = environmentService.GetEnvironment(1);
        String case_position = scheme.getCombat_direction();
        List<Environment> environment_list = environmentService.GetEnvironmentByCasePosition(case_position);
        System.out.println(environment_list);
        Special_Case special_case = new Special_Case(null, scheme.getCombat_direction(), null, month_number, null);
        List<Special_Case> special_case_list = environmentService.GetSpecialCase(special_case);

        return jsonBuilder.buildEnvironmentCase(type, environment_list, special_case_list);
    }

    @ResponseBody
    @RequestMapping(value = "/GetActionGroupsMsg", method = {RequestMethod.GET})
    public String RequestActionGroupMsg(@Param("scheme_id") String scheme_id) {
        List<Action_Group> actionGroups = schemeService.GetActionGroups(Integer.parseInt(scheme_id));
        System.out.println(jsonBuilder.buildActionGroupList(actionGroups));
        return jsonBuilder.buildActionGroupList(actionGroups);
    }

    @ResponseBody
    @RequestMapping(value = "/GetArmyMsg/{schemeId}", method = {RequestMethod.GET})
    public String GetArmyMsg(@PathVariable("schemeId") Integer schemeId,
                             @Param("platoon_id") Integer platoon_id,
                             @Param("army_type") String army_type) {
        List<Army> army_list;
        //  将已选择的armyId作标记
        List<Scheme_Army> schemeArmyList = schemeService.GetSchemeArmyBySchemeId(schemeId);
        if (army_type != null) {
            army_list = schemeService.RequestArmyByType(platoon_id, army_type);
        } else {
            army_list = schemeService.RequestArmy(platoon_id);
            System.out.println("ArmyMsg:" + army_list.size());
        }
        Map<Integer, String> map = new HashMap<>();
        for (Scheme_Army s : schemeArmyList) {
            map.put(s.getArmy_id(), s.getArmy_name());
        }
        for (int i = 0; i < army_list.size(); i++) {
            if (map.containsKey(army_list.get(i).getArmy_id())) {
                army_list.get(i).setState(true);
            }
        }
        return jsonBuilder.buildArmyList(army_list);
    }

    @ResponseBody
    @RequestMapping(value = "/GetArmyMsgBy", method = {RequestMethod.GET})
    public String GetArmyMsgByActionGroupId(@Param("action_group_id") Integer action_group_id) {

        List<Army> army_list = schemeService.RequestGroupArmy(action_group_id);
        System.out.println("ArmyMsg:" + army_list.size());
        return jsonBuilder.buildArmyList(army_list);
    }

    @ResponseBody
    @RequestMapping(value = "/GetEquipmentMsg/{scheme_id}", method = {RequestMethod.GET})
    public String GetEquipmentMsg(@PathVariable("scheme_id") Integer scheme_id,
                                  @Param("platoon_id") Integer platoon_id,
                                  @Param("type") String type) {
        List<Equipment> equipment_list = equipmentService.GetEquipmentByPlatoonIdAndType(platoon_id, type);
        Integer carryPattern = schemeService.GetOneSchemeSafeguardBySchemeId(scheme_id).getCarry_method();
        //  携装方式为“全装”时，默认全选状态
        if (carryPattern == 1) {
            for (int i = 0; i < equipment_list.size(); i++) {
                equipment_list.get(i).setState(true);
            }
        }
        return jsonBuilder.buildEquipmentList(equipment_list);
    }

    @ResponseBody
    @RequestMapping(value = "/GetSimilarEquipmentMsg/{id}", method = {RequestMethod.GET})
    public String GetSimilarEquipmentMsg(@PathVariable("id") Integer id,
                                         @Param("platoon_id") Integer platoon_id,
                                         @Param("type") String type) {
        List<Equipment> similarEquipmentList = schemeService.GetEquipmentBySchemeId(id);
        List<Equipment> equipment_list = equipmentService.GetEquipmentByPlatoonIdAndType(platoon_id, type);
        Map<String, String> map = new HashMap<>();
        for (Equipment s : similarEquipmentList) {
            map.put(s.getEquipment_id(), s.getEquipment_name());
        }
        for (int i = 0; i < equipment_list.size(); i++) {
            if (map.containsKey(equipment_list.get(i).getEquipment_id())) {
                equipment_list.get(i).setState(true);
            }
        }
        return jsonBuilder.buildEquipmentList(equipment_list);
    }

    @ResponseBody
    @RequestMapping(value = "/GetElementMsg", method = {RequestMethod.GET})
    public String GetElementMsg(@Param("equipment_id") String equipment_id) {
        System.out.println("getElementMsg");
        List<Element> element_list = equipmentService.GetElementByEquipmentId(equipment_id);
        return jsonBuilder.buildElementList(element_list);
    }

    @ResponseBody
    @RequestMapping(value = "/GetMaintainMsg", method = {RequestMethod.GET})
    public String GetMaintainMsg(@Param("equipment_id") String equipment_id) {
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
    @RequestMapping(value = "GetPlatoonCategoryMsg/{schemeId}", method = {RequestMethod.GET})
    public String GetPlatoonCategoryMsg(@PathVariable("schemeId") Integer schemeId, @Param("platoon_id") Integer platoon_id, @Param("type") String type) {
        System.out.println("getPlatoonCategory");
//        获取所有的装备列表
        List<Category> categoryList = equipmentService.GetCategoryByPlatoonIdAndType(platoon_id, type);
//        获取改方案下的保障team装备
        List<Team> teamList = schemeService.GetTeamBySchemeId(schemeId);
        List<Category> categories = new ArrayList<Category>();
        for (Team t : teamList) {
            List<Category> team_categoryList = schemeService.RequestTeamCategoryByTeamId(t.getTeam_id());
            categories.addAll(team_categoryList);
        }
//        将已选择的装备数量进行计算
        Map<Integer, Integer> map = new HashMap<>();
        for (Category c : categories) {
            map.put(c.getCategory_id(), c.getCategory_number());
        }
        for (int i = 0; i < categoryList.size(); i++) {
            Integer categoryId = categoryList.get(i).getCategory_id();
            if (map.containsKey(categoryId)) {
                Integer num = categoryList.get(i).getCategory_number() - map.get(categoryId);
                categoryList.get(i).setCategory_number(num);
            }
        }
        return jsonBuilder.buildPlatoonCategoryList(categoryList);
    }

    //    获得依托保障资源
    @ResponseBody
    @RequestMapping(value = "/GetBaseResource", method = {RequestMethod.GET})
    public String GetSupplierMsg(@Param("baseId") Integer baseId) {
        System.out.println("baseId:" + baseId);
        List<Supplier> supplier_list = equipmentService.GetSupplierByBase(baseId);
        return jsonBuilder.buildSupplierList(supplier_list);
    }

    //    获得民用保障资源
    @ResponseBody
    @RequestMapping(value = "/GetSupplierMsg", method = {RequestMethod.GET})
    public String GetSupplierMsg(@Param("case_position") String case_position) {
        System.out.println(case_position);
        List<Supplier> supplier_list = equipmentService.GetSupplierByPosition(case_position);
        return jsonBuilder.buildSupplierList(supplier_list);
    }

    //    获得人员信息
    @ResponseBody
    @RequestMapping(value = "/GetPeopleMsg/{schemeId}", method = {RequestMethod.GET})
    public String AddPeopleMsg(@PathVariable("schemeId") Integer schemeId, @Param("army_type") String army_type) {
        String Both = "both";
        List<People> peopleList = peopleService.GetPeopleByArmyType("expert");
        if (army_type.equals(Both)) {
            List<People> peopleList2 = peopleService.GetPeopleByArmyType("engineer");
            peopleList.addAll(peopleList2);
        }
        return jsonBuilder.buildPeopleList(peopleList);
    }

    //    获取保障小分队的table，对应表格在Team_resultProtection中
    @ResponseBody
    @RequestMapping(value = "/GetTeamMsg", method = {RequestMethod.GET})
    public String GetProtectionTeamMsg(@Param("scheme_id") Integer scheme_id, @Param("type") String type) {
        List<TeamStr> teamList = schemeService.RequestTeamBySchemeIdAndType(scheme_id, type);
        return jsonBuilder.buildTeamStrList(teamList);
    }

    //    获取保障小分队下的人员职责表，对应表格在edit_protection_group.html中的teamDepartment
    @ResponseBody
    @RequestMapping(value = "/GetTeamDepartmentMsg", method = {RequestMethod.GET})
    public String GetProTeamDepartmentMsg(@Param("teamId") Integer teamId) {
        List<Department> team_departmentList = schemeService.RequestTeamDepartmentByTeamId(teamId);
        return jsonBuilder.buildDepartmentList(team_departmentList);
    }

    //    获取保障小分队下的人员信息表，对应表格在edit_protection_group.html中的InitSonTable，是一个子表，父表为teamDepartment
    @ResponseBody
    @RequestMapping(value = "/GetDepartmentPeople", method = {RequestMethod.GET})
    public String GetDepartmentPeopleMsg(@Param("departmentId") Integer departmentId) {
        List<People> peopleList = schemeService.RequestPeopleByDepartmentId(departmentId);
        return jsonBuilder.buildPeopleList(peopleList);
    }

    //    获取保障小分队下的装备信息表，对应表格在edit_protection_group.html中的teamCategory
    @ResponseBody
    @RequestMapping(value = "/GetTeamCategoryMsg", method = {RequestMethod.GET})
    public String GetProTeamCategoryMsg(@Param("teamId") Integer teamId) {
        List<Category> team_categoryList = schemeService.RequestTeamCategoryByTeamId(teamId);
        return jsonBuilder.buildCategoryList(team_categoryList);
    }

    //  删除保障小分队
    @ResponseBody
    @RequestMapping(value = "/DeleteTeam", method = {RequestMethod.DELETE})
    public void DeleteTeam(@Param("teamId") Integer teamId) {
        //        通过TeamId查找DepartmentList
        List<Department> teamDepartmentListResults = schemeService.RequestTeamDepartmentByTeamId(teamId);
        for (Department d : teamDepartmentListResults) {
            schemeService.SetPeopleSelectState(d.getDepartment_id(), false);
        }
        schemeService.DeleteTeam(teamId);
    }

    @ResponseBody
    @RequestMapping(value = "/DeleteActionGroup", method = {RequestMethod.DELETE})
    public void DeleteActionGroup(@Param("groupId") Integer groupId) {
        System.out.println(groupId);
        schemeService.DeleteActionGroup(groupId);
    }

    @ResponseBody
    @RequestMapping(value = "/GetCategoryCase", method = {RequestMethod.GET})
    public String GetCategoryCase(@Param("equipment_id") Integer category_id, @Param("case_position") String case_position) {
        List<Category_Case> category_case_list = environmentService.GetCategoryCase(category_id, case_position);
        return jsonBuilder.buildCategoryCase(category_case_list);
    }

    //    增加特情信息
    @ResponseBody
    @RequestMapping(value = "/AddSpecialCase", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String AddSpecialCase(@RequestBody String jsonStr) {
        Special_Case special_case = jsonPaser.ParseSpecialCase(jsonStr);
        //  n是关键词数目
        Integer caseId = classifyService.AddSpecialCase(special_case, 5);
        if (caseId != 0) {
        //  通过caseId获取case
            Special_Case specialCaseResult = schemeService.GetSpecialCaseById(caseId);
            String caseType = specialCaseResult.getCase_type();
            switch (caseType) {
                case "geography":
                    specialCaseResult.setCase_type("地理环境特情");
                    break;
                case "climate":
                    specialCaseResult.setCase_type("气候环境特情");
                    break;
                case "border":
                    specialCaseResult.setCase_type("边境环境特情");
                    break;
                case "category":
                    specialCaseResult.setCase_type("装备环境特情");
                    break;
                default:
                    specialCaseResult.setCase_type("其他特情");
                    break;
            }
            return jsonBuilder.buildSpecailCase(specialCaseResult);
        } else {
            return "{\"message\":" + "\"failed\"" + "}";
        }
    }

}
