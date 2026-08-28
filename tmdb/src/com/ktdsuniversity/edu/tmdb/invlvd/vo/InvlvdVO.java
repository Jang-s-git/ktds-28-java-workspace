package com.ktdsuniversity.edu.tmdb.invlvd.vo;

public class InvlvdVO {

	private String invlvdId;
	private String prflPhtUrl;
	private String nm;
	
	public InvlvdVO(String invlvdId, String prflPhtUrl, String nm) {
		super();
		this.invlvdId = invlvdId;
		this.prflPhtUrl = prflPhtUrl;
		this.nm = nm;
	}
	
	public String getInvlvdId() {
		return this.invlvdId;
	}
	public void setInvlvdId(String invlvdId) {
		this.invlvdId = invlvdId;
	}
	public String getPrflPhtUrl() {
		return this.prflPhtUrl;
	}
	public void setPrflPhtUrl(String prflPhtUrl) {
		this.prflPhtUrl = prflPhtUrl;
	}
	public String getNm() {
		return this.nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	
}
