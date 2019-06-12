package com.springlearn.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//�����������Ϊһ�����棺
//1.���������������
//2.������Ϊһ������

@Aspect
@Component
public class LoggingAspect {
	//�����÷���Ϊһ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
	@Before("execution(* com.springlearn.aop.impl.ArithmeticCalculator.*(int,int))")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins with "+ args);
	}
}
