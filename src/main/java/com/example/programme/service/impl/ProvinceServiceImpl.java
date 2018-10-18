package com.example.programme.service.impl;

import com.example.programme.domain.DO.ProvinceDO;
import com.example.programme.persist.ProvinceMapper;
import com.example.programme.service.ProvinceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/18 22:50
 * @description:
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Resource
    private ProvinceMapper provinceMapper;

    @Override
    public void save(ProvinceDO province) {
        provinceMapper.addProvince(province);
    }
}
