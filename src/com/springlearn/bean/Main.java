package com.springlearn.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//����helloworld����
		HelloWorld helloworld=new HelloWorld();
		//Ϊname���Ը�ֵ
		helloworld.setName("Spring");
		*/
		
		//1.����spring��IOC��������
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.��IOC�����л�ȡBeanʵ��
		HelloWorld helloworld = (HelloWorld) ctx.getBean("helloworld");
		//3.����hello()����
		helloworld.hello();
	}

}
