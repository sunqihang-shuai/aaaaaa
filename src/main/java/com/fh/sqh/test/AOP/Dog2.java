package com.fh.sqh.test.AOP;

import org.springframework.stereotype.Component;

@Component
public class Dog2 {

    public void hit(String name){
        System.out.println("狗来了,想咬"+name);
    }


}
