package operations_exam;

public class Problem1 {

	public static void main(String[] args) {
		int angle = 91;
		int result = 0;
		
		if (0 < angle && angle < 90) {
			result = 1;
			System.out.println(result + ", 예각");
		} else if (angle == 90) {
			result = 2;
			System.out.println(result + ", 직각");
		} else if (90 < angle && angle < 180) {
			result = 3;
			System.out.println(result + ", 둔각");
		} else if (angle == 180) {
			result = 4;
			System.out.println(result + ", 평각");
		} else {
			System.out.println("올바른 각도를 입력하시오.");
		}
		
		// or
		
		if ( angle == 180 ) {
			result = 4;
			System.out.println(result + ", 평각");
		} else if ( angle > 90 ) {
			result = 3;
			System.out.println(result + ", 둔각");
		} else if ( angle == 90 ) {
			result = 3;
			System.out.println(result + ", 직각");
		} else if ( angle > 0 ) {
			result = 3;
			System.out.println(result + ", 예각");
		} else {
			System.out.println("올바른 각도를 입력하시오.");
		}
	}
}
