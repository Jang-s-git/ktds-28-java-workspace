package operations_exam;

public class AtrithmaticProblem5 {

	public static void main(String[] args) {
		
		// 3인 가족이 100만원으로 비행기를 타고 편도 여행을 가려합니다.
		int money = 1_000_000;
		
		// 부모님의 나이는 각각 40, 36세입니다.
		// 딸의 나이는 11세입니다.
		int father = 40;
		int mother = 36;
		int daughter = 11;
		
		// 성인의 비행요금은 30만원
		// 아동의 비행요금은 12만원입니다.
		int adultOneWayFlightFare = 300_000;
		int kidOneWayFlightFare = 120_000;
		
		// 성인 판단 기준은 19세 이상입니다.
		final int AGE = 19;
		int adult = 0;
		int kid = 0;
		
		if (father >= AGE) {
			adult++;
		} else {
			kid++;
		}
		
		if (mother >= AGE) {
			adult++;
		} else {
			kid++;
		}
		
		if (daughter >= AGE) {
			adult++;
		} else {
			kid++;
		}
		
		// 3인 가족은 여행을 떠날 수 있을까요?
		int adultFlightFare = adultOneWayFlightFare * adult;
		int kidFlightFare = kidOneWayFlightFare * kid;
		int flightFare = adultFlightFare + kidFlightFare;
		
		// 여행을 떠날 수 있다면 "여행가자!"
		if (flightFare <= money) {
			System.out.println("여행가자!");
		}
		// 여행을 떠날 수 없다면 "다음에 가자"를 출력해보세요.
		else {
			System.out.println("다음에 가자");
		}
	}
	
}
