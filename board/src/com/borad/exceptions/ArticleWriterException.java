package com.borad.exceptions;

/**
 * 게시글 작성자의 이름을 입력하지 않았다면, ArticleWriterException 예외가 던져져야 합니다.
 */
public class ArticleWriterException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5357325520671793395L;
	
	public ArticleWriterException(String message) {
		super(message);
	}
	
}
