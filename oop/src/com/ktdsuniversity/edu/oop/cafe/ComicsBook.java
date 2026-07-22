package com.ktdsuniversity.edu.oop.cafe;

public class ComicsBook {
	
	/**
	 * 만화 제목
	 */
	private String comicName;
	
	/**
	 * 대여 상태
	 */
	private boolean isRent;
	
	/**
	 * 대여료
	 */
	private int rentalFee;
	
	public ComicsBook (String comicName, boolean isRent, int rentalFee) {
		this.comicName = comicName;
		this.isRent = isRent;
		this.rentalFee = rentalFee;
	}
	
	public String getComicName() {
		return this.comicName;
	}
	
	public boolean getIsRent() {
		return this.isRent;
	}
	
	public int getRentalFee() {
		return this.rentalFee;
	}
	
	public void rent() {
		this.isRent = true;
	}
	
	public void returnBook() {
		this.isRent = false;
	}
	
}
