package com.example.test.builder;

import com.example.domain.bean.SimpleDTO;

/**
 * @author: lingjun.jlj
 * @date: 2019/5/23 09:42
 * @description:
 */
public class BuilderTest {

    public static void main(String[] args) {
        SimpleDTO simpleDTO = new SimpleDTO(1, "张三");
        ResponseModel<SimpleDTO> responseModel = ResponseModel.ResponseModelBuilder
                .aResponseModel()
                .code("200")
                .data(simpleDTO)
                .msg("成功")
                .build();

        System.out.println(responseModel);
    }
}
