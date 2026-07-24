package com.ktdsuniversity.edu.oop.string;

public class Test {

	public static void changeStr(StringBuffer str) {
		str.append("바뀌었을까요?");
		System.out.println(str); // 원본입니다.바뀌었을까요?
	}
	public static void main(String[] args) {
		StringBuffer message = new StringBuffer();
		// StringBuffer의_인스턴스.append("문자열");
		message.append("원본입니다.");
		System.out.println(message); // 원본입니다.
		changeStr(message);
		System.out.println(message); // 원본입니다.바뀌었을까요?
	}
}
