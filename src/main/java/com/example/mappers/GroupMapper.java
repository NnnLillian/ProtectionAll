package com.example.mappers;

import com.example.entity.Group;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMapper {
    public Group GetGroupByGroupId(Integer group_id);

    public Group GetGroupBySchemeId(Integer scheme_id);
}
