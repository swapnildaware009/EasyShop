package com.thinkitive.EasyShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.EasyShop.dto.AddressDTO;
import com.thinkitive.EasyShop.model.Address;
import com.thinkitive.EasyShop.service.AddressService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/address")
public class AddressController  {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/create")
	public ResponseEntity<Void> createAddress(@RequestBody Address address)
	{
//		System.out.println("Creating Customer Address...." + address.getAddress_id());
		addressService.createAddress(address);

		if (address == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/getAll")
	Page<Address> getAllAddressList(Pageable pageable )
	{
		System.out.println("----------------------------------------------------------------------");
		System.out.println(" Address List is ::::"+addressService.getAllAddress(pageable));
		return addressService.getAllAddress(pageable);
	}
	
	@GetMapping(value = "/getByAddressType/{addressType}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Address> getByAddressType(@PathVariable("addressType") String addressType) throws Exception {
		System.out.println("addressType ::::"+addressType);
		
		Address address= addressService.getAllAdressBytype(addressType)
;		System.out.println("data::::::"+address);
		if(address==null) 
		{
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		else 
		{
			System.out.println("Address==> GetById "+addressType);
	      	return new ResponseEntity<Address>((Address) address,HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/getById/{address_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Address> getAddressById(@PathVariable("address_id") int address_id) throws Exception {
		System.out.println("id ::::"+address_id);
		
		Address address= addressService.getAddressByAddress_id(address_id);

		if(address==null) 
		{
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		else 
		{
			System.out.println("Address==> GetById "+address_id);
	      	return new ResponseEntity<Address>((Address) address,HttpStatus.OK);
		}
	}
	

	@GetMapping(value = "/getByCity/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Address> getByAddressCity(@PathVariable("city") String city) throws Exception {
		System.out.println("City ::::"+city);
		
		Address address= addressService.getAddressByCity(city);
		System.out.println("data::::::"+city);
		if(address==null) 
		{
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		else 
		{
			System.out.println("Address city==> GetByCity "+city);
	      	return new ResponseEntity<Address>((Address) address,HttpStatus.OK);
		}
	}

	
	@PutMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Address> updateCustomer(@RequestBody AddressDTO addressDTO)
    {
		Address address = new Address(addressDTO);
		
		Address address1 = addressService.getAddressByAddress_id(address.getAddress_id());
	        if (address1==null) {
	            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
	        }
	        else 
	        {
	        	address1.setAddress_id(addressDTO.getAddress_id());
	        	address1.setAddressType(addressDTO.getAddressType());
	        	address1.setCity(addressDTO.getCity());
	        	address1.setCountry(addressDTO.getCountry());
	        	address1.setLandmark(addressDTO.getLandmark());
	        	address1.setPincode(addressDTO.getPincode());
	        	address1.setState(addressDTO.getState());
	        	address1.setStreetName(addressDTO.getStreetName());
	        	
	        	addressService.updateAddreass(address1,address1.getAddress_id());
        	
	        	return new ResponseEntity<Address>(address1,HttpStatus.CREATED);	
	        	
	        }
    }
	
	@DeleteMapping(value = "/delete/{address_id}")
	public ResponseEntity<Address> deleteCustomer(@PathVariable("address_id") int address_id) {

		Address address = addressService.getAddressByAddress_id(address_id);
		if (address == null) {
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		} else {
			addressService.deleteAddressById(address_id);
			return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
		}
	}
	@DeleteMapping(value = "/deleteAll")
	public ResponseEntity<Address> deleteAllCustomer() {

		
			addressService.deleteAllAddress();
			return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
		
	}

	
}

