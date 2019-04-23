package com.example;

import com.example.entity.*;
import com.example.mappers.*;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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
    public void ReturnSimilarSchemeId(){
       List<Integer> similarSchemeIds =similarSchemeService.GetSimilarSchemeService(18);
        List<Scheme> similarSchemeList = new ArrayList<>();
        for(Integer m : similarSchemeIds){
            similarSchemeList.add(schemeMapper.GetSchemeBySchemeID(m));
        }
        System.out.println(similarSchemeList);
    }

    @Test
    public void RemoveList(){
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
}
