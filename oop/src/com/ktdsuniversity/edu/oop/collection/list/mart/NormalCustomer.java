package com.ktdsuniversity.edu.oop.collection.list.mart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ktdsuniversity.edu.oop.collection.list.mart.inf.Customer;
import com.ktdsuniversity.edu.oop.interfaces.mart.goods.AlcoholicBeverages;
import com.ktdsuniversity.edu.oop.interfaces.mart.goods.Goods;

public abstract class NormalCustomer implements Customer {

	private String name;
	private int money;
	private List<Goods> goods;
	private int age;

	public NormalCustomer(String name, int money, int age) {
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

		System.out.println("결제 금액: " + orderAmount);
		System.out.println("보유 금액: " + this.money);
		if (orderAmount > this.money) {
			System.out.println("구매 불가능 사유: 잔액 부족");
		} else {
			this.money -= orderAmount;
			System.out.println("결제 후 보유 금액: " + this.money);
		}
	}

	@Override
	public String toString() {
		return "NormalCustomer [name=" + this.name + ", money=" + this.money
				+ ", goods=" + ", age=" + this.age + "]";
	}

}