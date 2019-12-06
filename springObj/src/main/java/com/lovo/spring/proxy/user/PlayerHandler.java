package com.lovo.spring.proxy.user;

import com.lovo.spring.proxy.IPlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PlayerHandler implements InvocationHandler {
    private Object obj;
    //被代理者
    public PlayerHandler(Object obj){
          this.obj=obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用目标方法之前");
        //调用目标方法
      Object methodObj=   method.invoke(obj);
        System.out.println("调用目标方法之后");
        return methodObj;
    }
}
