package com.ktdsuniversity.edu.oop.interfaces.mart.goods;

public class FrozenFood extends Goods {

	private String expiredDate;
	private int storageTemperature;
	
	public FrozenFood(String name, int price, String expiredDate, int storageTemperature) {
		super(name, price);
		this.expiredDate = expiredDate;
		this.storageTemperature = storageTemperature;
	}

	public String getExpiredDate() {
		return this.expiredDate;
	}

	public int getStorageTemperature() {
		return this.storageTemperature;
	}

	@Override
	public String toString() {
		return "FrozenFood [expiredDate=" + this.expiredDate + ", storageTemperature=" + this.storageTemperature + ", getName()="
				+ super.getName() + ", getPrice()=" + super.getPrice() + "]";
	}

}