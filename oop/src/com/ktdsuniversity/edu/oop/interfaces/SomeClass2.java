package com.ktdsuniversity.edu.oop.interfaces;

public class SomeClass2 implements SomeInterface {

	@Override
	public void doSomething1() {
		System.out.println("HBD");
	}

	@Override
	public void doSomething2() {
		System.out.println("HBD!!!");
	}

	@Override
	public void doSomething3() {
		System.out.println("Happy Birthday");
	}

	@Override
	public int getSomething() {
		return Integer.MIN_VALUE;
	}

	@Override
	public String getString() {
		return "생일축하해";
	}

}
