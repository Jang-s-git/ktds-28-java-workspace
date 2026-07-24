package com.ktdsuniversity.edu.oop.string;

public class Programmers {

	public static void main(String[] args) {
		
		// 181842
		String str1 = "abc";
		String str2 = "aabcc";
		
		boolean isContains = str2.contains(str1);
		if (isContains) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		
		String str3 = "tbt";
		String str4 = "tbbttb";
		
		isContains = str4.contains(str3);
		if (isContains) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		
		// 181843
		String my_string = "banana";
		String target = "ana";
		
		isContains = my_string.contains(target);
		if (isContains) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		
		String target2 = "wxyz";
		
		isContains = my_string.contains(target2);
		if (isContains) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		
		// 181845
		int n = 123;
		String result = Integer.toString(n);
		System.out.println(result);
		
		// 181848
		String n_str = "10";
		int n_int = Integer.parseInt(n_str);
		System.out.println(n_int);
		
		// 181847
		String num_str = "123456789";
		String[] num_arr = num_str.split("");
		int sum = 0;
		for (int i = 0; i < num_arr.length; i++) {
			int num_int = Integer.parseInt(num_arr[i]);
			sum += num_int;
		}
		System.out.println(sum);
		
		// 181876
		String myString = "aBcDeFg";
		String r = myString.toLowerCase();
		System.out.println(r);
		
		// 181878
		String myString1 = "AbCdEfG";
		String pat1 = "aBc";
		String lowerMyString1 = myString1.toLowerCase();
		String lowerPat1 = pat1.toLowerCase();
		isContains = lowerMyString1.contains(lowerPat1);
		if (isContains) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		
		String myString2 = "aaAA";
		String pat2 = "aaaaa";
		String lowerMyString2 = myString2.toLowerCase();
		String lowerPat2 = pat2.toLowerCase();
		isContains = lowerMyString2.contains(lowerPat2);
		if (isContains) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		
		// 181875
		String[] strArr = new String[4];
		strArr[0] = "AAA";
		strArr[1] = "BBB";
		strArr[2] = "CCC";
		strArr[3] = "DDD";
		
		for (int i = 0; i < strArr.length; i++) {
			if (i%2==0) {
				System.out.println(strArr[i].toLowerCase());
			} else {
				System.out.println(strArr[i].toUpperCase());
			}
		}
		
		
	}
}
