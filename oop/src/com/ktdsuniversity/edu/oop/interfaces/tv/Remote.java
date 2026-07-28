package com.ktdsuniversity.edu.oop.interfaces.tv;

public interface Remote {

	void turnOn(Tv tv);
	void turnOff(Tv tv);
	
	void increaseVolume(Tv tv);
	void decreaseVolume(Tv tv);
	
	void increaseChannel(Tv tv);
	void decreaseChannel(Tv tv);
	
	void changeInputSource(Tv tv);
	
	void runApps(Tv tv);
	
	void runAI(Tv tv);
	
	void controlShoppingButtons(Tv tv);
	
	void inputChannelNumber(int number, Tv tv);
	
	void mute(Tv tv);
	
	void changeTvSettings(Tv tv);
	
}
