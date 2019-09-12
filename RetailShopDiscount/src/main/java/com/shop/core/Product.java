package com.shop.core;

/*
 * Class for actual product items
 */
public class Product implements Item {

    private final String name;
    private final double unitPrice;
    private final ItemType type;

    public Product(String name, double price, ItemType type) {
        this.name = name;
        this.unitPrice = price;
        this.type = type;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getName() {
        return name;
    }

    public double priceForQuantity(int quantity) {
        return unitPrice * quantity;
    }
    
    public ItemType getType() {
    	return type;
    }
}
