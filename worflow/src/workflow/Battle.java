package workflow;

public class Battle {

	public static void main(String[] args) {
		/*
		 * BOSS와 Player가 전투를 합니다.
		 * BOSS의 체력과 Player의 체력 중 하나라도 0이하가 된다면 게임은 종료됩니다.
		 * 
		 * BOSS가 Player에게 공격을 합니다. (데미지는 랜덤한 정수 값)
		 * Player가 BOSS에게 공격을 합니다. (데미지는 랜덤한 정수 값)
		 * 
		 * 공격이 끝난 후 서로의 체력을 출력합니다.
		 */
		
		int boss = 1000;
		int player = 1000;
		
		while(boss > 0 && player > 0){
			double randomDamage = Math.random();
			int bossAttack = (int)(randomDamage * 100);
			player -= bossAttack;
			
			randomDamage = Math.random();
			int playerAttack = (int)(randomDamage * 100);
			boss -= playerAttack;
			
			System.out.println("BOSS 체력:" + boss);
			System.out.println("Player 체력:" + player);
			System.out.println("========");
			
			if (boss <= 0 && player > 0){
				System.out.println("BOSS KO!");
				System.out.println("최종 Player 체력:" + player);
				System.out.println("게임종료");
				break;
			} else if (boss > 0 && player <= 0){
				System.out.println("Player KO!");
				System.out.println("최종 BOSS 체력:" + boss);
				System.out.println("게임종료");
				break;
			} else if (boss <= 0 && player <= 0) {
				System.out.println("무승부!");
				System.out.println("게임종료");
			}
		}
	}
}
