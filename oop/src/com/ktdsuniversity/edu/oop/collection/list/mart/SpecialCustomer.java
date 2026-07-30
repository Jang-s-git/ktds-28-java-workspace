package com.ktdsuniversity.edu.oop.collection.list.mart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ktdsuniversity.edu.oop.collection.list.mart.inf.RegularCustomer;
import com.ktdsuniversity.edu.oop.interfaces.mart.goods.AlcoholicBeverages;
import com.ktdsuniversity.edu.oop.interfaces.mart.goods.Goods;

public abstract class SpecialCustomer implements RegularCustomer {

	private String name;
	private int money;
	private List<Goods> goods;
	private int age;

	public SpecialCustomer(String name, int money, int age) {
		this.name = name;
		this.money = money;
		this.goods = new ArrayList<>();
		this.age = age;
	}

	@Override
	public void buy(List<Goods> goods) {
		System.out.println();
		System.out.println(this.name + " 고객 계산 시작");
		
		int orderAmount = 0;
		Goods good = null;
		for (int i = 0; i < goods.size(); i++) {
			good = goods.get(i);

			if (good instanceof AlcoholicBeverages alcohol) {
				if (alcohol.getPurchageAgeLimit() <= this.age) {
					orderAmount += good.getPrice();
					goods.add(alcohol);
				}
			} else {
				orderAmount += good.getPrice();
				goods.add(good);
			}
		}

		
		orderAmount = this.gift(goods, orderAmount);

		System.out.println("최종 결제 금액: " + orderAmount);
		System.out.println("보유 금액: " + this.money);
		if (orderAmount > this.money) {
			System.out.println("구매 불가능 사유: 잔액 부족");
		} else {
			this.money -= orderAmount;
			System.out.println("결제 후 보유 금액: " + this.money);
		}
	}
	
	@Override
	public int gift(List<Goods> goods, int amount) {
		int giftPrice = Integer.MAX_VALUE;
		
		Goods good = null;
		for (int i = 0; i < goods.size(); i++) {
			good = goods.get(i);

			if (good instanceof AlcoholicBeverages alcohol) {
				if (alcohol.getPurchageAgeLimit() <= this.age) {
					if (giftPrice > good.getPrice()) {
						giftPrice = good.getPrice();
					}
				}
			} else {
				if (giftPrice > good.getPrice()) {
					giftPrice = good.getPrice();
				}
			}
		}
		
		System.out.println("서비스 제공 상품 가격: " + giftPrice);
		return amount - giftPrice;
	}

	@Override
	public String toString() {
		return "SpecialCustomer [name=" + this.name + ", money=" + this.money
				+ ", goods=" + ", age=" + this.age + "]";
	}

}