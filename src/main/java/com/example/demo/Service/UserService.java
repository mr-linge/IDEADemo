package com.example.demo.Service;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    User getByUserNameAndPassword(User user);


}
