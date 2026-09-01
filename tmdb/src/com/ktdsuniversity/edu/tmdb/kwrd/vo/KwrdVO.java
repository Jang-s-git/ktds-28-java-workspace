package com.ktdsuniversity.edu.tmdb.kwrd.vo;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class KwrdVO {

	private String kwrdId;
	private String nm;
	
	// 하나의 키워드에는 여러 개의 영화가 있다.
	private List<MvVO> mvList;
	
	public String getKwrdId() {
		return this.kwrdId;
	}
	public void setKwrdId(String kwrdId) {
		this.kwrdId = kwrdId;
	}
	public String getNm() {
		return this.nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}

	public List<MvVO> getMvList() {
		return this.mvList;
	}

	public void setMvList(List<MvVO> mvList) {
		this.mvList = mvList;
	}
	
	@Override
	public String toString() {
		return "kwrdId: " + this.kwrdId
				+ ", nm: " + this.nm ;
	}
	
}
