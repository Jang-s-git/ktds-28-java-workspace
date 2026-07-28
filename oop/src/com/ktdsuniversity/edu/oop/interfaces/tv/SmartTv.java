package com.ktdsuniversity.edu.oop.interfaces.tv;

public class SmartTv implements Tv {

	private final String[] INPUT_SOURCE = 
		{"COMPONENT", "HDMI1", "HDMI2", "USB"};
	private final String[] APPS = 
		{"NETFLIX", "Wavve", "Youtube", "Tving", "Disney+"};
	
	private boolean isOn;
	private int volume;
	private int channerNumber;
	private int activeInputSourceNumber;
	private int activeAppNumber;
	
	@Override
	public void turnOn() {
		this.isOn = true;
		System.out.println("전원이 켜집니다.");
	}

	@Override
	public void turnOff() {
		this.isOn = false;
		System.out.println("전원이 꺼집니다.");
	}

	@Override
	public void increaseVolume() {
		if (!this.isOn) {
			return;
		}
		this.volume++;
		if (this.volume > 100) {
			this.volume = 100;
			System.out.println("볼륨을 더 높일 수 없습니다.");
		}
		System.out.println("현재 볼륨은 " + this.volume + "입니다.");
	}

	@Override
	public void decreaseVolume() {
		if (!this.isOn) {
			return;
		}
		this.volume--;
		if (this.volume < 0) {
			this.volume = 0;
			System.out.println("볼륨을 더 낮출 수 없습니다.");
		}
		System.out.println("현재 볼륨은 " + this.volume + "입니다.");
	}

	@Override
	public void increaseChannel() {
		if (!this.isOn) {
			return;
		}
		this.channerNumber++;
		
		if (this.channerNumber == Tv.CHANNELS.length) {
			this.channerNumber = 0;
		}
		
		String channelName = Tv.CHANNELS[this.channerNumber];
		System.out.println("현재 보고 있는 채널은 " + channelName + "입니다.");
	}

	@Override
	public void decreaseChannel() {
		if (!this.isOn) {
			return;
		}
		this.channerNumber--;
		
		if (this.channerNumber < 0) {
			this.channerNumber = Tv.CHANNELS.length - 1;
		}
		
		String channelName = Tv.CHANNELS[this.channerNumber];
		System.out.println("현재 보고 있는 채널은 " + channelName + "입니다.");
	}

	@Override
	public void changeInputSource() {
		if (!this.isOn) {
			return;
		}
		
		this.activeInputSourceNumber++;
		if (this.activeInputSourceNumber == this.INPUT_SOURCE.length) {
			this.activeInputSourceNumber = 0;
		}
		String inputSourceName = this.INPUT_SOURCE[this.activeInputSourceNumber];
		System.out.println("외부 입력 이름: " + inputSourceName);
		
		if (inputSourceName.equals("USB")) {
			this.readUsb();
		}
	}

	@Override
	public void readUsb() {
		System.out.println("USB를 읽습니다.");
	}

	@Override
	public void runApps() {
		if (!this.isOn) {
			return;
		}
		
		this.activeAppNumber++;
		if (this.activeAppNumber == this.APPS.length) {
			this.activeAppNumber = 0;
		}
		String appName = this.APPS[this.activeAppNumber];
		System.out.println(appName + " 실행합니다.");
	}
	
	@Override
	public void mute() {
		this.volume = 0;
		System.out.println("음소거 되었습니다.");
	}
	
	@Override
	public void changeChannel(int channelNumber) {
		for (int i = 0 ; i < Tv.CHANNELS.length; i++) {
			if (Tv.CHANNELS[i].equals(channelNumber + "")) {
				this.channerNumber = i;
				break;
			}
		}
		String channelName = Tv.CHANNELS[this.channerNumber];
		System.out.println("현재 채널: " + channelName);
	}

}
