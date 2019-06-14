package com.example;

import com.example.entity.*;
import com.example.mappers.*;
import com.example.service.EnvironmentService;
import com.example.service.EvaluateService;
import com.example.service.SchemeService;
import com.example.service.SimilarSchemeService;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import net.minidev.json.writer.ArraysMapper;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private ArmyMapper armyMapper;
    @Autowired
    private PeopleMapper peopleMapper;
    @Autowired
    private SchemeMapper schemeMapper;
    @Autowired
    private SimilarSchemeService similarSchemeService;
    @Autowired
    private Similar_SchemeMapper similarSchemeMapper;
    @Autowired
    private SchemeService schemeService;
    @Autowired
    private EnvironmentMapper environmentMapper;
    @Autowired
    private EnvironmentService environmentService;
    @Autowired
    private Special_CaseMapper specialCaseMapper;
    @Autowired
    private EvaluateMapper evaluateMapper;
    @Autowired
    private EvaluateService evaluateService;

    @Test
    public void checkGetGroup() {
        Group group1 = groupMapper.GetSchemeGroupBySchemeIdAndGroupType(12, "repair");
        System.out.println(group1);
    }

    @Test
    public void getProtectCategory() {
        List<Category> categoryList = equipmentMapper.GetCategoryByPlatoonIdAndType(1, "protect");
        System.out.println(categoryList);
    }

    @Test
    public void getPeople() {
        Team_Department team_department = groupMapper.GetTeamDepartmentByDepartmentId(19);
        String peopleStrs = team_department.getDepartment_people();
        String peopleStr = peopleStrs.substring(1, peopleStrs.length() - 1);
        String[] peopleListStr = peopleStr.split(",");
        List<People> peopleList = new ArrayList<>();
        for (int i = 0; i < peopleListStr.length; i++) {
            Integer peopleId = Integer.parseInt(peopleListStr[i]);
            peopleList.add(peopleMapper.GetPeopleByPeopleID(peopleId));
        }
    }

    @Test
    public void IncreaseCategories() {
        Category category = new Category();
        category.setCategory_name("111");
        category.setCategory_model("xk254");
        category.setCategory_type("action");
        category.setCategory_unit("台");
        int flag; // flag:1表示成功；0表示失败；
        Category category1 = equipmentMapper.GetCategoryByNameAndModel(category.getCategory_name(), category.getCategory_model());
        if (category1 != null) {
            flag = 0;
        } else {
            equipmentMapper.IncreaseCategory(category);
            flag = 1;
        }

        System.out.println(flag);
    }

    @Test
    public void AboutSafeguard() {
        Scheme_Safeguard scheme_safeguard = schemeMapper.GetSchemeSafeguardBySchemeID(16).get(0);
        System.out.println(scheme_safeguard.getBase_id());
        System.out.println(scheme_safeguard.getBase_name());
    }

    @Test
    public void TeamStrMsg() {
        Group group = groupMapper.GetSchemeGroupBySchemeIdAndGroupType(16, "repair");
        Integer groupId = group.getGroup_id();
        String groupName = group.getGroup_name();
        List<Team> teamList = groupMapper.GetTeamByGroupId(groupId);
        List<TeamStr> teamStrList = new ArrayList<>();
        for (int i = 0; i < teamList.size(); i++) {
            TeamStr teamStr = new TeamStr();
            Integer teamId = teamList.get(i).getTeam_id();
            teamStr.setTeam_id(teamId);
            String teamName = "第" + teamList.get(i).getTeam_name() + groupName;
            teamStr.setTeam_name(teamName);
            teamStr.setGroup_name(groupName);
            String armyIds = teamList.get(i).getArmy_id();
            String[] armyId = armyIds.split(",");
            String armyNames = "";
            for (int j = 0; j < armyId.length; j++) {
                String armyName = armyMapper.GetArmyByArmyId(Integer.parseInt(armyId[j])).getArmy_name();
                armyNames = armyName + "、" + armyNames;
            }
            teamStr.setArmy_name(armyNames);
            teamStr.setTeam_duty(teamList.get(i).getTeam_duty());
            List<Team_Department> teamDepartmentList = groupMapper.GetTeamDepartmentByTeamId(teamId);
            String memberMsg = teamDepartmentList.get(2).getDepartment_people();
            String[] memberList = memberMsg.split(",");
            Integer memberCount = memberList.length;
            teamStr.setTeam_people_count(memberCount + 2);
            String categoryMsg = "";
            List<Team_Category> teamCategoryList = groupMapper.GetTeamCategoryByTeamId(teamId);
            for (Team_Category teamCategory : teamCategoryList) {
                categoryMsg = categoryMsg + teamCategory.getCategory_name() + " " + teamCategory.getCategory_number() + teamCategory.getCategory_unit() + "、";
            }
            teamStr.setTeam_category_msg(categoryMsg);
            teamStrList.add(teamStr);
        }
    }

    @Test
    public void TeamPeopleMsg() {
        Group group = groupMapper.GetSchemeGroupBySchemeIdAndGroupType(16, "repair");
    }

    @Test
    public void SelectSimilarScheme() {
//        选择出Action相似的schemeId
        List<Integer> schemeIdList1 = similarSchemeMapper.GetSimilarActionSchemeId("1", "1", "4", "5");
        System.out.println("action: " + schemeIdList1);
//        选择出Safeguards相似的schemeId
        List<Integer> schemeIdList2 = similarSchemeMapper.GetSimilarSafeguardSchemeId(1, 6);
        System.out.println("safeguard: " + schemeIdList2);

//        选择出两个数组中相同的部分并输出
        HashSet<Integer> sameHash = new HashSet(schemeIdList1);
        sameHash.retainAll(schemeIdList2);
        System.out.println(sameHash);

//        将HashSet转化为Array
        Integer[] sameList = new Integer[sameHash.size()];
        sameList = sameHash.toArray(sameList);

//        存放相似内容的schemeId List
        List<Integer> similarSchemeId = new ArrayList<>();
        for (int i = 0; i < sameList.length; i++) {
//            输出不同scheme的作战规模（作战队伍数量）
            Integer armyCount = similarSchemeMapper.GetSchemeArmyCountBySchemeId(sameList[i]);
//            如果作战规模相似，则加入similarSchemeId
            if (armyCount == 3) {
                similarSchemeId.add(sameList[i]);
            }
        }
    }

    @Test
    public void ReturnSimilarSchemeId() {
        List<Integer> similarSchemeIds = similarSchemeService.GetSimilarSchemeService(18);
        List<Scheme> similarSchemeList = new ArrayList<>();
        for (Integer m : similarSchemeIds) {
            similarSchemeList.add(schemeMapper.GetSchemeBySchemeID(m));
        }
        System.out.println(similarSchemeList);
    }

    @Test
    public void RemoveList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("beijing");
        list.add("shanghai");
        list.add("shanghai");
        list.add("guangzhou");
        list.add("shenzhen");
        list.add("hangzhou");
        list.remove("shanghai");
        System.out.println(list);
    }

    @Test
    public void AddSimilarSchemeGroup() {
        //  将相似方案的groupInfo复制给当前方案
        similarSchemeMapper.AddSchemeSimilarGroup(25, 7);
        //  得到当前方案的groupInfo
        List<Group> groupList = groupMapper.GetGroupBySchemeId(7);
        for (Group i : groupList) {
            //  得到相似方案的TeamInfo
            List<Team> similarTeamInfo = groupMapper.GetTeamBySchemeIdAndTeamType(25, i.getGroup_type());
            for (Team t : similarTeamInfo) {
                t.setGroup_id(i.getGroup_id());
                Integer similarTeamId = t.getTeam_id();
                //  将相似方案的teamInfo复制给当前方案
                groupMapper.AddTeam(t);
                //  得到当前方案的TeamId；
                Integer teamId = t.getTeam_id();
                //  将相似方案的teamCategoryInfo复制给当前方案
                similarSchemeMapper.AddSchemeSimilarTeamCategory(similarTeamId, teamId);
                //  得到相似方案的teamDepartment
                List<Team_Department> similarDepartmentList = groupMapper.GetTeamDepartmentByTeamId(similarTeamId);
                //  将相似方案的department_info复制给当前方案
                for (Team_Department td : similarDepartmentList) {
                    Integer similarDepartmentId = td.getDepartment_id();
                    similarSchemeMapper.AddSchemeSimilarDepartment(similarDepartmentId);
                    Integer department_id = groupMapper.GetDepartmentLastItem();
                    similarSchemeMapper.AddSchemeSimilarTeamDepartment(similarDepartmentId, teamId, department_id);
                }
            }

        }
    }

    @Test
    public void AddSimilarSchemeEquipment() {
        List<Equipment> e = schemeMapper.GetSchemeEquipmentBySchemeId(25);
        List<Equipment> alle = equipmentMapper.GetEquipmentByPlatoonIdAndType(1, "action");
//        List<Equipment> e = equipmentMapper.GetEquipmentByPlatoonIdAndType(1,"action");

        Map<String, String> map = new HashMap<>();
        for (Equipment m : e) {
            map.put(m.getEquipment_id(), m.getEquipment_name());
        }

        for (int i = 0; i < alle.size(); i++) {
            if (map.containsKey(alle.get(i).getEquipment_id())) {
                alle.get(i).setState(true);
            }
        }
        System.out.println("After For");
        for (Equipment m : alle) {
            System.out.println(m.getState());
        }
    }

    @Test
    public void AddTeam() {
        Team team = new Team();
        team.setGroup_id(15);
        team.setTeam_name("2");
        team.setArmy_id("1");
        team.setTeam_type("123321");
        groupMapper.AddTeam(team);
        System.out.println(team.getTeam_id());
    }

    @Test
    public void ChangeCheck() {
        Integer scheme_id = 33;
        Integer id = 32;
//        similarSchemeService.AddSimilarScheme(scheme_id, id);
//        得到三种保障小分队的List
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
    }

    @Test
    public void testSql() {
        List<Category> categoryList = equipmentMapper.GetCategoryByPlatoonIdAndType(1, "protect");
        List<Team> teamList = schemeService.GetTeamBySchemeId(33);
        List<Category> categories = new ArrayList<Category>();
        for (Team t : teamList) {
            List<Category> team_categoryList = schemeService.RequestTeamCategoryByTeamId(t.getTeam_id());
            categories.addAll(team_categoryList);
        }
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
    }

    @Test
    public void GetEnvironmentTips() {
        String type = "temperature";
        Scheme scheme = schemeMapper.GetSchemeBySchemeID(34);
        Integer beginMonth = Integer.parseInt(scheme.getScheme_begin_time().substring(5, 7));
        Integer endMonth = Integer.parseInt(scheme.getScheme_end_time().substring(5, 7));
        List<Environment> eList = environmentMapper.GetEnvironmentByCasePosition(scheme.getCombat_direction());
        List<Environment> environments = eList.subList(beginMonth - 1, endMonth);
        List<Double> r = environmentService.GetResultByType(type, environments);
        //  获取不同类型的数据标准
        List<Double> standard = environmentService.GetTypeStandard(type);
        Double lowStandard = standard.get(0);
        Double highStandard = standard.get(1);
        if (Collections.max(r) > highStandard) {
            List<Special_Case> specialCaseList = specialCaseMapper.GetEnvironmentSpecialCase(type, 6, 10);
            System.out.println(specialCaseList);
        }
    }

    @Test
    public void Try() {
        List<Integer> schemeList = evaluateMapper.GetSchemeIdWhereEvaluateCountMore(2);
        System.out.println(schemeList);
    }
}
