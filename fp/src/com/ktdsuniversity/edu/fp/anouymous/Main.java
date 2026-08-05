package com.ktdsuniversity.edu.fp.anouymous;

import com.ktdsuniversity.edu.fp.anouymous.inf.Compare;
import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

public class Main {

	public static void main(String[] args) {
		DishSummary summary = new DishSummary();
//		summary.printAllDishes();
		
//		summary.printAllMeatDishes();
//		summary.printAllFishDishes();
//		summary.printAllOtherDishes();
		
//		summary.printAllDishesBy(DishType.MEAT);
//		summary.printAllDishesBy(DishType.FISH);
//		summary.printAllDishesBy(DishType.OTHER);
//		
//		summary.printAllDishesBy(FoodType.MEAT);
//		summary.printAllDishesBy(FoodType.VEGETABLES);
//		
//		summary.printTotalCalories();
//		summary.printTotalCaloriesBy(DishType.FISH);
//		summary.printTotalCaloriesBy(FoodType.VEGETABLES);
//		
//		summary.printAverageCalories();
//		summary.printAverageCaloriesBy(DishType.OTHER);
//		summary.printAverageCaloriesBy(FoodType.MEAT);
		
		Compare<DishType> dishCompare = new Compare<>() {
			@Override
			public boolean compareType(Dish dish, DishType type) {
				return dish.getDishType() == type;
			}
		};
		
		// DishType의 MEAT만 출력하라
		summary.printAllDishesBy(dishCompare, DishType.MEAT);
		summary.printAllDishesBy(dishCompare, DishType.FISH);
		summary.printAllDishesBy(dishCompare, DishType.OTHER);
		
		Compare<FoodType> foodCompare = new Compare<>() {
			@Override
			public boolean compareType(Dish dish, FoodType type) {
				return dish.getFoodType() == type;
			}
		};
		
		// FoodType의 MEAT만 출력하라
		summary.printAllDishesBy(foodCompare, FoodType.MEAT);
		summary.printAllDishesBy(foodCompare, FoodType.VEGETABLES);
		
		// void의 Reference Type
		Compare<Void> voidCompare = new Compare<>() {
			@Override
			public boolean compareType(Dish dish, Void type) {
				return true;
			}
		};
		
		// 모든 메뉴를 출력해라
		summary.printAllDishesBy(voidCompare, null);
		
		
		// 익명클래스의 인스턴스를 함수화 시키기.
		// 모든 메뉴를 출력해라.
		summary.printAllDishesBy((dish, type) -> true, null);
		
		// DishType.MEAT만 출력해라.
		summary.printAllDishesBy((dish, type) -> dish.getDishType() == type, DishType.MEAT);
		
		// DishType.FISH만 출력해라.
		summary.printAllDishesBy((dish, type) -> dish.getDishType() == type, DishType.FISH);
		
		// DishType.OTHER만 출력해라.
		summary.printAllDishesBy((dish, type) -> dish.getDishType() == type, DishType.OTHER);
		
		// FoodType.MEAT만 출력해라.
		summary.printAllDishesBy((dish, type) -> dish.getFoodType() == type, FoodType.MEAT);
		
		// VEGETABLES.FISH만 출력해라.
		summary.printAllDishesBy((dish, type) -> dish.getFoodType() == type, FoodType.VEGETABLES);
		
	}
	
}
