package com.springlearn.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class ValidateAspect {
	
	
	public void beforeMethod(JoinPoint joinPoint) {
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("-->validate:"+ args);
	}
}
