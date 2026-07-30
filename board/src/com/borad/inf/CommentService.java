package com.borad.inf;

import java.util.List;

import com.borad.domain.Comment;

public interface CommentService {

	/** 댓글 추가 */
	void addComment(List<Comment> comments, String content, String writer, String date);
	
	/** 댓글 삭제 */
	void deleteComment(List<Comment> comments, int index);
	
	/** 댓글 추천 */
	void recommendComment(List<Comment> comments, int index);
	
	/** 댓글 목록 출력 */
	void printComment(List<Comment> comments);
	
	/** 댓글 전체 삭제 */
	void deleteAllComment(List<Comment> comments);
	
}
