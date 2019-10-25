package com.example.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.example.domain.bean.SimpleDTO;
import org.springframework.cglib.beans.BeanCopier;

import java.nio.file.CopyOption;

/**
 * @author: lingjun.jlj
 * @date: 2019/10/25 11:12
 * @description:
 */
public class BeanCopierTest {

    public static void main(String[] args) {
        BeanCopier copier = BeanCopier.create(SimpleDTO.class, SimpleDTO.class, false);
        SimpleDTO old = new SimpleDTO();
        old.setName("蒋灵俊");
        old.setContent("测试BeanCopier");

        SimpleDTO copy = new SimpleDTO();
        copy.setId(1);
        copy.setName("合同");
        copy.setContent("123141");

        //copier.copy(old, copy, null);
        BeanUtil.copyProperties(old, copy,  CopyOptions.create().setIgnoreNullValue(true));
        System.out.println(copy);

    }
}
