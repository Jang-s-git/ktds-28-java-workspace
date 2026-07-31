package com.borad.impl;

import java.util.ArrayList;
import java.util.List;

import com.borad.domain.Board;
import com.borad.exceptions.ArticleException;
import com.borad.exceptions.ArticleWriterException;
import com.borad.inf.BoardService;

public class BoardImpl implements BoardService {

	private List<Board> boards = new ArrayList<>();
	
	@Override
	public void add(String title, String writer, String date, String content) {
		title = title.trim();
		if(title.isBlank()) {
			ArticleException ae = new ArticleException("제목은 필수로 입력해야 하며, 30글자 내로 작성해야 합니다.");
			throw ae;
		}
		
		writer = writer.trim();
		if(writer.isBlank()) {
			ArticleWriterException awe = new ArticleWriterException("이름은 필수 입력 값이며 길이의 제한은 없습니다.");
			throw awe;
		}
		
		boards.add(new Board(title, writer, date, 0, content));
		System.out.println("게시글이 성공적으로 저장되었습니다.");
		System.out.println("제목: " + title);
		System.out.println("작성자: " + writer);
		System.out.println("작성 날짜: " + date);
		System.out.println("내용: " + content);
	}

	@Override
	public void printAll() {
		for (int i = 0; i < boards.size(); i++) {
			((Board) boards).increaseViewCount();
			System.out.println("제목: " + boards.get(i).getTitle());
			System.out.println("작성자: " + boards.get(i).getWriter());
			System.out.println("작성 날짜: " + boards.get(i).getDate());
			System.out.println("내용: " + boards.get(i).getContent());
			System.out.println("조회수: " + boards.get(i).getViewCount());
		}
	}

	@Override
	public void print(int index) {
		System.out.println("제목: " + boards.get(index).getTitle());
		System.out.println("작성자: " + boards.get(index).getWriter());
		System.out.println("작성 날짜: " + boards.get(index).getDate());
		System.out.println("내용: " + boards.get(index).getContent());
		System.out.println("조회수: " + boards.get(index).getViewCount());
	}

	@Override
	public void update(int index, String title, String content) {
		// IndexOutOfBoundsException
		
	}

	@Override
	public void delete(int index) {
		//IndexOutOfBoundsException
		
	}

	@Override
	public void count() {
		System.out.println(boards.size());
	}

	@Override
	public void search(String keyboard) {
		
	}

	@Override
	public void deleteAll() {
		
	}

}
