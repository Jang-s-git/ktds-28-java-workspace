package com.ktdsuniversity.edu.oop.collection.map;

import java.util.ArrayList;
import java.util.HashMap; // 2차원 배열로 만들어진 자료구조
import java.util.List;
import java.util.Map;

public class Tag {

	public static void main(String[] args) {
		
		// 의류에 붙어있는 택 정보를 Map을 이용해 표현
		Map<String, Object> tags = new HashMap<>();
		tags.put("사이즈", 30);
		tags.put("소재", "폴리에스테르");
		tags.put("가격", 59000);
		
		System.out.println(tags); // {소재=폴리에스테르, 사이즈=30, 가격=59000}
		//							--> List와 달리 Map은 순서가 보장되지 않음
		System.out.println(tags.size()); // 3
		
		tags.put("가격", 69000);
		System.out.println(tags); // {소재=폴리에스테르, 사이즈=30, 가격=69000}
		System.out.println(tags.size()); // 3
		
		// String is a Object -> 명시적 형변환
		String 소재 = (String) tags.get("소재");
		System.out.println(소재); // 폴리에스테르
		
		String 브랜드 = (String) tags.get("브랜드");
		System.out.println(브랜드); // null
		
		int 가격 = (int) tags.get("가격");
		System.out.println(가격); // 69000
		
		// java.lang.NullPointerException
		// int 할인가 = (int) tags.get("할인가");
		// System.out.println(할인가);
		// ↓
		// ↓
		// ↓
		// 해결방법 1
		if (tags.containsKey("할인가")) {
			int 할인가 = (int) tags.get("할인가");
			System.out.println(할인가);
		}
		
		//해결방법 2
		int 할인가 = (int) tags.getOrDefault("할인가", 0);
		System.out.println(할인가); // 0
		
		
		
		// Map을 사용하지 않는 이유 - Side Effect가 높아짐
		List<Map<String, Object>> clothes = new ArrayList<>();
		Map<String, Object> tags1 = new HashMap<>();
		tags1.put("판매가격", 15000); // 가격 -> 판매가격
		tags1.put("소재", "나일론");
		tags1.put("사이즈", 32);
		clothes.add(tags1);
		
		tags1 = new HashMap<>();
		tags1.put("판매가격", 15000);
		tags1.put("소재", "나일론");
		tags1.put("사이즈", 30);
		clothes.add(tags1);
		
		tags1 = new HashMap<>();
		tags1.put("판매가격", 15000);
		tags1.put("소재", "나일론");
		tags1.put("사이즈", 28);
		clothes.add(tags1);
		
		tags1 = new HashMap<>();
		tags1.put("판매가격", 15000);
		tags1.put("소재", "나일론");
		tags1.put("사이즈", 26);
		clothes.add(tags1);
		
		for(int i = 0; i < clothes.size(); i++) {
			printTags(clothes.get(i));
		}
		
	}
	
	public static void printTags(Map<String, Object> tags) {
		System.out.println("소재: " + tags.get("소재"));
		System.out.println("가격: " + tags.get("가격")); // null
		System.out.println("사이즈: " + tags.get("사이즈"));
	}
	
}
