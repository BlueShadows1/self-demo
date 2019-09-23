package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customAnnotations.AnnotationsDemo;
import com.example.demo.customAnnotations.AnnotationsDemo2;
import com.example.demo.customAnnotations.LogAnnotation;
import com.example.demo.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService service;
    @RequestMapping("/userInfo")
    public Object queryInfo() {
        return service.getUserInfo();
    }
    
    @AnnotationsDemo
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {

    }
    
    @AnnotationsDemo2(age = 10, name = "张三", id = 0)
    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public void test2() {
    	System.out.println();
    }
    
    @LogAnnotation(desc = "注解测试")
    @RequestMapping(value = "test3")
    public Object test3() {
    	System.out.println("这是运行时");
    	return "Just Test";  
    }
    
}
