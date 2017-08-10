package com.niit.dao;

import java.util.List;   

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sf;
	
	public void saveProduct(product product) {
		
		Session session = sf.openSession();
		session.save(product);
		session.flush();
		session.close();
		}
	public List<product> getAllProduct()
	{ 
		Session session = sf.openSession();
		Query query = session.createQuery("from product");
		List<product> products = query.list();
		session.close();
		return products;
	}
	public product getProductById(int pid) {
		
		Session session=sf.openSession();
		//select * from product where id=34
		product product=(product)session.get(product.class,pid);
		session.close();
		return product;
	}
	public void updateProduct(product product) {
		Session session=sf.openSession();
		System.out.println("Id of the product in dao is " + product.getPid());
		session.update(product); //update product set ..... where id=?
		session.flush();
		session.close();
		
	}
	public void deleteProduct(int id) {
		Session session=sf.openSession();
		//Make the object persistent[read the data from the table and add it to session]
		product product=(product)session.get(product.class, id);
		session.delete(product);
		session.flush();
		session.close();
		
	}
	 public List<Category> getAllCategories()
	{ 
		Session session = sf.openSession();
		Query query = session.createQuery("from Category");
		List<Category> categories = query.list();
		return categories;
	}
	
	 public void addCategory(Category categories) {
		
		Session session = sf.openSession();
		System.out.println("categorydao");
		session.save(categories);
		session.flush();
		session.close();
	}
}
