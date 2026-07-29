package com.ktdsuniversity.edu.oop.exceptions;

public class GoodsHolder {

	private Goods[] goods;
	private int goodsIndex;
	
	public GoodsHolder(int goodsCount) {
		if (goodsCount <= 0) {
			HolderInitiateException hie = new HolderInitiateException
					("잘못된 인덱스 개수입니다. 0보다 큰 값을 입력하세요.");
			throw hie;
		}
		this.goods = new Goods[goodsCount];
	}
	
	public void addGoods(String name, String price) {
		if (price == null) {
			return;
		}
		
		int intPrice = 0;
		try {
			intPrice = Integer.parseInt(price);
		} catch (NumberFormatException e) {
			System.out.println("숫자 변환 실패: " + e.getLocalizedMessage());
		}
		
//		price = price.replaceAll("[^0-9]", "");
//		if (price.isBlank()) {
//			return;
//		}
////		int tempPrice = Integer.parseInt(price);
//		long tempPrice = Long.parseLong(price);
//		if (tempPrice > Integer.MAX_VALUE || tempPrice  < Integer.MIN_VALUE) {
//			return;
//		}
//		int intPrice = (int) tempPrice;
		this.addGoods(name, intPrice);
	}
	
	public void addGoods(String name, int price) {
		if (name == null || name.trim().length() == 0) {
			return;
		}
		if (this.goodsIndex < this.goods.length) {
			this.goods[this.goodsIndex++] = new Goods(name, price);
		}
	}
	
	public void removeGoods(int goodsIndex) {
		if (goodsIndex >= 0 && goodsIndex < this.goodsIndex) {
			this.goods[goodsIndex] = null;
		}
	}
	
	public void printGoodsAt(int index) {
		Goods goods = null;
		if (index >= 0 && index < this.goodsIndex) {
			goods = this.goods[index];
		}
		if (goods != null) {
			String message = "%d. %s(%d)".formatted(
					index + 1, goods.getName(), goods.getPrice());
			System.out.println(message);
		}
	}
	
	public void printGoods() {
		for (int i = 0; i < this.goods.length; i++) {
			this.printGoodsAt(i);
		}
	}
	
}