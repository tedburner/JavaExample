package com.example.programme.base.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 14:19
 * @description:
 */
@Aspect
@Component
public class AdminOnlyAop {

    /**
     * 当有这个注解的时候，执行切面
     */
    @Pointcut("@annotation(AdminOnly)")
    public void adminOnly() {

    }

    @Before("adminOnly()")
    public void before() {

    }
}
