package operations;

public class Operations {

	public static void main(String[] args) {
		
		// 정수 변수 두 개 만들어서 다른 정수 변수에 연산의 결과를 저장한 후 출력
		int firstNumber = 10;
		int secondNumber = 30;
		
		// firstNumber + secondNumber
		int addResult = firstNumber + secondNumber;
		System.out.println(addResult); // 40
		
		// firstNumber - secondNumber
		int subResult = firstNumber - secondNumber;
		System.out.println(subResult); //-20
		
		// firstNumber * secondNumber
		int mulResult = firstNumber * secondNumber;
		System.out.println(mulResult); // 300

		// firstNumber / secondNumber
		int divResult = firstNumber / secondNumber;
		System.out.println(divResult); // 0
		
		float firstFloatNumber = 10.5f;
		float secondFloatNumber = 3.55f;
		float divFloatResult = firstFloatNumber / secondFloatNumber;
		System.out.println(divFloatResult); // 2.9577465
		
		firstNumber = 50;
		// firstNumber / secondNumber
		int divResult2 = firstNumber / secondNumber;
		System.out.println(divResult2); // 1 (몫)
		
		// firstNumber % secondNumber
		int modResult = firstNumber % secondNumber;
		System.out.println(modResult); // 20 (나머지)
		
		int kor = 80;
		int eng = 90;
		int math = 93;
		
		final float SUBJECT_COUNT = 3f;
		
		float avg2 = (kor + math + eng) / SUBJECT_COUNT;
		System.out.println(avg2); // 87.666664
		
		int maxIntValue = Integer.MAX_VALUE; // 2147483647
		int minIntValue = Integer.MIN_VALUE; // -2147483648
		
		maxIntValue++;
		minIntValue--;
		
		maxIntValue = maxIntValue + 1; // -2147483648, 정수 오버플로우
		minIntValue = minIntValue - 1; // 2147483647, 정수 언더플로우
		
		System.out.println(maxIntValue);
		System.out.println(minIntValue);
		
		int bigNumber = 1_000_000_000;
		int powerResult = bigNumber * bigNumber;
		System.out.println(powerResult); // -1486618624
		
		// 나누기의 나머지를 구한다
		int num1 = 10;
		int num2 = 3;
		
		int mod = num1 % num2;
		System.out.println(mod);
		
		int num = 10;
		System.out.println(num++); // 10
		System.out.println(++num); // 12
		System.out.println(num--); // 12
		System.out.println(--num); // 10

		int num3 = 3;
		int num4 = 5;
		
		int operResult = num++ + num3 * ++num4; // 10 + 3 * 6
		System.out.println(operResult); // 28
		
	}
}
