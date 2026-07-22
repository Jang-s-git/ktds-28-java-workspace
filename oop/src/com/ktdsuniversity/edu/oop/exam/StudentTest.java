package com.ktdsuniversity.edu.oop.exam;

public class StudentTest {

	public static void main(String[] args) {
		StudentScore student = new StudentScore(0,0,0,0);
		student.getSumAllScore(); // -> The field StudentScore.java is not visible
		
		System.out.println(student.java); // -> The field StudentScore.java is not visible
		
		// 멤버변수 앞에는 무조건 private
		// 아무나 접근하지 못하게 -> 보안
		
	}
}
