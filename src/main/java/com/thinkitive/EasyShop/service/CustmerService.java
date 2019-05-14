package com.thinkitive.EasyShop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thinkitive.EasyShop.model.Customer;

public interface CustmerService {

	public void createCustomer(Customer customer);

	public Page<Customer> getAllCustomer(Pageable pageable);

	public Customer getById(int id);

	public Customer getByFirstName(String firstName);

	public Customer updateCustomer(Customer customer, int id);

	public void deleteById(int id);

	public void deleteAll();
}
