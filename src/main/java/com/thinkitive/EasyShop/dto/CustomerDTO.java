package com.thinkitive.EasyShop.dto;

import java.util.List;

import com.thinkitive.EasyShop.model.Address;
import com.thinkitive.EasyShop.model.Customer;

public class CustomerDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String gender;
	private String phoneNumber;
	private String email;
	private List<Address> address;
	
	
	
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CustomerDTO() {
		super();
	}
	public CustomerDTO(Customer  customer) {
		this.id=customer.getId();
		this.firstName=customer.getFirstName();
		this.lastName=customer.getLastName();
		this.userName=customer.getUserName();
		this.password=customer.getPassword();
		this.gender=customer.getGender();
		this.phoneNumber=customer.getPhoneNumber();
		this.email=customer.getEmail();
		this.address=customer.getAddress();
	}
}
