package workflow;

public class CU {
	
	public static int pointPay(int point, int amount) {
		// TODO 포인트 선결제 기능을 하는 메소드 작성
		// TODO amount = 포인트 선결제 후 잔여 결제 금액을 반환
		System.out.println("포인트를 사용합니다.");
		if (point >= amount) {
			point -= amount;
			System.out.println("잔여 포인트: "+ point);
			amount = 0;
		} else {
			System.out.println("사용한 포인트: "+ point);
			amount -= point;
			point = 0;
			System.out.println("남은 결제금액: "+ amount + "원");
		}
		return amount;
	}
	
	public static int checkPay(int remainAccount, int amount) {
		// TODO 현금결제 기능을 하는 메소드 작성
		// TODO amount = 현금 결제 후 잔여 결제 금액을 반환
		System.out.println("체크카드로 결제합니다.");
		
		if (remainAccount >= amount) {
			remainAccount -= amount;
			System.out.println("남은 체크카드 잔액: "+ remainAccount + "원");
			amount = 0;
		} else {
			System.out.println("체크카드 잔액이 부족합니다.");
		}
		
		return amount;
	}
	
	public static int creditPay(int amount, int cardPaidMoney, int CARD_LIMIT) {
		// TODO 신용카드 결제 기능을 하는 메소드 작성
		// TODO amount = 신용카드 결제 후 잔여 결제 금액을 반환
		System.out.println("신용카드로 결제합니다.");
		
		int cardMoney = (CARD_LIMIT - cardPaidMoney);
		if (amount >= 50000) {
			System.out.println("서명을 해주세요.");
			
			int monthlyOrSum = (int) (Math.random() * 2);
			
			int monthly = 0;
			if (monthlyOrSum == 0) {
				monthly = (int) (Math.random() * 10) + 2;
				amount = amount / monthly;
				System.out.println("할부 개월 수: "+ monthly + "개월");
				System.out.println("할부 적용 금액: "+ amount + "원");
				
				cardPaidMoney += amount;
				cardMoney = (CARD_LIMIT - cardPaidMoney);
				if (cardMoney <= amount) {
					System.out.println("한도가 초과되었습니다.");
				} else {
					System.out.println("남은 신용카드 한도: " + cardMoney + "원");
					amount = 0;
				}
			} else {
				monthly = 1;
				amount = amount / monthly;
				System.out.println("일시불 금액: "+amount);
				
				cardPaidMoney += amount;
				cardMoney = (CARD_LIMIT - cardPaidMoney);
				
				if (cardMoney <= amount) {
					System.out.println("한도가 초과되었습니다.");
				} else {
					cardMoney = (CARD_LIMIT - cardPaidMoney);
					System.out.println("남은 신용카드 한도: "+ cardMoney + "원");
					amount = 0;
				}
			}
		} else {
			cardPaidMoney += amount;
			cardMoney = (CARD_LIMIT - cardPaidMoney);
			if (cardMoney <= amount) {
				System.out.println("한도가 초과되었습니다.");
			} else {
				System.out.println("남은 신용카드 한도: "+ cardMoney + "원");
				amount = 0;
			}
		}
		
		return amount;
	}
	
	public static int cashPay(int cash, int amount) {
		// TODO 현금결제 기능을 하는 메소드 작성
		// TODO amount = 현금 결제 후 잔여 결제 금액을 반환
		System.out.println("현금으로 결제합니다.");
		
		if (cash >= amount) {
			cash -= amount;
			System.out.println("남은 현금 잔액: "+ cash + "원");
			amount = 0;
		} else {
			System.out.println("현금 잔액이 부족합니다.");
		}
		
		return amount;
	}

	public static int pay(int amount, int cash, int CARD_LIMIT,
							int cardPaidMoney, int remainAccount, 
							int point, int addPoint) {
		while (amount > 0) {
			
			// 결제 수단 선택 (0 ==> 현금, 1 ==> 신용카드, 2 ==> 체크카드, 
			//				3 ==> 포인트 선결제, 4 ==> 포기)
			int payment =(int) (Math.random() * 5);
			
			// TODO 현금으로 결제했을 때 보유한 현금을 최종 결제 금액 만큼 차감
			if (payment == 0) {
				amount = cashPay(cash, amount);
			}

			// TODO 신용카드 & 결제금액 5만원 이상일 경우 할부(0) 또는 일시불(1) 선택
			else if (payment == 1) {
				amount = creditPay(amount, cardPaidMoney, CARD_LIMIT);
			}
			
			// TODO 체크카드로 결제했을 때 카드 결제 금액을 최종 금액 만큼 차감
			else if (payment == 2) {
				amount = checkPay(remainAccount, amount);
			}
			
			// TODO 포인트로 선결제했을 때 포인트를 최종 금액 만큼 차감
			else if (payment == 3) {
				amount = pointPay(point, amount);
			}
			
			// TODO 계산을 하지 않고 나갈 경우
			else if (payment == 4) {
				System.out.println("결제를 포기합니다.");
				
				if (addPoint == 0) {
					System.out.println("포인트 적립 취소");
					
					point -= (int)(amount * 0.1f);
				}
				System.out.println("현재 포인트: "+ point);
				
				amount = 0;
			}
			
			// 잔여 결제 금액
			return amount;
		}
		return amount;
	}
	public static int calculateEarnPoints(int amount) {
		return (int)(amount * 0.1f);
	}
	public static int buyItems(int[] items, float[] dc) {
		int amount = 0;
		for (int i = 0; i < 5; i++) {
			float dcPrice = 0;
			dcPrice = (items[i] * dc[i]);
			amount += (int) (items[i] - dcPrice);
		}
		return amount;
	}
	
	public static int buyPlasticBag(int[] items, int SPLIT_COUNT,
									int BAG_PRICE) {
		int bagCount = items.length / SPLIT_COUNT;
		if (items.length % SPLIT_COUNT > 0) {
			bagCount++;
		}
		System.out.println("봉투 " + bagCount + "개 구매");
		System.out.println("봉투가격: " + bagCount * BAG_PRICE + "원");
		
		return bagCount * BAG_PRICE;
	}
	
	public static void main(String[] args) {
		// 편의점.drawio 파일을 토대로 작성한 코드
		
		// 시작
		// 손님이 바구니에 담아온 상품의 가격 정보. -> 배열
		int[] items = new int[5];
		items[0] = 5000;
		items[1] = 1800;
		items[2] = 3200;
		items[3] = 30000;
		items[4] = 1300;
		
		// 손님이 바구니에 담아온 상품의 할인 정보.
		float[] dc = new float[5];
		dc[0] = 0; // 할인 x
		dc[1] = 0.1f; // 10% 할인
		dc[2] = 0.2f; // 20% 할인
		dc[3] = 1f; // 100% 할인
		dc[4] = 0; // 할인 x
		
		// 봉투 가격
		final int BAG_PRICE = 100;
		
		// 한 봉투에 넣을 수 있는 상품의 수
		final int SPLIT_COUNT = 2;
		
		// 고객의 자금 상황
		final int CARD_LIMIT = 1_000_000;
		
		// 현재까지 사용한 카드 결제 금액
		int cardPaidMoney = 150000;
		
		// 체크 카드 계좌 잔액
		int remainAccount = 4000;
		
		// 보유한 현금
		int cash = 30000;
		
		// 보유한 포인트
		int point = 1750;
		
		// 최종 결제 금액
		int amount = 0;
		
		// 봉투 필요여부(필요 == 0, 불필요 == 1)
		int needBag = (int) (Math.random() * 2);
		if (needBag == 0) {
			amount += buyPlasticBag(items, SPLIT_COUNT, BAG_PRICE);
		}
		
		// TODO 손님이 가져온 상품 목록의 결제 금액 계산해서 amount에 할당
		// 할인율 계산 필요
		amount += buyItems(items, dc);
		
		System.out.println("총 금액: "+ amount + "원");

		// 포인트 적립 (0 ==> 적립, 1 ==> 적립X)
		int addPoint = (int) (Math.random() * 2);
		
		// TODO 적립을 할 경우 (addPoint == 0)이라면 총 결제 금액에서 10% 적립
		if (addPoint == 0) {
			point += calculateEarnPoints(amount);
			System.out.println("적립된 포인트: "+ (int)(amount * 0.1f));
		}
		System.out.println("현재 포인트: "+ point);
		
		while (amount > 0) {
			
			amount = pay (amount, cash, CARD_LIMIT, cardPaidMoney,
					remainAccount, point, addPoint);
					
		}
		
		// 메소드에서 값이 변경되어도 반환하지 않으면 메인에 반영되지 X
		System.out.println(point);
		System.out.println(cardPaidMoney);
	}
}
