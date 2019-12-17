package com.lovo.mvc.controller;

import com.lovo.mvc.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //下面的所有方法只返回数据
public class UserVueController {
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

}