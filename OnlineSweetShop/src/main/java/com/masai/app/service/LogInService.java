package com.masai.app.service;


import java.util.List;

import com.masai.app.model.Customer;
import com.masai.app.model.LogIn;
import com.masai.app.model.OrderProduct;
import com.masai.app.model.Product;

public interface LogInService {
	

	public String logIn(LogIn logIn);
	
	public String logOut();
	
	public String update(Customer customer);
	
	public String delete();
	
	public List<Product> seeProducts();
	
	public String addToCart(String Productname, int quantity);
	
	public List<OrderProduct> seeCart();
	
	public String removeFromCart(String Productname);
	
	public List<OrderProduct> makeOrder();
	
}
