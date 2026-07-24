package com.ktdsuniversity.edu.oop.inheritence.zoo;

public class Zoo {

//	private Penguin[] penguins;
//	private Tiger[] tigers;
//	private Giraffe[] giraffes;
	private Animal[] animals;
	
	public Zoo() {
//		this.penguins = new Penguin[100];
//		this.tigers = new Tiger[100];
//		this.giraffes = new Giraffe[100];
		this.animals = new Animal[100];
	}
	
	public void addTiger() {
		// 상속과 구현
		this.animals[10] = new Tiger();
	}
	
	public void enterTourist() {
		
	}
	
	public void enterArea() {
		
	}
	
	public void seeAmimals() {
		
	}
	
}
