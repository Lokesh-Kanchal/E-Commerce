package com.niit.controller;

import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.model.Category;
import com.niit.model.product;
import com.niit.service.ProductService;

@Controller
public class ProductController {
	
@Autowired	
private ProductService ps;
/*private CategoryService cs;*/

@RequestMapping("/admin/product/productform")
public String getProductForm(Model model){
	List<Category> categories=ps.getAllCategories();
	model.addAttribute("categories",categories);
	model.addAttribute("product",new product());
	return "productform";
}

@RequestMapping("/admin/product/addNewProduct")
public String saveProduct(@ModelAttribute(value="product") product product) {
	System.out.println("inside saveProduct");
	ps.saveProduct(product);
	/*MultipartFile image=product.getImage();
	Path path=Paths.get("D:\demo1\src\main\webapp\WEB-INF\resources\images\\"+product.getPid()+".png")*/
	
	return "redirect:/getallproduct";	
}

@RequestMapping("/getallproduct")
public String getAllProduct(Model model)
{
	List<product> I= ps.getAllProduct();
	model.addAttribute("product",I);
	return "productlist";
}

@RequestMapping("/all/product/viewproduct/{pid}")
public String viewProduct(@PathVariable int pid,Model model){
	product product=ps.getProductById(pid);
	model.addAttribute("pd",product);
return "viewproduct";
}

@RequestMapping("/admin/product/deleteproduct/{pid}")
public String deleteProduct(@PathVariable int pid){
	ps.deleteProduct(pid);
	return "redirect:/getallproduct";
}

@RequestMapping("/editform/{pid}")
public String editProductForm(@PathVariable int pid , Model model){	
	List<Category> categories=ps.getAllCategories();
	model.addAttribute("categories",categories);	
	product product=ps.getProductById(pid);
	model.addAttribute("product",product);
	/*model.addAttribute("categories",categoryService.getCategories());*/
	return "editform";
}
@RequestMapping("/editProduct/{pid}")
public String editProduct(@ModelAttribute(value="product") product product) {
	System.out.println("inside saveProduct");
	ps.updateProduct(product);
	return "redirect:/getallproduct";
	}


}

