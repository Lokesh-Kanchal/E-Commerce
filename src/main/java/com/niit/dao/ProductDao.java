package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.product;


public interface ProductDao {
	
void saveProduct(product product);

public List<product> getAllProduct();

public product getProductById(int pid);

void updateProduct(product product);

void deleteProduct(int id);

List<Category> getAllCategories();

public void addCategory(Category categories);


}
