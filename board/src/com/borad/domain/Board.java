package com.borad.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private String title;
	private String writer;
	private String date;
	private int viewCount;
	private String content;
	private List<Comment> comments;
	
	public Board(String title, String writer, String date, int viewCount, String content) {
		this.title = title;
		this.writer = writer;
		this.date = date;
		this.viewCount = 0;
		this.content = content;
		this.comments = new ArrayList<>();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getWriter() {
		return this.writer;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public int getViewCount() {
		return this.viewCount;
	}
	
	public void increaseViewCount() {
		this.viewCount++;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public List<Comment> getComments(){
		return this.comments;
	}
	
}
