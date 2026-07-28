package com.ktdsuniversity.edu.oop.interfaces;

public interface SomeInterface {
	
	int PRICE = 300;
	// 인터페이스에서 상수는 public static final 생략 가능
	
	// public abstract는 생략 가능
	void doSomething1(); // 추상 메소드: 메소드의 정의만 존재하고 바디가 없는 형태
	void doSomething2();
	void doSomething3();
	int getSomething();
	String getString();
	
}
