package com;

import com.lovo.spring.bean.UserBean;
import com.lovo.spring.service.IUserCrudService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Tmybaits {

    @Test
    public void  sava(){
        ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("userMybaits.xml");
    IUserCrudService service= (IUserCrudService) app.getBean("userCrudService");
        UserBean userBean=new UserBean();
        userBean.setUserName("马超100");
        userBean.setAge(30);
    service.savaUser2(userBean);
//       List<UserBean> list=service.findUserList();
//        for (UserBean u:list
//             ) {
//            System.out.println(u.getUserName());
//        }
   }
}
