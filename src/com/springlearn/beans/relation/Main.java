package com.springlearn.beans.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springlearn.beans.autowire.Address;
import com.springlearn.beans.autowire.Person;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("beans-relation.xml");
		
		Address address1= (Address) ctx.getBean("address3");
		Address address2= (Address) ctx.getBean("address2");
		Person person1 =(Person) ctx.getBean("person1");
		Person person2 =(Person) ctx.getBean("person2");
		System.out.println(address1);
		System.out.println(address2);
		System.out.println(person1);
		System.out.println(person2);
		
	}
}
