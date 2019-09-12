package com.shop.discount;

/*
 * To generate discount of $5 for every 100 dollars in cart
 */
public class Discount {

	/**
	 * Method to apply discount for 5$
	 * @param totalAmount
	 * @return
	 */
	public double applyDiscount(double totalAmount) {
		
		if (totalAmount < 100) {
			return totalAmount;
		}
		
		int discountFactor = (int) totalAmount / 100;
		double discount = discountFactor * 5;
		return totalAmount - discount; 
	}

}
