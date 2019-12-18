package com.lovo.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("调用方法之前");
        boolean bl=false;
        //从session中获取用户
      Object obj=  request.getSession().getAttribute("user");
      if(null!=obj){
        bl=true;
      }else{
          //没有登录,跳转到登录界面
        response.sendRedirect("/mvc/index.jsp");
      }
        return bl;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("调用方法之后，视图没渲染");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("调用方法之后，视图渲染完毕");
    }
}
