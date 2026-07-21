package com.ktdsuniversity.edu.oop.vendingmachine;

/**
 * 자판기
 * 음료가 들어있는 자판기에 돈을 넣고 음료의 번호를 입력하면 음료가 추출된다.
 * 거스름돈이 남아있을 경우 사용자에게 돌려준다.
 */
public class VendingMachine {
	
	ItemHolder holder;
	
	public VendingMachine(ItemHolder holder) {
		// 생성자에서의 this -> 생성자가 만든 인스턴스 객체
		this.holder = holder;
	}
	
	// 자판기에 새로운 라면을 추가
	public void addNewItem(int index, Item newItem) {
		// 메소드에서의 this -> 점연산자(.)를 사용한 인스턴스 객체
		this.holder.items[index] = newItem;
	}
	
	public static void main(String[] args) {
		
		Item[] ramenItems = new Item[5];
		ramenItems[0] = new Item("Item-1", "너구리", 3800, 7);
		ramenItems[1] = new Item("Item-2", "신라면", 3500, 9);
		ramenItems[2] = new Item("Item-3", "진짬뽕", 4000, 3);
		
		ItemHolder ramenHolder = new ItemHolder(ramenItems);
		
		VendingMachine ramen = new VendingMachine(ramenHolder);
		
		ramen.addNewItem(3, new Item("Item-4", "불닭볶음면", 3200, 4));
		
		VendingMachine ramen2nd = new VendingMachine(ramenHolder);
		ramen2nd.addNewItem(0, new Item("Item-1", "짜파게티", 3800, 4));
		
	}
	
}
