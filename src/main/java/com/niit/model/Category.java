package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
public class Category implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String categoryName;
	
	@OneToMany(mappedBy="category")
	private List<product> products;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<product> getProducts() {
		return products;
	}
	public void setProducts(List<product> products) {
		this.products = products;
	}
	@Override
	public String toString(){
		return this.id + " " + this.categoryName;
	}
		
	}
	

