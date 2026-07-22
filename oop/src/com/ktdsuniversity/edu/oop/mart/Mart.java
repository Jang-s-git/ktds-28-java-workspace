package com.ktdsuniversity.edu.oop.mart;

public class Mart {
	
	public static void main(String[] args) {
		
		Seller auction = new Seller(10, 1000, 0, 0);
		Seller naverSmartStore = new Seller(20, 1500, 3*1500, 3);
		
		Buyer me = new Buyer(17000, 0);
		
		// 내가 auction에서 3개를 구매한다.
		me.buy(3, auction);
		
		me.printStatus();
		auction.printStatus();
		
		System.out.println();
		// 내가 naverSmartStore에서 2개를 구매한다.
		me.buy(2, naverSmartStore);
		
		me.printStatus();
		naverSmartStore.printStatus();
		
		System.out.println();
		// 내가 auction에서 2개를 구매한다.
		// 구매자가 몇 개를 샀는지.
		me.buy(2, auction);
		
		me.printStatus();
		auction.printStatus();
		
		System.out.println();
		// 내가 auction에서 9개를 구매한다.
		me.buy(9, auction);
		
		me.printStatus();
		auction.printStatus();
		
	}
}
