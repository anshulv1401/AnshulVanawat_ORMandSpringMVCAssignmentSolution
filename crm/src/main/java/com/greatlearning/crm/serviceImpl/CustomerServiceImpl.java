package com.greatlearning.crm.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.crm.model.Customer;
import com.greatlearning.crm.service.ICustomerService;

@Repository
public class CustomerServiceImpl implements ICustomerService {

	private SessionFactory sessionFactory;
	private Session session;

	CustomerServiceImpl(SessionFactory sessionFactory) {
		System.out.println("CustomerServiceImpl");
		this.sessionFactory = sessionFactory;

		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = this.sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer").list();
		tx.commit();

		return customers;
	}

	public List<Customer> searchBy(String firstName, String LastName, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer findById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Customer theBook) {
		// TODO Auto-generated method stub

	}

	public void deleteById(int Id) {
		// TODO Auto-generated method stub

	}

}
