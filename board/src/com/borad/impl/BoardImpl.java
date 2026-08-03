package com.borad.impl;

import java.util.ArrayList;
import java.util.List;

import com.borad.domain.Board;
import com.borad.exceptions.ArticleException;
import com.borad.exceptions.ArticleWriterException;
import com.borad.inf.BoardService;

public class BoardImpl implements BoardService {

	private List<Board> boards;
	
	public BoardImpl() {
		this.boards = new ArrayList<>();
	}
	
	@Override
	public void add(String title, String writer, String date, String content) {
		title = title.trim();
		if(title.isBlank() || title.length() > 30) {
			ArticleException ae = new ArticleException("제목은 필수로 입력해야 하며, 30글자 내로 작성해야 합니다.");
			throw ae;
		}
		
		writer = writer.trim();
		if(writer.isBlank()) {
			ArticleWriterException awe = new ArticleWriterException("이름은 필수 입력 값이며 길이의 제한은 없습니다.");
			throw awe;
		}
		
		boards.add(new Board(title, writer, date, 0, content));
		System.out.println("게시글 작성이 완료되었습니다.");
		System.out.println("제목: " + title);
		System.out.println("작성자: " + writer);
		System.out.println("작성 날짜: " + date);
		System.out.println("내용: " + content);
	}

	@Override
	public void printAll() {
		if (boards.isEmpty()) {
			System.out.println("등록된 게시글이 없습니다.");
		}
		for (int i = 0; i < boards.size(); i++) {
			Board board = boards.get(i);
			int comment = board.getComments().size();
			System.out.println(i+ ". " + boards.get(i).getTitle() + "(" + comment + ")");
		}
	}

	@Override
	public void print(int index) {
		try {
			Board board = boards.get(index);
			board.increaseViewCount();
			System.out.println("-----------------------");
			System.out.println("제목: " + boards.get(index).getTitle());
			System.out.println("작성자: " + boards.get(index).getWriter());
			System.out.println("작성 날짜: " + boards.get(index).getDate());
			System.out.println("내용: " + boards.get(index).getContent());
			System.out.println("조회수: " + boards.get(index).getViewCount());
		} catch(IndexOutOfBoundsException e) {
			System.out.println("잘못된 게시글 번호입니다.");
		}
		
	}

	@Override
	public void update(int index, String title, String content) {
		try {
			Board board = boards.get(index);
			title = title.trim();
			if(title.isBlank() || title.length() > 30) {
				ArticleException ae = new ArticleException("제목은 필수로 입력해야 하며, 30글자 내로 작성해야 합니다.");
				throw ae;
			}
			
			board.modifyBoard(title, content);
			
			System.out.println("게시글 수정이 완료되었습니다.");
		} catch(IndexOutOfBoundsException e) {
			System.out.println("잘못된 게시글 번호입니다.");
		}
	}

	@Override
	public void delete(int index) {
		try {
			boards.remove(index);
			System.out.println("게시글 삭제가 완료되었습니다.");
		} catch(IndexOutOfBoundsException e) {
			System.out.println("잘못된 게시글 번호입니다.");
		}
	}

	@Override
	public void count() {
		System.out.println("총 게시글 수: " + boards.size());
	}

	@Override
	public void search(String keyboard) {
		for (int i = 0; i < boards.size(); i++) {
			if (boards.get(i).getTitle().contains(keyboard)) {
					Board board = boards.get(i);
					board.increaseViewCount();
					System.out.println("제목: " + boards.get(i).getTitle());
					System.out.println("작성자: " + boards.get(i).getWriter());
					System.out.println("작성 날짜: " + boards.get(i).getDate());
					System.out.println("내용: " + boards.get(i).getContent());
					System.out.println("조회수: " + boards.get(i).getViewCount());
			} else {
				System.out.println("게시글이 없습니다.");
			}
		}
	}

	@Override
	public void deleteAll() {
		boards.clear();
		System.out.println("게시글을 전부 삭제하였습니다.");
	}
	
	@Override
	public Board getBoard(int index) {
		if (index >=0 && index < boards.size()) {
			return boards.get(index);
		}
		return null;
	}
	
}
