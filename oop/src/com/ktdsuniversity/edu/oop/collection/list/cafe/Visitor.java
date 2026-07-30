package com.ktdsuniversity.edu.oop.collection.list.cafe;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.cafe.ComicsBook;

public class Visitor {

	/**
	 * 고객이 대여한 만화책 목록
	 */
	private List<ComicsBook> books;
	
	/**
	 * 고객의 소지금
	 */
	private int money;
	
	public Visitor(int money) {
		this.books = new ArrayList<>();
		this.money = money;
	}
	
	public void rental(ComicsBookCafe cafe, int bookId) {
		
		// cafe가 소지하고 있는 만화책이 대여 중인가?
		List<ComicsBook> cafeBooks = cafe.getBooks();
		if (bookId < 0 || bookId >= cafeBooks.size()) {
			System.out.println("존재하지 않는 만화책입니다.");
			return;
		}
		
		ComicsBook book = cafeBooks.get(bookId);
		
		// cafe가 소지하고 있는 만화책은 얼마인가?
		if (book.getIsRent()) {
			System.out.println("이미 대여 중인 만화책입니다.");
		} else {
			// 만화책의 대여비는 얼마인가?
			int fee = book.getRentalFee();
			if (fee <= this.money) {
				// 고객이 대여한 책 목록에 추가한다.
				this.books.add(book);
				
				// 돈을 내고
				this.money -= fee;
				
				// 카페가 돈을 받고
				cafe.takeRentFee(fee);
				
				// 책의 상태를 변경
				book.rent();
			}
		}
		
	}
	
	public void returnBook (int bookId) {
		
		// 고객이 반납할 책
		ComicsBook book = this.books.get(bookId);
		
		// 책의 대여 상태를 false로 변경
		book.returnBook();
		
		// 고객이 대여한 책을 목록에서 제거
		this.books.remove(bookId);
		
	}
	
	public void printBooks() {
		System.out.println("---고객이 대여한 책 목록---");
		for (int i = 0; i < this.books.size(); i++) {
			System.out.println("만화책 번호: " + i);
			System.out.println("만화책 이름: " + this.books.get(i).getComicName());
		}
	}
	
}
