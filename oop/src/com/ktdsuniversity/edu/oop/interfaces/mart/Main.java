package com.ktdsuniversity.edu.oop.interfaces.mart;

import com.ktdsuniversity.edu.oop.interfaces.mart.customers.Customer;
import com.ktdsuniversity.edu.oop.interfaces.mart.customers.impl.NormalCustomer;
import com.ktdsuniversity.edu.oop.interfaces.mart.customers.impl.PromotionCustomer;
import com.ktdsuniversity.edu.oop.interfaces.mart.customers.impl.SpecialCustomer;
import com.ktdsuniversity.edu.oop.interfaces.mart.goods.AlcoholicBeverages;
import com.ktdsuniversity.edu.oop.interfaces.mart.goods.FreshFood;
import com.ktdsuniversity.edu.oop.interfaces.mart.goods.FrozenFood;
import com.ktdsuniversity.edu.oop.interfaces.mart.goods.Goods;

public class Main {

	public static void main(String[] args) {
		Goods snack = new Goods("치토스", 1500);
		Goods vegitable = new FreshFood("상추", 800, "2026-08-01", 6);
		Goods sashimi = new FreshFood("광어회", 15000, "2026-07-30", 3);
		Goods dumpling = new FrozenFood("고향만두", 9000, "2027-12-01", -2);
		Goods whisky = new AlcoholicBeverages("Jony Walker Blue Label", 335000, 10, 19, 40);
		Goods cognac = new AlcoholicBeverages("Remy Martin V.S.O.P", 109000, 15, 19, 40);
		Goods soju = new AlcoholicBeverages("처음처럼", 4000, 2, 19, 17);
		
		Customer cust1 = new NormalCustomer("A", 500_000, 16);
		Customer cust2 = new PromotionCustomer("B", 30_000, 20);
		Customer cust3 = new SpecialCustomer("C", 1_000_000, 51);
		
		cust1.buy(new Goods[] {whisky, dumpling, dumpling, snack});
		cust2.buy(new Goods[] {whisky, dumpling, dumpling, snack});
		cust3.buy(new Goods[] {whisky, dumpling, dumpling, snack});
		
		System.out.println(cust1);
		System.out.println(cust2);
		System.out.println(cust3);
	}
	
}