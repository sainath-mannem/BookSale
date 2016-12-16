package com.interview.harry.business;

import java.util.EnumMap;

import com.interview.harry.constants.HarrySeries;

public class ShoppingCart {
	EnumMap<HarrySeries, Integer> books = new EnumMap<HarrySeries, Integer>(HarrySeries.class);
	public void addBook(HarrySeries book, int count) {
		Integer copies = books.get(book);
		if( copies == null) {
			books.put(book, count);
		} else {
			books.put(book, count + copies);
		}
	}

	public EnumMap<HarrySeries, Integer> getCurrentCart() {
		return books;
	}
	
	public void removeBook(HarrySeries book) {
		books.remove(book);
	}
	
	public boolean updateBookCount(HarrySeries book, int count) {
		if(books.containsKey(book)) {
			books.put(book, count);
			return true;
		}
		else
			return false;
	}
}
