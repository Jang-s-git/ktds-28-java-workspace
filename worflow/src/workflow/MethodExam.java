package workflow;

public class MethodExam {
	
	public static double divideTwoNumbers(int num1, int num2) {
		double divResult = num1 / (double) num2;
		return divResult;
	}
	
	public static void printNameAndAge(String name, int age) {
		System.out.println("이름: "+name+", 나이: "+age);
	}
	
	public static void powerAndPrint(int number) {
		int powerResult = number * number;
		System.out.println(powerResult);
	}
	
	public static void print() {
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		// 단순하게 출력하는 메소드(함수)를 생성하고 호출해본다.
		print();
		print();
		print();
		
		// 파라미터(인자)가 있는 메소드(함수)를 생성하고 호출해본다.
		powerAndPrint(3);
		powerAndPrint(7);
		powerAndPrint(29);
		
		// 파라미터(인자)가 여러 개 있는 메소드(함수)를 생성하고 호출해본다.
		printNameAndAge("장규나",24);
		
		// 반환값(결과)이 있는 메소드(함수)를 생성하고 호출한 뒤 결과를 출력한다.
		double div1 = divideTwoNumbers(189,17);
		double div2 = divideTwoNumbers(20,7);
		System.out.println(div1);
		System.out.println(div2);
		
	}
}
