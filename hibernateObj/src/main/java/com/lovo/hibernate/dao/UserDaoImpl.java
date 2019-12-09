package com.lovo.hibernate.dao;

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
