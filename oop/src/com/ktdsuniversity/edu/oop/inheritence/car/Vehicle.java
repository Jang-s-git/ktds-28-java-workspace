package com.ktdsuniversity.edu.oop.inheritence.car;

public class Vehicle{

	private String model;
	
	public Vehicle(String model) {
		this.model = model;
	}
	
	public void startEngine() {
		System.out.println(model + " 시동을 겁니다.");
	}
	
	public String getModel() {
		return this.model;
	}
	
}
