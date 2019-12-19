package com.lovo.mvc.controller;

import com.lovo.mvc.entity.UserEntity;
import com.lovo.mvc.service.IUserService;
import com.lovo.mvc.util.StringInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //下面的所有方法只返回数据
public class UserVueController {
    @Autowired
    private IUserService userService;

   @RequestMapping("getListUser.lovo")
    public List<UserEntity> getListUser(){
        List<UserEntity> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            UserEntity u=new UserEntity();
            u.setUserName("赵云"+i);
            u.setUserAge(30+i);
            list.add(u);
        }
        return  list;
    }
   @RequestMapping("savaUserVue.lovo")
    public String savaUserVue(UserEntity user){
       //验证。。。。。
       userService.savaUser(user);
       return StringInfo.RESULETOK;
    }
}
