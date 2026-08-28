package com.ktdsuniversity.edu.tmdb.appr.vo;

public class ApprVO {

	private String strId;
	private String invlvdId;
	private String mvId;
	private String rl;
	
	public ApprVO(String strId, String invlvdId, String mvId, String rl) {
		super();
		this.strId = strId;
		this.invlvdId = invlvdId;
		this.mvId = mvId;
		this.rl = rl;
	}
	
	public String getStrId() {
		return this.strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getInvlvdId() {
		return this.invlvdId;
	}
	public void setInvlvdId(String invlvdId) {
		this.invlvdId = invlvdId;
	}
	public String getMvId() {
		return this.mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public String getRl() {
		return this.rl;
	}
	public void setRl(String rl) {
		this.rl = rl;
	}
	
}
