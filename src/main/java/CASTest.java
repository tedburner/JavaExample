/**
 * @author lingjun.jlj
 * @data 2018/5/8
 * @Description: CAS的思想很简单：三个参数，一个当前内存值V、旧的预期值A、即将更新的值B，
 * 当且仅当预期值A和内存值V相同时，将内存值修改为B并返回true，否则什么都不做，并返回false。
 * 代码如下：
 * public boolean compareAndSwapInt(int b) {
 *     if (a == 1) {
 *         a = b;
 *         return true;
 *     }
 *     return false;
 * }
 *
 */
public class CASTest {

    private static int n ;

    public void increase() {
        n++;
    }

    public static void threadTest() {
        CASTest cas = new CASTest();
        //创建10个线程
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        cas.increase();
                    }
                }
            });
            threads[i] = t;
            t.start();
        }
        System.out.println("结果：" + n);

    }

    public static void main(String[] args) {
        threadTest();
    }
}
