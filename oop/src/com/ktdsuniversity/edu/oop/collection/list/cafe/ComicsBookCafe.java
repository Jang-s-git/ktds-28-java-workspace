package com.ktdsuniversity.edu.oop.collection.list.cafe;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.cafe.ComicsBook;

public class ComicsBookCafe {
	
	/**
	 * 소지금
	 */
	private int amount;
	
	/**
	 * 만화책들
	 */
	List<ComicsBook> books;
	
	public ComicsBookCafe() {
		this.books = new ArrayList<>();
	}
	
	public void addBook(ComicsBook book) {
		this.books.add(book);
	}
	
	public void displayBooks() {
		System.out.println("---만화책 목록---");
		for (int i = 0; i < this.books.size(); i++) {
			
			ComicsBook book = this.books.get(i);
			
			if (book == null) {
				continue;
			}
			
			if (book != null) {
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
	}
	
	public void takeRentFee (int fee) {
		this.amount += fee;
	}
	
	public List<ComicsBook> getBooks() {
		return this.books;
	}
	
	public void printRental() {
		System.out.println("만화카페 소지금: " + this.amount);
	}
	
	
}
