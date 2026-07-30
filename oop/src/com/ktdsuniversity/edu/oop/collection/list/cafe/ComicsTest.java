package com.ktdsuniversity.edu.oop.collection.list.cafe;

import com.ktdsuniversity.edu.oop.cafe.ComicsBook;

public class ComicsTest {

	public static void main(String[] args) {
		ComicsBookCafe cafe = new ComicsBookCafe();
		cafe.addBook(new ComicsBook("만화책 1권", false, 600));
		cafe.addBook(new ComicsBook("만화책 2권", false, 600));
		cafe.addBook(new ComicsBook("만화책 3권", false, 600));
		cafe.addBook(new ComicsBook("만화책 4권", false, 600));
		cafe.addBook(new ComicsBook("만화책 5권", false, 600));
		cafe.addBook(new ComicsBook("만화책 6권", false, 600));
		cafe.addBook(new ComicsBook("만화책 7권", false, 600));
		
		cafe.displayBooks();
		
		Visitor v = new Visitor(10000);
		v.rental(cafe, 0);
		v.rental(cafe, 1);
		v.rental(cafe, 2);
		v.rental(cafe, 3);
		
		v.returnBook(0);
		
		v.printBooks();
		
	}
	
}
