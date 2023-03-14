package com.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.dao.CustomerDao;
import com.cms.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Transactional
	@Override
	public List<Customer> getCustomers() {

		return customerDao.getCustomers();
	}

	@Transactional
	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}

	@Transactional
	@Override
	public void saveOrUpdateCustomer(Customer customer) {
		customerDao.saveOrUpdateCustomer(customer);
	}

	@Transactional
	@Override
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}

}
