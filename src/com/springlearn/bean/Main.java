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
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从IOC容器中获取Bean实例
		HelloWorld helloworld = (HelloWorld) ctx.getBean("helloworld");
		//3.调用hello()方法
		helloworld.hello();
	}

}
