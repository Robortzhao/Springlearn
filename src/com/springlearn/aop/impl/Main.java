package com.springlearn.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aopContext.xml");
		
		/**
		 * 注意这三种方式的区别
		 * 方式一：不添加("arithmeticCalculator"),直接用ArithmeticCalculator.class调用
		 * 方式二：不添加("arithmeticCalculator"),直接用arithmeticCalculatorImpl获取bean
		 * 方式三：添加("arithmeticCalculator")，通过设定的value获取bean
		 */
		
//		ArithmeticCalculator arithmeticCalculator =(ArithmeticCalculator) ctx.getBean(ArithmeticCalculator.class);
		ArithmeticCalculator arithmeticCalculator =(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		int result = arithmeticCalculator.add(2, 4);
		System.out.println("-->result:"+result);
		
		result = arithmeticCalculator.div(12, 3);
		System.out.println("-->result:"+result);
	}
}
