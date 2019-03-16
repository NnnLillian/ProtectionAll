package com.example.mappers;

import com.example.entity.Environment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvironmentMapper {

    /*
    * environment 中location_id必须有,temperature\pressure\rainfall\snowfall\wind_level需要存在
    * */
    public List<Environment> GetEnvironment(@Param("location_id") Integer location_id);
    /*
    * location_id : 位置id，month：月份
    * */

    public void AddEnvironment(Environment environment);

    public void ModifyEnvironment(Environment environment);
}
