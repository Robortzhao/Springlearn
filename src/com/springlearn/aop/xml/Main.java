package com.springlearn.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aop-xml-context.xml");
		
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
		
		result = arithmeticCalculator.div(12, 1);
		System.out.println("-->result:"+result);
	}
}
