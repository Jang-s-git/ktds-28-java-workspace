package com.ktdsuniversity.edu.oop.interfaces;

public class Main {

	public static void main(String[] args) {
		
		// ArticleSystem is a ArticleService
		ArticleService articleService = new ArticleSystem();
		articleService.write();
		articleService.delete();
		articleService.view();
		
		// ArticleSystem is a ReplyService
		ReplyService replyService = new ArticleSystem();
		replyService.addReply();
		replyService.deleteReply();
		replyService.recommendReply();
		
		// MemberService, VipMemberService의 인스턴스 생성.
		// VipMemberService is a MemberService
		// Member is a MemberService
		MemberService system = new Member();
		system.deleteMe();
		system.join();
		system.login();
		system.logout();
		
		// VipMember is a VipMemberService
		VipMemberService vipSystem = new VipMember();
		vipSystem.deleteMe();
		vipSystem.join();
		vipSystem.login();
		vipSystem.logout();
		vipSystem.addPoint(100);
		
		// VipMember is a MemberService
		MemberService vipSystem2 = new VipMember();
		vipSystem2.deleteMe();
		vipSystem2.join();
		vipSystem2.login();
		vipSystem2.logout();
		if (vipSystem2 instanceof VipMemberService vip) {
			vip.addPoint(1000);
		}
		
		// SomeInterface의 인스턴스를 생성해보기
		// Interface는 인스턴스로 생성할 수 없다.
		// SomeInterface inf = new SomeInterface(); XXXXX
		// ==> Java의 인스턴스는 모든 메소드가 구현되어있어야 한다. --> 구현클래스 필요
		SomeInterface inf = new SomeClass2();
		inf.doSomething1();
		inf.doSomething2();
		inf.doSomething3();
		
		int value = inf.getSomething();
		System.out.println(value);
		
		String str = inf.getString();
		System.out.println(str);
		
		// 인터페이스를 사용하면 사이드이펙트를 줄일 수 있음. -> 안정형 애플리케이션 구현 시 필수
		
	}
}
