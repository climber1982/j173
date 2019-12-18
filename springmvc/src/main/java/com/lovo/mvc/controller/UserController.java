package com.lovo.mvc.controller;

import com.lovo.mvc.entity.UserEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller //被spring管理
@RequestMapping("user/")
public class UserController {
    List<UserEntity> list=new ArrayList<>();



   @RequestMapping("savaUser.lovo")
    public ModelAndView savaUser(UserEntity userEntity, String userName, String userAge, ServletRequest request, ServletResponse response){

           list.add(userEntity);
           ModelAndView mv=new ModelAndView();
           mv.setViewName("index");//返回的视图地址
           mv.addObject("listUser",list);
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

           request.setAttribute("userName",userName);
           //登录成功，把用户放入session
           request.getSession().setAttribute("user",userName);
           return "info";
       }
       //把结果放入到request对象
        request.setAttribute("info",rstring);

       return "index";
    }
  @RequestMapping("gotoInfo.lovo")
    public  String gotoInfo(){

       return  "info";
    }
   @RequestMapping("redirectTest.lovo")
    public ModelAndView redirectTest(){
       ModelAndView mv=new ModelAndView();

       //创建重定向视图
       RedirectView redirectView=new RedirectView();
       redirectView.setUrl("/mvc/index.jsp");
       //把重定向视图放入到ModelAndView
       mv.setView(redirectView);


       return mv;
    }
    @RequestMapping("redirectTest2.lovo")
    public String redirectTest2(){

       return "redirect:/index.jsp";
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
       userEntity.setUserAge(32);
       userEntity.setUserName("赵云2");
        return userEntity;
    }
   @RequestMapping("{tag}/info.lovo")
   @ResponseBody
    public String getCarInfo(@PathVariable("tag") int tag){
       String carInfo="";
       switch (tag){
           case 0:
               carInfo="宝马";
               break;
           case 1:
               carInfo="奔驰";
               break;
           case 2:
               carInfo="路虎";
               break;
               default:
                   carInfo="奇瑞";
       }
       return  carInfo;
    }
}
