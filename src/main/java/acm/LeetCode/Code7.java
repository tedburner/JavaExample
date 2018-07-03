package acm.LeetCode;

/**
 * @author lingjun.jlj
 * @data 2018/5/9
 * @Description: 反整数
 */
public class Code7 {

    public static int reverse(int x) {

        int y = 0;
        int n;
        while (x != 0) {
            n = x % 10;
            if (y > Integer.MAX_VALUE / 10 || y < Integer.MIN_VALUE / 10) {
                return 0;
            }
            y = y * 10 + n;
            x /= 10;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(-1%10);
        System.out.println(reverse(-123));

    }
}
