package com.greatlearning.crmapp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
		SessionFactory sessionFactory = con.buildSessionFactory();

		CustomerService bs = new CustomerServiceImpl(sessionFactory);

		List<Customer> customers = bs.findAll();

		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
