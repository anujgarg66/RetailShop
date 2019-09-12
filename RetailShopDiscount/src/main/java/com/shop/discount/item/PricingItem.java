package com.shop.discount.item;

import com.shop.core.Item;
import com.shop.core.ItemType;

/*
 * Class to implement pricing at item level
 */
public class PricingItem implements Item {

    private final Item baseItem;

    public PricingItem(Item baseItem) {
        this.baseItem = baseItem;
    }

    public double getUnitPrice() { 
    	return baseItem.getUnitPrice();
    }

    public String getName() { 
    	return baseItem.getName(); 
    }
    
    public ItemType getType() {
    	return baseItem.getType(); 
    }

    public double priceForQuantity(int quantity) {
        return baseItem.priceForQuantity(quantity);
    }
}
