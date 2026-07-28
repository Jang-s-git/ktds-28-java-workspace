package com.ktdsuniversity.edu.oop.interfaces;

// SomeInterface를 구현한 구현클래스	  (↓구현할 인터페이스)
// 인터페이스를 구현한 클래스는 인터페이스 내부의 메소드(추상메소드)를 구현할 의무가 있음.
public class SomeClass implements SomeInterface {

	@Override
	public void doSomething1() {
		System.out.println("무언가 합니다.1");
	}

	@Override
	public void doSomething2() {
		System.out.println("무언가 합니다.2");
	}

	@Override
	public void doSomething3() {
		System.out.println("무언가 합니다.3");
	}

	@Override
	public int getSomething() {
		return 20260729;
	}

	@Override
	public String getString() {
		return "생일!";
	}

}
