package com.thinkitive.EasyShop.serviceImpl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thinkitive.EasyShop.model.Customer;
import com.thinkitive.EasyShop.repository.CustomerRepository;
import com.thinkitive.EasyShop.service.CustmerService;

@Service
public class CustomerServiceImpl implements CustmerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void createCustomer(Customer customer) {
		try {
			customerRepository.save(customer);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	

	@Override
	public Customer getById(int id) {
		try {
			Customer customer = customerRepository.getOne(id);
			return customer;
		} catch (EntityNotFoundException e) {
			System.out.println("Exception while fetching entity {}" +e.getCause());
			return null;
		}

	}

	@Override
	public Customer getByFirstName(String firstName) {

		return customerRepository.getByFirstName(firstName);
	}

	@Override
	public Customer updateCustomer(Customer customer, int id) {

		return customerRepository.save(customer);
	}

	@Override
	public void deleteById(int id) {

		customerRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {

		customerRepository.deleteAll();
	}



	@Override
	public Page<Customer> getAllCustomer(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}



}
