package com.ktdsuniversity.edu.fp.lambda;

import java.util.List;
import java.util.function.Predicate;

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
	
	public void printAllDishesBy(Predicate<Dish> condition) {
		for (int i = 0; i < this.dishes.size(); i++) {
			
			if (condition.test(this.dishes.get(i))) {
				System.out.println(this.dishes.get(i));
			}
		}
	}
	
	public void printTotalCaloriesBy(Predicate<Dish> condition) {
		int totalCalories = 0;
		
		for (int i = 0; i < this.dishes.size(); i++) {
			if (condition.test(this.dishes.get(i))) {
				totalCalories += this.dishes.get(i).getCalories();
			}
		}
		
		System.out.println(totalCalories);
	}
	
	public void printAverageCaloriesBy(Predicate<Dish> condition) {
		int totalCalories = 0;
		int size = 0;
		
		for (int i = 0; i < this.dishes.size(); i++) {
			if (condition.test(this.dishes.get(i))) {
				size++;
				totalCalories += this.dishes.get(i).getCalories();
			}
		}
		
		System.out.println(totalCalories / (double) size);
	}
	
}
