package com.ktdsuniversity.edu.tmdb.mvkwrd.vo;

public class MvKwrdVO {

	private String mvKwrdId;
	private String mvId;
	private String kwrdId;
	
	public MvKwrdVO(String mvKwrdId, String mvId, String kwrdId) {
		super();
		this.mvKwrdId = mvKwrdId;
		this.mvId = mvId;
		this.kwrdId = kwrdId;
	}

	public String getMvKwrdId() {
		return this.mvKwrdId;
	}

	public void setMvKwrdId(String mvKwrdId) {
		this.mvKwrdId = mvKwrdId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getKwrdId() {
		return this.kwrdId;
	}

	public void setKwrdId(String kwrdId) {
		this.kwrdId = kwrdId;
	}
	
	
}
