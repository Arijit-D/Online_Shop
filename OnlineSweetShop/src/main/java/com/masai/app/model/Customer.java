package com.masai.app.model;



import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;



@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "name is mandatory")
	private String name;
	
	@NotNull
	private String number;
	
	@NotNull
	private String email;
	
	@NotNull(message = "password is mandatory")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$",
	message = "Password must be of 8 characters and must include "
			+ " at least one upper case English letter, one lower case "
			+ "English letter, one number and one special character.")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Default()
	private Status status;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aid")
	private Address address;

	public Customer(int id, @NotNull(message = "name is mandatory") String name, @NotNull String number,
			@NotNull String email,
			@NotNull(message = "password is mandatory") @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$", message = "Password must be of 8 characters and must include  at least one upper case English letter, one lower case English letter, one number and one special character.") String password,
			Status status, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.email = email;
		this.password = password;
		this.status = status;
		this.address = address;
	}

	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", number=" + number + ", email=" + email + ", password="
				+ password + ", status=" + status + ", address=" + address + "]";
	}
	
	
	
	

}
