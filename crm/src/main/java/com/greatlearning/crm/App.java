package com.greatlearning.crm;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.crm.model.Customer;
import com.greatlearning.crm.service.ICustomerService;
import com.greatlearning.crm.serviceImpl.CustomerServiceImpl;

public class App {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
		SessionFactory sessionFactory = con.buildSessionFactory();

		ICustomerService bs = new CustomerServiceImpl(sessionFactory);

		List<Customer> customers = bs.findAll();

		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

}
