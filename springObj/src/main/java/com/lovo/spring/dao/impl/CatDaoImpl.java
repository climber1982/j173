package com.lovo.spring.dao.impl;

import com.lovo.spring.dao.ICatDao;
import org.springframework.stereotype.Repository;

@Repository(value = "catDao")
public class CatDaoImpl implements ICatDao {

    public void eat(String food) {
        System.out.println("猫正在吃："+food);
    }
}
