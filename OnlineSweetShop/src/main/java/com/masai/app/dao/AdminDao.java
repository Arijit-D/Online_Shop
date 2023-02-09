package com.masai.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.model.Admin;


@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	

//	public Admin findbyName(String name);
	
	
	public Admin findByName(String name);
	
	public Admin findByPassword(String password);

}
