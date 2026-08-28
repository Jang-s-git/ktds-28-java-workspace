package com.ktdsuniversity.edu.tmdb.gnr.vo;

public class GnrVO {

	private String gnrId;
	private String nm;
	
	public GnrVO(String gnrId, String nm) {
		super();
		this.gnrId = gnrId;
		this.nm = nm;
	}
	
	public String getGnrId() {
		return this.gnrId;
	}
	public void setGnrId(String gnrId) {
		this.gnrId = gnrId;
	}
	public String getNm() {
		return this.nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	
}
