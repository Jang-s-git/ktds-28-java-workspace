package workflow;

public class ConvStore {

	public static void main(String[] args) {
		// A편의점은 한 종류의 음료수만 판매합니다.
		// 음료수 하나의 가격은 3000원 입니다. <-- 상수
		final int PRICE_A = 3000;
		
		// 손님이 가지고 있는 돈, 구매개수 => 변수
		// 5000원을 가지고 있는 손님이 음료수를 3개 구매하려 합니다.
		int moneyA = 5000;
		int buyPriceA = PRICE_A * 3;
		
		// 구매할 수 있다면 음료수 가격 X 구매개수를 출력하고,
		if (moneyA >= buyPriceA) {
			System.out.println(buyPriceA);
		}
		// 구매할 수 없다면 "금액이 부족합니다."를 출력한다.
		else {
			System.out.println("금액이 부족합니다.");
		}
		
		
		// B편의점은 한 종류의 음료수만 판매합니다.
		// 총 5개의 음료수가 있으며 음료수 하나의 가격은 4500원 입니다. <-- 상수
		final int PRICE_B = 4500;
		final int STOCK = 5;
		
		// 30000원을 가지고 있는 손님이 음료수를 n개 구매하려합니다.
		int moneyB = 30000;
		int n = 3;
		int buyPriceB = PRICE_B * n;
		
		// 만약, 손님이 음료수를 5개 이하를 구매할 수 있으면(금액이 충분하면) 음료수 가격 * 구매개수 를 출력합니다.
		if (n <= STOCK && moneyB >= buyPriceB) {
			System.out.println(buyPriceB);
		}
		//	그러나 5개 이하를 구매할 수 없으면(금액이 충분하지 않으면) "잔액이 부족합니다."를 출력합니다.
		else if (n <= STOCK && moneyB < buyPriceB) {
			System.out.println("금액이 부족합니다.");
		}
		// 만약, 손님이 음료수 6개를 구매하려 한다면 "재고가 충분하지 않습니다."를 출력합니다.
		else if (n > STOCK) {
			System.out.println("재고가 충분하지 않습니다.");
		}
		
	}
}
