package com.example.service;

import com.example.entity.*;

import java.util.List;

public interface SimilarSchemeService {
    //    选出相似的推荐方案
    public List<Integer> GetSimilarSchemeService(Integer schemeId);

    //    将推荐方案中的保障小分队信息加入现有方案
    public void AddSimilarScheme(Integer scheme_id, Integer similarSchemeId);

}
