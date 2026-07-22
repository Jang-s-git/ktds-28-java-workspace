package com.ktdsuniversity.edu.oop.cafe;

public class ComicsBookCafe {
	
	/**
	 * 소지금
	 */
	private int amount;
	
	/**
	 * 만화책들
	 */
	ComicsBook[] books;
	
	public ComicsBookCafe(ComicsBook[] comicsBook) {
		this.books = comicsBook;
	}
	
	public void displayBooks() {
		System.out.println("---만화책 목록---");
		for (int i = 0; i < this.books.length; i++) {
			ComicsBook book = this.books[i];
			
			String state = "대여 가능";
			
			if (book.getIsRent()) {
				state = "대여 중";
			}
			
			System.out.println("만화책 번호: "+i);
			System.out.println("만화책 이름: "+ book.getComicName());
			System.out.println("만화책 대여 상태: "+ state);
			System.out.println("만화책 대여비: "+ book.getRentalFee());
		}
	}
	
	public void takeRentFee (int fee) {
		this.amount += fee;
	}
	
	public ComicsBook[] getBooks() {
		return this.books;
	}
	
	public void printRental() {
		System.out.println("만화카페 소지금: " + this.amount);
	}
	
	
}
