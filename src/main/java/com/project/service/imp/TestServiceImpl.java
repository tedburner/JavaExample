package com.project.service.imp;

import com.project.model.DO.CityDO;
import com.project.model.DO.ProvinceDO;
import com.project.persist.CityMapper;
import com.project.persist.ProvinceMapper;
import com.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lingjun.jlj
 * @data 2018/4/28
 * @Description:
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private CityMapper cityMapper;
    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public CityDO findCityById(Long id) {

        return cityMapper.selectById(id);
    }

    @Override
    public void addAddress() {

        ProvinceDO provinceDO = ProvinceDO.ProvinceDOBuilder
                .aProvinceDO()
                .withName("浙江省")
                .build();
        provinceMapper.addProvince(provinceDO);

        CityDO cityDO = CityDO.CityBuilder
                .aCity()
                .withName("杭州")
                .withProvinceId(provinceDO.getId())
                .withDescription("阿里巴巴、西湖")
                .build();
        cityMapper.addCity(cityDO);
    }
}
