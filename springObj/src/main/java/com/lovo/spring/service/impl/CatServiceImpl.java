package com.lovo.spring.service.impl;

import com.lovo.spring.dao.ICatDao;
import com.lovo.spring.service.ICatService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "catService")
public class CatServiceImpl implements ICatService {
  //@Resource(name = "catDao")
   @Autowired //根据类型来注入
    private  ICatDao catDao;

    public void eat(String food) {

        catDao.eat(food);
    }
}
