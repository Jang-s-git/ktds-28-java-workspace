package com.ktdsuniversity.edu.oop.array;

import java.util.Arrays;

public class Programmers {

	public static void main(String[] args) {
		
		// 181941
		String[] arr = new String[3];
		arr[0] = "a";
		arr[1] = "b";
		arr[2] = "c";
		
		System.out.println(arr[0]+arr[1]+arr[2]);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		
		// 181852
		int[] num_list = new int[] {12, 4, 15, 46, 38, 1, 14, 56, 32, 10};
		Arrays.sort(num_list);
		for (int i = 5; i < num_list.length; i++) {
			System.out.print(num_list[i] + " ");
		}
		System.out.println();
		
		// 181853
		for (int i = 0; i < 5; i++) {
			System.out.print(num_list[i] + " ");
		}
		System.out.println();
		
		// 181854
		int[] arr1 = new int[] {49, 12, 100, 276, 33};
		
		int n1 = 27;
		if (arr1.length % 2 != 0) {
			for (int i = 0; i < arr1.length; i++) {
				if (i % 2 == 0) {
					arr1[i] += n1;
				}
				System.out.print(arr1[i] + " ");
			}
		} else {
			for (int i = 0; i < arr1.length; i++) {
				if (i % 2 != 0) {
					arr1[i] += n1;
				}
				System.out.print(arr1[i] + " ");
			}
		}
		System.out.println();
		
		int[] arr2 = new int[] {444, 555, 666, 777};
		
		int n2 = 100;
		if (arr2.length % 2 != 0) {
			for (int i = 0; i < arr2.length; i++) {
				if (i % 2 == 0) {
					arr2[i] += n2;
				}
				System.out.print(arr2[i] + " ");
			}
		} else {
			for (int i = 0; i < arr2.length; i++) {
				if (i % 2 != 0) {
					arr2[i] += n2;
				}
				System.out.print(arr2[i] + " ");
			}
		}
		System.out.println();
		
		// 181856
		int[] arr_1 = new int[] {49, 13};
		int[] arr_2 = new int[] {70, 11, 2};
		if (arr_1.length < arr_2.length) {
			System.out.println("arr_2");
		} else if (arr_1.length > arr_2.length) {
			System.out.println("arr_1");
		}
		
		int[] arr_3 = new int[] {100, 17, 84, 1};
		int[] arr_4 = new int[] {55, 12, 65, 36};
		if (arr_3.length < arr_4.length) {
			System.out.println("arr_4");
		} else if (arr_3.length < arr_4.length) {
			System.out.println("arr_3");
		} else {
			int sum3 = 0;
			for (int i = 0; i < arr_3.length; i++) {
				sum3 += arr_3[i];
			}
			int sum4 = 0;
			for (int i = 0; i < arr_4.length; i++) {
				sum4 += arr_4[i];
			}
			if (sum3 < sum4) {
				System.out.println("arr_4");
			} else if (sum3 > sum4) {
				System.out.println("arr_3");
			} else {
				System.out.println("0");
			}
		}
		
		int[] arr_5 = new int[] {1, 2, 3, 4, 5};
		int[] arr_6 = new int[] {3, 3, 3, 3, 3};
		if (arr_5.length < arr_6.length) {
			System.out.println("arr_6");
		} else if (arr_5.length < arr_6.length) {
			System.out.println("arr_5");
		} else {
			int sum3 = 0;
			for (int i = 0; i < arr_5.length; i++) {
				sum3 += arr_5[i];
			}
			int sum4 = 0;
			for (int i = 0; i < arr_6.length; i++) {
				sum4 += arr_6[i];
			}
			if (sum3 < sum4) {
				System.out.println("arr_6");
			} else if (sum3 > sum4) {
				System.out.println("arr_5");
			} else {
				System.out.println("0");
			}
		}
		
		// 181861
		int[] x_arr = new int[] {5, 1, 4};
		for (int i = 0; i < x_arr.length; i++) {
			for (int j = 0; j < x_arr[i]; j++) {
				System.out.print(x_arr[i] + " ");
			}
		}
		System.out.println();
		
		// 181867
		String myString = "xabcxdefxghi";
		String[] myArray = myString.split("x");
		int myLength = 0;
		for (int i = 0; i < myArray.length; i++) {
			myLength = myArray[i].length();
			System.out.print(myLength + " ");
		}
		System.out.println();
		
		// 181869
		String my_string = " i love you ";
		my_string = my_string.trim();
		String[] my_array = my_string.split(" ");
		for (int i = 0; i < my_array.length; i++) {
			System.out.println(my_array[i]);
		}
		
		// 181868
		String my_string2 = " i  love  you ";
		my_string2 = my_string2.trim();
		String[] my_array2 = my_string2.split("  ");
		for (int i = 0; i < my_array2.length; i++) {
			System.out.println(my_array2[i]);
		}
		
	}
}
