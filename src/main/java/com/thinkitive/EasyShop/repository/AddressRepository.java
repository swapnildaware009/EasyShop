package com.thinkitive.EasyShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkitive.EasyShop.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

	

	Address getAddressByAddressType(String addressType);

	Address getAddressByCity(String city);

}
