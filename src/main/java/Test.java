import basejava.Java8.BeanData;
import basejava.Java8.bean.SimpleDTO;
import utils.ByteUtils;

import java.io.*;
import java.net.URL;
import java.time.Clock;
import java.util.*;

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
