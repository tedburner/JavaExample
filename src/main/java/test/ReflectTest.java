package test;

import java.lang.reflect.Method;

/**
 * @author: lingjun.jlj
 * @date: 2018/8/9 18:50
 * @description:
 */
public class ReflectTest {

    public static void main(String[] args) {
        ReflectTest.printClassMessage(Object.class.getName());
    }

    public static void printClassMessage(Object object) {
        Class c = object.getClass();

        System.out.println("类的名称：" + c.getName());

        Method[] methods = c.getMethods();
        for (Method method : methods) {
            Class returnType = method.getReturnType();
            System.out.println(returnType.getName());

            System.out.println("方法名称：" + method.getName());
            Class[] params = method.getParameterTypes();

        }
    }
}
