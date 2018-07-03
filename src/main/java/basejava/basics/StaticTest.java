package basejava.basics;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lingjun.jlj
 * @date 2017-12-28
 **/
public class StaticTest {

    private  static final Map<Integer,String> recordTypeMap = new HashMap<>();
    static {
        recordTypeMap.put(1,"到院就诊");
        recordTypeMap.put(2,"随访建议");
        recordTypeMap.put(3,"服务小结");
        recordTypeMap.put(4,"病历列表");
        recordTypeMap.put(5,"IM咨询");
    }

    public static void main(String[] args){
        System.out.println(recordTypeMap.get(1));
    }
}
