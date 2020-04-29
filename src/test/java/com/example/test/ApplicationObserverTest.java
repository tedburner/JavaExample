package com.example.test;

import com.example.programme.domain.Product;
import com.example.programme.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 14:25
 * @description:
 */
public class ApplicationObserverTest extends BaseObserverTest {

    @Autowired
    private ProductService productService;

    @Test
    public void AopTest() {
        Product product = new Product();
        productService.save(product);
    }
}
