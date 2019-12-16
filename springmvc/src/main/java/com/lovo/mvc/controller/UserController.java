package com.lovo.mvc.controller;

import com.lovo.mvc.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //被spring管理
public class UserController {

   @RequestMapping("savaUser.lovo")
    public String savaUser(UserEntity userEntity ){
       System.out.println(userEntity.getUserName()+"/"+userEntity.getUserAge());
        return "index.jsp";
    }
   @RequestMapping("findUser.lovo")
    public String findUser(){
       return "error.jsp";
    }

}
