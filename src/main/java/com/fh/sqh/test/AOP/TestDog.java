package com.fh.sqh.test.AOP;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDog {

    @Test
    public void test(){
        Dog dog = new Dog();
        dog.hit();
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext beans = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Dog2 dog = (Dog2) beans.getBean("dog2");
        dog.hit("里斯");
    }

}
