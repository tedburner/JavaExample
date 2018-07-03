package com.project.service.imp;

import com.project.model.DO.CityDO;
import com.project.persist.CityMapper;
import com.project.service.TestService;
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

    @Override
    public CityDO findCityById(Long id) {

        return cityMapper.selectById(id);
    }
}
