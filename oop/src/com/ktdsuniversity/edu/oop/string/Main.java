package com.ktdsuniversity.edu.oop.string;

import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		
		String startWord = "자전거";
		System.out.println("끝말잇기를 시작합니다! \n"+ startWord);
		
		// 시작단어의 마지막 글자 저장
		String lastWord = startWord.substring(startWord.length()-1);
		System.out.println(lastWord);
		
		int relayCount = 0;
		
		// Scanner 생성
		Scanner keyboard = new Scanner(System.in);
		String nextWord = null; // 반복문 내부에 변수 생성 X
		
		while(true){
			
			// 이전 단어의 마지막 글자로 시작하는 다음단어 입력
			nextWord = keyboard.nextLine();
			// 공백 제거
			nextWord = nextWord.replace(" ", "");
			
			// 이전단어가 시작단어의 마지막 글자로 시작하고, 단어가 세 글자 이상인가?
			if (nextWord.startsWith(lastWord) && nextWord.length() >= 3) {
				System.out.println(nextWord);
				
				// 다음단어의 마지막 글자 저장
				lastWord = nextWord.substring(nextWord.length()-1);
				System.out.println(lastWord);
				
				relayCount += 1;
			} else {
				break;
			}
		
		}
		
		System.out.println("끝말잇기 종료!");
		System.out.println("총 " + relayCount + "회 진행");
	}
}
