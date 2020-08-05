package com.fh.sqh.test.model;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestIOC {

    @Test
    public void test(){
        User user=new User();
        user.setName("张三");
        user.setId(1);
        System.out.println(user.getName());
    }

    @Test
    public void test1(){
        ClassPathXmlApplicationContext beans=new ClassPathXmlApplicationContext("applicationContext2.xml");
        User userName = (User) beans.getBean("user");
        System.out.println(userName.getName());
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext beans=new ClassPathXmlApplicationContext("applicationContext2.xml");
        User2 userName = (User2) beans.getBean("user2");
        System.out.println(userName);
    }

    @Test
    public void test3(){
        ClassPathXmlApplicationContext beans=new ClassPathXmlApplicationContext("applicationContext2.xml");
        User user = (User) beans.getBean("user3");
        System.out.println(user.getTeacher().getName());
    }


    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D:\\飞狐教育课件\\六月份\\1908A班学生信息.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheetAt = workbook.getSheetAt(1);
            int firstRowNum = sheetAt.getFirstRowNum();
            int lastRowNum = sheetAt.getLastRowNum();
            String[] arr = new String[29];
            int j =0;
            for (int i = firstRowNum+2; i <lastRowNum+1; i++) {
                XSSFRow row = sheetAt.getRow(i);
                String stringCellValue = row.getCell(0).getStringCellValue();
                arr[j]=stringCellValue;
                j++;
            }
            int index=(int)(Math.random()*arr.length);
            String rand = arr[index];
            System.out.println(rand);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
