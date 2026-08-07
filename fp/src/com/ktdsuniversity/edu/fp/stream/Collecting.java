package com.ktdsuniversity.edu.fp.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

public class Collecting {

	public static void printCaloryGroups() {
		// 칼로리 별로 그룹을 나누어 출력
		// 400 이하 => "Diet"
		// 700 이하 => "Normal"
		// 700 초과 => "Fat"
		// Map<String, List<Dish>>
		List<Dish> dishes = DishList.makeDishList();
		
		Map<String, List<Dish>> groups = 
				dishes.stream() // Stream<Dish>
					  .collect(Collectors.groupingBy(dish ->{
						  int calory = dish.getCalories();
						  if (calory <= 400) {
							  return "Diet";
						  } else if (calory <= 700) {
							  return "Normal";
						  }
						  return "Fat";
			})) // Map<String, List<Dish>>
		;
		
		// k: String, v: List<Dish>
		groups.forEach((k, v) -> {
			System.out.println(k + "=".repeat(50));
			v.forEach(System.out::println);
		});
		
	}
	
	public static void printFoodTypeGroups() {
		// FoodType별 Dish 목록을 출력
		List<Dish> dishes = DishList.makeDishList();
		
		Map<FoodType, List<Dish>> groupMap = dishes.stream()
												.collect(Collectors.groupingBy(dish ->
													dish.getFoodType())) // Map<FoodType, List<Dish>>
		;
		groupMap.forEach((k, v) -> {
			System.out.println(k + "=".repeat(50));
			v.forEach(System.out::println);
		});
	}
	
	public static void printDishTypeGroups() {
		// DishType별 Dish 목록을 출력
		List<Dish> dishes = DishList.makeDishList();
		
		Map<DishType, List<Dish>> groupMap = dishes.stream() // Stream<Dish>
											.collect(Collectors.groupingBy(dish ->
												dish.getDishType())) // Map<DishType, List<Dish>>
		;
		System.out.println(groupMap);
		System.out.println("OTHER =>" + groupMap.get(DishType.OTHER));
		System.out.println("FISH =>" + groupMap.get(DishType.FISH));
		System.out.println("MEAT =>" + groupMap.get(DishType.MEAT));
		
		// map 반복하기
		groupMap.forEach((key, value) -> {
			System.out.println(key + "=".repeat(50));
			value.forEach(System.out::println);
		});
		
	}
	
	public static void printDishNames3() {
		List<Dish> dishes = DishList.makeDishList();
		// 메뉴의 칼로리들을 칼로리 순으로 내림차순 하여 " -> "로 구분해서 출력한다.
		String calories = dishes.stream() // Stream<Dish>
								.sorted((d1, d2) -> d2.getCalories() - d1.getCalories()) // Stream<Dish>
								.map(dish -> dish.getCalories() + "") // String
								.collect(Collectors.joining(" -> ")) // String
		;
		System.out.println(calories);
	}
	
	public static void printDishNames2() {
		List<Dish> dishes = DishList.makeDishList();
		// 메뉴의 이름들을 칼로리 순으로 오름차순 하여 " -> "로 구분해서 출력한다.
		String names = dishes.stream() // Stream<Dish>
							 .sorted((d1, d2) -> d1.getCalories() - d2.getCalories())
							 .map(Dish::getName) // String
							 .collect(Collectors.joining(" -> ")) // String
		;
		System.out.println(names);
	}
	
	public static void printDishNames() {
		List<Dish> dishes = DishList.makeDishList();
		// 메뉴의 이름들을 ", "로 구분해서 출력한다.
		String names = dishes.stream() // Stream<Dish>
							 .map(dish -> dish.getName()) // String
							 .collect(Collectors.joining(", ")) // String
		;
		System.out.println(names);
	}
	
	public static String concatStrings(List<String> strings, String seperator) {
		
		return strings.stream() // Stream<String>
					  .collect(Collectors.joining(seperator)) // String
		;
	}
	
	public static Dish getMinCaloryDish() {
		List<Dish> dishes = DishList.makeDishList();
		
		return dishes.stream() // Stream<Dish>
					 .collect(Collectors.minBy((dish1, dish2) ->
						dish1.getCalories() - dish2.getCalories())) // Optional<Dish>
					 .orElse(null) // Dish
		;
	}
	
	public static Dish getMaxCaloryDish() {
		List<Dish> dishes = DishList.makeDishList();
		
		 return dishes.stream() // Stream<Dish>
					  .collect(Collectors.maxBy((dish1, dish2) -> 
						dish1.getCalories() - dish2.getCalories())) // Optional<Dish>
					  .orElse(null) // Dish
		;
	}
	
	public static List<Integer> getDescendingOrderedList(List<Integer> intList) {
		return intList.stream() // Stream<Integer>
				  .sorted((n1, n2) -> n2 - n1) // Stream<Integer>
				  .collect(Collectors.toList()) // List<Integer>
				;
	}
	
	public static List<Integer> getOrderedList(List<Integer> intList) {
		return intList.stream() // Stream<Integer>
					  .sorted() // Stream<Integer>
					  .collect(Collectors.toList()) // List<Integer>
				;
	}
	
	public static List<Integer> getEvenNumberList(List<Integer> intList) {
		return intList.stream() // Stream<Integer>
					  .filter(num -> num % 2 == 0) // Stream<Integer>
					  .collect(Collectors.toList()) // List<Integer>
				;
	}
	
	public static void main(String[] args) {
		List<Integer> evenList = getEvenNumberList(List.of(1, 2, 3, 4, 5, 6, 7,
													8, 9, 10, 11, 12));
		evenList.forEach(System.out::println);
		System.out.println(evenList);
		
		// 오름차순 정렬된 리스트를 반환
		List<Integer> orderedList = getOrderedList(List.of(4, 3, 7, 1, 8, 23,
													13, 67, 28, -6, 2, -17));
		orderedList.forEach(System.out::println);
		System.out.println(orderedList);
		
		// 내림차순 정렬된 리스트를 반환
		List<Integer> descList = getDescendingOrderedList(List.of(4, 3, 7, 1, 8,
												23, 13, 67, 28, -6, 2, -17));
		descList.forEach(System.out::println);
		System.out.println(descList);
		
		Dish maxDish = getMaxCaloryDish();
		System.out.println(maxDish);
		Dish minDish = getMinCaloryDish();
		System.out.println(minDish);
		
		String result = concatStrings(List.of("A", "B", "C", "D", "E", "F", "G"), ", ");
		System.out.println(result); // A, B, C, D, E, F, G
		
		result = concatStrings(List.of("A", "B", "C", "D", "E", "F", "G"), "");
		System.out.println(result); // ABCDEFG
		
		printDishNames();
		printDishNames2();
		printDishNames3();
		printDishTypeGroups();
		printFoodTypeGroups();
		printCaloryGroups();
	}
}
