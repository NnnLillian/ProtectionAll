package com.example.service.impl;

import java.util.List;
import java.util.UUID;

import com.example.entity.User;
import com.example.exception.BhException;
import com.example.mappers.UserMapper;
import com.example.service.UserService;
import com.example.util.CheckUtils;
import com.example.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User SaveUser(User user) throws BhException {
        if (null == user.getId()) {
            user.setId(0L);
        }
        if (CheckUtils.isEmpty(user.getName())) {
            throw new BhException("用户名称不能为空");
        }
        Long now = TimeUtils.getCurrentTimeInMillis(); // 取当前时间戳
        String nowStr = TimeUtils.formatDateWithMilis("", now);
        if (CheckUtils.isEmpty(user.getCreateTime())) {
            user.setCreateTime(nowStr);
        }
        user.setUpdateTime(nowStr);
        userMapper.SaveUser(user);
//        得到插入后的主键
        Long id = user.getId();
        if (id != 0L) {
            System.out.println("user插入成功");
        }
        return user;
    }

    @Override
    public User DeleteUserById(Long id) {
        if (CheckUtils.isEmpty(id)) {
            return null;
        }
        User user = userMapper.findById(id);
        if (null != user) {
            userMapper.delete(user.getId());
            return user;
        }
        return null;
    }

    @Override
    public User GetUserById(Long id) {
        User user = null;
        if (null == user && !CheckUtils.isEmpty(id)) {
            user = userMapper.findById(id);
        }
        return user;
    }

    @Override
    public List<User> RequestAllUser() {
        List<User> users = userMapper.findAll();
        return users;
    }

}
