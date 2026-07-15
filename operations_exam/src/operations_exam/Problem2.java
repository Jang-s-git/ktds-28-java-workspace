package operations_exam;

public class Problem2 {

	public static void main(String[] args) {
		int n = 64; // 먹은 양꼬치의 개수
		int k = 6; // 먹은 음료수의 개수(서비스 포함)
				
		final int MEAL = 12000; // 양꼬치 가격(고정)
		final int DRINK = 2000; // 음료수 가격(고정)
		
		if (0 > n || n > 1000) {
			System.out.println("올바른 개수를 입력하세요");
		} else {
			if (0 > k || k > 1000) {
				System.out.println("올바른 개수를 입력하세요");
			} else {
				// 양꼬치를 10인분 먹을 때마다 음료수 하나가 서비스
				int k1 = n/10; // 서비스로 나온 음료수의 개수
				
				int totalFee = n * MEAL + k * DRINK - k1 * DRINK; // 총 금액
				System.out.println(totalFee  + "원");
			}
		}
	}
}
