package com.example.mappers;

import com.example.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SafetyMapper {
    @Insert("insert into safety_info (uid, username, mobile, password, createTime, updateTime) values (#{uid}, #{username}, #{mobile}, #{password}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void save(Safety safety);

    Safety findByUsernameAndUinNot(String username, Long uid);

    Safety findByMobileAndUidNot(String mobile, Long uid);

    @Select("select * from safety_info where uid = #{uid}")
    Safety findByUid(Long uid);

    @Select("select * from safety_info where username = #{username}")
    Safety findByUsername(String username);

    @Select("select * from safety_info where mobile = #{mobile}")
    Safety findByMobile(String mobile);

    @Transactional
    @Delete("delete from safety_info where uid = #{uid}")
    void deleteByUid(Long uid);

    @Transactional
    @Delete("delete from safety_info where id = #{id}")
    void deleteById(Long id);
}
