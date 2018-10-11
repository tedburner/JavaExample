package com.example.basejava.basics.reflect;


import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 10:29
 * @description: 反射测试类
 */

public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException,
            IntrospectionException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            NoSuchMethodException {
        Person person = new Person(1L, "反射");
        //1、通过对象名
        Class clazz1 = person.getClass();
        //2、通过类名
        Class clazz = Person.class;
        //3、通过全类名
        Class clazz2 = Class.forName("com.example.basejava.basics.reflect.Person");

        System.out.println("----获取文件名----");
        System.out.println(clazz.getName());

        System.out.println("---获取类内部信息-----");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //获取内部成员变量，比如 id、name
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
            Method method = descriptor.getReadMethod();
            Object value = method.invoke(person);
            System.out.println(key + ":" + value);
        }

        System.out.println("----获取实例对象----");
        //利用Class对象的newInstance方法创建一个类的实例
        Object obj = clazz.newInstance();
        System.out.println(obj);

        System.out.println("------获取方法---------");
        //获取方法，不能获取private方法，且获取从父类继承来的所有方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.print(" " + method.getName());
        }
        System.out.println();

        //获取所有方法，包括私有方法
        methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(" " + method.getName());
        }
        System.out.println();

        //获取指定方法
        Method method = clazz.getDeclaredMethod("setName", String.class);
        System.out.println(method);

        //修改类内部信息，setName("反射)
        method.invoke(obj, "反射");
        System.out.println(obj);

        System.out.println("----所有公有构造方法-----");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("-----所有的构造方法(包括：私有、受保护、默认、公有)-------");
        constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("--------获取公有、无参的构造方法--------");
        Constructor constructor = clazz.getConstructor(null);
        System.out.println("constructor : " + constructor);

        System.out.println("------获取私有构造方法，并调用-------");
        Object object = constructor.newInstance();
        constructor = clazz.getDeclaredConstructor(String.class);
        System.out.println(constructor);
        //调用构造方法
        constructor.setAccessible(true);
        object = constructor.newInstance("男");
        System.out.println(object);
    }
}
