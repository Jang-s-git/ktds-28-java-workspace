package com.ktdsuniversity.edu.tmdb.appr.vo;

import com.ktdsuniversity.edu.tmdb.invlvd.vo.InvlvdVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class ApprVO {

	private String strId;
	private String invlvdId;
	private String mvId;
	private String rl;
	
	// 참여자 한 명이 하나의 영화에 출연했다.
	private MvVO mvVO;
	
	// 출연자의 정보
	private InvlvdVO invlvdVO;
	
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

	public MvVO getMvVO() {
		return this.mvVO;
	}

	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
	}

	public InvlvdVO getInvlvdVO() {
		return this.invlvdVO;
	}

	public void setInvlvdVO(InvlvdVO invlvdVO) {
		this.invlvdVO = invlvdVO;
	}
	
	@Override
	public String toString() {
		return "strId: " + this.strId
				+ ", invlvdId: " + this.invlvdId
				+ ", mvId: " + this.mvId
				+ ", rl: " + this.rl;
	}
	
}
