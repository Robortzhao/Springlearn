package com.springlearn.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aopContext.xml");
		ArithmeticCalculator arithmeticCalculator =(ArithmeticCalculator) ctx.getBean(ArithmeticCalculator.class);
		int result = arithmeticCalculator.add(2, 4);
		System.out.println(result);
		
		result = arithmeticCalculator.div(12, 4);
		System.out.println(result);
	}
}
