package com.springlearn.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//把这个类声明为一个切面：
//1.将该类放入容器中
//2.再声明为一个切面

@Aspect
@Component
public class LoggingAspect {
	//声明该方法为一个前置通知；在目标方法开始之前执行
	@Before("execution(* com.springlearn.aop.impl.ArithmeticCalculator.*(int,int))")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins with "+ args);
	}
}
