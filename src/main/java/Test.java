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

    public static void main(String[] args) {
        Optional<List<SimpleDTO>> optionalInteger = Optional.of(BeanData.getBeanDataList());
        Optional<Integer> optional2 = Optional.ofNullable(null);
        //获取值
        System.out.println(optionalInteger.get());
        //isPresent判断该值是否为null
        System.out.println(optional2.isPresent());
        //输出Optional.empty
        System.out.println(optional2);
        //true
        System.out.println(optional2 == Optional.<Integer>empty());
        //orElse(value)：如果optional对象保存的值不是null，则返回原来的值，否则返回value
        System.out.println(optional2.orElse(1000));

    }
}
