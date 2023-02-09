package com.masai.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.dao.CustomerDao;
import com.masai.app.model.Customer;
import com.masai.app.model.Status;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public String saveCustomer(Customer customer) {
		
		customer.setStatus(Status.INACTIVE);
		
		if(customer.getEmail()==null || customer.getAddress()==null||customer.getName()==null
				|| customer.getName()==null||customer.getPassword()==null) {
			return "fill all the details";
		}
		// TODO Auto-generated method stub
		
	   Customer xCustomer =	customerDao.findByEmail(customer.getEmail());
	   
	   Customer yCustomer =	customerDao.findByNumber(customer.getNumber());
	   
//	   System.out.println(xCustomer.getName());
	   
	   if(xCustomer == null && yCustomer==null) {
		   customerDao.save(customer);
			
			return "done";
	   }
	   else {
		   return "not done";
	   }
		
	}

	
	

}
