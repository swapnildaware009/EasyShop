package com.thinkitive.EasyShop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thinkitive.EasyShop.model.Address;

public interface AddressService {

	public void createAddress(Address address);
	public Page<Address> getAllAddress(Pageable pageable);
	public Address getAddressByAddress_id(int id);
	public Address getAddressByCity(String city);
	public Address getAllAdressBytype(String addressType);
	public Address updateAddreass(Address address, int id);
	public void deleteAddressById(int id);
	public void deleteAllAddress();

}