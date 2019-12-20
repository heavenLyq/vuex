package com.newer.service;

import com.newer.dao.UserMapper;
import com.newer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper dao;


    public User login(String username,String password){
        return  dao.login(username,password);
    }
}
