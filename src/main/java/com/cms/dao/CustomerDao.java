package com.cms.dao;

import java.util.List;
import com.cms.entity.Customer;


public interface CustomerDao {
	
	public List<Customer> getCustomers();
	
	public Customer getCustomerById(int id);
	
	public void saveOrUpdateCustomer(Customer customer);
	
	public void deleteCustomer(int id);

}
