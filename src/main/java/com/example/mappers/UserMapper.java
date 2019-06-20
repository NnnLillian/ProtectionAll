package com.example.mappers;

import com.example.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    void SaveUser(User user);

    @Select("select * from user_info where id = #{id}")
    User findById(Long id);

    @Select("select * from user_info")
    List<User> findAll();

    @Delete("delete from user_info where id = #{id}")
    void delete(Long id);
}
