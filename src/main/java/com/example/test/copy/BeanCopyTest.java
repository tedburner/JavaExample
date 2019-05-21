package com.example.test.copy;

import com.example.domain.bean.SimpleDTO;
import com.example.domain.dto.UserDTO;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * @author: lingjun.jlj
 * @date: 2019/5/21 19:06
 * @description: 基于orika 拷贝
 */
public class BeanCopyTest {

    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setName("张三");
        userDTO.setPassword("123456");
        userDTO.setEmail("123@qq.com");

        MapperFactory factory = new DefaultMapperFactory.Builder().build();

        factory.classMap(UserDTO.class, SimpleDTO.class)
                .field("email", "content")
                .byDefault()
                .register();

        MapperFacade mapper = factory.getMapperFacade();


        SimpleDTO simpleDTO = mapper.map(userDTO, SimpleDTO.class);

        System.out.println(simpleDTO);
    }
}
