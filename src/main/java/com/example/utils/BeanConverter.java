package com.example.utils;

import com.example.domain.bean.SimpleDTO;
import com.example.domain.bean.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author: lingjun.jlj
 * @date: 2020/8/11 09:23
 * @description: Bean Converter 工具
 */
@Mapper
public interface BeanConverter {

    BeanConverter INSTANCE = Mappers.getMapper(BeanConverter.class);

    @Mappings(@Mapping(source = "name", target = "username"))
    UserDTO oldToNew(SimpleDTO old);
}
