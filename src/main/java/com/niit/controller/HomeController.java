package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService productService;
	
	
	
	@RequestMapping("/")
	public String controller(HttpSession session){
		session.setAttribute("cat",productService.getAllCategories());
		return "index";
	}

	@RequestMapping("/aboutUs")
	public String aboutUs(){
		
		return "aboutus";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session)
	{	
		return "index";
	}

	@RequestMapping("/login")
	public String login(
	@RequestParam(value="error", required = false)
	String error,
	@RequestParam(value="logout", required = false)
	String logout,Model model) {
		System.out.println("inside login");
		if(error != null){
			model.addAttribute("error", "Invalid username and password");
			}

			if (logout !=null){
			model.addAttribute("msg", "You have been logged out successfully !!!!");
			}
	return "login";
}
	

	@RequestMapping("/contactUs")
	public String contactUs(){
		
		return "contactus";
	}
	
}
