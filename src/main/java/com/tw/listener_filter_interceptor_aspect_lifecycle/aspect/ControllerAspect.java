package com.tw.listener_filter_interceptor_aspect_lifecycle.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author David Tian
 * @desc
 * @since 2019-12-07 19:58
 */
@Aspect
@Slf4j
@Component
public class ControllerAspect {

    public ControllerAspect() {
        log.info("切面{}开始初始化", this.getClass().getName());
    }

    @Pointcut("@annotation(com.tw.listener_filter_interceptor_aspect_lifecycle.aspect.CustomAnnotation)")
    public void controllerAspect(){}

    @Around("controllerAspect()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        log.info("切面{}开始执行", this.getClass().getName());
        Object returnContent = pjp.proceed();
        log.info("切面{}执行结束", this.getClass().getName());
        return returnContent;
    }
}
