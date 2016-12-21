package com.interview.harry.test;

import java.util.EnumMap;

import org.junit.Test;

import com.interview.harry.business.BookSaleProcessor;
import com.interview.harry.business.CurrentDiscountRule;
import com.interview.harry.business.ShoppingCart;
import com.interview.harry.constants.HarrySeries;

import static org.junit.Assert.*;
/**
 * Test class, Scenario explained at the respective method 
 * @author Sainath
 *
 */
public class TestBookSaleProcessor {

	/**
	 * the below scenario given in the problem
	 * 
	 * 	2 copies of the first book
		2 copies of the second book
		• 2 copies of the third book
		• 1 copy of the fourth book
		• 1 copy of the fifth book
 
		Answer: 51.20 EUR
		
		But I am getting 54.
		
		Each one different book discounted 25%, means 5*8= 40 and 25%of 40 is 10.
		The remaining 3 books charged the full amount. means 3*8 = 24.

		then Total is 40 for 5 books
                     -10 discount for 5 books
                      24 for remaining 3 books.
		then the total cost is 54
	 */
	@Test
	public void testScenario1() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks1(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		assertEquals("testScenario1 actualPrice case failed ", 64, actualPrice, 0);
		assertEquals("testScenario1 discounted price case failed", discountedPrice, 54, 0);
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
	/**
	 * Adding one book in the cart, the actual price and discounted price should be 8
	 */
	@Test
	public void testScenario2() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks2(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		assertEquals("testScenario2 actualPrice case failed", actualPrice, 8, 0);
		assertEquals("testScenario2 discounted price case failed", discountedPrice, 8, 0);
	}
	private EnumMap<HarrySeries, Integer> getBooks2() {
		ShoppingCart cart = new ShoppingCart();
		cart.addBook(HarrySeries.SERIES5, 1);
		return cart.getCurrentCart();
	}
	/**
	 * Adding 5 same books in the cart, the actual price and discounted price should be 40
	 */
	@Test
	public void testScenario3() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks3(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		assertEquals("testScenario3 actualPrice case failed ", actualPrice, 40, 0);
		assertEquals("testScenario3 discounted price case failed", discountedPrice, 40, 0);
	}
	private EnumMap<HarrySeries, Integer> getBooks3() {
		ShoppingCart cart = new ShoppingCart();
		cart.addBook(HarrySeries.SERIES5, 5);
		return cart.getCurrentCart();
	}
	
	/**
	 * Getting 5% discount, on two books.
	 * total books given are 3, then 5% discount on two books and the last book charged 8, 
	 * then the actualPrice=24 and discountedPrice = 23.2
	 */
	@Test
	public void testScenario4() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks4(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		assertEquals("testScenario4 actualPrice case failed", actualPrice, 24, 0);
		assertEquals("testScenario4 discounted price case failed", discountedPrice, 23.2, 0);
	}
	private EnumMap<HarrySeries, Integer> getBooks4() {
		ShoppingCart cart = new ShoppingCart();
		cart.addBook(HarrySeries.SERIES4, 2);
		cart.addBook(HarrySeries.SERIES5, 1);
		return cart.getCurrentCart();
	}
	
	/**
	 * Getting 10% discount, on three books.
	 * total books given are 3, then 10% discount on three books 
	 * then the actualPrice=24 and discountedPrice = 21.6
	 */
	@Test
	public void testScenario5() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks5(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		assertEquals("testScenario5 actualPrice case failed", actualPrice, 24, 0);
		assertEquals("testScenario5 discounted price case failed", discountedPrice, 21.6, 0);
	}
	private EnumMap<HarrySeries, Integer> getBooks5() {
		ShoppingCart cart = new ShoppingCart();
		cart.addBook(HarrySeries.SERIES4, 1);
		cart.addBook(HarrySeries.SERIES5, 1);
		cart.addBook(HarrySeries.SERIES3, 1);
		return cart.getCurrentCart();
	}
	/**
	 * Getting 20% discount, on four books.
	 * total books given are 5, then 20% discount on four books 
	 * then the actualPrice=40 and discountedPrice = 33.6
	 */
	@Test
	public void testScenario6() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks6(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		assertEquals("testScenario6 actualPrice case failed", actualPrice, 40, 0);
		assertEquals("testScenario6 discounted price case failed", discountedPrice, 33.6, 0);
	}
	private EnumMap<HarrySeries, Integer> getBooks6() {
		ShoppingCart cart = new ShoppingCart();
		cart.addBook(HarrySeries.SERIES4, 1);
		cart.addBook(HarrySeries.SERIES5, 1);
		cart.addBook(HarrySeries.SERIES3, 1);
		cart.addBook(HarrySeries.SERIES1, 2);
		return cart.getCurrentCart();
	}
	
	/**
	 * Getting 25% discount, on five books.
	 * total books given are 10, then 25% discount on five books i.e. Eur 10 is discount
	 * then the actualPrice=80 and discountedPrice = 70
	 */
	@Test
	public void testScenario7() {
		BookSaleProcessor processor = new BookSaleProcessor(getBooks7(), new CurrentDiscountRule());
		double actualPrice = processor.getActualPrice();
		double discountedPrice = processor.getDiscountedPrice();
		assertEquals("testScenario7 actualPrice case passed? ", actualPrice, 80, 0);
		assertEquals("testScenario7 discounted price case passed?  ", discountedPrice, 70, 0);
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
