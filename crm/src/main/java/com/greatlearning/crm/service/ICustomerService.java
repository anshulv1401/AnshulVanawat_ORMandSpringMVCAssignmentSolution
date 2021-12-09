package com.greatlearning.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.crm.model.Customer;

@Service
public interface ICustomerService {

	public List<Customer> findAll();

	public List<Customer> searchBy(String firstName, String LastName, String email);

	public Customer findById(int id);

	public void save(Customer customer);

	public void deleteById(int id);
}
