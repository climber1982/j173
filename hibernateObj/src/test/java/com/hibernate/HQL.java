package com.hibernate;

import com.lovo.hibernate.dao.BasicDAO;
import com.lovo.hibernate.dto.UserDto;
import com.lovo.hibernate.entity.RoleUserEntity;
import com.lovo.hibernate.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
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
    //查询部分字段
    @Test
    public void findSegmentMap(){
        String userName="赵云";
        String hql="select new map(userName,userAge) from UserEntity where userName like  ?0";
        Session session=basicDAO.getOpenSession();
        List<Map> list=
                session.createQuery(hql)
                        .setParameter(0,userName+"%")
                        .list();
          for(Map map:list){
              System.out.println("用户名"+map.get("0")+"/用户年龄"+map.get("1"));
          }
        System.out.println(list.size());

    }

    @Test
    public  void updateUser(){
        String hql="update UserEntity set message=?0,age=?1 where userName=?2";
        Session session=basicDAO.getOpenSession();
       Transaction tx= session.getTransaction();
       tx.begin();
     int i=  session.createQuery(hql)
               .setParameter(0,"hello hibernate")
               .setParameter(1,60)
               .setParameter(2,"赵云")
               .executeUpdate();
       tx.commit();
    }

    @Test
    public  void delUser(){
        String hql="delete from UserEntity  where userAge=?0";
        Session session=basicDAO.getOpenSession();
        Transaction tx= session.getTransaction();
        tx.begin();
        //executeUpdate(); 返回受影响的行数
        int i=  session.createQuery(hql)
                .setParameter(0,20)
                .executeUpdate();
        System.out.println(i);
        tx.commit();
    }
@Test
    public  void savaUser(){
        Session session=basicDAO.getOpenSession();
        Transaction tx= session.getTransaction();
        tx.begin();
        for(int i=0;i<20;i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName("关羽-2"+i);
            userEntity.setUserAge(30+i);
            userEntity.setDateTime("2019-11-12");
            session.save(userEntity);
        }
        tx.commit();
    }
    @Test
    public  void findData(){

        Session session=basicDAO.getOpenSession();
        String hql="from UserEntity where DateTime>?0 and DateTime<?1";
        List<UserEntity> list=
        session.createQuery(hql)
                .setParameter(0,"2019-01-01")
                .setParameter(1,"2020-01-01")
                .list();
        System.out.println(list.size());
    }
    @Test
    public void testJoin(){
        Session session=basicDAO.getOpenSession();
        String hql="select r.roleName  from RoleUserEntity ru left join ru.role r where ru.user.userName=?0";
        List<String> list=
        session.createQuery(hql)
                .setParameter(0,"赵云")
                .list();
        System.out.println(list.size());
    }
    @Test
    public  void testPage(){
        Session session=basicDAO.getOpenSession();

        String hql="from UserEntity where userName like ?0 order by  userAge";

        int currentPage=2;//当前页
        int pageCount=4;//每页的行数
        int startNum=(currentPage-1)*pageCount;//起始位置
        List<UserEntity> list=
        session.createQuery(hql)
                .setParameter(0,"关羽"+"%")
                .setFirstResult(startNum) //起始位置
                .setMaxResults(pageCount)//每页显示的行数
                .list();
       for (UserEntity user:list){
           System.out.println(user.getUserName());
       }
    }

}
