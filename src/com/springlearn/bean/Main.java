package com.springlearn.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//创建helloworld对象
		HelloWorld helloworld=new HelloWorld();
		//为name属性赋值
		helloworld.setName("Spring");
		*/
		
		//1.创建spring的IOC容器对象
		// ApplicationContext 代表IOC容器
		// ClassPathXmlApplicationContext是ApplicationContext的实现类
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从IOC容器中获取Bean实例
		//利用ID定位到IOC容器中的bean
		//HelloWorld helloworld = (HelloWorld) ctx.getBean("helloworld");
		//利用类型返回IOC 容器中的bean,但要求IOC容器中必须只有一个该类型的bean
		//HelloWorld helloworld = ctx.getBean(HelloWorld.class);
		//3.调用hello()方法
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
