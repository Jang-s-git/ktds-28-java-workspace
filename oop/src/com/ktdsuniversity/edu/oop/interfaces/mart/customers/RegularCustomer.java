package com.ktdsuniversity.edu.oop.interfaces.mart.customers;

import com.ktdsuniversity.edu.oop.interfaces.mart.goods.Goods;

public interface RegularCustomer extends Customer {

	int gift(Goods[] goods, int amount);

}