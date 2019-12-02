package com.example.programme.service.impl;

import com.example.programme.domain.DO.CityDO;
import com.example.programme.persist.CityMapper;
import com.example.programme.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 14:40
 * @description:
 */
@Slf4j
@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public List<CityDO> findCity(Long provinceId) {
        return cityMapper.selectCityByProvinceId(provinceId);
    }

    @Override
    public void save(CityDO city) {
        cityMapper.addCity(city);
    }

    @Override
    @Transactional
    public void save(List<String> cityNameList, Long provinceId) {
//        transactionTemplate.execute(status -> {
//            try {
//
//
//            } catch (Exception e) {
//                status.setRollbackOnly();
//                log.info("添加地址出现错误" + e);
//                throw e;
//            }
//            return null;
//        });

        cityNameList.stream().forEach(name -> {
            CityDO cityDO = CityDO.CityBuilder
                    .aCity()
                    .withName(name)
                    .withProvinceId(provinceId)
                    .withDescription("湖南省的" + name)
                    .build();
            cityMapper.addCity(cityDO);
        });

        CityDO builder = CityDO.CityBuilder
                .aCity()
                .withName("邵阳市")
                .withDescription("异常抛出")
                .build();
        cityMapper.addCity(builder);


    }
}
