package com.example.service;

import com.example.entity.*;
import com.example.exception.BhException;

import java.util.List;


public interface UserService {
    User SaveUser(User user) throws BhException;

    User DeleteUserById(Long id);

    User GetUserById(Long id);

    List<User> RequestAllUser();
}
