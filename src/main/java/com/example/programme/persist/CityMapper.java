package com.example.programme.persist;

import com.example.programme.domain.DO.CityDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lingjun.jlj
 * @create 2017-09-22
 **/
public interface CityMapper {

    Long addCity(CityDO cityDO);

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    CityDO selectByName(@Param("cityName") String cityName);

    /**
     * 根据城市id，查询城市信息
     *
     * @param id 城市名
     */
    CityDO selectById(@Param("id") Long id);

    /**
     * 根据省份ID查询城市信息
     *
     * @param provinceId 省份信息
     */
    List<CityDO> selectCityByProvinceId(Long provinceId);
}
