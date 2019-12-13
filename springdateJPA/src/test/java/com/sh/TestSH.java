package com.sh;

import com.lovo.sh.entity.UserEntity;
import com.lovo.sh.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSH {
    IUserService service;
    @Before
    public  void before(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("springJPA.xml");
      service= (IUserService) applicationContext.getBean("userService");
    }
   @Test
    public  void savaUser(){
        UserEntity userEntity=new UserEntity();
        userEntity.setUserName("赵云");
        userEntity.setUserAge(30);
        userEntity.setMessage("hello zy");
      service.savaUser(userEntity);
    }
}
