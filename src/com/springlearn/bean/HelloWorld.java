package com.springlearn.bean;

public class HelloWorld {

	private String name;
	
	public void setName(String name) {
//		System.out.println("setName methods");
		this.name = name;
	}
	
	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("hello: "+name);
	}
	public HelloWorld() {
//		System.out.println("Spring hello");
	}
	
}
