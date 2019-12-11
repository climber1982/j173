package com.hibernate;

import com.lovo.hibernate.dao.BasicDAO;
import com.lovo.hibernate.dto.UserDto;
import com.lovo.hibernate.entity.RoleUserEntity;
import com.lovo.hibernate.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class HQL {
    BasicDAO basicDAO=null;
    @Before
    public  void before(){
        //启动spring
        ClassPathXmlApplicationContext applicationContext
                =new ClassPathXmlApplicationContext("application.xml");
         basicDAO= (BasicDAO) applicationContext.getBean("basicDAO");
    }

    @Test
    public void findList(){
//获得session对象
        Session session=basicDAO.getOpenSession();

        String hql="from  RoleUserEntity ru where ru.user.userName=?0";//HQL
//        Query query=session.createQuery(hql);    //获得query对象
//        query.setParameter(0,"赵云");
//        //query.setParameter("userName","赵云");//设置条件
//        List<RoleUserEntity> roleUserEntityList=   query.list();//返回的类型
        List<RoleUserEntity> roleUserEntityList=
                session.createQuery(hql)
                .setParameter(0,"赵云")
                .list();
       for (RoleUserEntity ru:roleUserEntityList){
           System.out.println(ru.getRole().getRoleName()+"/"+ru.getUser().getUserName());
       }
    }

    @Test
    public void findList2(){
//获得session对象
        Session session=basicDAO.getOpenSession();

        String hql="select ru from  RoleUserEntity ru where ru.user.userName=?0";//HQL
//        Query query=session.createQuery(hql);    //获得query对象
//        query.setParameter(0,"赵云");
//        //query.setParameter("userName","赵云");//设置条件
//        List<RoleUserEntity> roleUserEntityList=   query.list();//返回的类型
        List<Object> roleUserEntityList=
                session.createQuery(hql)
                        .setParameter(0,"赵云")
                        .list();
        for (Object obj:roleUserEntityList){
            RoleUserEntity ru=     (RoleUserEntity)obj;
            System.out.println(ru.getRole().getRoleName()+"/"+ru.getUser().getUserName());
        }
    }
    //查询一个对象
    @Test
    public  void findOneObject(){
        Session session=basicDAO.getOpenSession();
        UserEntity user=
                (UserEntity) session.createQuery("from UserEntity where userAge=?0 and userName=?1")
                        .setParameter(0,30)
                        .setParameter(1,"赵云")
                        .uniqueResult();
        System.out.println(user.getUserName());
    }
    //模糊查询
    @Test
    public void likeObject(){
        String userName="赵云";
        Session session=basicDAO.getOpenSession();
        List<UserEntity> list=
        session.createQuery("from UserEntity where userName like  ?0")
                .setParameter(0,userName+"%")
                .list();
        for (UserEntity user:list){
            System.out.println(user.getUserName());
        }
    }

    //查询部分字段
    @Test
    public void findSegment(){
        String userName="赵云";
      String hql="select userName,userAge from UserEntity where userName like  ?0";
        Session session=basicDAO.getOpenSession();
     List<Object[]> list=
        session.createQuery(hql)
                .setParameter(0,userName+"%")
                .list();

     for (Object[] objs:list){
         System.out.println("名字"+objs[0].toString());
         System.out.println("年龄"+objs[1].toString());
     }

    }
    //查询部分字段
    @Test
    public void findSegmentDto(){
        String userName="赵云";
        String hql="select new com.lovo.hibernate.dto.UserDto(userName,userAge) from UserEntity where userName like  ?0";
        Session session=basicDAO.getOpenSession();
        List<UserDto> list=
                session.createQuery(hql)
                        .setParameter(0,userName+"%")
                        .list();

        for (UserDto dto:list){
            System.out.println("名字"+dto.getUserName());
            System.out.println("年龄"+dto.getUserAge());
        }

    }

}
