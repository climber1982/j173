package com;

import com.lovo.spring.bean.UserBean;
import com.lovo.spring.service.IUserCrudService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tmybaits {

    @Test
    public void  sava(){
        ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("userMybaits.xml");
    IUserCrudService service= (IUserCrudService) app.getBean("userCrudService");
//        UserBean userBean=new UserBean();
//        userBean.setUserName("赵云");
//        userBean.setAge(30);
//    service.savaUser(userBean);
        service.findUserList();
    }
}
