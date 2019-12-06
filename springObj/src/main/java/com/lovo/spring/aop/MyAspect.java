package com.lovo.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 切面
 */
@Component
@Aspect
public class MyAspect {

      public void beforeMessage(JoinPoint joinPoint){
          //获得目标方法的名字
           String methodName=joinPoint.getSignature().getName();
          System.out.println("调用"+methodName+"之前的时间"+System.currentTimeMillis());
      }

    /**
     * 环绕通知
     * @return
     */
    @Around("execution( * com.lovo.spring.*.IUserCrudService.*(..) )")
    public Object aroundMessage(ProceedingJoinPoint joinPoint){
        Object object=null;
        //获得目标方法的名字
        String methodName=joinPoint.getSignature().getName();
        long startTime=System.currentTimeMillis();
        //调用目标方法
        try {
           object= joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long endTime=System.currentTimeMillis();
        System.out.println(methodName+"方法执行的时间为："+(endTime-startTime));
        return object;
      }
}
