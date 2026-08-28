package com.ktdsuniversity.edu.tmdb.pstr.vo;

public class PstrVO {

	private String pstrId;
	private String mvId;
	private String pstrUrl;
	
	public PstrVO(String pstrId, String mvId, String pstrUrl) {
		super();
		this.pstrId = pstrId;
		this.mvId = mvId;
		this.pstrUrl = pstrUrl;
	}

	public String getPstrId() {
		return this.pstrId;
	}

	public void setPstrId(String pstrId) {
		this.pstrId = pstrId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getPstrUrl() {
		return this.pstrUrl;
	}

	public void setPstrUrl(String pstrUrl) {
		this.pstrUrl = pstrUrl;
	}
	 
	
}
