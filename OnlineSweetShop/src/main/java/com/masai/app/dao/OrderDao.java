package com.masai.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.model.OrderProduct;



@Repository
public interface OrderDao extends JpaRepository<OrderProduct, Integer> {

	
	public OrderProduct findByProductName(String productName);
	
	
}
