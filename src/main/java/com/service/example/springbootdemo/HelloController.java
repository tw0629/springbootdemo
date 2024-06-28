package com.service.example.springbootdemo;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello tian ";
    }

    /**
     * 返回html模板.
     */
    @RequestMapping("/hello2")
    public String hello(ModelMap map) {
        map.put("hello", "hello world");
        return "/templates/hello";
    }

    /**
     * 返回Ftl模板.
     */
    @RequestMapping("/hello3")
    public String helloFtl(ModelMap map) {
        map.put("hello", "from TemplateController.helloFtl");
        return "/templates/hello2.html";
    }
}
