package com.springlearn.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springlearn.beans.annotation.controller.UserController;
import com.springlearn.beans.annotation.repository.UserRepository;
import com.springlearn.beans.annotation.service.UserService;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("beans-annotation.xml");
			
//		TestObject test = (TestObject) ctx.getBean("testObject");
//		System.out.println(test);
		
		UserController userController = (UserController) ctx.getBean("userController");
		System.out.println(userController);
		userController.execute();
		
//		UserService userService =(UserService)ctx.getBean("userService");
//		System.out.println(userService);
//		
//		UserRepository userRepository = (UserRepository)ctx.getBean("userRepository");
//		System.out.println(userRepository);
	}
}
