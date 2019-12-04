package com;

import com.lovo.spring.bean.UserBean;
import com.lovo.spring.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    //创建spring
    ClassPathXmlApplicationContext app=null;
    IUserService service=null;
    @Before
    public  void before(){
       app=new ClassPathXmlApplicationContext("user.xml");
        service= (IUserService) app.getBean("userService");
        System.out.println(service);
        service= (IUserService) app.getBean("userService");
        System.out.println(service);
    }

    @Test
    public  void t(){}

    @Test
    public  void savaUser(){
        UserBean user=new UserBean();
        user.setUserName("赵云");
        service.savaUser(user);


    }

@Test
    public  void getAgeByName(){
    System.out.println( service.getAgeByName("zf"));
    }
}
