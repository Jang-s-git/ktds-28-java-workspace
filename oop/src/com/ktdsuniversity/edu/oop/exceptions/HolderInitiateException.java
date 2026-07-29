package com.ktdsuniversity.edu.oop.exceptions;

/**
 * GoodsHolder의 생성자에 잘못된 값을 전달했을 때 발생하는 예외
 */
public class HolderInitiateException extends RuntimeException {

	/**
	 * 사용자 예외 만들기 - serialVersionUID
	 */
	private static final long serialVersionUID = 4827507370487960003L;
	
	public HolderInitiateException(String message) {
		super(message);
	}
	
}
