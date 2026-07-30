package com.borad.inf;

public interface BoardService {
	
	/** 게시글 추가 */
	void add(String title, String writer, String date, String content);
	
	/** 게시글 전체 출력 */
	void printAll();
	
	/** 게시글 번호로 게시글 정보 출력하기 */
	void print(int index);
	
	/** 게시글 수정 */
	void update(int index, String title, String content);
	
	/** 게시글 삭제 */
	void delete(int index);
	
	/** 게시글 수 */
	void count();
	
	/** 게시글 검색 */
	void search(String keyboard);
	
	/** 게시글 목록 전체 삭제 */
	void deleteAll();

}
