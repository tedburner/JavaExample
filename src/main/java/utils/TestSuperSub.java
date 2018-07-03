package utils;

/**
 * @author lingjun.jlj
 * @create 2017-09-18
 **/
class SuperClass {
    public static void main(String[] args) {
        Sub c1 = new Sub();
        System.out.println(" c1.s : " + c1.s);
        System.out.println(" c1.say : " + c1.say());

        Super c2 = new Sub();//子类不能把父类的成员变量覆盖掉
        System.out.println(" c2.s : " + c2.s);
        System.out.println(" c2.say : " + c2.say());

        Super c3 = new Super();
        System.out.println(" c3.s : " + c3.s);
        System.out.println(" c3.say : " + c3.say());
    }
}
class Super {
    String s = "Super";

    String say(){
        return "hello Super";
    }
}

class Sub extends Super {
    String s = "Sub";

    String say(){
        return "hello Sub";
    }
}
