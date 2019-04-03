package com.example;

import com.example.entity.Category;
import com.example.entity.Group;
import com.example.entity.Team;
import com.example.entity.TeamStr;
import com.example.mappers.ArmyMapper;
import com.example.mappers.EquipmentMapper;
import com.example.mappers.GroupMapper;
import net.minidev.json.writer.ArraysMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void getTeamMsg() {
        Group group = groupMapper.GetSchemeGroupBySchemeIdAndGroupType(12, "repair");
        Integer groupId = group.getGroup_id();
        String groupName = group.getGroup_name();
        List<Team> teamList = groupMapper.GetTeamByGroupId(groupId);
        List<TeamStr> teamStrList = new ArrayList<>();
        for (int i = 0; i < teamList.size(); i++) {
            TeamStr teamStr = new TeamStr();
            teamStr.setTeam_id(teamList.get(i).getTeam_id());
            String teamName = "第" + teamList.get(i).getTeam_name() + "装备抢修组";
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
            teamStrList.add(teamStr);
        }
    }
}
