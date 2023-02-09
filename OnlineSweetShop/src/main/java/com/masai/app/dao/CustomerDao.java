package com.masai.app.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.model.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	
    public Customer findByEmail(String email);
    public Customer findByNumber(String number);
    public Customer findByPassword(String password);
		
	
	
}
