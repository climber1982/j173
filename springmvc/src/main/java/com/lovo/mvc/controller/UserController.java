package com.lovo.mvc.controller;

import com.lovo.mvc.entity.UserEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller //被spring管理
@RequestMapping("user/")
public class UserController {

   @RequestMapping("savaUser.lovo")
    public ModelAndView savaUser(UserEntity userEntity, String userName, String userAge, ServletRequest request, ServletResponse response){

       System.out.println(userEntity.getUserName()+"/"+userEntity.getUserAge());
           ModelAndView mv=new ModelAndView();
           mv.setViewName("/index.jsp");//返回的视图地址
           mv.addObject("info",userName);
           return  mv;


    }
   @RequestMapping("findUser.lovo")
    public String findUser(){
       return "error.jsp";
    }

    @RequestMapping("login.lovo")
    public  String login(String userName, String password, HttpServletRequest request){
       String rstring="";
        Map<String,String> map=new HashMap<>();
        map.put("赵云_1234","赵云，登录成功");
        //查询用户是否合法登录
       String result=  map.get(userName+"_"+password);
       if(null==result){
           rstring="非法登录";
       }else {
           rstring=result;
       }
       //把结果放入到request对象
        request.setAttribute("info",rstring);

       return "index.jsp";
    }

   @RequestMapping("testUser.lovo")
    public ModelAndView testUser(@RequestParam("userName") String us){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("index");//返回的视图地址
        mv.addObject("info",us);
        return mv;
    }
   @RequestMapping("getJson.lovo")
   @ResponseBody //不返回视图，只返回数据
    public  String getJson(){
       return "{'userName':'赵云'}";
    }
    @RequestMapping("getJsonObj.lovo")
    @ResponseBody //不返回视图，只返回数据
    public  UserEntity getJsonObject(){
       UserEntity userEntity=new UserEntity();
       userEntity.setUserAge(30);
       userEntity.setUserName("赵云");
        return userEntity;
    }
}
