package workflow;

public class MethodProblem {
	
	// 정수 두 개를 받아서 사칙연산의 결과를 출력하는 메소드 호출
	public static void calculation(int a, int b) {
		System.out.println(a + " + " + b + " = " + (a+b));
		System.out.println(a + " - " + b + " = " + (a-b));
		System.out.println(a + " x " + b + " = " + (a*b));
		System.out.println(a + " / " + b + " = " + (a/b));
	}
	
	// 정수 한 개 받아서 짝수라면 true, 홀수라면 false 호출
	public static void evenAndOdd(int a) {
		if (a % 2 == 0) {
			System.out.println(a + "은/는 짝수");
		} else {
			System.out.println(a + "은/는 홀수");
		}
	}
	
	// 정수 세 개 받아서 가장 큰 수 출력하는 메소드
	public static void maxNum(int a, int b, int c) {
		if (a > b && a > c) {
			System.out.println(a);
		} else if (a < b && b > c) {
			System.out.println(b);
		} else {
			System.out.println(c);
		}
	}
	
	// 정수 한 개 받아서 소수라면 true, 아니라면 false 호출
	public static boolean minority(int m) {
		boolean isMinority = true;
		for (int i = 2; i < m; i++) {
			if (m % i == 0) {
				isMinority = false;
				break;
			} else {
				isMinority = true;
			}
		}
		return isMinority;
	}
	
	public static void main(String[] args) {
		// 1
		calculation(4,5);
		
		// 2
		evenAndOdd(19);
		
		// 3
		maxNum(14,17,34);
		maxNum(54,17,34);
		maxNum(14,67,34);
		
		// 4
		boolean isMinority = minority(15);
		System.out.println(isMinority);
		isMinority = minority(16);
		System.out.println(isMinority);
		isMinority = minority(17);
		System.out.println(isMinority);
		
	}

}
