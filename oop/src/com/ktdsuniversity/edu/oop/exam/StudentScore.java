package com.ktdsuniversity.edu.oop.exam;

public class StudentScore {

	private int java;
	private int python;
	private int cpp;
	private int csharp;
	
	public StudentScore() {
//		this.java = 100;
//		this.python = 100;
//		this.cpp = 100;
//		this.csharp = 100;
		// 생성자 내부에서는 다른 생성자의 호출이 가능
		// 호출방법: this();
		this(100, 100, 100, 100);
	}
	
	public StudentScore(int java, int python, int cpp, int csharp) {
		this.java = java;
		this.python = python;
		this.cpp = cpp;
		this.csharp = csharp;
	}
	
	private int getSumAllScore() {
		int sum = (java + python + cpp + csharp);
		return (sum);
	}
	
	public double getAverage(int sum) {
		double average = (double) sum / 4;
		average = (int) (average * 100);
		average = average / 100;
		return average;
	}
	
	public double getCourseCredit(double average) {
		double credit = (average - 55) / 10;
		credit = (int) (credit * 100);
		credit = credit / 100;
		return credit;
	}
	
	public String getABCDE(double credit) {
		if (credit > 4.0 && credit <= 4.5) {
			return "A+";
		} else if (credit > 3.5 && credit <= 4.0) {
			return "A";
		} else if (credit > 3.0 && credit <= 3.5) {
			return "B+";
		} else if (credit > 2.5 && credit <= 3.0) {
			return "B";
		} else if (credit > 1.5 && credit <= 2.5) {
			return "C";
		} else if (credit > 0.5 && credit <= 1.5) {
			return "D";
		} else {
			return "F";
		}
	}
	
	public static void main(String[] args) {
											// java, py, cpp, cs
		StudentScore studentA = new StudentScore(96, 90, 83, 78);
		StudentScore studentB = new StudentScore(); // 모든 점수가 100점인 학생 인스턴스
		
		int sum = studentA.getSumAllScore();
		
		double average = studentA.getAverage(sum);
		double credit = studentA.getCourseCredit(average);
		String score = studentA.getABCDE(credit);
		
		System.out.println(sum);
		System.out.println(average);
		System.out.println(credit);
		System.out.println(score);
		
	}
}
