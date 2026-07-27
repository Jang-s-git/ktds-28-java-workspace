package com.ktdsuniversity.edu.oop.inheritence.contact;

public class Main {

	// 모든 연락처들의 이름과 전화번호 출력.
	public static void printNameAndPhone(Contact contact) {
		System.out.println(contact.getName());
		System.out.println(contact.getPhone());
	}
	
	public static void main(String[] args) {
		Contact contact = new Contact("친구1", "010-1111-2222");
		printNameAndPhone(contact);
		contact.printContact();
		
		// 자식 클래스의 인스턴스가 부모에게 할당되는 것을 허가한다 - 다형성
		EmailContact contact2 = new EmailContact("친구2", "010-1234-5678", "test@email.com");
		printNameAndPhone(contact2);
		
		String email = contact2.getEmail();
		System.out.println(email);
		
		contact2.printContact();
	}
}
