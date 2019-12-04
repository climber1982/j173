package com.lovo.spring.dao.impl;

import com.lovo.spring.bean.UserBean;
import com.lovo.spring.dao.IUserDao;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements IUserDao {

    private  String userName2;
    private  int age;
    public UserDaoImpl(){}
    public UserDaoImpl(String userName2,int age){
        this.userName2=userName2;
        this.age=age;
    }
    private Map<String,Integer> mapUser=null;

   private Properties prop=null;
    public void savaUser(UserBean user) {
        System.out.println(user.getUserName());
    }


    public int getAgeByName(String userName) {


        System.out.println(mapUser.get(userName)+"/map");

        return Integer.valueOf(prop.getProperty(userName));
    }

    public Map<String, Integer> getMapUser() {
        return mapUser;
    }

    public void setMapUser(Map<String, Integer> mapUser) {
        this.mapUser = mapUser;
    }


    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }
}
