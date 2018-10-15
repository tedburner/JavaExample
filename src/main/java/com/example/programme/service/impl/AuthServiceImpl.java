package com.example.programme.service.impl;

import com.example.programme.domain.CurrentUserHolder;
import com.example.programme.service.AuthService;
import org.springframework.stereotype.Service;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 14:44
 * @description:
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public void checkAuth() {
        String user = CurrentUserHolder.get();
        if (!"admin".equals(user)) {
            throw new RuntimeException("权限不够");
        }
    }
}
