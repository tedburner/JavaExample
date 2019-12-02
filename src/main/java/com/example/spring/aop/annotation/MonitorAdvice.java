package com.example.spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.example.spring.aop.monitor.MonitorSession;

/**
 * @author lingjun.jlj
 * @data 2018/5/9
 * @Description:
 */
@Aspect
@Component
public class MonitorAdvice {

    @Pointcut("execution (* com.example.spring.aop.service.Speakable.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        MonitorSession.begin(pjp.getSignature().getName());
        pjp.proceed();
        MonitorSession.end();
    }
}
