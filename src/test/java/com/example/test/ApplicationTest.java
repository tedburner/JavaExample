package com.example.test;

import com.example.programme.domain.Product;
import com.example.programme.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 14:25
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ApplicationTest {

    @Autowired
    private ProductService productService;

    @Test
    public void AopTest() {
        Product product = new Product();
        productService.insert(product);
    }
}
