package com.masai.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.model.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

	public Address findById(int id);
	
	
}
