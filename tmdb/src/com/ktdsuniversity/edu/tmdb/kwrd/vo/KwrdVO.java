package com.ktdsuniversity.edu.tmdb.kwrd.vo;

public class KwrdVO {

	private String kwrdId;
	private String nm;
	
	public KwrdVO(String kwrdId, String nm) {
		super();
		this.kwrdId = kwrdId;
		this.nm = nm;
	}
	
	public String getKwrdId() {
		return this.kwrdId;
	}
	public void setKwrdId(String kwrdId) {
		this.kwrdId = kwrdId;
	}
	public String getNm() {
		return this.nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	
}
