package com.ktdsuniversity.edu.tmdb.vd.vo;

public class VdVO {

	private String vdId;
	private String mvId;
	private String vdUrl;
	
	public VdVO(String vdId, String mvId, String vdUrl) {
		super();
		this.vdId = vdId;
		this.mvId = mvId;
		this.vdUrl = vdUrl;
	}

	public String getVdId() {
		return this.vdId;
	}

	public void setVdId(String vdId) {
		this.vdId = vdId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getVdUrl() {
		return this.vdUrl;
	}

	public void setVdUrl(String vdUrl) {
		this.vdUrl = vdUrl;
	}
	
	
}
