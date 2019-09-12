package com.shop.core;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import com.shop.discount.Discount;
import com.shop.discount.item.PromotionDiscount;

/*
 * Cart Class to calculate complete to add items and contain the final net amount
 */
public class ShopingCart {
	
    private Map<Item, Integer> quantities;
    private Discount discountPolicy;
    private User user;

    public ShopingCart(User user) {
        quantities = new HashMap<Item, Integer>();
        this.user = user;
    }
    
    public ShopingCart(User user, Discount discountPolicy) {
        quantities = new HashMap<Item, Integer>();
        this.user = user;
        this.discountPolicy = discountPolicy;
    }

    /**
     * Calculate Total Bill Amount
     * @return
     */
    public double total() {
        double result = 0;
        for (Item each : quantities.keySet()) {
            result += each.priceForQuantity(quantities.get(each));
        }
        
        if (discountPolicy != null) {
        	result = discountPolicy.applyDiscount(result);
        }
        
        return result;
    }

    /**
     * Adding item in shopping cart
     * @param itemToBuy
     */
    public void add(Item itemToBuy) {    	
        add(itemToBuy, 1);
    }
    

    /**
     * Multiple Items to add in cart
     * @param itemToBuy
     * @param howMany
     */
    // To add multiple quantities of item
    public void add(Item itemToBuy, int howMany) {
    	Item item;
    	
    	// Apply 30% discount in case of employee of store
    	if (user.getType() == UserType.EMPLOYEE) {
    		item = new PromotionDiscount(itemToBuy, 30);
    	}
    	// Apply 10% discount in case of affiliate
    	else if (user.getType() == UserType.AFFILIATE) {
    		item = new PromotionDiscount(itemToBuy, 10);
    	}
    	
    	// If a user has been a customer for 2 or more years apply 5% discount
    	else if (user.getType() == UserType.GENERAL && 
    			ChronoUnit.YEARS.between(user.getJoiningDate(), LocalDateTime.now()) >= 2) {
    		item = new PromotionDiscount(itemToBuy, 5);
    	}
    	
    	else {
    		item = itemToBuy;
    	}
    	
        int previousQuantity = quantities.containsKey(item)
                ? quantities.get(item) : 0;
        quantities.put(item, previousQuantity + howMany);
    }
}
