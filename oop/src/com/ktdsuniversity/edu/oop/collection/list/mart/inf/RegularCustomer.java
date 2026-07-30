package com.ktdsuniversity.edu.oop.collection.list.mart.inf;

import java.util.List;

import com.ktdsuniversity.edu.oop.interfaces.mart.goods.Goods;

public interface RegularCustomer extends Customer {

	int gift(List<Goods> goods, int amount);

}