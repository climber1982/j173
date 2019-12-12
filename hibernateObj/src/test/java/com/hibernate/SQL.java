package com.hibernate;

import com.lovo.hibernate.dao.BasicDAO;
import com.lovo.hibernate.entity.RoleEntity;
import com.lovo.hibernate.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.management.Query;
import java.util.List;

public class SQL {
    BasicDAO basicDAO=null;
    Session session=null;
    @Before
    public  void before(){
        //启动spring
        ClassPathXmlApplicationContext applicationContext
                =new ClassPathXmlApplicationContext("application.xml");
        basicDAO= (BasicDAO) applicationContext.getBean("basicDAO");
        session=basicDAO.getOpenSession();
    }

    @Test
    public void test1(){
        String sql="select * from sys_user";
        NativeQuery query= session.createSQLQuery(sql);
        query.addEntity(UserEntity.class) ; //把SQL查询出来的结果放入到实体。实体是要被hibernate管理的类
       List<UserEntity> list= query.list();
       for (UserEntity user:list){
           System.out.println(user.getUserName());
       }
    }
     @Test
    public  void test2(){
       String sql="select u.*,r.* from sys_user u LEFT JOIN  sys_role_user ru on u.id=ru.u_id " +
               "                         LEFT JOIN  sys_role r on ru.r_id =r.r_id " +
               "                         where u.userName=?1 ";
     List<Object[]> list=
       session.createSQLQuery(sql)
               .addEntity("u",UserEntity.class)
               .addEntity("r", RoleEntity.class)
               .setParameter(1,"赵云")
               .list();
         System.out.println(list.size());
    }


}
