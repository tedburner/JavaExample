package com.example.programme.service.impl;

import com.example.programme.domain.DO.ProvinceDO;
import com.example.programme.service.CityService;
import com.example.programme.service.CommonService;
import com.example.programme.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/18 22:34
 * @description:
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CityService cityService;
    @Autowired
    private ProvinceService provinceService;

    @Override
    public void addAddress() {
        ProvinceDO province = ProvinceDO.ProvinceDOBuilder
                .aProvinceDO()
                .withName("湖南省")
                .build();
        provinceService.save(province);

        List<String> cityNameList = Stream.of("长沙市", "株洲市", "岳阳市", "常德市", "张家界市").collect(Collectors.toList());
        cityService.save(cityNameList, province.getId());
    }
}
