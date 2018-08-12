/**
 * @author lingjun.jlj
 * @data 2018/5/8
 * @Description:
 */
public class Test {

    private static String[] array = {""};

    static int test() {
        System.out.println("evaluated");
        return 0;
    }

    public static void main(String[] args) {
        array[test()] += "a";
    }
}
