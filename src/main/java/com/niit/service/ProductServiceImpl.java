package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productdao;
	
public void saveProduct(product product)
{
productdao.saveProduct(product);	
}
public List<product> getAllProduct()
{
	return productdao.getAllProduct();
}
public product getProductById(int id) {

	return productdao.getProductById(id);
}
public void updateProduct(product product) {
	productdao.updateProduct(product);
}
public void deleteProduct(int id) {
	productdao.deleteProduct(id);	
}
public List<Category> getAllCategories() {
	return productdao.getAllCategories();
}
public void addCategory(Category categories) {
	productdao.addCategory(categories);
	
}
}
