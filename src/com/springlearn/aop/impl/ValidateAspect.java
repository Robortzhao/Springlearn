package com.springlearn.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class ValidateAspect {
	
	/**
	 * �����÷���Ϊһ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
	 * @param joinPoint
	*/
	@Before("LoggingAspect.declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("-->validate:"+ args);
	}
}
