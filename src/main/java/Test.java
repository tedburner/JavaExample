/**
 * @author lingjun.jlj
 * @data 2018/5/8
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int hash = "hash".hashCode();
        System.out.println(hash);
        System.out.println(toBinary(hash));


    }

    static String toBinary(int num) {
        String str = "";
        while (num != 0) {
            str = num % 2 + str;
            num = num / 2;
        }
        return str;
    }

}
