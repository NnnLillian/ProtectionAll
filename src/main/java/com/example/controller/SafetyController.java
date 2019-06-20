package com.example.controller;

import com.example.entity.Safety;
import com.example.entity.User;
import com.example.exception.BhException;
import com.example.service.SafetyService;
import com.example.service.UserService;
import com.example.util.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SafetyController {
    @Autowired
    private UserService userService;
    @Autowired
    private SafetyService safetyService;

    @RequestMapping(value = "/user/safety/save", method = {RequestMethod.POST})
    public String SaveSafety(@RequestBody Safety safety) throws BhException {
        if (CheckUtils.isEmpty(safety.getMobile())) {
            throw new BhException("电话不能为空");
        }
        User user = userService.GetUserByPhone(safety.getMobile());
        if (null == user) {
            // 如果不是对某个用户设置登录参数则创建一个新用户，用户注册时
            user = new User();
            String name = safety.getUsername();
            if (CheckUtils.isEmpty(name)) {
                name = safety.getMobile();
            }
            user.setPhone(safety.getMobile());
            user.setName(name);
            user = userService.SaveUser(user);
        }
        safety.setUid(user.getId());
        safety = safetyService.saveSafety(safety);
        return "{ \"safetyId\": \"" + safety.getId() + "\"}";
    }
}
