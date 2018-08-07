package com.timo;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class JsonTest {
    public static void main(String[] args) throws Exception{
      //用java反射初始化Student类中的值
        Class<Student> studentClass = Student.class;
        Constructor<Student> studentConstructor = studentClass.getDeclaredConstructor();
        Student student = studentConstructor.newInstance();
        Field[] fields = studentClass.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            if(field.getName().equals("name")){
                field.set(student,"欧阳锋");
            }
            if(field.getName().equals("address")){
                field.set(student,"桃花岛");
            }
            if(field.getName().equals("age")){
                field.set(student,18);
            }
        }
        String s = JSON.toJSONString(student);
        System.out.println(s);
    }
}
