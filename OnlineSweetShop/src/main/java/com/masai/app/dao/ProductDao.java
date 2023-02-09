package com.masai.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.model.Product;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	
	public Product findByName(String name);
	
	
}
