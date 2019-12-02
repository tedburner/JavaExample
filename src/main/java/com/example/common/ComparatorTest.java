package com.example.common;

import com.example.domain.dto.UserDTO;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/18 14:57
 * @description: 排序 Comparator
 */
public class ComparatorTest {


    public static void main(String[] args) {
        List<UserDTO> userDTOList = Lists.newArrayList();
        for (int i = 0; i < 20; i++) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(i);
            userDTO.setName(i + "号机器人");
            userDTO.setEmail(i + i + "@qq.com");
            userDTO.setPassword(i + i + "密码");
            userDTOList.add(userDTO);
        }

        //数组根据ID 倒序排列
        //userDTOList.sort(Comparator.comparing(UserDTO::getId).reversed());
        //倒序排序
        userDTOList.sort(((o1, o2) -> o2.getId().compareTo(o1.getId())));

        userDTOList.forEach(System.out::println);

    }
}
