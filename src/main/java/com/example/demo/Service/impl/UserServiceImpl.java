package com.example.demo.Service.impl;

import com.example.demo.Service.UserService;
import com.example.demo.bean.User;
import com.example.demo.mapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl  implements UserService {
    @Autowired
    Usermapper usermapper;
    @Override
    public User getByUserNameAndPassword(User user) {
        return usermapper.getByUserNameAndPassword(user);
    }



}

