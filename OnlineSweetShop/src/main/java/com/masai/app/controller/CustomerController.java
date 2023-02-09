package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.model.Address;
import com.masai.app.model.Customer;
import com.masai.app.model.LogIn;
import com.masai.app.model.OrderProduct;
import com.masai.app.model.Product;
import com.masai.app.service.CustomerService;
import com.masai.app.service.LogInService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	LogInService logInService;
	

	@GetMapping("/hello")
	public String hello() {
		
		return "wellcome";
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<String>  addCustomer(@RequestBody Customer customer) {
		
		
		System.out.println(customer);
		
		String responseString = service.saveCustomer(customer);
		
		return new ResponseEntity<>(responseString,HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String>  logIn(@RequestBody LogIn logIn) {
		
		
//		System.out.println(customer);
		
		String responseString = logInService.logIn(logIn);
		
		return new ResponseEntity<>(responseString,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String>  logOut() {
		
		
//		System.out.println(customer);
		
		String responseString = logInService.logOut();
		
		return new ResponseEntity<>(responseString,HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<String>  update(@RequestBody Customer customer) {
		
		
		System.out.println(customer);
		
		String responseString = logInService.update(customer);
		
		return new ResponseEntity<>(responseString,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/delete")
	public ResponseEntity<String>  delete() {
		
		
//		System.out.println(customer);
		
		String responseString = logInService.delete();
		
		return new ResponseEntity<>(responseString,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/seeProducts")
	public ResponseEntity<List<Product> >  seeProducts() {
		
		
//		System.out.println(customer);
		
		List<Product> productds = logInService.seeProducts();
		
		return new ResponseEntity<>(productds,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/addtocart/{name}/{quantity}")
	public ResponseEntity<String >  addToCart(@PathVariable String name,@PathVariable int quantity) {
		
		
//		System.out.println(customer);
		
		String productds = logInService.addToCart(name,quantity);
		
		return new ResponseEntity<>(productds,HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/removefromcart/{name}")
	public ResponseEntity<String >  removeFromCart(@PathVariable String name) {
		
		
//		System.out.println(customer);
		
		String productds = logInService.removeFromCart(name);
		
		return new ResponseEntity<>(productds,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/seeOrder")
	public ResponseEntity<List<OrderProduct> >  seeOrder() {
		
		
//		System.out.println(customer);
		
		List<OrderProduct> productds = logInService.makeOrder();
		
		return new ResponseEntity<>(productds,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/seeCart")
	public ResponseEntity<List<OrderProduct> >  seeCart() {
		
		
//		System.out.println(customer);
		
		List<OrderProduct> productds = logInService.seeCart();
		
		return new ResponseEntity<>(productds,HttpStatus.ACCEPTED);
		
	}
	
	
	
}
