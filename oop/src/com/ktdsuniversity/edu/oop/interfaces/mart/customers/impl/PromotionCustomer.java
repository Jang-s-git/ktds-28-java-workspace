package com.ktdsuniversity.edu.oop.interfaces.mart.customers.impl;

import java.util.Arrays;

import com.ktdsuniversity.edu.oop.interfaces.mart.customers.NewCustomer;
import com.ktdsuniversity.edu.oop.interfaces.mart.goods.AlcoholicBeverages;
import com.ktdsuniversity.edu.oop.interfaces.mart.goods.Goods;

public class PromotionCustomer implements NewCustomer {

	private String name;
	private int money;
	private Goods[] goods;
	private int age;

	public PromotionCustomer(String name, int money, int age) {
		this.name = name;
		this.money = money;
		this.goods = new Goods[10];
		this.age = age;
	}

	@Override
	public void buy(Goods[] goods) {
		System.out.println();
		System.out.println(this.name + " 고객 계산 시작");
		
		int orderAmount = 0;
		Goods good = null;
		int haveGoodsIndex = 0;

		for (int i = 0; i < goods.length; i++) {
			good = goods[i];
			if (good instanceof AlcoholicBeverages alcohol) {
				if (alcohol.getPurchageAgeLimit() <= this.age) {
					orderAmount += good.getPrice();
					this.goods[haveGoodsIndex++] = good;
				}
			} else {
				orderAmount += good.getPrice();
				this.goods[haveGoodsIndex++] = good;
			}
		}
		orderAmount = this.discount(0.9f, orderAmount);
		System.out.println("서비스 할인 후 결제 금액: " + orderAmount);
		System.out.println("보유 금액: " + this.money);
		if (orderAmount > this.money) {
			System.out.println("구매 불가능 사유: 잔액 부족");
			this.goods = new Goods[10];
		} else {
			this.money -= orderAmount;
			System.out.println("결제 후 보유 금액: " + this.money);
		}
	}

	@Override
	public int discount(float discountRatio, int amount) {
		System.out.println("결제 금액: " + amount);
		return (int) (amount * discountRatio);
	}
	
	@Override
	public String toString() {
		return "PromotionCustomer [name=" + this.name + ", money=" + this.money + ", goods="
				+ Arrays.toString(this.goods) + ", age=" + this.age + "]";
	}

	

}