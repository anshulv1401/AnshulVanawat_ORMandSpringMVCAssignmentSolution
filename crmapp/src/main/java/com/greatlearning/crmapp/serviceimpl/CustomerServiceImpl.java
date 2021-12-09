package com.greatlearning.crmapp.serviceimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.crmapp.model.Customer;
import com.greatlearning.crmapp.service.CustomerService;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private Session session;

	public CustomerServiceImpl(SessionFactory sessionFactory) {
		try {
			this.session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = sessionFactory.openSession();
		}
	}

	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
		tx.commit();
		return customers;
	}

	public Customer findById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		tx.commit();
		return customer;
	}

	public void save(Customer customer) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
	}

	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		tx.commit();
	}

}
