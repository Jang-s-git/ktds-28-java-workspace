package com.ktdsuniversity.edu.tmdb.bckgrnd.vo;

public class BckgrndVO {

	private String bckgrndId;
	private String mvId;
	private String bckgrndUrl;
	
	public BckgrndVO(String bckgrndId, String mvId, String bckgrndUrl) {
		super();
		this.bckgrndId = bckgrndId;
		this.mvId = mvId;
		this.bckgrndUrl = bckgrndUrl;
	}

	public String getBckgrndId() {
		return this.bckgrndId;
	}

	public void setBckgrndId(String bckgrndId) {
		this.bckgrndId = bckgrndId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getBckgrndUrl() {
		return this.bckgrndUrl;
	}

	public void setBckgrndUrl(String bckgrndUrl) {
		this.bckgrndUrl = bckgrndUrl;
	}
	
	
}
