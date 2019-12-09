package com.tw.listener_filter_interceptor_aspect_lifecycle.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author David Tian
 * @desc
 * @since 2019-12-07 20:08
 */
@Slf4j
@WebListener
public class CustomListenerA implements ServletRequestListener {

    public CustomListenerA() {
        log.info("监听器 {} 加载", this.getClass().getName());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("监听器 {} 销毁", this.getClass().getName());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("监听器 {} 初始化", this.getClass().getName());
    }
}
