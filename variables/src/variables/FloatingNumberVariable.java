package variables;

public class FloatingNumberVariable {

	public static void main(String[] args) {
		// 실수 (float, double)
		float floatNumber1 = 3.0f; // float 타입은 literal f 또는 F 필요
		float floatNumber2 = 3;
		float floatNumber3 = 3.123456789012345678F;

		System.out.println(floatNumber1); // 3.0
		System.out.println(floatNumber2); // 3.0 (정수를 넣어도 실수로 출력)
		System.out.println(floatNumber3); // 3.1234567 (소수점 이하 7자리까지 출력)
		
		double doubleNumber = 3.123456789012345678;
		System.out.println(doubleNumber); // 3.1234567890123457 (소수점 이하 17자리까지 출력)
	}

}
