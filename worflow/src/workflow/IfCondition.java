package workflow;

public class IfCondition {
	
	public static void main(String[] args) {
		
		int num1 = 30;
		int num2 = 23;
		
		// num1과 num2 중에 큰 수를 출력해라.
		
		// num1이 num2 보다 크다면 num1 출력
		if (num1 > num2) {
			System.out.println(num1);
		}
		// num2가 num1 보다 크다면 num2 출력
		else if (num1 < num2) {
			System.out.println(num2);
		}
		// num1과 num2가 같다면 "같다" 출력
		else {
			System.out.println("같다");
		}
		
	}
}
