/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 20:09
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        synchronized (Test.class) {
            System.out.println("上锁了");
        }

        System.out.println("释放锁后......");
    }
}
