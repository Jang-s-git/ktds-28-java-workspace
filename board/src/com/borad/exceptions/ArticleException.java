package com.borad.exceptions;

/**
 * 게시글 제목을 입력하지 않았거나, 길이가 초과 한다면, ArticleException 예외가 던져져야 합니다.
 */
public class ArticleException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3310618232714593202L;
	
	public ArticleException(String message) {
		super(message);
	}

}
