package com.springlearn.beans.cycle;

public class Car {
	
	public Car() {
		System.out.println("Car's constructor...");
	}
	
	private String brand;
	
	public void setBrand(String brand) {
		System.out.println("SetBrand...");
		this.brand = brand;
	}
	
	public void init() {
		System.out.println("init...");
	}
	
	private void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy...");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
}
