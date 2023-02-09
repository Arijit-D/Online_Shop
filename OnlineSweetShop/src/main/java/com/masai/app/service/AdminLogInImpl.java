package com.masai.app.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.dao.AdminDao;
import com.masai.app.dao.CustomerDao;
import com.masai.app.dao.ProductDao;

import com.masai.app.model.Admin;
import com.masai.app.model.Product;

@Service
public class AdminLogInImpl implements AdminLogIn {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CustomerDao customerDao;
	
	int adminCount =1;
	

	@Override
	public String adminLogIn( Admin admin) {
		
		
		// TODO Auto-generated method stub
		
		
		if(adminCount>1) {
			
			System.out.println(adminCount);
			return "already loged in";
		}
		
	    Admin xAdmin = adminDao.findByName(admin.getName());
		
		if(admin.getName().equals(xAdmin.getName()) && admin.getPassword().equals(xAdmin.getPassword())) {
			
			adminCount++;
			
			return "loged in";
			
		}
		
		return "some mistake happend";
	}


	@Override
	public String adminLogOut() {
		// TODO Auto-generated method stub
		
		if(adminCount>1) {
			
			adminCount--;
			
			return "Logout done see you again";
		}
		
		return "login first";
	}


	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		
		if(adminCount>1) {
			
			productDao.save(product);
			
			return "Added";
			
		}
		
		return "Login please";
	}


	@Override
	public String deleteProduct(String name) {
		// TODO Auto-generated method stub
		
		if(adminCount>1) {
			
			 Product xProduct= productDao.findByName(name);
				
				productDao.delete(xProduct);;
				
//				productDao.save(xProduct);
				return "deleted successfully";
			
		}
		
		return "log in first";
		
	}

}
