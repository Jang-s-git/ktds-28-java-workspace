package com.ktdsuniversity.edu.oop.vendingmachine;

import java.util.Scanner;

import com.ktdsuniversity.edu.oop.exam.Car;

public class Test {

	public static void main(String[] args) {
		String name = "Abcdef";
		double rnd= Math.random();
		// -> String이나 Math 같은 java.lang에 포함된 클래스들은 import 하지 않아도 사용 가능
		
		Car testCar = new Car(10);
		testCar.pressEngineStartButton();
//		System.out.println(testCar.zero100Seconds); => "접근제어지시자"
		
		Scanner keyboard = new Scanner(System.in);
	}
}
