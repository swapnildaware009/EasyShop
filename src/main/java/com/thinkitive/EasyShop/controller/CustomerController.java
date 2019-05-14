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

import com.thinkitive.EasyShop.dto.CustomerDTO;
import com.thinkitive.EasyShop.model.Customer;
import com.thinkitive.EasyShop.service.CustmerService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	CustmerService custmerService;

	@PostMapping("/create")
	public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {
		System.out.println("Creating Customer Name...." + customer.getUserName());
		custmerService.createCustomer(customer);

		if (customer == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	@GetMapping(value = "/getAll")
	public Page<Customer> getAllCustomerList(Pageable pageable) {
		System.out.println("list" + custmerService.getAllCustomer(pageable));
		return custmerService.getAllCustomer(pageable);
	}

	@GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) throws Exception {
		System.out.println("id ::::" + id);

		Customer customer = custmerService.getById(id);
		System.out.println("Address:::" + customer.getAddress());
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		} else {
			System.out.println("Customer==> GetById " + id);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/getByFirstName/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Customer> getCustomerByFirstName(@PathVariable("firstName") String firstName)
			throws Exception {
		System.out.println("firstName ::::" + firstName);

		Customer customer = custmerService.getByFirstName(firstName);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		} else {
			System.out.println("Customer==> GetByFirstName " + firstName);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDTO customerDTO) {
		Customer customer = new Customer(customerDTO);

		Customer customers = custmerService.getById(customer.getId());
		if (customers == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		} else {
			customers.setId(customerDTO.getId());
			customers.setFirstName(customerDTO.getFirstName());
			customers.setLastName(customerDTO.getPassword());
			customers.setEmail(customerDTO.getEmail());
			customers.setGender(customerDTO.getGender());
			customers.setUserName(customerDTO.getUserName());
			customers.setPassword(customerDTO.getPassword());
			customers.setPhoneNumber(customerDTO.getPhoneNumber());

			custmerService.updateCustomer(customers, customers.getId());

			return new ResponseEntity<Customer>(customers, HttpStatus.CREATED);

		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id) {

		Customer customer = custmerService.getById(id);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		} else {
			custmerService.deleteById(id);
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping(value = "/deleteAll")
	public ResponseEntity<Customer> deleteAllCustomer() {

		custmerService.deleteAll();
		return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);

	}

}
