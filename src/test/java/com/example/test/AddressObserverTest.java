package com.example.test;

import com.example.programme.service.CityService;
import com.example.programme.service.CommonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/18 22:17
 * @description:
 */
public class AddressObserverTest extends BaseObserverTest {

    @Autowired
    private CityService cityService;
    @Autowired
    private CommonService commonService;

    @Test
    public void findCityTest(){
        System.out.println(cityService.findCity(2L));
    }

    @Test
    public void saveAddress(){
        commonService.addAddress();
    }
}
