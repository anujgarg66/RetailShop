package com.shop.core;

/*
 * Interface for all items
 */
public interface Item {
	
    double getUnitPrice();
    
    double priceForQuantity(int quantity);
    
    String getName();
    
    ItemType getType();
}
