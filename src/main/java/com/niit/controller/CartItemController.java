package com.niit.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;

import com.niit.model.product;
import com.niit.service.CartItemService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;

@Controller
public class CartItemController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartItemService cartItemService;
	
	
	@RequestMapping("/cart/addtocart/{pid}")
	public String addCartItem(@PathVariable int pid,@RequestParam int units,@RequestParam(value="error", required = false)
	String error,Model model){
		product product=productService.getProductById(pid);
		System.out.println("units" +units);
		System.out.println("quantity" +product.getQty());
		
		if(units<=product.getQty()){
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=user.getUsername();
		Customer customer=customerService.getCustomerByUsername(username);
		Cart cart=customer.getCart();
		List<CartItem> cartItems=cart.getCartItems();
		System.out.println(cart.getCartItems().size());
	
	for(CartItem cartItem:cartItems){
		
		System.out.println(cartItem.getProduct().getPid());
		System.out.println(pid);
		if(cartItem.getProduct().getPid()==pid){
			cartItem.setQuantity(units);
			cartItem.setTotalPrice(product.getPrice()*units);
			cartItemService.addCartItem(cartItem);
		return "redirect:/cart/getcart";
		}
	}
	
	CartItem cartItem=new CartItem();
	cartItem.setQuantity(units);
	cartItem.setTotalPrice(product.getPrice()* units);
	cartItem.setProduct(product);
	 cartItem.setCart(cart);
	 cartItemService.addCartItem(cartItem);
	 return "redirect:/cart/getcart";
	 }
		else{
			if(error != null){
				model.addAttribute("error", "Out of Stock");
				}
			
			return "redirect:/all/product/viewproduct/{pid}";
		}
	}
	
	@RequestMapping("cart/getcart")
	public String getCart(Model model){
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
	String username=user.getUsername();
	Customer customer=customerService.getCustomerByUsername(username);
	Cart cart=customer.getCart();
	model.addAttribute("cart",cart);
	return "cart";
	}
	
	@RequestMapping("/cart/removecartitem/{cartItemId}")
	public String removeCartItem(@PathVariable int cartItemId){
		cartItemService.removeCartItem(cartItemId);
		return "redirect:/cart/getcart";
		
	}
	
	@RequestMapping("/cart/clearcart/{cartId}")
	public String removeAllCartItem(@PathVariable("cartId") int cartId){
		cartItemService.removeAllCartItems(cartId);
		return "redirect:/cart/getcart";
		
	}
}
