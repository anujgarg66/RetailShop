package com.shop;

import com.shop.core.ShopingCart;
import com.shop.core.Item;
import com.shop.core.ItemType;
import com.shop.core.Product;
import com.shop.core.User;
import com.shop.core.UserType;
import com.shop.discount.Discount;

public class MainApp {
	
    public static void main (String[] args)
    {
    	User user = new User(UserType.EMPLOYEE, "Anuj");
        Item groceryItem = new Product("Rice", 20, ItemType.GROCERY);
        Item otherItem = new Product("Deodrant", 200, ItemType.OTHER);
        Discount discountPolicy = new Discount();
        
        ShopingCart cart = new ShopingCart(user, discountPolicy);
        cart.add(groceryItem, 4);
        cart.add(otherItem, 4);
        /*
         * Calculations:
         *  Total (20 * 4) + (200 * 4) = 880
         *  Grocery Item is 80
         *  After 30% discount on 4 other items total 800 = 560
         *  After 25 dollars off due to price over $600 = 610
         */
        System.out.println(cart.total());        
    }
}