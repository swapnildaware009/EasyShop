package com.thinkitive.EasyShop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Proxy;

import com.thinkitive.EasyShop.dto.AddressDTO;

@Entity
@Table(name="address")
@Proxy(lazy = false)
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9039456595886796473L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int address_id;
	
	@Column(name="street_name")
	@NotNull
	private String streetName;
	

	@Column(name="landmark")
	@NotNull
	private String landmark;
	
	@Column(name="city")
	@NotNull
	private String city;
	
	@Column(name="state")
	@NotNull
	private String state;
	
	@Column(name="country")
	@NotNull
	private String country;
	
	@Column(name="addressType")
	@NotNull
	private String addressType;
	
	@Column(name="pincode")
	@NotNull
	private int pincode;
	 
	
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public int getAddress_id() {
		return address_id;
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

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Address() {
		super();
		
	}
	
	public Address(AddressDTO addressDTO) {
		this.address_id=addressDTO.getAddress_id();
		this.landmark=addressDTO.getLandmark();
		this.streetName=addressDTO.getStreetName();
		this.city=addressDTO.getCity();
		this.state=addressDTO.getState();
		this.country=addressDTO.getCountry();
		this.addressType=addressDTO.getAddressType();
		this.pincode=addressDTO.getPincode();
		
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", streetName=" + streetName + ", landmark=" + landmark + ", city="
				+ city + ", state=" + state + ", country=" + country + ", addressType=" + addressType + ", pincode="
				+ pincode + "]";
	}

	
	
}
