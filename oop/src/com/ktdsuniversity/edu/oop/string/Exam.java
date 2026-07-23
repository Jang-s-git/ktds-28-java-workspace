package com.ktdsuniversity.edu.oop.string;

public class Exam {

	public static void main(String[] args) {
		
		// binding?
		//  	값을 특정 부분에 대입한다.
		int biggestNumber = Integer.MAX_VALUE;
		System.out.println(biggestNumber);
		String numberString = "%, d".formatted(biggestNumber);
		System.out.println(numberString);
		
		// format binding (static method)
		String messageFormat = "%s에서 교육하는 %s과정, %d시간 %d일 과정, %f (%.2f) 진행했습니다.";
		String message0 = String.format(messageFormat,
										"ktds University",
										"Java Programming",
										800,
										100,
										8 / 100d,
										8 / 100d);
		System.out.println(message0);
		
		// format binding (instance method)
		String message00 = messageFormat.formatted(
								"ktds University",
								"Java Programming",
								800,
								100,
								8 / 100d,
								8 / 100d);
		System.out.println(message00);
		
		// address에 “서울”이 포함되어있는지 확인
		String address = "서울특별시 서초구 효령로 176";
		boolean isSeoul = address.contains("서울");
		System.out.println(isSeoul);
		// address1에 “16”이 포함되어있는지 확인
		String address1 = "서울특별시 서초구 효령로 176";
		boolean isSeoul1 = address1.contains("16");
		System.out.println(isSeoul1);
		
		// address2가 "176"으로 끝나는지 확인
		String address2 = "서울특별시 서초구 효령로 176";
		boolean isSeoul2 = address2.endsWith("176");
		System.out.println(isSeoul2);
		// address3가 “서울”로 끝나는지 확인
		String address3 = "서울특별시 서초구 효령로 176";
		boolean isSeoul3 = address3.endsWith("서울");
		System.out.println(isSeoul3);
		
		// name1이 ktdsUniversity와 정확히 같은지 비교 (대소문자 비교 O)
		String name1 = "KTDSuniversity";
		boolean isEqual = name1.equals("ktdsUniversity");
		System.out.println(isEqual);
		
		// name2이 ktdsUniversity와 정확히 같은지 비교 (대소문자 비교 X)
		String name2 = "KTDSuniversity";
		boolean isEqual2 = name2.equalsIgnoreCase("ktdsUniversity");
		System.out.println(isEqual2);
		
		// 문자 c의 인덱스(위치) 찾기
		String alphabets = "abcdefg";
		int letterCIndex = alphabets.indexOf("c");
		System.out.println(letterCIndex);
		
		// 문자 C의 인덱스(위치) 찾기
		int letterCIndex2 = alphabets.indexOf("C");
		System.out.println(letterCIndex2);
		
		// 문자 def의 인덱스(위치) 찾기
		int letterDEFIndex = alphabets.indexOf("def");
		System.out.println(letterDEFIndex);
		
		// blank가 비어있거나 공백으로만 이루어져있는지 확인 (Java 11부터)
		String blank = "       ";
		boolean isBlank = blank.isBlank();
		System.out.println(isBlank);
		
		// blank가 공백으로 비워져있는지 확인
		boolean isEmpty = blank.isEmpty();
		System.out.println(isEmpty);
		
		// message와 name을 ", " 으로 연결하기
		String message = "안녕하세요";
		String name = "홍길동님";
		String helloMessage = String.join(",", message, name);
		System.out.println(helloMessage);
		
		// message2에서 “a”의 마지막 인덱스(위치) 찾기
		String message2 = "abcdefgaijkb";
		int letterALastIndex = message2.lastIndexOf("a");
		System.out.println(letterALastIndex);
		
		// message2에서 “jj”의 마지막 인덱스(위치) 찾기
		int letterJJLastIndex = message2.lastIndexOf("jj");
		System.out.println(letterJJLastIndex);
		
		// message2의 문자열 길이 구하기
		int length = message2.length();
		System.out.println(length);
		
		// phone이 숫자인지 확인하기
		String phone = "01012341234";
		boolean isNumber = phone.matches("^[0-9]+$");
		System.out.println(isNumber);
		
		// message3에서 홍길동을 ktds로 변경하기
		String message3 = "안녕하세요, 홍길동님, 안녕히 가세요, 홍길동님.";
		message3 = message3.replace("홍길동", "ktds");
		System.out.println(message3);
		
		// phone2에서 숫자가 아닌 문자를 공백문자(“”)로 변경하기
		String phone2 = "010-1234-1234";
		phone2 = phone2.replaceAll("[^0-9]", "");
		System.out.println(phone2);
		
		// phone3을 “-”로 잘라 배열에 할당하기
		String phone3 = "010-1234-1234";
		String[] phoneArea = phone3.split("-");
		System.out.println(phoneArea[0]);
		System.out.println(phoneArea[1]);
		System.out.println(phoneArea[2]);
		
		// phone4가 +82 로 시작하는지 확인하기
		String phone4 = "+82-010-1234-1234";
		boolean isKoreaNum = phone4.startsWith("+82");
		System.out.println(isKoreaNum);
		
		// datetime에서 2023(연) 글자만 잘라내어 할당하기
		String datetime = " 2023-05-02 14:56:13 ";
		String year = datetime.substring(0, 4);
		System.out.println(year);
		
		// datetime에서 14(시) 글자만 잘라내어 할당하기
		String hour = datetime.substring(11, 13);
		System.out.println(hour);
		
		// datetime에서 14:56:13(시:분:초) 글자만 잘라내어 할당하기
		String time = datetime.substring(11);
		System.out.println(time);
		
		// datetime에서 앞뒤 공백모두 제거하기
		System.out.println(datetime.length());
		System.out.println(datetime);
		datetime = datetime.trim();
		System.out.println(datetime.length());
		System.out.println(datetime);
		
		// int 타입 1을 문자열로 변경하기 (Overloaing)
		String iStr = String.valueOf(1);
		System.out.println(iStr);
		
	}
	
}
