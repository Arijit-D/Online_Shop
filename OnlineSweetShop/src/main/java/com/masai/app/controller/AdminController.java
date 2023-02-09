package com.masai.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.dao.ProductDao;
import com.masai.app.model.Admin;
import com.masai.app.model.Product;



@RestController
public class AdminController {
	
	@Autowired
	com.masai.app.service.AdminLogIn logIn;
	
	
	
	
	@PostMapping("/AdminLogIn")
	public ResponseEntity<String>  AdminLogIn( @RequestBody Admin admin) {
		
	 String resultString =	logIn.adminLogIn(admin);
		
		
		return new ResponseEntity<String>(resultString,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/AdminLogOut")
	public ResponseEntity<String> AdminLogOut(){
		
	  String xString =	logIn.adminLogOut();
	  
	  return new ResponseEntity<String>(xString,HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<String>  AddProduct( @RequestBody Product product) {
		
	 String resultString =	logIn.addProduct(product);
		
		
		return new ResponseEntity<String>(resultString,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/deleteProduct/{name}")
	public ResponseEntity<String>  deleteProduct(@PathVariable String name) {
		
//	 String resultString =	logIn.addProduct();
		
	  String xString =	logIn.deleteProduct(name);
		
		return new ResponseEntity<String>(xString,HttpStatus.ACCEPTED);
		
	}
	
}
