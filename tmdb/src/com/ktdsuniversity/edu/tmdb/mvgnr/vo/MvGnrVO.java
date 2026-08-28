package com.ktdsuniversity.edu.tmdb.mvgnr.vo;

public class MvGnrVO {

	private String mvGnrId;
	private String mvId;
	private String GnrId;
	
	public MvGnrVO(String mvGnrId, String mvId, String gnrId) {
		super();
		this.mvGnrId = mvGnrId;
		this.mvId = mvId;
		GnrId = gnrId;
	}
	
	public String getMvGnrId() {
		return this.mvGnrId;
	}
	public void setMvGnrId(String mvGnrId) {
		this.mvGnrId = mvGnrId;
	}
	public String getMvId() {
		return this.mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public String getGnrId() {
		return this.GnrId;
	}
	public void setGnrId(String gnrId) {
		GnrId = gnrId;
	}
	
}
