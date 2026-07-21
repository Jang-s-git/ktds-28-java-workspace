package sales;

public class Customer {

	/**
	 * 현금
	 */
	int cash;
	
	/**
	 * 장바구니
	 */
	int[] basket;
	
	/**
	 * 장바구니 수
	 */
	int basketNum;
	
	public Customer(int cash, int[] basket, int basketNum) {
		this.cash = cash;
		this.basket = basket;
		this.basketNum = basketNum;
	}
	
}
