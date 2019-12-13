package com.hibernate;

import com.lovo.hibernate.dao.BasicDAO;
import com.lovo.hibernate.dto.UserDto;
import com.lovo.hibernate.entity.RoleEntity;
import com.lovo.hibernate.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.management.Query;
import java.util.List;
import java.util.Map;

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
   @Test
    public void test3(){
      String sql="select u.userName,u.age,r.r_name from sys_user u LEFT JOIN  sys_role_user ru on u.id=ru.u_id " +
                "                         LEFT JOIN  sys_role r on ru.r_id =r.r_id " +
                "                         where u.userName=?1 ";
   List<Map> list=
      session.createSQLQuery(sql)
              .unwrap(NativeQueryImpl.class)//拆包,
              .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)//数据放入MAP
              .setParameter(1,"赵云")
              .list();

      for(Map map:list){
          System.out.println(map.get("userName")+"/"+map.get("r_name"));
      }
    }

    @Test
    public void test4(){
        String sql="select u.userName,u.age userAge,r.r_name roleName from sys_user u LEFT JOIN  sys_role_user ru on u.id=ru.u_id " +
                "                         LEFT JOIN  sys_role r on ru.r_id =r.r_id " +
                "                         where u.userName=?1 ";
        List<UserDto> list=
                session.createSQLQuery(sql)
                        .unwrap(NativeQueryImpl.class)//拆包,
                        .setResultTransformer(Transformers.aliasToBean(UserDto.class))//数据放入MAP
                        .setParameter(1,"赵云")
                        .list();

          for (UserDto dto:list){
              System.out.println(dto.getUserName()+"/"+dto.getRoleName());
          }
    }
    @Test
    public  void testPower(){
        //用户输入的权限对应的url
        String url="delz.lovo";
        //把用户拥有的所有权限查询出来
        String sql="select p.url from sys_user u \n" +
                "          LEFT JOIN sys_role_user ru on u.id=ru.u_id\n" +
                "          LEFT JOIN sys_role r on r.r_id=ru.r_id\n" +
                "          LEFT JOIN sys_role_power rp on rp.r_id=r.r_id\n" +
                "          LEFT JOIN sys_power p on p.p_id=rp.p_id\n" +
                "          where u.userName=?1";
     List<Map> list=
        session.createSQLQuery(sql)
                .setParameter(1,"赵云")
                .unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                .list();

     //对比用户是否拥有输入的权限
        boolean bl=false;
        for (Map map:list){
            if(url.equals(map.get("url"))){
                bl=true;
                break;
            }
        }
        if(bl){
            System.out.println("拥有权限");
        }else {
            System.out.println("非法访问");
        }
    }




}
