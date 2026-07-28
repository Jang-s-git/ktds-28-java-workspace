package com.ktdsuniversity.edu.oop.interfaces.mart.goods;

public class AlcoholicBeverages extends Goods {

	private int storageTemperature;
	private int purchageAgeLimit;
	private int alcoholContent;

	public AlcoholicBeverages(String name, int price, int storageTemperature, int purchageAgeLimit,
			int alcoholContent) {
		super(name, price);
		this.storageTemperature = storageTemperature;
		this.purchageAgeLimit = purchageAgeLimit;
		this.alcoholContent = alcoholContent;
	}

	public int getStorageTemperature() {
		return this.storageTemperature;
	}

	public int getPurchageAgeLimit() {
		return this.purchageAgeLimit;
	}

	public int getAlcoholContent() {
		return this.alcoholContent;
	}

	@Override
	public String toString() {
		return "AlcoholicBeverages [storageTemperature=" + this.storageTemperature + ", purchageAgeLimit=" + this.purchageAgeLimit
				+ ", alcoholContent=" + this.alcoholContent + ", getName()=" + super.getName() + ", getPrice()=" + super.getPrice()
				+ "]";
	}

}