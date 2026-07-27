package com.ktdsuniversity.edu.oop.inheritence.car;

public class SportsCar extends Vehicle {

	
	public SportsCar(String model) {
		super(model);
	}
	
	public void startTurboEngine() {
		System.out.println(super.getModel() + " 터보 모드를 시작합니다.");
	}
}
