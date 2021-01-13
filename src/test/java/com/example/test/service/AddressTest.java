package com.example.test.service;

import com.example.programme.domain.DO.CityDO;
import com.example.programme.service.CityService;
import com.example.programme.service.CommonService;
import com.example.test.BaseObserverTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/18 22:17
 * @description:
 */
@Slf4j
public class AddressTest extends BaseObserverTest {

    @Autowired
    private CityService cityService;
    @Autowired
    private CommonService commonService;

    @Test
    public void findCityTest() {
        List<CityDO> list = cityService.findCity(2L);
        log.info("查询结果：{}", list);
    }

    @Test
    public void saveAddress() {
        commonService.addAddress();
    }
}
