package com.service.tw.listener_filter_interceptor_aspect_lifecycle.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author David Tian
 * @desc
 * @since 2019-12-07 20:04
 */
@Slf4j
@Order(-100)
@WebFilter(urlPatterns = "/*", filterName = "customFilterB")
public class CustomFilterB implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器{}初始化...", this.getClass().getName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("执行过滤器{}逻辑...", this.getClass().getName());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("执行过滤器{}逻辑 执行结束...", this.getClass().getName());
    }

    @Override
    public void destroy() {
        log.info("过滤器{}销毁...", this.getClass().getName());
    }
}
