package com.ktdsuniversity.edu.tmdb.mv.vo;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.appr.vo.ApprVO;
import com.ktdsuniversity.edu.tmdb.bckgrnd.vo.BckgrndVO;
import com.ktdsuniversity.edu.tmdb.flmmkr.vo.FlmmkrVO;
import com.ktdsuniversity.edu.tmdb.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.kwrd.vo.KwrdVO;
import com.ktdsuniversity.edu.tmdb.pstr.vo.PstrVO;
import com.ktdsuniversity.edu.tmdb.vd.vo.VdVO;

public class MvVO {

	private String mvId;
	private String ttl;
	private String mvRtng;
	private String rlsDt;
	private int rnngTm;
	private String smmr;
	private String mainPstrUrl;
	private String url;
	private String fbUrl;
	private String xUrl;
	private String instaUrl;
	private String tgln;
	private String orgnlTtl;
	private String shwng;
	private String orgnlLngg;
	private int bdgt;
	private int bxOffcRvn;
	
	// 하나의 영화는 여러 개의 동영상을 가지고 있다
	private List<VdVO> vdList;
	
	// 하나의 영화는 여러 개의 배경을 가지고 있다
	private List<BckgrndVO> bckgrndList;
	
	// 하나의 영화는 여러 개의 포스터을 가지고 있다
	private List<PstrVO> pstrList;
	
	// 하나의 영화는 여러 명이 제작했다
	private List<FlmmkrVO> flmmkrList;
	
	// 하나의 영화에 여러 명이 출연했다
	private List<ApprVO> apprList;
	
	// 하나의 영화는 여러 개의 장르가 있다
	private List<GnrVO> gnrList;
	
	// 하나의 영화는 여러 개의 키워드가 있다
	private List<KwrdVO> kwrdList;
	
	public MvVO(String mvId, String ttl, String mvRtng, String rlsDt, int rnngTm, String smmr, String mainPstrUrl,
			String url, String fbUrl, String xUrl, String instaUrl, String tgln, String orgnlTtl, String shwng,
			String orgnlLngg, int bdgt, int bxOffcRvn) {
		super();
		this.mvId = mvId;
		this.ttl = ttl;
		this.mvRtng = mvRtng;
		this.rlsDt = rlsDt;
		this.rnngTm = rnngTm;
		this.smmr = smmr;
		this.mainPstrUrl = mainPstrUrl;
		this.url = url;
		this.fbUrl = fbUrl;
		this.xUrl = xUrl;
		this.instaUrl = instaUrl;
		this.tgln = tgln;
		this.orgnlTtl = orgnlTtl;
		this.shwng = shwng;
		this.orgnlLngg = orgnlLngg;
		this.bdgt = bdgt;
		this.bxOffcRvn = bxOffcRvn;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getTtl() {
		return this.ttl;
	}

	public void setTtl(String ttl) {
		this.ttl = ttl;
	}

	public String getMvRtng() {
		return this.mvRtng;
	}

	public void setMvRtng(String mvRtng) {
		this.mvRtng = mvRtng;
	}

	public String getRlsDt() {
		return this.rlsDt;
	}

	public void setRlsDt(String rlsDt) {
		this.rlsDt = rlsDt;
	}

	public int getRnngTm() {
		return this.rnngTm;
	}

	public void setRnngTm(int rnngTm) {
		this.rnngTm = rnngTm;
	}

	public String getSmmr() {
		return this.smmr;
	}

	public void setSmmr(String smmr) {
		this.smmr = smmr;
	}

	public String getMainPstrUrl() {
		return this.mainPstrUrl;
	}

	public void setMainPstrUrl(String mainPstrUrl) {
		this.mainPstrUrl = mainPstrUrl;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFbUrl() {
		return this.fbUrl;
	}

	public void setFbUrl(String fbUrl) {
		this.fbUrl = fbUrl;
	}

	public String getxUrl() {
		return this.xUrl;
	}

	public void setxUrl(String xUrl) {
		this.xUrl = xUrl;
	}

	public String getInstaUrl() {
		return this.instaUrl;
	}

	public void setInstaUrl(String instaUrl) {
		this.instaUrl = instaUrl;
	}

	public String getTgln() {
		return this.tgln;
	}

	public void setTgln(String tgln) {
		this.tgln = tgln;
	}

	public String getOrgnlTtl() {
		return this.orgnlTtl;
	}

	public void setOrgnlTtl(String orgnlTtl) {
		this.orgnlTtl = orgnlTtl;
	}

	public String getShwng() {
		return this.shwng;
	}

	public void setShwng(String shwng) {
		this.shwng = shwng;
	}

	public String getOrgnlLngg() {
		return this.orgnlLngg;
	}

	public void setOrgnlLngg(String orgnlLngg) {
		this.orgnlLngg = orgnlLngg;
	}

	public int getBdgt() {
		return this.bdgt;
	}

	public void setBdgt(int bdgt) {
		this.bdgt = bdgt;
	}

	public int getBxOffcRvn() {
		return this.bxOffcRvn;
	}

	public void setBxOffcRvn(int bxOffcRvn) {
		this.bxOffcRvn = bxOffcRvn;
	}

	public List<VdVO> getVdList() {
		return this.vdList;
	}

	public void setVdList(List<VdVO> vdList) {
		this.vdList = vdList;
	}

	public List<BckgrndVO> getBckgrndList() {
		return this.bckgrndList;
	}

	public void setBckgrndList(List<BckgrndVO> bckgrndList) {
		this.bckgrndList = bckgrndList;
	}

	public List<PstrVO> getPstrList() {
		return this.pstrList;
	}

	public void setPstrList(List<PstrVO> pstrList) {
		this.pstrList = pstrList;
	}

	public List<FlmmkrVO> getFlmmkrList() {
		return this.flmmkrList;
	}

	public void setFlmmkrList(List<FlmmkrVO> flmmkrList) {
		this.flmmkrList = flmmkrList;
	}

	public List<ApprVO> getApprList() {
		return this.apprList;
	}

	public void setApprList(List<ApprVO> apprList) {
		this.apprList = apprList;
	}

	public List<GnrVO> getGnrList() {
		return this.gnrList;
	}

	public void setGnrList(List<GnrVO> gnrList) {
		this.gnrList = gnrList;
	}

	public List<KwrdVO> getKwrdList() {
		return this.kwrdList;
	}

	public void setKwrdList(List<KwrdVO> kwrdList) {
		this.kwrdList = kwrdList;
	}
	
	
}
