package com.lovo.hibernate.dao;

import com.lovo.hibernate.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDao")
public class UserDaoImpl implements IUserDao {

    //注入hibernate工厂bean
    @Autowired
   private LocalSessionFactoryBean factoryBean;

    public void savaUser(UserEntity user) {
        //获得工厂
      SessionFactory sessionFactory= factoryBean.getObject();
      //获得session
      Session session= sessionFactory.openSession();

      //获得事务对象
     Transaction tx= session.getTransaction();
     //开启事务
        tx.begin();
        //执行保存
        session.save(user);
        //提交事务
        tx.commit();

        session.close();
    }

    @Override
    public UserEntity getUserById(String id) {
        //获得工厂
        SessionFactory sessionFactory= factoryBean.getObject();
        //获得session
        Session session= sessionFactory.openSession();

        return session.get(UserEntity.class,id);
    }
//
//    @Override
//    public List<UserEntity> getListUserList() {
//        //获得工厂
//        SessionFactory sessionFactory= factoryBean.getObject();
//        //获得session
//        Session session= sessionFactory.openSession();
//        String hql="from UserEntity";
//      List<UserEntity> list=   session.createQuery(hql).list();
//        return list;
//    }
}
