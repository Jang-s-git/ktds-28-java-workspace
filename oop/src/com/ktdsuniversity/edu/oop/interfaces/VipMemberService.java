package com.ktdsuniversity.edu.oop.interfaces;

public interface VipMemberService extends MemberService {
// VipMemberService is a MemberService

	/** 회원에게 포인트 지급 */
	void addPoint(int point);
	
}
