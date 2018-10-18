package com.example.programme.persist;


import com.example.programme.domain.DO.ProvinceDO;

/**
 * @author lingjun.jlj
 * @date 2017/12/2
 */
public interface ProvinceMapper {

    Long addProvince(ProvinceDO province);

    ProvinceDO selectProvinceById(Long id);
}
