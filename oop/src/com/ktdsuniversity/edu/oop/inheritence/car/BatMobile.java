package com.ktdsuniversity.edu.oop.inheritence.car;

public class BatMobile extends SportsCar {

	public BatMobile(String model) {
		super(model);
	}
	
	public void ejectBatPod() {
		System.out.println(super.getModel() + " 배트포트를 분리합니다.");
	}
	
}
