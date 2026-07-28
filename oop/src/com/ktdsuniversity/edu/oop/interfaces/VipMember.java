package com.ktdsuniversity.edu.oop.interfaces;

public class VipMember implements VipMemberService {
// VipMember is a VipMemberService
// VipMember is a MemberService
	
	@Override
	public void join() {
		System.out.println("VIP 회원 가입 합니다.");
	}

	@Override
	public void login() {
		System.out.println("VIP 회원 로그인 합니다.");
	}

	@Override
	public void deleteMe() {
		System.out.println("VIP 회원 탈퇴 합니다.");
	}

	@Override
	public void logout() {
		System.out.println("VIP 회원 로그아웃 합니다.");
	}

	@Override
	public void addPoint(int point) {
		System.out.println(point + "포인트를 적립합니다.");
	}

}
