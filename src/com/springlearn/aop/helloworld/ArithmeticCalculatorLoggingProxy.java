package com.springlearn.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


public class ArithmeticCalculatorLoggingProxy {
	private ArithmeticCalculator target;

	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target=target;
	}
	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy = null;
		//�����������һ����������������
		ClassLoader loader = target.getClass().getClassLoader();
		//�����������ͣ�����������Щ����
		Class [] interfaces = new Class[]{ArithmeticCalculator.class};
		//�����ô������ķ���ʱ����ִ�еĴ���
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * proxy:���ڷ��ص��Ǹ��������һ������£���invoke�����в����øö���
			 * method:���ڱ����õķ���
			 * args:���÷���ʱ������Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				String methodName =method.getName();
				//��־��ӡ
				System.out.println("The method "+ methodName+ " begin with "+ Arrays.asList(args));
				//����Ŀ�귽��
				Object result = null;
				try {
					//ǰ��֪ͨ
					result= method.invoke(target, args);
					//����֪ͨ�����Է��ʵ������ķ���ֵ
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					//�쳣֪ͨ�����Է��ʵ��������ֵ��쳣
				}
				
				//����֪ͨ����Ϊ�������ܻ�����쳣�����Է��ʲ��������ķ���ֵ
				
				//��ӡ��־
				System.out.println("The method "+ methodName+ " end with "+result);
				return result;
			}
		};
		proxy=(ArithmeticCalculator)Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
}
