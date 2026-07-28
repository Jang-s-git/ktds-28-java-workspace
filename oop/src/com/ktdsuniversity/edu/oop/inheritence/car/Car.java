package com.ktdsuniversity.edu.oop.inheritence.car;

public class Car {

	public static void startEngine(Vehicle car) {
		car.startEngine();
	}
	
	public static void startTurboEngine(Vehicle car) {
		if (car instanceof SportsCar sportsCar) {
			sportsCar.startTurboEngine();
		}
	}
	
	public static void batteryCheck(Vehicle car) {
		// Vehicle로 받아온 car가 인스턴스 타입 Ev를 가지고 있다면
		// car를 ev로 형변환 시켜라
		if (car instanceof Ev ev) {
			ev.batteryCheck();
		}
	}
	
	public static void ejectBatPod(Vehicle car) {
		// car로 전달된 인스턴스 타입이 BatMobile 이라면
		// ejectBatPod을 실행시켜라
		if (car instanceof BatMobile batMobile) {
			batMobile.ejectBatPod();
		}
	}
	
	public static void main(String[] args) {
		
		// 자식 클래스의 인스턴스가 부모에게 할당되는 것을 허가한다 - 다형성
		Vehicle[] vehicles = new Vehicle[5];
		vehicles[0] = new Vehicle("클래식카");
		vehicles[1] = new SportsCar("스포츠카1");
		vehicles[2] = new Ev("전기차2", 50f);
		vehicles[3] = new BatMobile("배트모빌1");
		vehicles[4] = new BatMobile("배트모빌2");
		
		for (int i = 0; i < vehicles.length; i++) {
			startEngine(vehicles[i]);
			startTurboEngine(vehicles[i]);
			batteryCheck(vehicles[i]);
			ejectBatPod(vehicles[i]);
		}
		
//		Vehicle classicCar = new Vehicle("클래식카");
//		
//		Vehicle sportsCar1 = new SportsCar("스포츠카1");
//		SportsCar sportsCar2 = new SportsCar("스포츠카2");
//		
//		Vehicle ev1 = new Ev("전기차1");
//		Ev ev2 = new Ev("전기차2", 50f);
//		
//		Vehicle batMobileCar1 = new BatMobile("배트모빌1");
//		SportsCar batMobileCar2 = new BatMobile("배트모빌2");
//		BatMobile batMobileCar3 = new BatMobile("배트모빌3");
//		
//		startEngine(classicCar);
//		startEngine(sportsCar1);
//		startEngine(sportsCar2);
//		startEngine(ev1);
//		startEngine(ev2);
//		startEngine(batMobileCar1);
//		startEngine(batMobileCar2);
//		startEngine(batMobileCar3);
//		
//		System.out.println();
//		
//		batteryCheck(ev1);
//		batteryCheck(ev2);
//		
//		System.out.println();
//		
//		startTurboEngine(sportsCar1);
//		startTurboEngine(sportsCar2);
//		
//		System.out.println();
//		
//		ejectBatPod(batMobileCar1);
//		ejectBatPod(batMobileCar2);
//		ejectBatPod(batMobileCar3);
		
	}
}
