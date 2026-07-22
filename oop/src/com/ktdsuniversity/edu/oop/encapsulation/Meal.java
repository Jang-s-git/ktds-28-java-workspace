package com.ktdsuniversity.edu.oop.encapsulation;

public class Meal {

	/**
	 * 종류
	 */
	private String meal;
	
	/**
	 * 포만감
	 */
	private int satiety;
	
	/**
	 * 취기
	 */
	private int tipsy;
	
	public Meal(String meal, int satiety, int tipsy) {
		this.meal = meal;
		this.satiety = satiety;
		this.tipsy = tipsy;
	}
	
	public String getMeal() {
		return this.meal;
	}
	
	public void serve(Customer customer) {
		// 포만감 100 초과 시 서빙 불가
		if (customer.getCustomerSatiety() > 100) {
			System.out.println("더 이상 음식을 드실 수 없습니다.");
			return;
		}
		
		customer.addSatiety(satiety);
		customer.addTipsy(tipsy);
		System.out.println(meal + "을/를 드셨습니다.");
		customer.printStatus();
	}
	
}
