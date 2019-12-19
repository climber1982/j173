package com.lovo.mvc.util;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class MyException implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
       ModelAndView mv=new ModelAndView("error");
       mv.addObject("info",StringInfo.ERRORINFO);
        HandlerMethod method=   (HandlerMethod)o;
      String methodName=  method.getMethod().getName();

        System.out.println("在"+new Date()+",在"+methodName+"/发生了"+e.toString()+"错误");
        
        return mv;
    }
}
