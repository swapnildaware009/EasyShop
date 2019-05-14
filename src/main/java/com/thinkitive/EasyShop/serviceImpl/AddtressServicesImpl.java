package com.thinkitive.EasyShop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thinkitive.EasyShop.model.Address;
import com.thinkitive.EasyShop.repository.AddressRepository;
import com.thinkitive.EasyShop.service.AddressService;

@Service

public class AddtressServicesImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	
	@Override
	public void createAddress(Address address) {
		addressRepository.save(address);
	}

	

	

	@Override
	public Address getAddressByCity(String city) {
		
		return addressRepository.getAddressByCity(city);
	}

	@Override
	public Address getAllAdressBytype(String addressType) {
		
		return addressRepository.getAddressByAddressType(addressType);
	}

	@Override
	public Address getAddressByAddress_id(int id) {
		
		return addressRepository.getOne(id);
	}

	@Override
	public Address updateAddreass(Address address, int id) {
		
		return addressRepository.save(address);
	}

	@Override
	public void deleteAddressById(int id) {
		addressRepository.deleteById(id);
	}

	@Override
	public void deleteAllAddress() {
		addressRepository.deleteAll();
	}





	@Override
	public Page<Address> getAllAddress(Pageable pageable) {
		return addressRepository.findAll(pageable);
	}

	
	
}
