package com.example.programme.service;

import com.example.programme.domain.Product;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 14:23
 * @description:
 */
public interface ProductService {



    void save(Product product);

    void delete(Long id);
}
