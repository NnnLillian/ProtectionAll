package com.example.service.impl;

import com.example.entity.Safety;
import com.example.entity.User;
import com.example.exception.BhException;
import com.example.mappers.SafetyMapper;
import com.example.mappers.UserMapper;
import com.example.service.SafetyService;
import com.example.util.CheckUtils;
import com.example.util.TimeUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SafetyServiceImpl implements SafetyService {
    @Autowired
    private SafetyMapper safetyMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Safety saveSafety(Safety safety) throws BhException {
        if (null == safety.getId()) {
            safety.setId(0L);
        }
        if (CheckUtils.isEmpty(safety.getMobile())) {
            throw new BhException("必须填写电话号码");
        } else if (CheckUtils.isEmpty(safety.getUsername())) {
            if (!CheckUtils.isEmpty(safety.getMobile())) {
                safety.setUsername(safety.getMobile());
            }
        }
//        通过safety_info的mobile和user_info的phone，可设置Uid。
        User user = userMapper.findByPhone(safety.getMobile());
        if (null != user) {
            safety.setUid(user.getId());
        } else {
            throw new BhException("必须关联到用户");
        }
        if (CheckUtils.isEmpty(safety.getUsername())) {
            throw new BhException("用户名不能为空");
        }
//        如果数据表中已经存在该条数据，则进行更新操作。
        Safety source = safetyMapper.findByUid(safety.getUid());
        if (null != source) {
            safety.setId(source.getId());
        }
        source = safetyMapper.findByUsername(safety.getUsername());
        if (null != source) {
            if (!safety.getUid().equals(source.getUid())) {
                throw new BhException("用户名已经被占用");
            }
            if (!source.getId().equals(safety.getId())) {
                if (CheckUtils.isEmpty(safety.getId())) {
                    safety.setId(source.getId());
                } else {
                    safetyMapper.deleteById(source.getId());
                }
            }
        }
        source = safetyMapper.findByMobile(safety.getMobile());
        if (null != source) {
            if (!safety.getUid().equals(source.getUid())) {
                throw new BhException("该电话号码已经被占用");
            }
            if (!source.getId().equals(safety.getId())) {
                if (CheckUtils.isEmpty(safety.getId())) {
                    safety.setId(source.getId());
                } else {
                    safetyMapper.deleteById(source.getId());
                }
            }
        }
//        密码不足32位时将密码加密
        if (!CheckUtils.isEmpty(safety.getPassword()) && safety.getPassword().length() != 32) {
            safety.setPassword(DigestUtils.md5Hex(safety.getPassword()));
        }
        Long now = TimeUtils.getCurrentTimeInMillis();
        String nowStr = TimeUtils.formatDateWithMilis("", now);
        if (CheckUtils.isEmpty(safety.getCreateTime())) {
            safety.setCreateTime(nowStr);
        }
        safety.setUpdateTime(nowStr);
        safetyMapper.save(safety);
        Long id = safety.getId();
        System.out.println("新增的SafetyUserId为:" + id);
        return safety;
    }

    @Override
    public void deleteSafety(Long id, Long uid) {
        if (!CheckUtils.isEmpty(uid)) {
            safetyMapper.deleteByUid(uid);
        }
        if (!CheckUtils.isEmpty(id)) {
            safetyMapper.deleteById(id);
        }
    }

    @Override
    public Safety loadSafety(Long uid, String username, String mobile) {
        Safety safety = null;
        if (!CheckUtils.isEmpty(uid)) {
            safety = safetyMapper.findByUid(uid);
        }
        if (null == safety && !CheckUtils.isEmpty(username)) {
            safety = safetyMapper.findByUsername(username);
        }
        if (null == safety && !CheckUtils.isEmpty(mobile)) {
            safety = safetyMapper.findByMobile(mobile);
        }
        return safety;
    }
}
