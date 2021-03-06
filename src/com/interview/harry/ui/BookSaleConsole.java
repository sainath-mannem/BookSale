package com.interview.harry.ui;

import java.util.EnumMap;
import java.util.Scanner;

import com.interview.harry.business.BookSaleProcessor;
import com.interview.harry.business.CurrentDiscountRule;
import com.interview.harry.business.ShoppingCart;
import com.interview.harry.constants.HarrySeries;
/**
 * Desktop application for the given Book sale problem
 * Running this class, user can manage cart, view cart and checkout.
 * @author Sainath
 *
 */
public class BookSaleConsole {
	private ShoppingCart cart;
	public Scanner reader = null;
	public BookSaleConsole(ShoppingCart shoppingCart) {
		this.cart = shoppingCart;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		reader.close();
		System.out.println("reader closed successfully");
	}

	public static void main(String[] args) {
		BookSaleConsole console = null;
		try {
			console = new BookSaleConsole(new ShoppingCart());
			console.reader = new Scanner(System.in);
			System.out.println("***********************************");
			System.out.println("WelCome to My Publishing House");
			System.out.println("***********************************");
			boolean flag = true;
			while(flag) {
				System.out.println("\n\n\nSelect Any Option...........\n");
				System.out.println("1. View Book Catalog");
				System.out.println("2. Add Book to Cart");
				System.out.println("3. Update Book Count to Cart");
				System.out.println("4. Remove Book from Cart");
				System.out.println("5. View My Cart");
				System.out.println("6. Checkout");
				System.out.println("7. Exit");
				System.out.print("Please enter your Choice: ");
				int choice = console.reader.nextInt();
				System.out.print("\n");
				switch (choice) {
				case 1:
					console.showCatalog();
					break;
				case 2: 
					console.addBook();
					break;
				case 3:
					console.updateCart();
					break;
				case 4:
					console.removeBook();
					break;
				case 5:
					console.viewCart(true);
					break;
				case 6:
					flag = false;
					console.viewCart(true);
					System.out.println("*******************************************************************");
					System.out.println(".............Thanks For Shopping with Us, Have a Nice Day........");
					System.out.println("*******************************************************************");
					break;
				case 7:
					flag = false;
					System.out.println("*******************************************************************");
					System.out.println("..........Thanks For visiting our Store, Have a Nice Day........");
					System.out.println("*******************************************************************");
					break;
				default:
					System.out.println("Please enter from 1 to 7");
					break;
				}
				
			}
		} finally {
			console.reader.close();
		}
	}

	private void viewCart(boolean showPrice) {
		
		System.out.println("***********************************************************");
		System.out.println("*****************Shopping Cart*****************************");
		System.out.println("***********************************************************");
		EnumMap<HarrySeries, Integer> currentCart = cart.getCurrentCart();
		BookSaleProcessor saleProcessor = new BookSaleProcessor(currentCart, new CurrentDiscountRule());
		showCatalog(currentCart);
		if(showPrice) {
			System.out.println("Total Original Price.............."+saleProcessor.getActualPrice());
			System.out.println("Total Price After Discount........"+saleProcessor.getDiscountedPrice());
			System.out.println("DIscount Availed.................."+(saleProcessor.getActualPrice() - saleProcessor.getDiscountedPrice()));
		}
	}

	private void removeBook() {
		viewCart(false);
		System.out.println("\n\nPlease enter Book Id to remove from cart");
		int choice = reader.nextInt();
		HarrySeries book = HarrySeries.getHarrySeriesById(choice);
		if(book == null) {
			System.out.println("\nBook Id is wrong, Please Enter Correct BookId to remove");
			removeBook();
		}
		cart.removeBook(book);
		System.out.println("Book "+book.getBookName()+" removed to Cart");
	}

	private void updateCart() {
		viewCart(false);
		System.out.println("Updating Book Copies\n\nPlease enter Book Id");
		int choice = reader.nextInt();
		HarrySeries book = HarrySeries.getHarrySeriesById(choice);
		if(book == null) {
			System.out.println("\nBook Id is wrong, Please Enter Correct BookId to update");
			updateCart();
		} else {
			int copies = addCopies(book);
			boolean result = cart.updateBookCount(book, copies);
			if(result) {
				System.out.println("Book "+book.getBookName()+" updated to Cart\n\n");
				viewCart(false);
			} else {
				System.out.println("Wrong book id to update Copies..");
			}
		}
	}

	private void addBook() {
		showCatalog();
		System.out.println("\nPlease Enter Book Id: ");
		int choice = reader.nextInt();
		HarrySeries book = HarrySeries.getHarrySeriesById(choice);
		if(book == null) {
			System.out.println("\nBook Id is wrong, Please Enter Correct BookId");
			addBook();
		}
		cart.addBook(book, addCopies(book));
		System.out.println("Book "+book.getBookName()+" added to Cart");
		viewCart(false);
	}

	private void showCatalog() {
		showCatalog(null);
	}

	private int addCopies(HarrySeries book) {
		System.out.println("\nNumber of Copies of "+ book.getBookName() + ": ");
		int count = reader.nextInt();
		if(count > 0) {
			return count;
		}
		else {
			System.out.println("\n Wrong Entry, please enter number of copies : ");
			return addCopies(book);
		}
	}

	private void showCatalog(EnumMap<HarrySeries, Integer> currentCart) {
		System.out.print("Book Id   ");
		System.out.print(" Book Title   ");
		System.out.print("    Book Price");
		if(currentCart != null) {
			System.out.println("           Copies");
		}
		System.out.println("\n...............................................................");
		for (HarrySeries book : HarrySeries.values()) {
			if((currentCart != null && currentCart.get(book) != null) || currentCart == null) {
				System.out.print(book.getBookId());
				System.out.print("          " + book.getBookName());
				System.out.print("          " +book.getBookPrice());
				if(currentCart != null) {
					System.out.print("                  "+currentCart.get(book));
				}
			}
			System.out.println("\n");
		}
		System.out.println();
	}

}
