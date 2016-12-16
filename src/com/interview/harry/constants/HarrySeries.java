package com.interview.harry.constants;
public enum HarrySeries {

	SERIES1(1, "Harry 1", 8.0),
	SERIES2(2, "Harry 2", 8.0),
	SERIES3(3, "Harry 3", 8.0),
	SERIES4(4, "Harry 4", 8.0),
	SERIES5(5, "Harry 5", 8.0);
	
	int bookId;
	String bookName;
	double bookPrice;
	
	private HarrySeries(int bookId, String bookName, double bookPrice) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	
	public int getBookId() {
		return bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	
	@Override
	public String toString() {
		return this.bookId + ". " +this.bookName;
	}
	
	public static HarrySeries getHarrySeriesById(int bookId) {
		for (HarrySeries book : HarrySeries.values()) {
			if(book.getBookId() == bookId)
				return book;
		}
		return null;
	}
	
}
