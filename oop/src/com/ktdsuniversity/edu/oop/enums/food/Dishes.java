package com.ktdsuniversity.edu.oop.enums.food;

public class Dishes {

	public static void main(String[] args) {
		Food bigmac = new Food("빅맥", 900, FoodType.FASTFOOD);
		System.out.println(bigmac);
		
		Food apple = new Food("사과", 150, FoodType.FRUIT);
		System.out.println(apple);
		
		Food tuna= new Food("참치", 300, FoodType.FISH);
		System.out.println(tuna);
		
		Food rips = new Food("갈비", 500, FoodType.MEAT);
		System.out.println(rips);
		
		Food salary = new Food("샐러리", 70, FoodType.VEGETABLE);
		System.out.println(salary);
	}
}
