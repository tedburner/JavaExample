package com.example.common.jvm;

/**
 * @author: lingjun.jlj
 * @date: 2020/3/12 22:49
 * @description: staticObj、instanceObj 、localObj 放在哪里？
 * staticObj 随着 Test 的类型信息放在方法区，
 * instanceObj 随着 Test 的实例对象存放在堆中，
 * localObj 则放在 foo() 方法栈帧的局部变量表中。
 */
public class JHSDB_TestCase {

    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }

    private static class ObjectHolder {};

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}
