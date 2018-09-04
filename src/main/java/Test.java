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


    }

}
