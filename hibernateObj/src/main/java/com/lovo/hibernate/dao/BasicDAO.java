package com.lovo.hibernate.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class BasicDAO {

    //注入hibernate工厂bean
    @Autowired
    private LocalSessionFactoryBean factoryBean;

    /**
     * 没有被spring管理的session
     * @return
     */
    public Session getOpenSession(){
      return   factoryBean.getObject().openSession();
    }

    /**
     * 被spring管理的session
     * @return
     */
    public Session getCurrentSession(){
        return  factoryBean.getObject().getCurrentSession();
    }

}
