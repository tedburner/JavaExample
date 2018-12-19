package com.example.common.Java8;

import com.example.domain.bean.SimpleDTO;

import java.util.List;
import java.util.Optional;


/**
 * @author: lingjun.jlj
 * @Date: 2018/7/13 11:21
 * @Description:
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<List<SimpleDTO>> optionalInteger = java.util.Optional.of(BeanData.getBeanDataList());
        Optional<Integer> optional = Optional.ofNullable(null);
        //获取值
        System.out.println(optionalInteger.get());
        //isPresent判断该值是否为null
        System.out.println(optional.isPresent());
        //输出Optional.empty
        System.out.println(optional);
        //true
        System.out.println(optional == java.util.Optional.<Integer>empty());
        //orElse(value)：如果optional对象保存的值不是null，则返回原来的值，否则返回value
        System.out.println(optional.orElse(1000));
        //orElseGet(Supplier supplier)：功能与orElse一样，只不过orElseGet参数是一个对象
        System.out.println(optional.orElseGet(() -> {
            return 1000;
        }));
        //orElseThrow()：值不存在则抛出异常，存在则什么不做，有点类似Guava的Precoditions
//        try {
//            optional.orElseThrow(() -> { throw new IllegalStateException(); });
//        }catch (IllegalStateException e){
//            e.printStackTrace();
//        }

        Optional<String> optional1 = optionalInteger.map((a) -> "map" + a.get(1).name);
        System.out.println(optional1);

    }
}
