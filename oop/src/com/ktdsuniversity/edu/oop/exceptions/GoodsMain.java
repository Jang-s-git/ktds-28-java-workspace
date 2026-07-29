package com.ktdsuniversity.edu.oop.exceptions;

public class GoodsMain {

	public static void main(String[] args) {
		
		GoodsHolder capsuleHolder = null;
		while (capsuleHolder == null) {
			int randomCount = (int) (Math.random() * 1000) - 300;
			try {
				capsuleHolder = new GoodsHolder(randomCount);
			} catch (HolderInitiateException hie) {
				System.out.println(hie.getMessage());
			}
		}
		
//		GoodsHolder capsuleHolder = new GoodsHolder(-10);
		capsuleHolder.addGoods("네스프레소 솔티드 캬라멜 커피", "팔천구백원");
		capsuleHolder.addGoods("네스프레소 카페라떼", "30000000000");
		capsuleHolder.addGoods(null, "9_800");
		capsuleHolder.addGoods("돌체구스토 아메리카노", "7_800");
		capsuleHolder.addGoods("", "8700");
		capsuleHolder.addGoods("    ", "8800");
		capsuleHolder.addGoods("카누 에스프레소", "8_000");
		capsuleHolder.addGoods("일리 에스프레소", "7900");
		
		capsuleHolder.printGoodsAt(-1);
		capsuleHolder.printGoodsAt(0);
		capsuleHolder.printGoodsAt(1);
		capsuleHolder.printGoodsAt(2);
		capsuleHolder.printGoodsAt(3);
		capsuleHolder.printGoodsAt(99);
		
		capsuleHolder.removeGoods(-1);
		capsuleHolder.removeGoods(0);
		capsuleHolder.removeGoods(1);
		capsuleHolder.removeGoods(2);
		capsuleHolder.removeGoods(3);
		capsuleHolder.removeGoods(99);
		
		capsuleHolder.printGoods();
	}
	
}
