package com.ktdsuniversity.edu.oop.exam;

public class ArrayExam {

	public static void printArraysValue(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(i+"번째 인덱스의 값: "+ numbers[i]);
		}
	}
	public static void main(String[] args) {
		
		// 배열을 정의하고 생성하는 3가지 방법
		//1. 자료형[] 배열이름 = new 자료형[배열길이];
		int[] nums = new int[3];
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		// 2. 자료형[] 배열이름 = new 자료형[] {각 인덱스에 들어갈 값들}
		//						0	1	2	3	4	5	6	7번 인덱스
		int[] num2 = new int[] {50, 30, 60, 10, 20, 55, 7, 88};
		System.out.println(num2.length); // 8
		
		// 3. 자료형[] 배열이름 = {각 인덱스에 들어갈 값들)
		// 사용 조건이 제한적임. -> (임시변수, 파라미터한테는 쓸 수 없음(지역변수 가능))
		//				0	1	2	  3	   4	5	6	7
		int[] num3 = {100, 200, 300, 500, 250, 700, 10, 20};
		System.out.println(num3.length); // 8
		
		
		// 1. OK
		printArraysValue(new int[3]);
		// 2. OK
		printArraysValue(new int[] {1, 2, 3, 4, 5});
		// 3. X -> (임시변수, 파라미터한테는 쓸 수 없음(지역변수 가능))
//		printArraysValue({1, 2, 3, 4, 5});
		
	}
}
