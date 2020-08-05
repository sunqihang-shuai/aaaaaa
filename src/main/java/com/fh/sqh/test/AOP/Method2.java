package com.fh.sqh.test.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Method2 {

    public void before(){
        System.out.println("放开狗");
    }

    public void after(){
        System.out.println("咬死狗");
    }

    @Around("execution(* com.fh.sqh.test.AOP.Dog2.hit(..))")
    public void around(ProceedingJoinPoint pointcut) throws Throwable {
        System.out.println("狼狗大步流星的跑来了");
        pointcut.proceed();
        System.out.println("我把狗咬死了");
    }

}
