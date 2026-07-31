package com.borad.impl;

import java.util.List;

import com.borad.domain.Comment;
import com.borad.inf.CommentService;

public class CommentImpl implements CommentService {

	@Override
	public void addComment(List<Comment> comments, String content, String writer, String date) {
		if (comments.size() >= 10) {
			System.out.println("댓글을 더 이상 등록할 수 없습니다.");
			return;
		}
		comments.add(new Comment(content, writer, date, 0));
		System.out.println("댓글 작성이 완료되었습니다.");
	}

	@Override
	public void deleteComment(List<Comment> comments, int index) {
		try {
			comments.remove(index);
			System.out.println("댓글 삭제가 완료되었습니다.");
		} catch(IndexOutOfBoundsException e) {
			System.out.println("잘못된 댓글 번호입니다.");
		}
	}

	@Override
	public void recommendComment(List<Comment> comments, int index) {
		try {
			comments.get(index).increaseRecommendCount();
			System.out.println("댓글을 추천합니다.");
		} catch(IndexOutOfBoundsException e) {
			System.out.println("잘못된 댓글 번호입니다.");
		}
	}

	@Override
	public void printComment(List<Comment> comments) {
		if (comments.isEmpty()) {
			System.out.println("등록된 댓글이 없습니다.");
			return;
		}
		for (int i = 0; i < comments.size(); i++) {
			System.out.println("-----------------------");
			System.out.println("내용: " + comments.get(i).getContent());
			System.out.println("작성자: " + comments.get(i).getWriter());
			System.out.println("작성 날짜: " + comments.get(i).getDate());
			System.out.println("추천 수: " + comments.get(i).getRecommendCount());
		}
	}

	@Override
	public void deleteAllComment(List<Comment> comments) {
		if (comments.isEmpty()) {
			System.out.println("등록된 댓글이 없습니다.");
			return;
		}
		comments.clear();
		System.out.println("댓글을 전부 삭제하였습니다.");
	}

}
