package com.ktdsuniversity.edu.oop.datetime;

import java.time.LocalDate;
import java.util.List;

public class Talk {

	public static void main(String[] args) {
		Friends talk = new Friends();
		talk.addFriend(new Friend("친구1", LocalDate.parse("2003-07-29")));
		talk.addFriend(new Friend("친구2", LocalDate.parse("2003-06-29")));
		talk.addFriend(new Friend("친구3", LocalDate.parse("2003-08-24")));
		talk.addFriend(new Friend("친구4", LocalDate.parse("2003-12-29")));
		talk.addFriend(new Friend("친구5", LocalDate.parse("2003-01-13")));
		talk.addFriend(new Friend("친구6", LocalDate.parse("2003-11-18")));
		talk.addFriend(new Friend("친구7", LocalDate.parse("2002-05-05")));
		talk.addFriend(new Friend("친구8", LocalDate.parse("1999-04-24")));
		talk.addFriend(new Friend("친구9", LocalDate.parse("2000-08-07")));
		talk.addFriend(new Friend("친구10", LocalDate.parse("2002-09-19")));
		talk.addFriend(new Friend("친구11", LocalDate.parse("2001-08-01")));
		talk.addFriend(new Friend("친구12", LocalDate.parse("2001-08-02")));
		talk.addFriend(new Friend("친구13", LocalDate.parse("2001-08-03")));
		talk.addFriend(new Friend("친구14", LocalDate.parse("2001-08-04")));
		talk.addFriend(new Friend("친구15", LocalDate.parse("2001-08-05")));
		talk.addFriend(new Friend("친구16", LocalDate.parse("2001-08-06")));
		
		// 오늘로부터 3일 전후로 생일을 맞이했거나 하는 친구
		// 2026-08-04 기준 2026-08-01 ~ 2026-08-07 까지 생일인 친구들
		// 
		List<Friend> specialFriends = talk.findFriendsBy(3);
		
		
		for (int i = 0; i < specialFriends.size(); i++) {
			System.out.println(specialFriends.get(i));
		}
	}
}
