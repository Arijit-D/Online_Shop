package com.masai.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.dao.AddressDao;
import com.masai.app.dao.CustomerDao;
import com.masai.app.dao.OrderDao;
import com.masai.app.dao.ProductDao;
import com.masai.app.model.Address;
import com.masai.app.model.Customer;
import com.masai.app.model.LogIn;
import com.masai.app.model.OrderProduct;
import com.masai.app.model.Product;
import com.masai.app.model.Status;





@Service
public class LogInServiceImpl implements LogInService {

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	AddressDao addressDao;
	
	
	public int count =1;
	
	Customer x;
	
	List<OrderProduct> list = new ArrayList<>();
	
	@Override
	public String logIn(LogIn logIn) {
		// TODO Auto-generated method stub
		
		if(count==2) {
			return "alread loged in";
		}
	  	
		
		 x =	customerDao.findByEmail(logIn.getEmail());
		 
		 if(x.getStatus().equals("ACTIVE")) {
			 return "alread loged in";
		 }
	  
	  if(x.getPassword().equals(logIn.getPassword()) ){  
		  
		  logIn.setSecret("yes");
		  
		  x.setStatus(Status.ACTIVE);
		  
		  customerDao.save(x);
		  
		  count++;
		  
		  return "Loged in";
	  }	
		return "try again";
	}



	@Override
	public String logOut() {
		// TODO Auto-generated method stub
		
		if(count>1) {
			count--;
			
			  x.setStatus(Status.INACTIVE);
			  
			  customerDao.save(x);
			return "loged out";
		}
		else {
			return "login first";
		}
		

	}



	@Override
	public String update(Customer customer) {
		// TODO Auto-generated method stub
		
		
		  
		  if(count>1) {
			  
			  Customer xCustomer =	customerDao.findByEmail(customer.getEmail());
			  
//			  xCustomer.setAddress(customer.getAddress());
			  xCustomer.setName(customer.getName());
			  
			  System.out.println(xCustomer);
			  xCustomer.setPassword(customer.getPassword());
			  
			  customerDao.save(xCustomer);
			  
			  return "updated";
		  }
			
			return "log in please";
		
	}



	@Override
	public String delete() {
		
		// TODO Auto-generated method stub
		
		if(count>1) {
			count--;
			
			customerDao.delete(x);
			 
			return "deleted sucessfully";
		}
		else {
			return "login first";
		}
		
	}



	@Override
	public List<Product> seeProducts() {
		// TODO Auto-generated method stub
		
		if(count>1) {
		  List<Product> products =	productDao.findAll();
		  
		  return products;
		}
		
		return null;
	}



	@Override
	public String addToCart(String Productname, int quantity) {
		// TODO Auto-generated method stub
		
		if(count>1) {
			
			
			
			   Product product =	productDao.findByName(Productname);
			   
			   if(quantity>product.getAvailableQuantity()) {
				   return null;
			   }
				
				OrderProduct order = new OrderProduct();
				
				order.setUserName(x.getName());
				order.setUserEmail(x.getEmail());
				order.setUserNumber(x.getNumber());
				
				int aid = x.getId();
				
			     Address address = addressDao.findById(aid);
			     
			     System.out.println(address);
				
				order.setUserAddress(address);
				
				
				order.setProductName(Productname);
				order.setProductQuantity(quantity);
				order.setProductPrice(product.getPrice());
				
				int y = product.getPrice()*quantity;
				
				order.setTotalAmount(y);
				
				order.setLocalDateTime(LocalDateTime.now());
				
//				product.setAvailableQuantity(product.getAvailableQuantity()-quantity);
//				productDao.save(product);
				
				list.add(order);
				
				
			
				return "added";
				
			}
			
		
		return "not added";
	}



	@Override
	public String removeFromCart(String Productname) {
		// TODO Auto-generated method stub
		
		if(count>1) {
			
			for(OrderProduct i : list) {
				
//				frontend developer is responsible for productname
				if(i.getProductName().equals(Productname)) {
					list.remove(i);
					return "done";
				}
				
			}
			
			
		}
		

		return "not done";
	}



	@Override
	public List<OrderProduct> makeOrder() {
		// TODO Auto-generated method stub
		
		
		if(count>1) {
			
			
			
			
             for(OrderProduct i : list) {
            	 
            	  orderDao.save(i);
				
            	  Product product =	productDao.findByName(i.getProductName());
            	 
            	  product.setAvailableQuantity(product.getAvailableQuantity()-i.getProductQuantity());
//				
            	  productDao.save(product);
				
			}
			
           
             
		    List<OrderProduct> list1 = list;
			
		    list.clear();
		  
			return list1;
		}
		
		
		return null;
	}



	@Override
	public List<OrderProduct> seeCart() {
		// TODO Auto-generated method stub
		
		if(count>1) {
			
			return list;
			
		}
		
		return null;
	}

	



	
}
