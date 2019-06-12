package com.springlearn.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aopContext.xml");
		
		/**
		 * ע�������ַ�ʽ������
		 * ��ʽһ�������("arithmeticCalculator"),ֱ����ArithmeticCalculator.class����
		 * ��ʽ���������("arithmeticCalculator"),ֱ����arithmeticCalculatorImpl��ȡbean
		 * ��ʽ�������("arithmeticCalculator")��ͨ���趨��value��ȡbean
		 */
		
//		ArithmeticCalculator arithmeticCalculator =(ArithmeticCalculator) ctx.getBean(ArithmeticCalculator.class);
		ArithmeticCalculator arithmeticCalculator =(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		int result = arithmeticCalculator.add(2, 4);
		System.out.println("-->result:"+result);
		
		result = arithmeticCalculator.div(12, 3);
		System.out.println("-->result:"+result);
	}
}
