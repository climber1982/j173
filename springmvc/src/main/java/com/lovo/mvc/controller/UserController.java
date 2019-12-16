package com.lovo.mvc.controller;

import com.lovo.mvc.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Controller //被spring管理
public class UserController {

   @RequestMapping("savaUser.lovo")
    public String savaUser(UserEntity userEntity, String userName, String userAge, ServletRequest request, ServletResponse response){
       System.out.println(userEntity.getUserName()+"/"+userEntity.getUserAge());

        return "index.jsp";
    }
   @RequestMapping("findUser.lovo")
    public String findUser(){
       return "error.jsp";
    }

}
