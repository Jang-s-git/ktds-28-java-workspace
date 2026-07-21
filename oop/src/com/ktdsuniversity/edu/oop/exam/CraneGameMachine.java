package com.ktdsuniversity.edu.oop.exam;

public class CraneGameMachine {
	boolean isInsertCoin;
	int dolls;
	
	public void insertCoin() {
		isInsertCoin = true;
		
		if (dolls <= 0 ) {
			isInsertCoin = false;
		}
		
	}
	
	public int doGame() {
		if (isInsertCoin = true) {
			int craneGame = (int) (Math.random() * 2);
			isInsertCoin = false;
			return craneGame;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		CraneGameMachine craneGameMachine = new CraneGameMachine();
		
		craneGameMachine.isInsertCoin = false;
		craneGameMachine.dolls = 10;
		
		craneGameMachine.insertCoin();
		
		int success = craneGameMachine.doGame();
		
		if (success == 1) {
			System.out.println("인형 뽑기 성공!");
			craneGameMachine.dolls -= 1;
		} else if (success == 0) {
			System.out.println("인형 뽑기 실패!");
		}
		
		System.out.println("남은 인형 개수: "+ craneGameMachine.dolls);
	}
	
}
