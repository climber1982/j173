package com.service;

import com.lovo.mvc.entity.UserEntity;
import com.lovo.mvc.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TUser {

    IUserService userService=null;

    @Before
    public  void before(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("springJPA.xml");
         userService= (IUserService) applicationContext.getBean("userService");
    }
    @Test
    public  void savaUser(){
        UserEntity user=new UserEntity();
        user.setUserName("马超24");
        user.setUserAge(30);
        user.setMessage("先锋");
        userService.savaUser(user);
    }


}
