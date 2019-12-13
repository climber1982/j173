package com.hibernate;

import com.lovo.hibernate.dao.BasicDAO;
import com.lovo.hibernate.entity.UserEntity;
import com.lovo.hibernate.service.IPersonService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class FrameT {
    IPersonService service=null;
    @Before
    public  void before(){
        //启动spring
        ClassPathXmlApplicationContext applicationContext
                =new ClassPathXmlApplicationContext("application.xml");
    service = (IPersonService) applicationContext.getBean("personService");
    }
@Test
    public  void sava(){
        UserEntity user=new UserEntity();
        user.setUserName("关羽11111");
        service.savaUser(user);
    }
@Test
    public void del(){
        service.delUserById("402883c56efd2abc016efd2ac1990000");
    }

    @Test
    public  void findList(){
     List<UserEntity> list=   service.getListUserByAge(30);
     for (UserEntity userEntity:list){
         System.out.println(userEntity.getUserName());
     }
    }
}
