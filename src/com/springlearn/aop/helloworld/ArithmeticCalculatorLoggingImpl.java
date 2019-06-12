package com.springlearn.aop.helloworld;

public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

	@Override
	public int add(int a, int b) {
		System.out.println("The method add beagin with ["+a+","+b+"]");
		int result=a+b;
		System.out.println("The method add end with "+result);
		return result;
	}

	@Override
	public int sub(int a, int b) {
		System.out.println("The method sub beagin with ["+a+","+b+"]");
		int result=a-b;
		System.out.println("The method sub end with "+result);
		return result;
	}

	@Override
	public int mul(int a, int b) {
		System.out.println("The method mul beagin with ["+a+","+b+"]");
		int result=a*b;
		System.out.println("The method mul end with "+result);
		return result;
	}

	@Override
	public int div(int a, int b) {
		System.out.println("The method div beagin with ["+a+","+b+"]");
		int result=a/b;
		System.out.println("The method div end with "+result);
		return result;
	}

}
