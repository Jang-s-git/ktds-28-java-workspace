package com.ktdsuniversity.edu.oop.exceptions;

public class ExceptionTest {

	public static void main(String[] args) {
		
		String name = null;
		if (StringUtils.isEmpty(name)) {
			System.out.println("이름을 입력해주세요.");
		} else {
			System.out.println(name);
		}
		
		String job = "     ";
		if (StringUtils.isEmpty(job)) {
			System.out.println("직업을 입력해주세요.");
		} else {
			System.out.println(job);
		}
		
		String address = "   ";
		String message = StringUtils.emptyToDefault(address, "주소를 입력해주세요.");
		System.out.println(message);
	}
}
