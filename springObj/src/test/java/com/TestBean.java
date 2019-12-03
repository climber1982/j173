package com;

import com.lovo.spring.bean.UserBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
    @Test
    public  void createUser(){

        //创建spring
        ClassPathXmlApplicationContext app=
                new ClassPathXmlApplicationContext("application.xml");
      //从容器中根据ID获取spring给我们创建好的对象
       UserBean user= (UserBean) app.getBean("userBean");
        System.out.println(user.getUserName()+"/"+user.getAge());
    }
}
