package method;

public class Method {

	// 1. 정수형 변수 2개를 파라미터로 받아, 값을 출력하는 메소드.
	public static void method1(int a, int b) {
		System.out.println(a + ", "+ b);
	}
	
	// 2. 정수형 변수 2개를 파라미터로 받아, 합계를 출력하는 메소드.
	public static void method2(int a, int b) {
		System.out.println(a + " + " + b + " = " + (a+b));
	}
	
	// 3. 정수형 변수 3개를 파라미터로 받아, 합계를 반환하는 메소드.
	public static void method3(int a, int b, int c) {
		System.out.println(a + " + " + b + " + " + c + " = " + (a+b+c));
	}
	
	// 4. 정수형 변수 2개를 파라미터로 받아, 나누기의 결과(실수)를 출력하는 메소드.
	public static void method4(int a, int b) {
		double c = (double) a / (double) b;
		System.out.println(a + " / " + b + " = " + c);
	}
	
	// 5. 정수형 변수 2개를 파라미터로 받아, 나누기의 결과(실수)를 반환하는 메소드.
	public static double method5(int a, int b) {
		double c = (double) a / (double) b;
		System.out.println(a + " / " + b + " = " + c);
		return c;
	}
	
	// 6. 실수형 변수 1개와 정수형 파라미터 1개를 받아 소수점 이하 자리수를 변경하여 반환하는 메소드.
	//	   -> 예> 소수점 변경(10.33333333, 2) ==> 10.33 
	//	   -> 예> 소수점 변경(10.33333333, 3) ==> 10.333
	//	   -> 예> 소수점 변경(10.33333333, 1) ==> 10.3
	//	   -> 예> 소수점 변경(10.33333333, 0) ==> 10.0
	public static double method6(double a, int b) {
		
		return 0;
	}
	
	// 7. 실수형 변수 2개를 파라미터로 받아, 가장 큰 수만 반환하는 메소드.
	public static double method7(double a, double b) {
		double c;
		if (a>b) {
			c = a;
		} else if (a<b) {
			c = b;
		} else {
			c = a = b;
		}
		
		return c;
	}
	
	// 8. 실수형 변수 4개를 파라미터로 받아, 가장 작은 수만 반환하는 메소드.
	public static double method8(double a, double b, double c, double d) {
		double e;
		if (a<b && a<c && a<d) {
			e = a;
		} else if (b<a && b<c && b<d) {
			e = b;
		} else if (c<a && c<b && c<d) {
			e = c;
		} else if (d<a && d<b && d<c) {
			e = d;
		} else {
			e = a = b = c = d;
		}
		
		return e;
	}
	
	// 9. 정수 배열을 파라미터로 받아, 2,5,8 배수인 숫자만 출력하는 메소드.
	public static void method9(int[] array8) {
		for (int i = 0; i < 100; i++) {
			if (array8[i] % 2 == 0 && array8[i] % 5 == 0 && array8[i] % 8 == 0) {
				
				System.out.print(array8[i]+" ");
			}
		}
		System.out.println();
	}
	
	// 10. 문자열 1개와 정수형 변수 1개를 파라미터로 받아, 문자열을 정수형 변수만큼 반복 출력하는 메소드.
	public static void method10(char a, int b) {
		for (int i = 0; i < b; i++) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	
	// 11. 정수형 변수 1개를 파라미터로 받아, 해당 정수의 구구단을 출력하는 메소드.
	public static void method11(int a) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(a + " X " + i + " = " + a*i);
		}
	}
	
	// 12. 정수형 변수 1개를 파라미터로 받아, 4부터 정수형 변수까지의 범위 중 소수(Prime Number)만 출력하는 메소드.
	public static void method12(int a) {
		for (int i = 4; i <= a; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j != 0) {
					System.out.print(i + " ");
					break;
				}
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		// 1s
		method1(3,7);

		// 2
		method2(3,7);

		// 3
		method3(5,6,17);

		// 4
		method4(189,26);

		// 5
		method5(189,26);
		
		// 6
		method6(3.141592, 2);

		// 7
		double result7 = method7(5.78, 2.467);
		System.out.println(result7);

		// 8
		double result8 = method8(4.465536, 4.3564462, 7.13456, 2.273783);
		System.out.println(result8);

		// 9
		int[] array9 = new int[100];
		for (int i = 0; i < 100; i++) {
			array9[i] = i + 1;
		}
		method9(array9);

		// 10
		method10('A', 5);
		
		// 11
		method11(6);
		
		// 12
		method12(78);

//		13. 정수형 배열 변수 1개와 정수형 변수 1개를 파라미터로 받아, 해당 배열의 정수형변수 인덱스에 의 값을 반환하는 메소드.
//		    -> 예> 값(길이가 5인 배열, 2) ==> 배열의 2번 인덱스의 값
//		    -> 예> 값(길이가 5인 배열, 4) ==> 배열의 4번 인덱스의 값
//		    -> 예> 값(길이가 5인 배열, 5) ==> 0
//		    -> 예> 값(길이가 5인 배열, -1) ==> 0
//		    -> 예> 값(길이가 5인 배열, 1) ==> 배열의 1번 인덱스의 값
//		    -> 예> 값(길이가 5인 배열, 0) ==> 배열의 0번 인덱스의 값
//		    -> 예> 값(길이가 5인 배열, 3) ==> 배열의 3번 인덱스의 값
//		    -> 예> 값(길이가 5인 배열, 7) ==> 0

//		14. 정수형 배열 변수 1개를 파라미터로 받아, 가장 처음 나오는 3의 배수만 반환하는 메소드    - 정수형 배열 변수내부에 3의 배수가 없을 경우 -1 을 반환.

//		15. 정수형 배열 변수 2개를 파라미터로 받아, 각 배열에 중복값만 출력하는 메소드.
//		    -> 중복([1,2,3,4,5], [9,7,454,1,2,3]) ==> 1 2 3
		
//		16. 정수형 배열 변수 2개를 파라미터로 받아, 각 배열에 중복되지 않는 값만 출력하는 메소드.
//	    -> 예> 고유([1,2,3,4,5], [9,7,454,1,2,3]) ==> 4, 5, 9. 7, 454
//	    -> 예> 고유([1,2,3,4,5], [1,2,3,4,5]) ==> ""

		// 17. 정수형 배열 변수 1개를 파라미터로 받아, 모든 값들을 배수로 만드는(반환X) 메소드.
//	    -> 호출 이후에 main 메소드 내부에서 배열 내부의 값들을 모두 출력.
		
		
		
	}
}
