package com.example.common.agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

import java.lang.reflect.Method;

/**
 * javassist 测试用例
 *
 * @author lingjun.jlj
 * @date 2020/4/6 22:15
 */
public class JavassistDemo {

    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("hello World!");
        CtMethod ctMethod = CtNewMethod.make("public static void test() {\n" +
                "        System.out.println(\"Hello World!\");\n" +
                "    }", ctClass);
        ctClass.addMethod(ctMethod);
        Class clzz = ctClass.toClass();

        Object object = clzz.newInstance();
        Method method = clzz.getDeclaredMethod("test", null);
        method.invoke(object, null);
    }

}
