package com.interview.harry.business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import com.interview.harry.constants.HarrySeries;
/**
 * This is the main service class
 *this class need books and the discount rule
 *this class gives the actual price and discounted price
 * @author Sainath
 *
 */
public class BookSaleProcessor {
	
	EnumMap<HarrySeries, Integer> books;
	Discount discount;
	
	public BookSaleProcessor(EnumMap<HarrySeries, Integer> books, Discount discount) {
		this.books = books;
		this.discount = discount;
	}
	
	/**
	 * This method calculates the actual price of the books
	 * @return actual price
	 */
	public Double getActualPrice() {
		Double totalPrice = new Double(0);
		for (Entry<HarrySeries, Integer> booksEntry : books.entrySet()) {
			totalPrice += ((HarrySeries) booksEntry.getKey()).getBookPrice() *  booksEntry.getValue() ;
		}
		return totalPrice;
	}
	
	/**
	 * This method calculates the discounted price of the books
	 * @return discounted price
	 */
	public Double getDiscountedPrice() {
		Double totalPrice = new Double(0);
		int booksCount = books.size();
		float discountRate = discount.getDiscountRate(booksCount);
		if(discountRate == 0) {
			return getActualPrice();
		}
		double totalSingleBookPrice = 0;
		Set<HarrySeries> discountedBooks = new HashSet<HarrySeries>();
		for (HarrySeries book: books.keySet()) {
			totalSingleBookPrice += book.getBookPrice();
			discountedBooks.add(book);
		}
		double singleBookTotalDiscount = round(totalSingleBookPrice * (discountRate/100), 2);
		totalPrice = totalSingleBookPrice - singleBookTotalDiscount;
		for (Entry<HarrySeries,Integer> bookEntry: books.entrySet()) {
			int copies = bookEntry.getValue();
			if(discountedBooks.contains(bookEntry.getKey())) {
				copies--;
			}
			if(copies > 0) {
				totalPrice += bookEntry.getKey().getBookPrice() * copies;
			}
		}
		return totalPrice;
	}
	
	/**
	 * @param value
	 * @param places
	 * @return rounded value
	 */
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
