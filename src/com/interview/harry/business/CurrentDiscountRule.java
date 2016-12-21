package com.interview.harry.business;
/**
 * This is the current discount rule class
 * @author Sainath
 *
 */
public class CurrentDiscountRule implements Discount{

	public int oneBookDiscount() {
		return 0;
	}

	public int twoBookDiscount() {
		return 5;
	}

	public int threeBookDiscount() {
		return 10;
	}

	public int fourBookDiscount() {
		return 20;
	}

	public int fiveBookDiscount() {
		return 25;
	}

	@Override
	public float getDiscountRate(int count) {
		float discount = 0f;
		switch (count) {
		case 1:
			discount = oneBookDiscount();
			break;
		case 2:
			discount = twoBookDiscount();
			break;
		case 3:
			discount = threeBookDiscount();
			break;
		case 4:
			discount = fourBookDiscount();
			break;
		case 5:
			discount = fiveBookDiscount();
			break;
		default:
			break;
		}
		return discount;
	}

}
