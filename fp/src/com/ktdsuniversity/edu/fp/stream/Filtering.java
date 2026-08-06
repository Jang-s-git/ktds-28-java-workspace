package com.ktdsuniversity.edu.fp.stream;

import java.util.List;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

/**
 * 리스트 인스턴스를 스트림 인스턴스로 변환해
 * 필요한 데이터만 추출해내는 실습
 */
public class Filtering {

	public static void printLowCaloryFishDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
			  .filter((dish) -> dish.getDishType() == DishType.FISH) // Stream<Dish>
			  .filter((dish) -> dish.getCalories() <= 400) // Stream<Dish>
			  .forEach(System.out::println); // void
		;
	}
	
	public static void printFishDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
			  .filter((dish) -> dish.getDishType() == DishType.FISH) // Stream<Dish>
			  .forEach(System.out::println) // void
		;
	}
	
	public static void printHighCaloryDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
			  .filter((dish) -> dish.getCalories() >= 800) // Stream<Dish>
			  .forEach(System.out::println); // void
		;
	}
	
	public static void printLowCaloryDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
			  .filter((dish) -> dish.getCalories() <= 400) // Stream<Dish>
			  .forEach(System.out::println); // void
		;
	}
	
	public static void printMeatDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
			  .filter((dish) -> dish.getFoodType()== FoodType.MEAT) // Stream<Dish>
			  .limit(3) // Stream<Dish>
			  .forEach(System.out::println) // void
		;
	}
	
	public static void printVegetableDishes() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
			// 디버깅 코드 .peek()
//			  .peek((dish) -> {
//				  System.out.println("필터링 수행 전");
//				  System.out.println(dish);
//			  }) // Stream<Dish>
			  .filter((dish) -> dish.getFoodType() == FoodType.VEGETABLES) // Stream<Dish> (중간 연산: 반환타입 Stream)
//			  .peek((dish) -> {
//				  System.out.println("필터링 수행 후");
//				  System.out.println(dish);
//			  }) // Stream<Dish>
//			  .forEach((dish) -> System.out.println(dish)) // void
			  .forEach(System.out::println) // void (최종 연산: 반환타입 Stream이 아님)
		;
	}
	
	public static void main(String[] args) {
		printLowCaloryFishDishes();
		System.out.println("============");
		printFishDishes();
		System.out.println("============");
		printHighCaloryDishes();
		System.out.println("============");
		printLowCaloryDishes();
		System.out.println("============");
		printMeatDishes();
		System.out.println("============");
		printVegetableDishes();
	}
	
}
