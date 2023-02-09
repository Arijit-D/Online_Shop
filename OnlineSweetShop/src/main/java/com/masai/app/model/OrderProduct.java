package com.masai.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	private String userName;
	
	private String userEmail;
	
	private String userNumber;
	
	private Address userAddress;
	
	private String productName;
	
	private int productQuantity;
	
	private int productPrice;
	
	private int totalAmount;
	
	private LocalDateTime localDateTime;

	public OrderProduct(int orderId, String userName, String userEmail, String userNumber, Address userAddress,
			String productName, int productQuantity, int productPrice, int totalAmount, LocalDateTime localDateTime) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userNumber = userNumber;
		this.userAddress = userAddress;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.totalAmount = totalAmount;
		this.localDateTime = localDateTime;
	}

	public OrderProduct() {
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	@Override
	public String toString() {
		return "OrderProduct [orderId=" + orderId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userNumber=" + userNumber + ", userAddress=" + userAddress + ", productName=" + productName
				+ ", productQuantity=" + productQuantity + ", productPrice=" + productPrice + ", totalAmount="
				+ totalAmount + ", localDateTime=" + localDateTime + "]";
	}

	
	
	
	
	
}
