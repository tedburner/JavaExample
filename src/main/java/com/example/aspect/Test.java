package com.example.aspect;

import com.example.aspect.annotation.ConsAnnotation;
import com.example.aspect.annotation.Fields;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/2 17:26
 * @description:
 */
public class Test {

    public static void main(String[] args) throws NoSuchFieldException, IntrospectionException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        User user = new User();
        user.setUserName("张三");
        Class clazz = user.getClass();

        // 1、 获取 User类上的注解 @ConsAnnotation
        ConsAnnotation anno = user.getClass().getAnnotation(ConsAnnotation.class);
        String[] arr = anno.request();
        System.out.println(Arrays.toString(arr)); // [hello, world, annotation!]

        // 2、 获取User类中 private String userName; 变量上的注解 @Field
//        Field f = user.getClass().getDeclaredField("userName");
//        Fields anno2 = f.getAnnotation(Fields.class);
//        user.setUserName(anno2.value());
//        System.out.println(user.getUserName()); // 中华人民共和国

        List<Field> fieldList = Arrays.asList(user.getClass().getDeclaredFields())
                .stream()
                .filter(x -> x.isAnnotationPresent(Fields.class))
                .collect(Collectors.toList());
        Field field = fieldList.get(0);
//        PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(), user.getClass());
//        Method method = descriptor.getReadMethod();
//        Object value = method.invoke(user);
//        System.out.println(value);

//        field.setAccessible(true); // 私有属性必须设置访问权限
//        Object resultValue = field.get(clazz.newInstance());
//        System.out.println(resultValue);

        String fieldName = field.getName();
        String upperChar = fieldName.substring(0, 1).toUpperCase();
        String anotherStr = fieldName.substring(1);
        String methodName = "get" + upperChar + anotherStr;
        Method method = clazz.getMethod(methodName, new Class[]{});
        method.setAccessible(true);
        Object resultValue = method.invoke(user, new Object[]{});
        System.out.println(resultValue);
    }
}
