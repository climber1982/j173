package com.sh;

import com.lovo.sh.entity.UserEntity;
import com.lovo.sh.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
        userEntity.setUserName("赵云1");
        userEntity.setUserAge(30);
        userEntity.setMessage("hello zy");
      service.savaUser(userEntity);
    }
    @Test
    public  void findAll(){
       List<UserEntity> list= service.findAll();
       for (UserEntity userEntity:list){
           System.out.println(userEntity.getUserName());
       }
    }
    @Test
    public void getListByAge(){
        List<UserEntity> list= service.getUserListByAge(30);
        for (UserEntity userEntity:list){
            System.out.println(userEntity.getUserName());
        }
    }
}
