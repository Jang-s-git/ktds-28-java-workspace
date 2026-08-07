package com.ktdsuniversity.edu.fp.stream;

import java.util.IntSummaryStatistics;
import java.util.List;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;

public class PrimitiveStream {

	public static void printSummaryStatisticsOfDishes() {
		// 모든 Dish의 Calory를 가진 IntStream으로 변환해서
		// summaryStatistics()를 호출한 결과를 출력해본다.
		List<Dish> dishes = DishList.makeDishList();
		IntSummaryStatistics statistics = dishes.stream() // Stream<Dish>
				.mapToInt(dish -> dish.getCalories()) // IntStream
				.summaryStatistics() // IntSummaryStatistics
		;
		System.out.println(statistics);
		
		int min = statistics.getMin();
		System.out.println("min: " + min);
		
		double average = statistics.getAverage();
		System.out.println("average: " + average);
		
		long sum = statistics.getSum();
		System.out.println("sum: " + sum);
		
		long count = statistics.getCount();
		System.out.println("count: " + count);
	}
	
	public static void printDishesAverageCalory() {
		// 모든 Dish의 평균 칼로리를 구한다.
		List<Dish> dishes = DishList.makeDishList();
		double dishCal = dishes.stream() // Stream<Dish>
							.mapToInt(dish -> dish.getCalories()) // IntStream
							.average() // OptionalDouble
							.orElse(0) // double
		;
		System.out.println(dishCal);
	}
	
	public static void printMinNumber() {
		List<String> numbers = List.of("12", "34", "54", "67", "93", "23", "44",
					"5", "7", "17", "37", "4883", "323", "765", "875", "2811");
		int min = numbers.stream() // Stream<Integer>
						 .mapToInt(str -> Integer.parseInt(str)) // IntStream
						 .min() // OptionalInt
						 .orElse(-1); // int
		;
		System.out.println(min);
	}
	
	public static void printMaxNumber() {
		List<Integer> numbers = List.of(12, 34, 54, 67, 93, 23, 44, 5, 7, 17,
				37, 4883, 323, 765, 875, 2811);
		int max = numbers.stream() // Stream<Integer>
						 .mapToInt(num -> num) // IntStream
						 .max() // OptionalInt
						 .orElse(-1); // int
		;
		System.out.println(max);
	}
	
	public static void printSumNumbers() {
		List<Integer> numbers = List.of(12, 34, 54, 67, 93, 23, 44, 5, 7, 17,
										37, 4883, 323, 765, 875, 2811);
		int sum = numbers.stream() // Stream<Integer>
						 .mapToInt(num -> num) // IntStream
						 .sum() // int
		;
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		printSumNumbers();
		printMaxNumber();
		printMinNumber();
		printDishesAverageCalory();
		printSummaryStatisticsOfDishes();
	}
	
}
