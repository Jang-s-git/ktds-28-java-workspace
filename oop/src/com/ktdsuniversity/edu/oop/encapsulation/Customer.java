package com.ktdsuniversity.edu.oop.encapsulation;

public class Customer {
	
	/**
	 * 나이
	 */
	private int age;
	
	/**
	 * 부모 동반 여부
	 */
	private boolean isWithParents;
	
	/**
	 * 고객의 포만감
	 */
	private int customerSatiety;
	
	/**
	 * 고객의 취기
	 */
	private int customerTipsy;
	
	public Customer (int age, boolean isWithParents, int customerSatiety, int customerTipsy) {
		this.age = age;
		this.isWithParents = isWithParents;
		this.customerSatiety = customerSatiety;
		this.customerTipsy = customerTipsy;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public boolean getIsWithParents() {
		return this.isWithParents;
	}
	
	public int getCustomerSatiety() {
		return this.customerSatiety;
	}
	
	public int getCustomerTipsy() {
		return this.customerTipsy;
	}
	
	public void addSatiety(int statiety) {
		this.customerSatiety += statiety;
		if (this.customerSatiety < 0) {
			this.customerSatiety = 0;
		}
	}
	
	public void addTipsy(int tipsy) {
		this.customerTipsy += tipsy;
		if (this.customerTipsy < 0) {
			this.customerTipsy = 0;
		}
	}
	
	public void printStatus() {
		System.out.println("---현재 상태---");
		System.out.println("포만감: " + this.customerSatiety);
		System.out.println("취기: " + this.customerTipsy);
	}
	
}
