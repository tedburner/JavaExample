package com.example.programme.service;

import com.example.programme.domain.DO.CityDO;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 14:40
 * @description:
 */
public interface CityService {

    /**
     * 根据省份ID查询城市信息
     *
     * @param provinceId
     */
    List<CityDO> findCity(Long provinceId);

    /**
     * 添加城市信息
     */
    void save(CityDO city);

    /**
     * 批量增加城市信息
     */
    void save(List<String> cityNameList, Long provinceId);
}
