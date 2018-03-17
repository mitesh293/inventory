package com.mit.dao;

import java.util.List;

import com.mit.model.Customer;

public interface CustomerDao {
	public void addCustomer(Customer Customer);
	 
    public List<Customer> getAllCustomers();
 
    public void deleteCustomer(Integer CustomerId);
 
    public Customer updateCustomer(Customer Customer);
 
    public Customer getCustomer(int Customerid);
}
