package com.ktdsuniversity.edu.oop.encapsulation;

public class Restaurant {

	public static void main(String[] args) {
		
		// 메뉴 등록
		Meal meat = new Meal("육고기", 25, 0);
		Meal veggie = new Meal("채소", 13, -5);
		Meal fruit = new Meal("과일", 13, -5);
		Meal fish = new Meal("생선", 7, 0);
		
		Drink soju = new Drink("소주", 17, -7);
		Drink beer = new Drink("맥주", 6, 8);
		Drink whiskey = new Drink("위스키", 40, -7);
		Drink cognac = new Drink("꼬냑", 40, -7);
		
		// 엄마와 딸이 방문
		Customer mom = new Customer(42, true, 0 , 0);
		Customer daugther = new Customer(15, true, 0 , 0);
		
		// 혼자 방문
		Customer me = new Customer(18, false, 0 , 0);
		
		System.out.println("===== mom =====");
		meat.serve(mom);
		soju.serve(mom);
		whiskey.serve(mom);
		veggie.serve(mom);
		veggie.serve(mom);
		veggie.serve(mom);
		cognac.serve(mom);
		fruit.serve(mom);
		soju.serve(mom);
		
		System.out.println("===== daugther =====");
		meat.serve(daugther);
		soju.serve(daugther);
		fish.serve(daugther);
		fish.serve(daugther);
		meat.serve(daugther);
		meat.serve(daugther);
		meat.serve(daugther);
		fruit.serve(daugther);
		
		System.out.println("===== me =====");
		beer.serve(me);
	}
	
}
