package com.example.demo.customAnnotations.impl;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 实现注解类
 * 
 * @author RuiJiang
 * @date 2019/9/20
 */
@Component
@Aspect
public class AnnotationsDemoImpl {
	
	static Logger logger = LoggerFactory.getLogger(AnnotationsDemoImpl.class);
	
	// 使用pointcut实现，pointcut直接指定需要匹配的类或方法
	@Pointcut("@annotation(com.example.demo.customAnnotations.AnnotationsDemo)")
	public void cut() {
		//point.getArgs();
		System.out.println(999);
	}
	
	// 开始环绕
	@Around("cut()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		logger.info("1");
//		try {
//			joinPoint.proceed();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("4");
	}
//	
//	@Before("cut()") 
//	public void before() {
//		System.out.println("2");
//	}
//	
//	@After("cut()")
//	public void after() {
//		System.out.println("5");
//	}
	
}
