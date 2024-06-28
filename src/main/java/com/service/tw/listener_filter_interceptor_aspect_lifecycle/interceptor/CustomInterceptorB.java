package com.service.tw.listener_filter_interceptor_aspect_lifecycle.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author David Tian
 * @desc
 * @since 2019-12-07 20:06
 */
@Slf4j
public class CustomInterceptorB implements HandlerInterceptor {

    public CustomInterceptorB() {
        log.info("拦截器 {} 开始加载", this.getClass().getName());
    }

    // 请求处理之前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器 {} preHandler 方法开始执行", this.getClass().getName());

        // return true 继续下面的逻辑
        // return false 本次拦截失效
        return true;
    }

    // 请求处理结束，视图渲染之前调用（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("拦截器 {} postHandler 方法开始执行", this.getClass().getName());
    }

    // 请求结束，在 DispatcherServlet 渲染视图后调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("拦截器 {} afterCompletion 方法开始执行", this.getClass().getName());
    }
}
