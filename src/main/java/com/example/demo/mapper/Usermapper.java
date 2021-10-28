package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Usermapper {
    //通过用户名密码查询用户数据
    @Select("select * from user where login=#{login} and password=#{password}")
    User getByUserNameAndPassword(User user);

    List<User> findall();
}