package com.example.demo.customAnnotations.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.demo.customAnnotations.LogAnnotation;

@Aspect // 该注解标注该类为切面类
@Component // 注入依赖
public class LogAspect {

	@AfterReturning("within(com.example.demo.controller..*) && @annotation(rl)")  
	public void addLogSuccess(JoinPoint jp, LogAnnotation rl){
		Object[] parames = jp.getArgs();//获取目标方法体参数  
        for (int i = 0; i < parames.length; i++) {  
            System.out.println(parames[i]);  
        }  
        System.out.println(jp.getSignature().getName());  
        String className = jp.getTarget().getClass().toString();//获取目标类名  
        System.out.println("className:" + className);
        className = className.substring(className.indexOf("com"));  
        String signature = jp.getSignature().toString();//获取目标方法签名  
        System.out.println("signature:" + signature);
        System.out.println("这是return");
	}
	
	@Before("within(com.example.demo.controller..*) && @annotation(rl)")
	public void addBeforeLog(JoinPoint jp, LogAnnotation rl) {
		System.out.println("这是before");
	}
	
	@Around("within(com.example.demo.controller..*) && @annotation(rl)")
	public void addRunLog(ProceedingJoinPoint jp,LogAnnotation rl) throws Throwable {
		System.out.println("这是around");
		jp.proceed();
	}
	
	
	@After("within(com.example.demo.controller..*) && @annotation(rl)")
	public void afterRunLog(LogAnnotation rl) {
		System.out.println("这是after");
	}
}
