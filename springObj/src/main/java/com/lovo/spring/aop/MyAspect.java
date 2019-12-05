package com.lovo.spring.aop;

/**
 * 切面
 */
public class MyAspect {

      public void beforeMessage(){
          System.out.println("调用方法之前的时间"+System.currentTimeMillis());
      }
}
