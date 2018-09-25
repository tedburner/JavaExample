import java.util.Objects;

/**
 * @author lingjun.jlj
 * @data 2018/5/8
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        String pdf = "测试PDF截取.pdf";
        int number = pdf.lastIndexOf(".");
        System.out.println(number);
        String fileType = pdf.substring(0, number);
        System.out.println(fileType);

        int threshold = (int) Math.min(11 * 0.75f, Integer.MAX_VALUE - 8 + 1);
        System.out.println(threshold);

        int newCapacity = (8 << 1) + 1;
        System.out.println(newCapacity);

        if (Objects.equals("1","1")){
            System.out.println("Hello World");
        }


    }

}
