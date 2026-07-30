package com.ktdsuniversity.edu.oop.generics;

public class UserTest {

	public static void main(String[] args) {
		User<Integer, String> user01 = new User<>(1, "장민창");
		int id = user01.getId();
		String name = user01.getName();
		System.out.println(id);
		System.out.println(name);
		
		User<Integer, Long> user02 = new User<>(2, 346739983828924490L);
		id = user02.getId();
		long name02 = user02.getName();
		System.out.println(id);
		System.out.println(name02);
		
	}
	
}
