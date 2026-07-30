package com.borad.domain;

public class Comment {

	private String content;
	private String writer;
	private String date;
	private int recommendCount;
	
	public Comment(String content, String writer, String date, int recommendCount) {
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.recommendCount = 0;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public String getWriter() {
		return this.writer;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public int getRecommendCount() {
		return this.recommendCount;
	}
	
	public void increaseRecommendCount() {
		this.recommendCount++;
	}
	
}
