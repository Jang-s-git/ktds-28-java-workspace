package com.ktdsuniversity.edu.tmdb.bckgrnd.vo;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class BckgrndVO {

	private String bckgrndId;
	private String mvId;
	private String bckgrndUrl;
	
	// 하나의 포스터는 하나의 영화를 위한 것이다.
	private MvVO mvVO;
	
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

	public MvVO getMvVO() {
		return this.mvVO;
	}

	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
	}
	
	
}
