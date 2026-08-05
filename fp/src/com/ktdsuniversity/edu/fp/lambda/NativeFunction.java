package com.ktdsuniversity.edu.fp.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.ktdsuniversity.edu.fp.objects.enums.DishType;
import com.ktdsuniversity.edu.fp.objects.enums.FoodType;

public class NativeFunction {

	public static void main(String[] args) {
		
		// Predicate<T> => T를 받아서 boolean을 반환시킨다
		Predicate<String> isEmpty = (str) -> str == null || str.isBlank();
		System.out.println(isEmpty.test(null));
		System.out.println(isEmpty.test("   "));
		System.out.println(isEmpty.test("adgdfs"));
		
		// Consumer<T> => T를 받아서 void를 반환시킨다
		Consumer<String> print = (str) -> System.out.println(str);
		// --> Consumer가 반환시키는 타입과 결과를 반환시키는 타입이 void로 같으면 중괄호를 생략 가능하다
		// --> Consumer => void 반환, println => void 반환
		print.accept(null);
		print.accept("answk");
		
		// Function<T, R> => T를 받아서 R을 반환시킨다
		// String을 파라미터로 전달해서 문자열의 길이를 반환시키는 함수
		Function<String, Integer> getLength = (str) -> str.length();
		int len = getLength.apply("fjsdfofokfjskgosaldf");
		System.out.println(len);
		
		// String을 파라미터로 전달해서 숫자로 변경해주는 함수
		Function<String, Integer> getInt = (str) -> Integer.parseInt(str);
		int i = getInt.apply("1234");
		System.out.println(i);
		
		// Integer를 파라미터로 전달해서 문자로 변경해주는 함수
		Function<Integer, String> getStr = (intVal) -> intVal + "";
		String s = getStr.apply(43);
		System.out.println(s);
		
		// Integer를 파라미터로 전달해서 2의 배수만 true로 반환시켜주는 함수
		Function<Integer, Boolean> isEven = (intVal) -> intVal % 2 == 0;
		boolean result = isEven.apply(34);
		System.out.println(result);
		
		
		
		DishSummary summary = new DishSummary();
		summary.printAllDishesBy((dish) -> dish.getDishType() == DishType.MEAT);
		System.out.println();
		summary.printAllDishesBy((dish) -> true);
		summary.printAllDishesBy((dish) -> false);
		System.out.println();
		summary.printAllDishesBy((dish) -> dish.getFoodType() == FoodType.VEGETABLES);
		System.out.println();
		
	}
}
