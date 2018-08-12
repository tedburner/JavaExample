package com.example.project.service;

import com.example.project.model.DO.CityDO;

/**
 * @author lingjun.jlj
 * @data 2018/4/28
 * @Description:
 */
public interface TestService {

    CityDO findCityById(Long id);

    void addAddress();
}
