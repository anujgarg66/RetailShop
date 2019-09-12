package com.shop.discount.item;

import com.shop.core.Item;
import com.shop.core.ItemType;

/*
 * Apply percentage discount on items based on type
 */
public class PromotionDiscount extends PricingItem {

    private final double priceFactor;

    public PromotionDiscount(Item baseItem, int percentPromotion) {
        super(baseItem);
        if (percentPromotion < 0 || percentPromotion > 100 ) {
            throw new IllegalArgumentException("Invalid discount");
        }
        this.priceFactor = (100 - percentPromotion) / 100.0;
    }

    @Override
    public double priceForQuantity(int quantity) {
    	// No Discount on Grocery Items
    	if (super.getType() == ItemType.GROCERY) {
    		return super.priceForQuantity(quantity);
    	}
    	
    	// else apply percentage discount
        return (super.priceForQuantity(quantity) * priceFactor);
    }
}
