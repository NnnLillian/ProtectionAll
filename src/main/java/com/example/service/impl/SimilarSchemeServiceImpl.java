package com.example.service.impl;

import com.example.entity.*;
import com.example.mappers.*;
import com.example.service.SimilarSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Service
public class SimilarSchemeServiceImpl implements SimilarSchemeService {

    @Autowired
    private Similar_SchemeMapper similarSchemeMapper;
    @Autowired
    private SchemeMapper schemeMapper;
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public List<Integer> GetSimilarSchemeService(Integer schemeId) {
        Scheme schemeAction = schemeMapper.GetSchemeBySchemeID(schemeId);
        Scheme_Safeguard schemeSafeguard = schemeMapper.GetSchemeSafeguardBySchemeID(schemeId).get(0);
//        选择出Action相似的schemeId
        List<Integer> schemeIdList1 = similarSchemeMapper.GetSimilarActionSchemeId(schemeAction.getCombat_direction(), schemeAction.getScheme_type(), schemeAction.getScheme_begin_time().substring(5,7), schemeAction.getScheme_end_time().substring(5,7));
//        选择出Safeguards相似的schemeId
        List<Integer> schemeIdList2 = similarSchemeMapper.GetSimilarSafeguardSchemeId(schemeSafeguard.getCarry_method(), schemeSafeguard.getSafeguard_mode());

//        选择出两个数组中相同的部分并输出
        HashSet<Integer> sameHash = new HashSet<>(schemeIdList1);
        sameHash.retainAll(schemeIdList2);

//        将HashSet转化为Array
        Integer[] sameList = new Integer[sameHash.size()];
        sameList = sameHash.toArray(sameList);

//        存放相似内容的schemeId List
        List<Integer> similarSchemeId = new ArrayList<>();
        for (int i = 0; i < sameList.length; i++) {
//            输出不同scheme的作战规模（作战队伍数量）
            Integer armyCount = similarSchemeMapper.GetSchemeArmyCountBySchemeId(sameList[i]);
//            如果作战规模相似，则加入similarSchemeId
            if (armyCount == similarSchemeMapper.GetSchemeArmyCountBySchemeId(schemeId)) {
                similarSchemeId.add(sameList[i]);
            }
        }

//        删除新生成的那个ID, 但是这种方法只能删除一次
//        如果 数组为[18,18,19,20] 执行 .remove(18) 得到 [18,19,20]
        similarSchemeId.remove(schemeId);

        return similarSchemeId;
    }

    @Override
    public void AddSimilarScheme(Integer scheme_id, Integer similarSchemeId) {
        //  将相似方案的groupInfo复制给当前方案
        similarSchemeMapper.AddSchemeSimilarGroup(similarSchemeId, scheme_id);
        //  得到当前方案的groupInfo
        List<Group> groupList = groupMapper.GetGroupBySchemeId(scheme_id);
        for (Group i : groupList) {
            //  得到相似方案的TeamInfo
            List<Team> similarTeamInfo = groupMapper.GetTeamBySchemeIdAndTeamType(similarSchemeId, i.getGroup_type());
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


}
