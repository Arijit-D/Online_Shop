package com.masai.app.service;

import java.util.List;

import com.masai.app.model.Admin;
import com.masai.app.model.Product;

public interface AdminLogIn {

	public String adminLogIn(Admin admin);
	
	public String adminLogOut();
	
	public String addProduct(Product product);
	
	public String deleteProduct(String name);
	
	
}
