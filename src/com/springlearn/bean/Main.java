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
		// ApplicationContext ����IOC����
		// ClassPathXmlApplicationContext��ApplicationContext��ʵ����
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.��IOC�����л�ȡBeanʵ��
		//����ID��λ��IOC�����е�bean
		//HelloWorld helloworld = (HelloWorld) ctx.getBean("helloworld");
		//�������ͷ���IOC �����е�bean,��Ҫ��IOC�����б���ֻ��һ�������͵�bean
		//HelloWorld helloworld = ctx.getBean(HelloWorld.class);
		//3.����hello()����
		//helloworld.hello();
		
		Car car1= (Car) ctx.getBean("car");
		System.out.println(car1);
		
		Car car2= (Car) ctx.getBean("car2");
		System.out.println(car2);
		
		Person person1 =(Person) ctx.getBean("person1");
		System.out.println(person1);
		
		Person person2 =(Person) ctx.getBean("person2");
		System.out.println(person2);
	}

}
