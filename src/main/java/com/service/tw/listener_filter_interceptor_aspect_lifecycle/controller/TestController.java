package com.service.tw.listener_filter_interceptor_aspect_lifecycle.controller;

import com.service.tw.listener_filter_interceptor_aspect_lifecycle.aspect.CustomAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David Tian
 * @desc
 * @since 2019-12-07 20:04
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @CustomAnnotation
    public String test() {
        log.info("test controller 方法");

        return "test";
    }
}
