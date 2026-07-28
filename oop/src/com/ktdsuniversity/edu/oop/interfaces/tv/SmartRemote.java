package com.ktdsuniversity.edu.oop.interfaces.tv;

public class SmartRemote implements Remote {

	@Override
	public void turnOn(Tv tv) {
		tv.turnOn();
	}

	@Override
	public void turnOff(Tv tv) {
		tv.turnOff();
	}

	@Override
	public void increaseVolume(Tv tv) {
		tv.increaseVolume();
	}

	@Override
	public void decreaseVolume(Tv tv) {
		tv.decreaseVolume();
	}

	@Override
	public void increaseChannel(Tv tv) {
		tv.increaseChannel();
	}

	@Override
	public void decreaseChannel(Tv tv) {
		tv.decreaseChannel();
	}

	@Override
	public void changeInputSource(Tv tv) {
		tv.changeInputSource();
	}

	@Override
	public void runApps(Tv tv) {
		tv.runApps();
	}

	@Override
	public void runAI(Tv tv) {
		System.out.println("이 TV에는 AI 기능이 존재하지 않습니다.");
	}

	@Override
	public void controlShoppingButtons(Tv tv) {
		System.out.println("이 TV에는 홈쇼핑 기능이 존재하지 않습니다.");
	}

	@Override
	public void inputChannelNumber(int number, Tv tv) {
		tv.changeChannel(number);
	}

	@Override
	public void mute(Tv tv) {
		tv.mute();
	}

	@Override
	public void changeTvSettings(Tv tv) {
		System.out.println("이 TV의 설정 정보가 존재하지 않습니다.");
	}
	
}
