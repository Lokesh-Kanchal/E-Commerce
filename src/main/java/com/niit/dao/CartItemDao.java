package com.niit.dao;

import com.niit.model.Cart;
import com.niit.model.CartItem;

public interface CartItemDao {

	void addCartItem(CartItem cartItem);
	void removecartItem(int cartitemId);
	public void removeAllCartItem(int cartId);
	public Cart getCart(int cartId);
	
}
