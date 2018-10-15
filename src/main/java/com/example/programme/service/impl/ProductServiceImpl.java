package com.example.programme.service.impl;

import com.example.programme.base.annotation.AdminOnly;
import com.example.programme.domain.Product;
import com.example.programme.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 14:24
 * @description:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    @AdminOnly
    public void insert(Product product) {
        System.out.println("insert a product");
    }

    @Override
    @AdminOnly
    public void delete(Long id) {
        System.out.println("delete a product");

    }
}
