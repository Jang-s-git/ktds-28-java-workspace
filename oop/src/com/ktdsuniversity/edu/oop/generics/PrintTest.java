package com.ktdsuniversity.edu.oop.generics;

import com.ktdsuniversity.edu.oop.exceptions.Goods;

public class PrintTest {

	public static void main(String[] args) {
		
		//		↓ Reference Type
		Print<Integer> intPrint = new Print<>(0);
		Print<Double> doublePrint = new Print<>(0d);
		Print<Long> longPrint = new Print<>(0L);
		Print<Boolean> booleanPrint = new Print<>(false);
		
		int a = intPrint.getPrintData();
		double b = doublePrint.getPrintData();
		long c = longPrint.getPrintData();
		boolean d = booleanPrint.getPrintData();
		
		// 제네릭
		// D == Goods						↓ 앞에 있는 Goods로 대체
		Print<Goods> goodsPrint = new Print<>(new Goods("A", 300));
		Goods goods = goodsPrint.getPrintData();
		goodsPrint.print();
		System.out.println(goods);
		
	}
	
}
