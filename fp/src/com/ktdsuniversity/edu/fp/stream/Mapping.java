package com.ktdsuniversity.edu.fp.stream;

import java.util.List;
import java.util.Scanner;

import com.ktdsuniversity.edu.fp.objects.Dish;
import com.ktdsuniversity.edu.fp.objects.DishList;
import com.ktdsuniversity.edu.fp.objects.enums.DishType;

/**
 * 스트림의 데이터를 변경시키는 Map 실습
 */
public class Mapping {

	public static void compareString() {
		//	  변수	상수
		String a = "이름";
		String b = "이름";
		
		System.out.println(a == b); // true
		
		
		Scanner key = new Scanner(System.in);
		//	  변수	변수
		String c = key.nextLine(); // 이름
		String d = key.nextLine(); // 이름
		
		System.out.println(c == d); // false
	}
	
	public static void printDishesUniqueFoodType() {
		// DishList에 있는 FoodType을 중복없이 출력한다.
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
			  .map(dish -> dish.getFoodType()) // Stream<FoodType>
//			  .map(Dish::getFoodType)
			  .distinct() // Stream<FoodType>
			  .forEach(System.out::println); // void
		;
	}
	
	public static void printFishDishesName() {
		List<Dish> dishes = DishList.makeDishList();
		dishes.stream() // Stream<Dish>
			  .filter(dish -> dish.getDishType() == DishType.FISH) // Stream<Dish>
			  .map(dish -> dish.getName()) // Stream<String>
			  .forEach(System.out::println); // void
		;
	}
	
	public static void printMultipleThreeNumbers() {
		List<String> strings = List.of("1", "2", "A", "3", "99", "ABC", "100",
				"-999", "16374298103974361984");
		// 숫자 형태의 문자들을 숫자로 변경하고 3의 배수만 골라서 출력한다.
		strings.stream() // Stream<String>
			   .filter(Mapping::isIntFormat) // Stream<String>
			   .map(str -> Integer.parseInt(str))
			   .filter(str -> str % 3 == 0)
			   .forEach(System.out::println);
		;
	}
	
	public static void printStringToNumber2() {
		// 모든 문자열들을 숫자로 변경해서 출력한다.
		List<String> strings = List.of("1", "2", "A", "3", "99", "ABC", "100",
										"-999", "16374298103974361984");
		// 숫자 형태의 문자들만 숫자로 변경해서 출력한다.
		strings.stream() // Stream<String>
			   .filter((str) -> str.matches("^-{0,1}[0-9]+$")) // Stream<String>
			   .filter(Mapping::isIntFormat)
			   .map((str) -> Integer.parseInt(str)) // Stream<R> --> Stream<Integer>
			   .forEach(System.out::println); // void
		;
	}
	
	public static boolean isIntFormat(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	
	public static void printStringToNumber() {
		// 모든 문자열들을 숫자로 변경해서 출력한다.
		List<String> strings = List.of("1234", "12345", "22322", "1111", "54555", "456456", "78987");
		strings.stream() // Stream<String>
			   .map((str) -> Integer.parseInt(str)) // Stream<R> --> Stream<Integer>
			   .forEach(System.out::println); // void
		;
	}
	
	public static void printOddToEven() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(numbers);
		// 모든 숫자들에게 2를 곱해서 짝수로 만들어 출력한다.
		numbers.stream() // Stream<Integer>
			   .map((n) -> n * 2) // Stream<R> --> Stream<Integer>
			   .forEach(System.out::println); // void
		;
	}
	
	public static void main(String[] args) {
		printDishesUniqueFoodType();
		System.out.println("=".repeat(10));
		printFishDishesName();
		System.out.println("=".repeat(10));
		printMultipleThreeNumbers();
		System.out.println("=".repeat(10));
		printStringToNumber2();
		System.out.println("=".repeat(10));
		printStringToNumber();
		printOddToEven();
		
		compareString();
	}
	
}
