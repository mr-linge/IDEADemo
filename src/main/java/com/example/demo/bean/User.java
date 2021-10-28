package com.example.demo.bean;

import lombok.Getter;
import lombok.Setter;
import sun.dc.pr.PRError;


@Setter
@Getter
public class User {

    private  int id;
    private  String login;
    private String password;
    private  String role;

}
