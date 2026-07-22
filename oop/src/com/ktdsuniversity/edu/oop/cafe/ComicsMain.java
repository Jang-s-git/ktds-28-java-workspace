package com.ktdsuniversity.edu.oop.cafe;

public class ComicsMain {
	
	public static void main(String[] args) {
		
		ComicsBook[] books = new ComicsBook[3];
		books[0] = new ComicsBook("슬램덩크 1권", false, 500);
		books[1] = new ComicsBook("슬램덩크 2권", false, 500);
		books[2] = new ComicsBook("슬램덩크 3권", false, 500);
		
		ComicsBookCafe 벌툰 = new ComicsBookCafe(books);
		
		Visitor me = new Visitor(4000);
		Visitor other = new Visitor(5000);
		
		// 벌툰이 보유 중인 만화책 목록
		벌툰.displayBooks();
		
		// 내가 만화카페 벌툰에서 슬램덩크 1권을 빌린다.
		me.rental(벌툰, 0); // visitor.books[0] 만화책 정보 할당
		
		// 내가 만화카페 벌툰에서 슬램덩크 3권을 빌린다.
		me.rental(벌툰, 2); // visitor.books[1] 만화책 정보 할당
		
		// 다른사람이 만화카페 벌툰에서 슬램덩크 3권을 빌린다.
		other.rental(벌툰, 2);
		
		// 내가 슬램덩크 1권을 벌툰에게 반납한다.
		me.returnBook(0);
		me.returnBook(0);
		
		// 내가 대여한 만화책 목록 출력
		me.printBooks();
		
		// 다른사람이 대여한 만화책 목록 출력
		other.printBooks();
		
		벌툰.printRental();
	}
	
}
