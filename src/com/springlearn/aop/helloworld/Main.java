package com.springlearn.aop.helloworld;

public class Main {
	public static void main(String[] args) {
//		ArithmeticCalculator arithmeticCalculator=null;
//		arithmeticCalculator=new ArithmeticCalculatorLoggingImpl();
		
//		System.out.println("-->"+arithmeticCalculator.add(1,2));
//		System.out.println("-->"+arithmeticCalculator.div(4,2));
		
		ArithmeticCalculator target=new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy =new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		
		System.out.println("-->"+proxy.add(1,2));
		System.out.println("-->"+proxy.div(4,2));
	}
}
