package com.hibernate;

import com.lovo.hibernate.dao.IUserDao;
import com.lovo.hibernate.entity.UserEntity;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestH {

    @Test
    public void  savaUser(){
        //启动spring
        ClassPathXmlApplicationContext applicationContext
                =new ClassPathXmlApplicationContext("application.xml");
        //获得DAO
     IUserDao userDao= (IUserDao) applicationContext.getBean("userDao");
        //创建用户对象
        UserEntity userEntity=new UserEntity();
        userEntity.setUserId("1a");
        userEntity.setUserName("关羽");
        userEntity.setUserAge(30);

        //保存
        userDao.savaUser(userEntity);

    }

@Test
  public  void getUserById(){
    //启动spring
    ClassPathXmlApplicationContext applicationContext
            =new ClassPathXmlApplicationContext("application.xml");
    //获得DAO
    IUserDao userDao= (IUserDao) applicationContext.getBean("userDao");
   UserEntity user= userDao.getUserById("1a");
    System.out.println(user.getUserName());
  }
}
