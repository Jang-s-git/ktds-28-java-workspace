package com.ktdsuniversity.edu.oop.enums.food;

public class Food {

	private String name;
	private int calories;
	
	/**
	 * 채소 과일 고기 생선 패스트푸드
	 */
	private FoodType type;

	public Food(String name, int calories, FoodType type) {
		this.name = name;
		this.calories = calories;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", calories=" + calories + ", type=" + type + "]";
	}
	
	
}
