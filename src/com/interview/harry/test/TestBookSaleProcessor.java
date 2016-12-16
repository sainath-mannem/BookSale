package com.interview.harry.test;

import java.util.EnumMap;

import org.junit.Test;

import com.interview.harry.business.BookSaleProcessor;
import com.interview.harry.business.CurrentDiscountRule;
import com.interview.harry.business.ShoppingCart;
import com.interview.harry.constants.HarrySeries;
//Test class, Scenario explained at the respective method 
public class TestBookSaleProcessor {

	@Test
	//the below scenario given in the problem
	public void testScenario1() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks1(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		System.out.println("testScenario1 actualPrice case passed? " +(actualPrice == 64));
		System.out.println("testScenario1 dicounted price case passed?  " +(discountedPrice == 54));
	}

	private EnumMap<HarrySeries, Integer> getBooks1() {
		ShoppingCart cart = new ShoppingCart();
		cart.addBook(HarrySeries.SERIES1, 2);
		cart.addBook(HarrySeries.SERIES2, 2);
		cart.addBook(HarrySeries.SERIES3, 2);
		cart.addBook(HarrySeries.SERIES4, 1);
		cart.addBook(HarrySeries.SERIES5, 1);
		return cart.getCurrentCart();
	}
	@Test
	//Adding one book in the cart, the actual price and discounted price should be 8
	public void testScenario2() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks2(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		System.out.println("testScenario2 actualPrice case passed? " +(actualPrice == 8));
		System.out.println("testScenario2 dicounted price case passed?  " +(discountedPrice == 8));
	}
	private EnumMap<HarrySeries, Integer> getBooks2() {
		ShoppingCart cart = new ShoppingCart();
		cart.addBook(HarrySeries.SERIES5, 1);
		return cart.getCurrentCart();
	}
	@Test
	//Adding 5 same books in the cart, the actual price and discounted price should be 40
	public void testScenario3() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks3(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		System.out.println("testScenario3 actualPrice case passed? " +(actualPrice == 40));
		System.out.println("testScenario3 dicounted price case passed?  " +(discountedPrice == 40));
	}
	private EnumMap<HarrySeries, Integer> getBooks3() {
		ShoppingCart cart = new ShoppingCart();
		cart.addBook(HarrySeries.SERIES5, 5);
		return cart.getCurrentCart();
	}
	
	@Test
	//Getting 5% discount, on two books.
	// total books given are 3, then 5% discount on two books and the last book charged 8, 
	//then the actualPrice=24 and discountedPrice = 23.2
	public void testScenario4() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks4(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		System.out.println("testScenario4 actualPrice case passed? " +(actualPrice == 24));
		System.out.println("testScenario4 dicounted price case passed?  " +(discountedPrice == 23.2));
	}
	private EnumMap<HarrySeries, Integer> getBooks4() {
		ShoppingCart cart = new ShoppingCart();
		cart.addBook(HarrySeries.SERIES4, 2);
		cart.addBook(HarrySeries.SERIES5, 1);
		return cart.getCurrentCart();
	}
	
	@Test
	//Getting 10% discount, on three books.
	// total books given are 3, then 10% discount on three books 
	//then the actualPrice=24 and discountedPrice = 21.6
	public void testScenario5() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks5(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		System.out.println("testScenario5 actualPrice case passed? " +(actualPrice == 24));
		System.out.println("testScenario5 dicounted price case passed?  " +(discountedPrice == 21.6));
	}
	private EnumMap<HarrySeries, Integer> getBooks5() {
		ShoppingCart cart = new ShoppingCart();
		cart.addBook(HarrySeries.SERIES4, 1);
		cart.addBook(HarrySeries.SERIES5, 1);
		cart.addBook(HarrySeries.SERIES3, 1);
		return cart.getCurrentCart();
	}
	@Test
	//Getting 20% discount, on four books.
	// total books given are 5, then 20% discount on four books 
	//then the actualPrice=40 and discountedPrice = 33.6
	public void testScenario6() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks6(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		System.out.println("testScenario6 actualPrice case passed? " +(actualPrice == 40));
		System.out.println("testScenario6 dicounted price case passed?  " +(discountedPrice == 33.6));
	}
	private EnumMap<HarrySeries, Integer> getBooks6() {
		ShoppingCart cart = new ShoppingCart();
		cart.addBook(HarrySeries.SERIES4, 1);
		cart.addBook(HarrySeries.SERIES5, 1);
		cart.addBook(HarrySeries.SERIES3, 1);
		cart.addBook(HarrySeries.SERIES1, 2);
		return cart.getCurrentCart();
	}
	
	@Test
	//Getting 25% discount, on five books.
	// total books given are 10, then 25% discount on five books i.e. Eur 10 is discount
	//then the actualPrice=80 and discountedPrice = 70
	public void testScenario7() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks7(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		System.out.println("testScenario7 actualPrice case passed? " +(actualPrice == 80));
		System.out.println("testScenario7 dicounted price case passed?  " +(discountedPrice == 70));
	}
	private EnumMap<HarrySeries, Integer> getBooks7() {
		ShoppingCart cart = new ShoppingCart();
		cart.addBook(HarrySeries.SERIES4, 1);
		cart.addBook(HarrySeries.SERIES5, 2);
		cart.addBook(HarrySeries.SERIES3, 3);
		cart.addBook(HarrySeries.SERIES1, 2);
		cart.addBook(HarrySeries.SERIES2, 2);
		return cart.getCurrentCart();
	}
}
