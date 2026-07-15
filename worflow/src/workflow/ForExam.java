package workflow;

public class ForExam {
	
	public static void main(String[] args) {

		// 구구단
		for (int i = 2; i<10; i++) { // i의 범위는 2부터 9까지
			for (int j = 1; j<10; j++) { // j의 범위는 1부터 9까지
				System.out.println(i + " x " + j + " = " + i*j);
			}
		}
		
		// 1부터 100까지의 합
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
		
		// 1부터 100 중 홀수의 합
		int sum1 = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 1) {
				sum1 = sum1 + i;
			}
		}
		System.out.println(sum1);
		
		// 1부터 100 중 3, 5, 6의 배수만 출력
		for (int i = 1; i<=100; i++) {
			if (i % 3 == 0 || i % 5 == 0 || i % 6 == 0) {
				System.out.println(i);
			}
		}
		
		//
		for (int i = 1; i <= 5; i++) {
			for (int j = 2; j <= i; j++) {
				System.out.printf("*");
			}
			System.out.println("*");
		}
	}
}
