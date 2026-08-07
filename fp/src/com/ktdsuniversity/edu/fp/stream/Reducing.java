package com.ktdsuniversity.edu.fp.stream;

import java.util.List;
import java.util.stream.Stream;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;

public class Reducing {

	public static void printLongestNameDish() {
		// 이름이 가장 긴 Dish를 출력
		List<Dish> dishes = DishList.makeDishList();
		
		Dish longNameDish = dishes.stream() // Stream<Dish>
								  .reduce(dishes.get(0), (longestDish, eachDish) -> {
									  int longestDishNameLength = longestDish.getName().length();
									  int eachDishNameLength = eachDish.getName().length();
									  if (longestDishNameLength < eachDishNameLength) {
										  return eachDish;
									  } else {
										  return longestDish;
									  }
								  })
		;
		System.out.println("이름이 가장 긴 Dish: " + longNameDish);
	}
	
	public static void printMaxCalory() {
		// 가장 높은 칼로리를 출력
		List<Dish> dishes = DishList.makeDishList();
		
		int maxCalory = dishes.stream() // Stream<Dish>
							  .map(dish -> (int) dish.getCalories()) // Stream<Integer>
							  .reduce(Integer.MIN_VALUE, Math::max) // Integer
		;
		System.out.println("가장 높은 칼로리: " + maxCalory);
	}
	
	public static void printMinCaloryOtherDishes() {
		// OTHER Dish 중에 가장 낮은 칼로리를 출력
		List<Dish> dishes = DishList.makeDishList();
		int minCalory = dishes.stream() // Stream<Dish>
							  .filter(dish -> dish.getDishType() == DishType.OTHER) // Stream<Dish>
							  .map(dish -> (int) dish.getCalories()) // Stream<Integer>
							  .reduce(Integer.MAX_VALUE, Math::min) // Integer 
		;
		System.out.println("OTHER 중 가장 낮은 칼로리: " + minCalory);
	}
	
	public static void printMinNumberWithReference() {
		List<Integer> numbers = List.of(123, 123, 4323, 5678, 1234, 656, 25,
										5798, 1000, 38, -743, -999, 0);
		
		int max = numbers.stream()
						 .reduce(Integer.MAX_VALUE, Math::min)
		;
		System.out.println(max);
	}
	
	public static void printMaxNumberWithReference() {
		List<Integer> numbers = List.of(123, 123, 4323, 5678, 1234, 656, 25,
										5798, 1000, 38, -743, -999, 0);
		
		int max = numbers.stream()
						 .reduce(Integer.MIN_VALUE, Math::max)
		;
		System.out.println(max);
	}
	
	public static void printMaxNumber() {
		List<Integer> numbers = List.of(123, 123, 4323, 5678, 1234, 656, 25,
										5798, 1000, 38, -743, -999, 0);
		
		int max = numbers.stream()
						 .reduce(Integer.MIN_VALUE, (maxNum, eachNumber) -> {
							 if (maxNum < eachNumber) {
								 return eachNumber;
							 } else {
								 return maxNum;
							 }
						 })
		;
		System.out.println(max);
	}
	
	public static void printSumNumbers() {
		List<Integer> numbers = List.of(123, 123, 4323, 5678, 1234, 656, 25, 5798, 1000, 38);
		
		int sum = numbers.stream()
						 .reduce(0, (total, eachNumber) -> total + eachNumber)
		;
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		printSumNumbers();
		printMaxNumber();
		printMaxNumberWithReference();
		printMinNumberWithReference();
		printMinCaloryOtherDishes();
		printMaxCalory();
		printLongestNameDish();
	}
}
