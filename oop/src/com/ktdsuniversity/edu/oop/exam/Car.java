package com.ktdsuniversity.edu.oop.exam;

public class Car {

	// 멤버변수
	// 클래스의 인스턴스가 독립적으로 가지고 있는 정보들
	boolean isEngineStart;
	int speed;
	public int zero100Seconds;
	
	public Car(int zero100Seconds){
		this.zero100Seconds = zero100Seconds;
		System.out.println("생성자 호출되었습니다.");
		System.out.println(this);
		this.pressEngineStartButton();
	}
	
	// 인스턴스 메소드 (이하 메소드) 정의
	// 엔진 켜고 끄기
	public void pressEngineStartButton() {
		// 이 메소드를 호출하는 인스턴스의 isEngineStart가 false => true, true => false
		
		// isEngineStart = !isEngineStart;
		
		if (isEngineStart) {
			// 시동이 켜져있다면 끈다
			isEngineStart = false;
			speed = 0;
		} else {
			// 시동이 꺼져있다면 켠다
			isEngineStart = true;
			speed = 10;
		}
	}
	
	// 가속페달을 밟는다
	// 페달을 밟는 압력만큼 속도 증가
	public void pressGasolinPedal(int pressure) {
		if (isEngineStart) {
			speed += pressure;
		} 
	}
	
	// 브레이크 페달을 밟는다
	// 페달을 밟는 압력만큼 속도 감소
	public void pressBrakePedal(int pressure) {
		if (isEngineStart) {
			speed -= pressure;
		}
	}
	
	// 부모 클래스에 있는 toString이라는 클래스를 오버라이딩 했다
	@Override 
	public String toString() {
		// 출력의 형태를 정의
		return this.zero100Seconds + "";
	}
	
	public static void main(String[] args){
		
		// Car 클래스를 이용해 다음을 생성
		// Car 타입의 kona 인스턴스 생성
		Car kona = new Car(8);
		
		// Car 타입의 carnival 인스턴스 생성
		Car carnival = new Car(6);
		
		System.out.println(kona); // Type@HashData => 8
		System.out.println(carnival); // Type@HashData => 6
		
		String name = "asdfgqwert"; // name은 변수가 아닌 인스턴스
		System.out.println(name); // asdfgqwert
		// -> System은 클래스.(final, 상속 불가)
		// -> out은 인스턴스. System 클래스/PrintStream 클래스
		// -> println => 껍데기는 Object로 받아서 실제로 들어가는 데이터 확인
		//			  => null 또는 toString으로 반환
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("asdfgqwert");
		System.out.println(buffer); // asdfgqwert
		// => toStingCache를 통해 String으로 반환
		
		// kona의 시동을 켠다
		kona.pressEngineStartButton();
		
		// 브레이크 페달을 몇 차례 밟는다
		kona.pressBrakePedal(3);
		kona.pressBrakePedal(3);
		
		// 가속 페달을 3회 강하게 밟는다
		kona.pressGasolinPedal(150);
		kona.pressGasolinPedal(150);
		kona.pressGasolinPedal(150);

		// 브레이크 페달을 아주 강하게 밟는다
		kona.pressBrakePedal(300);
		
		// kona의 시동을 끈다
		kona.pressEngineStartButton();		
		
		carnival.pressEngineStartButton();
		carnival.pressGasolinPedal(120);
		carnival.pressBrakePedal(20);
		carnival.pressGasolinPedal(110);
		carnival.pressBrakePedal(300);
		carnival.pressEngineStartButton();
		
		// 인스턴스는 자신의 멤버변수의 값을 할당하거나 출력할 수 있음
//		kona.isEngineStart = true;
//		kona.speed= 100;
//		carnival.isEngineStart = false;
//		carnival.speed = 70;
		
		System.out.println(kona.isEngineStart);
		System.out.println(kona.speed);
		System.out.println(carnival.isEngineStart);
		System.out.println(carnival.speed);
		
	}
	
}
