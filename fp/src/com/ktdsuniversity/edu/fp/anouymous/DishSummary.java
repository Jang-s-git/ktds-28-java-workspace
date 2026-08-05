package com.ktdsuniversity.edu.fp.anouymous;

import java.util.List;

import com.ktdsuniversity.edu.fp.anouymous.inf.Compare;
import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

public class DishSummary {

	private List<Dish> dishes;
	
	public DishSummary() {
		this.dishes = DishList.makeDishList();
	}
	
	/**
	 * 모든 메뉴(Dish)를 출력한다.
	 */
//	public void printAllDishes() {
//		for (int i = 0; i < this.dishes.size(); i++) {
//			System.out.println(this.dishes.get(i));
//		}
//	}
	
	/**
	 * 모든 메뉴에서 DishType이 MEAT인 것만 출력한다.
	 */
//	public void printAllMeatDishes() {
//		for (int i = 0; i < this.dishes.size(); i++) {
//			
//			if (this.dishes.get(i).getDishType() == DishType.MEAT) {
//				System.out.println(this.dishes.get(i));
//			}
//		}
//	}
	
	/**
	 * 모든 메뉴에서 DishType이 FISH인 것만 출력한다.
	 */
//	public void printAllFishDishes() {
//		for (int i = 0; i < this.dishes.size(); i++) {
//			
//			if (this.dishes.get(i).getDishType() == DishType.FISH) {
//				System.out.println(this.dishes.get(i));
//			}
//		}
//	}
	
	/**
	 * 모든 메뉴에서 DishType이 OTHER인 것만 출력한다.
	 */
//	public void printAllOtherDishes() {
//		for (int i = 0; i < this.dishes.size(); i++) {
//			
//			if (this.dishes.get(i).getDishType() == DishType.OTHER) {
//				System.out.println(this.dishes.get(i));
//			}
//		}
//	}
	
//	public void printAllDishesBy(DishType dishType) {
//		for (int i = 0; i < this.dishes.size(); i++) {
//			
//			if (this.dishes.get(i).getDishType() == dishType) {
//				System.out.println(this.dishes.get(i));
//			}
//		}
//	}
	
//	public void printAllDishesBy(FoodType foodType) {
//		for (int i = 0; i < this.dishes.size(); i++) {
//			
//			if (this.dishes.get(i).getFoodType() == foodType) {
//				System.out.println(this.dishes.get(i));
//			}
//		}
//	}
	
	public <T> void printAllDishesBy(Compare<T> compare, T type) {
		for (int i = 0; i < this.dishes.size(); i++) {
			
			if (compare.compareType(this.dishes.get(i), type)) {
				System.out.println(this.dishes.get(i));
			}
		}
	}
	
//	public void printTotalCalories() {
//		int totalCalories = 0;
//		
//		for (int i = 0; i < this.dishes.size(); i++) {
//			totalCalories += this.dishes.get(i).getCalories();
//		}
//		
//		System.out.println(totalCalories);
//	}
	
//	public void printTotalCaloriesBy(DishType dishType) {
//		int totalCalories = 0;
//		
//		for (int i = 0; i < this.dishes.size(); i++) {
//			if (this.dishes.get(i).getDishType() == dishType) {
//				totalCalories += this.dishes.get(i).getCalories();
//			}
//		}
//		
//		System.out.println(totalCalories);
//	}
	
//	public void printTotalCaloriesBy(FoodType foodType) {
//		int totalCalories = 0;
//		
//		for (int i = 0; i < this.dishes.size(); i++) {
//			if (this.dishes.get(i).getFoodType() == foodType) {
//				totalCalories += this.dishes.get(i).getCalories();
//			}
//		}
//		
//		System.out.println(totalCalories);
//	}
	
	public <T> void printTotalCaloriesBy(Compare<T> compare, T type) {
		int totalCalories = 0;
		
		for (int i = 0; i < this.dishes.size(); i++) {
			if (compare.compareType(this.dishes.get(i), type)) {
				totalCalories += this.dishes.get(i).getCalories();
			}
		}
		
		System.out.println(totalCalories);
	}
	
//	public void printAverageCalories() {
//		int totalCalories = 0;
//		
//		for (int i = 0; i < this.dishes.size(); i++) {
//			totalCalories += this.dishes.get(i).getCalories();
//		}
//		
//		System.out.println(totalCalories / (double) this.dishes.size());
//	}
	
//	public void printAverageCaloriesBy(DishType dishType) {
//		int totalCalories = 0;
//		int size = 0;
//		
//		for (int i = 0; i < this.dishes.size(); i++) {
//			if (this.dishes.get(i).getDishType() == dishType) {
//				size++;
//				totalCalories += this.dishes.get(i).getCalories();
//			}
//		}
//		
//		System.out.println(totalCalories / (double) size);
//	}
	
//	public void printAverageCaloriesBy(FoodType foodType) {
//		int totalCalories = 0;
//		int size = 0;
//		
//		for (int i = 0; i < this.dishes.size(); i++) {
//			if (this.dishes.get(i).getFoodType() == foodType) {
//				size++;
//				totalCalories += this.dishes.get(i).getCalories();
//			}
//		}
//		
//		System.out.println(totalCalories / (double) size);
//	}
	
	public <T> void printAverageCaloriesBy(Compare<T> compare, T type) {
		int totalCalories = 0;
		int size = 0;
		
		for (int i = 0; i < this.dishes.size(); i++) {
			if (compare.compareType(this.dishes.get(i), type)) {
				size++;
				totalCalories += this.dishes.get(i).getCalories();
			}
		}
		
		System.out.println(totalCalories / (double) size);
	}
	
}
