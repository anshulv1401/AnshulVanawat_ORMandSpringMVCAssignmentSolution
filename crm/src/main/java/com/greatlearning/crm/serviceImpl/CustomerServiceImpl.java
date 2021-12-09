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

	private Session session;

	public CustomerServiceImpl(SessionFactory sessionFactory) {
		try {
			this.session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Customer> findAll() {

		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer").list();
		tx.commit();

		return customers;
	}

	@Transactional
	public List<Customer> searchBy(String firstName, String LastName, String email) {
		Transaction tx = session.beginTransaction();

		String qry = "";

		if (firstName.length() != 0 && LastName.length() != 0) {
			qry = "from Customer where name like '%'" + firstName + "% or author like %" + LastName + "%";
		} else if (firstName.length() != 0) {
			qry = "from Customer where name like '%'" + firstName + "%";
		} else if (LastName.length() != 0) {
			qry = "from Customer where author like %" + LastName + "%";
		} else {
			System.out.println("cannot search without parameters");
		}

		List<Customer> customers = session.createQuery(qry).list();
		tx.commit();

		return customers;
	}

	@Transactional
	public Customer findById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		tx.commit();
		return customer;
	}

	@Transactional
	public void save(Customer customer) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();

	}

	@Transactional
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		tx.commit();
	}

}
