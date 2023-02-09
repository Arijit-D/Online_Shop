package com.masai.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Address implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
	private  List<Customer> customer = new ArrayList<>();

	public Address() {
		super();
	}



	public Address(int aid, String city, String state, String country, String pincode, List<Customer> customer) {
		super();
		this.aid = aid;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.customer = customer;
	}



	public int getAid() {
		return aid;
	}



	public void setAid(int aid) {
		this.aid = aid;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	public List<Customer> getCustomer() {
		return customer;
	}



	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
	
	
	
}
