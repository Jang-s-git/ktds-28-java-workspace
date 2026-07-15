package workflow;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		
		// 키보드에서 값을 받아올 수 있는 변수 하나를 생성한다.
		Scanner keyboard = new Scanner(System.in);
		
		// "업 다운 게임 시작" 출력
		System.out.println("업 다운 게임 시작");
		
		// 0 ~ 99 사이의 숫자를 임의로 생성
		double randomNumber = Math.random();
		int goal = (int) (randomNumber * 100);
		
		int value = -1;
		// 정답이 입력 될 때까지 무한반복
		while (goal != value) {
			// 사용자로부터 값을 입력 받는다
			System.out.println("숫자를 입력하세요:");
			value = keyboard.nextInt();
			System.out.println(value);
			
			// 임의의 숫자 = 사용자 입력 값 -> "정답" 출력
			if (goal == value) {
				System.out.println("정답");
//				break; // 코드 실행 중단
			}
			
			// 임의의 숫자 > 사용자 입력 값 -> "UP! 출력
			else if (goal > value) {
				System.out.println("UP!");
			}
			
			// 임의의 숫자 < 사용자 입력 값 -> "DOWN!" 출력
			else {
				System.out.println("DOWN!");
			}
		}
	}
}
