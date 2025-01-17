package com.springlearn.beans.spel;

public class Person {
	private String name;
	private Car car;
	
	//引用address Bean的city属性
	private String city;
	//根据car的price确定info：price>300000 金领  否则为白领
	
	private String info;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + ", city=" + city + ", info=" + info + "]";
	}

	
}
