package com.niit.service;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.product;

public interface ProductService {
void saveProduct(product product);
public List<product> getAllProduct();
public product getProductById(int id);
void updateProduct(product product);
void deleteProduct(int id);
List<Category> getAllCategories();
public void addCategory(Category categories);
}
