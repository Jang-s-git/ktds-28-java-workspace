package com.ktdsuniversity.edu.tmdb.pstr.vo;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class PstrVO {

	private String pstrId;
	private String mvId;
	private String pstrUrl;
	
	// 하나의 배경은 하나의 영화를 위한 것이다.
	private MvVO mvVO;
	
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

	public MvVO getMvVO() {
		return this.mvVO;
	}

	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
	}
	
	
}
