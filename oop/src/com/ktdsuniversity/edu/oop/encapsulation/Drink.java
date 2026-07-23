package com.ktdsuniversity.edu.oop.encapsulation;

public class Drink {

	/**
	 * 종류
	 */
	private String drink;
	
	/**
	 * 취기
	 */
	private int tipsy;
	
	/**
	 * 포만감
	 */
	private int satiety;
	
	static final int ADULT = 19;
	
	public Drink(String drink, int tipsy, int satiety) {
		this.drink = drink;
		this.tipsy = tipsy;
		this.satiety = satiety;
	}
	
	public String getDrink() {
		return this.drink;
	}
	
	public void serve(Customer customer) {
		
		// 미성년자, 부모동반 여부 체크
		if (customer.getAge() < ADULT && !customer.getIsWithParents()) {
			System.out.println("미성년자는 주류를 드실 수 없습니다.");
			return;
		}
		
		// 취기 60 초과 시 서빙 불가
		if (customer.getCustomerTipsy() > 60) {
			System.out.println("더 이상 주류를 드실 수 없습니다.");
			return;
		}
		
		customer.addTipsy(tipsy);
		customer.addSatiety(satiety);
		System.out.println(drink + "을/를 드셨습니다.");
		customer.printStatus();
	}
	
}
