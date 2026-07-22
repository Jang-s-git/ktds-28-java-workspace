package sales;

public class Seller {

	/**
	 * 판매액
	 */
	int price;
	
	/**
	 * 상품 판매개수
	 */
	int itemNum;
	
	/**
	 * 재고
	 */
	int stock;
	
	Customer[] basket;
	
	public Seller(int price, int itemNum, int stock) {
		this.price = price;
		this.itemNum = itemNum;
		this.stock = stock;
	}
	
	public void AddItem(int index, Customer newItem) {
		this.basket[index] = newItem;
	}
	
	public int Sales(int price, int itemNum) {
		return price*itemNum;
	}
	
	public static void main(String[] args) {
		int[] basketA = new int[10];
		Customer customerA = new Customer(30000, basketA, 10);
		int[] basketB = new int[5];
		Customer customerB = new Customer(12000, basketB, 5);
		
		Seller sellerA = new Seller(3500, 0, 15);
		Seller sellerB = new Seller(2000, 4000, 20);
		
		int salesB = sellerB.Sales(2000, customerA.basketNum);
		if (customerA.cash >= salesB && customerA.basketNum <= sellerB.stock) {
			sellerB.stock -= customerA.basketNum;
			customerA.cash -= salesB;
			System.out.println("구매자A 구매 성공!");
			System.out.println("남은 재고: " + sellerB.stock);
		} else {
			System.out.println("구매자A 구매 실패");
		}
		
		int salesA = sellerA.Sales(3500, customerB.basketNum);
		if (customerB.cash >= salesA && customerB.basketNum <= sellerA.stock) {
			sellerA.stock -= customerB.basketNum;
			customerB.cash -= salesA;
			System.out.println("구매자B 구매 성공!");
			System.out.println("남은 재고: " + sellerA.stock);
		} else {
			System.out.println("구매자B 구매 실패");
		}
		
	}
	
}
