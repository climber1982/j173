package com.lovo.hibernate.dao.impl;

import com.lovo.hibernate.dao.BasicDAO;
import com.lovo.hibernate.dao.IUserDao;
import com.lovo.hibernate.entity.RoleEntity;
import com.lovo.hibernate.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value = "userDao")
public class UserDaoImpl extends BasicDAO implements IUserDao {

    public void savaUser(UserEntity user) {

      //获得session
      Session session= super.getCurrentSession();

        session.save(user);

    }

    @Override
    public UserEntity getUserById(String id) {

        //获得session
        Session session= super.getOpenSession();

        return session.get(UserEntity.class,id);
    }

    @Override
    public void savaUser2(UserEntity user) {
        Session session=super.getOpenSession();
        //开启事务
      Transaction tx=  session.getTransaction();
      tx.begin();
        session.save(user);
        user.setUserName("赵云");
        tx.commit();
        session.close();
        System.out.println("session已经关闭");
    }

    @Override
    public void updateUser(String id) {
        Session session=super.getOpenSession();
        //开启事务
        Transaction tx=  session.getTransaction();
        tx.begin();
         //根据ID来获取对象
        UserEntity userEntity=session.get(UserEntity.class,id);
        System.out.println(userEntity.getUserName());
        UserEntity userEntity2=session.get(UserEntity.class,id);
        System.out.println(userEntity2.getUserName());
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserEntity userEntity3=session.get(UserEntity.class,id);
        System.out.println(userEntity3.getUserName());
        UserEntity userEntity4=session.get(UserEntity.class,id);
        userEntity.setUserName("马超2");
        tx.commit();
        session.close();
    }

    public  UserEntity getUser(String id){
        Session session=super.getOpenSession();
      UserEntity user=  session.load(UserEntity.class,id);

        session.close();
     return  user;
    }



}
