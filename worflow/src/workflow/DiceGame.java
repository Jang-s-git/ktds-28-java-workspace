package workflow;

public class DiceGame {

	public static void main(String[] args) {
		/*
		 * 주사위를 굴려 최종 목적지에 먼저 도착하는 플레이어가 승리하는 게임
		 * 
		 * 위치 값을 가진 4명의 플레이어가 있습니다.
		 * 모든 플레이어들의 위치값은 0부터 시작합니다.
		 * 
		 * 각 플레이어들은 주사위 두 개를 굴려 나온 수 만큼 이동을 합니다.
		 * 
		 * ==== 주사위 규칙 ====
		 * 1. 두 개의 주사위를 굴린 값이 3, 7 이라면 위치 값은 10 만큼 증가합니다.
		 * 2. 두 주사위가 똑같은 숫자가 나온다면 주사위의 합의 배수만큼 이동합니다.
		 * 		-> 4, 4 => 8 * 2 ==> +16
		 * 3. 두 주사위 값의 합이 3의 배수일 경우 위치 값은 합의 수만큼 감소합니다.
		 * 		-> 4, 5 ==> 9 ==> -9
		 * 
		 * 플레이어의 위치 값은 0보다 작아질 수 없습니다.
		 * - 현재 위치값이 8이고, 이동할 칸의 수가 -9 라면, 위치 값은 0이 되어야 합니다.
		 * 
		 * 플레이어가 주사위를 굴릴 때마다 주사위의 값, 이동할 칸의 수, 현재 위치값을 표시한다.
		 */
		int player1 = 0;
		int player2 = 0;
		int player3 = 0;
		int player4 = 0;
		
		final int GOAL_POSITION = 127;
		
		while(player1 < GOAL_POSITION
				&& player2 < GOAL_POSITION
				&& player3 < GOAL_POSITION
				&& player4 < GOAL_POSITION
				) {
			System.out.println("==========");

			double player1RamdomDice1 = Math.random();
			int player1Dice1 = (int) (player1RamdomDice1 * 6) + 1;
			double player1RamdomDice2 = Math.random();
			int player1Dice2 = (int) (player1RamdomDice2 * 6) + 1;
			
			int player1Dice = player1Dice1 + player1Dice2;
			
			if (player1Dice1 == player1Dice2 && player1Dice % 3 != 0) {
				player1 += player1Dice * 2;
				System.out.println("player1의 위치: " + player1);
			} else if (player1Dice % 3 == 0) {
				player1 -= player1Dice;
				if (player1 < 0) {
					player1 = 0;
				}
				System.out.println("player1의 위치: " + player1);
			} else {
				player1 += player1Dice;
				System.out.println("player1의 위치: " + player1);
			}
			
			double player2RamdomDice1 = Math.random();
			int player2Dice1 = (int) (player2RamdomDice1 * 10);
			double player2RamdomDice2 = Math.random();
			int player2Dice2 = (int) (player2RamdomDice2 * 10);
			
			int player2Dice = player2Dice1 + player2Dice2;
			
			if (player2Dice1 == player2Dice2 && player2Dice % 3 != 0) {
				player2 += player2Dice * 2;
				System.out.println("player2의 위치: " + player2);
			} else if (player2Dice % 3 == 0) {
				player2 -= player2Dice;
				if (player2 < 0) {
					player2 = 0;
				}
				System.out.println("player2의 위치: " + player2);
			} else {
				player2 += player2Dice;
				System.out.println("player2의 위치: " + player2);
			}
			
			double player3RamdomDice1 = Math.random();
			int player3Dice1 = (int) (player3RamdomDice1 * 10);
			double player3RamdomDice2 = Math.random();
			int player3Dice2 = (int) (player3RamdomDice2 * 10);
			
			int player3Dice = player3Dice1 + player3Dice2;
			
			if (player3Dice1 == player3Dice2 && player3Dice % 3 != 0) {
				player3 += player3Dice * 2;
				System.out.println("player3의 위치: " + player3);
			} else if (player3Dice % 3 == 0) {
				player3 -= player3Dice;
				if (player3 < 0) {
					player3 = 0;
				}
				System.out.println("player3의 위치: " + player3);
			} else {
				player3 += player3Dice;
				System.out.println("player3의 위치: " + player3);
			}
			
			double player4RamdomDice1 = Math.random();
			int player4Dice1 = (int) (player4RamdomDice1 * 10);
			double player4RamdomDice2 = Math.random();
			int player4Dice2 = (int) (player4RamdomDice2 * 10);
			
			int player4Dice = player2Dice1 + player2Dice2;
			
			if (player4Dice1 == player4Dice2 && player4Dice % 3 != 0) {
				player4 += player4Dice * 2;
				System.out.println("player4의 위치: " + player4);
			} else if (player4Dice % 3 == 0) {
				player4 -= player4Dice;
				if (player4 < 0) {
					player4 = 0;
				}
				System.out.println("player4의 위치: " + player4);
			} else {
				player4 += player4Dice;
				System.out.println("player4의 위치: " + player4);
			}
		}
	}
}
