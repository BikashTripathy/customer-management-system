package com.cms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.entity.Customer;

@SuppressWarnings("deprecation")
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> queryCustomers = session.createQuery("from Customer c", Customer.class);

		List<Customer> customers = queryCustomers.getResultList();
		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void saveOrUpdateCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		System.out.println("Customer: " + id + " Deleted...");
	}

}
