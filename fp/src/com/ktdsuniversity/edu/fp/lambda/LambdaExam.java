package com.ktdsuniversity.edu.fp.lambda;

public class LambdaExam {

	public static void main(String[] args) {
		
		// 람다 함수를 사용하려면
		// 조건 1. 반드시 인터페이스가 필요하다.
		// 조건 2. 추상 메소드가 반드시 1개만 있어야 한다.
		
		// 덧셈하는 익명클래스 만들기
		Computable addComputer = new Computable() {
			@Override
			public int compute(int number1, int number2) {
				return number1 + number2;
			}
		};
		System.out.println(addComputer); // com.ktdsuniversity.edu.fp.lambda.LambdaExam$1@1f32e575
		int addResult = addComputer.compute(10, 40);
		System.out.println(addResult); // 50
		
		
		
		// 추상메소드가 한 개만 있는 Computable 인터페이스를 이용해 함수 만들기
		Computable mutiplicateComputer = (int number1, int number2) -> {
			return number1 * number2;
		};
		System.out.println(mutiplicateComputer); // com.ktdsuniversity.edu.fp.lambda.LambdaExam$$Lambda/0x000001fb91000400@65b54208
		int mulResult = mutiplicateComputer.compute(3, 8);
		System.out.println(mulResult); // 24
		
		// Computable 인터페이스를 이용해 두 개의 숫자를 뺄셈한 결과를 반환시키는 함수 만들기
		Computable subtractComputer = (int number1, int number2) -> {
			return number1 - number2;
		};
		int subtractResult = subtractComputer.compute(17, 13);
		System.out.println(subtractResult); // 4
		
		// Computable 인터페이스를 이용해 두 개의 숫자를 나눗셈한 몫을 반환시키는 함수 만들기
		Computable divideComputer = (int number1, int number2) -> {
			return number1 / number2;
		};
		int divideResult = divideComputer.compute(56, subtractResult);
		System.out.println(divideResult); // 14
		
		// Computable 인터페이스를 이용해 두 개의 숫자를 나눗셈한 나머지를 반환시키는 함수 만들기
								// 파라미터 타입을 명시하지 않아도 됨.
								// 값을 반환 시키는 타입은 return + 중괄호도 생략 가능
		Computable modComputer = (number1, number2) -> number1 % number2;
		
		int modResult = modComputer.compute(mulResult, divideResult);
		System.out.println(modResult); // 10
		
	}
}
