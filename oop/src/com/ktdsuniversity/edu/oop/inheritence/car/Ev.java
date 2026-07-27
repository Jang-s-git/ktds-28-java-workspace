package com.ktdsuniversity.edu.oop.inheritence.car;

public class Ev extends Vehicle {

	private float battery;
	
	public Ev (String model) {
		super(model);
	}
	public Ev (String model, float battery) {
		super(model);
		this.battery = battery;
	}
	
	public void batteryCheck() {
		System.out.println(super.getModel() + " 배터리를 체크합니다.");
		if (this.battery > 0f) {
			System.out.println(super.getModel() + " 배터리가 충분합니다.");
		} else {
			System.out.println(super.getModel() + " 배터리가 충분하지 않습니다.");
		}
	}
	
	public float getBattery() {
		return this.battery;
	}
	
}
