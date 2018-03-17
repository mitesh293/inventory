package com.mit.serviceImpl;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.model.Customer;

 
@Service
@Transactional
public class CustomerServiceImpl{
 
    @Autowired
    private com.mit.dao.CustomerDao CustomerDao;
 
    
    @Transactional
    public void addCustomer(Customer Customer) {
        CustomerDao.addCustomer(Customer);
    }
 
  
    @Transactional
    public List<Customer> getAllCustomers() {
        return CustomerDao.getAllCustomers();
    }
 

    @Transactional
    public void deleteCustomer(Integer CustomerId) {
        CustomerDao.deleteCustomer(CustomerId);
    }
 
    public Customer getCustomer(int empid) {
        return CustomerDao.getCustomer(empid);
    }
 
    public Customer updateCustomer(Customer Customer) {
        // TODO Auto-generated method stub
        return CustomerDao.updateCustomer(Customer);
    }
 
    public void setCustomerDao(com.mit.dao.CustomerDao CustomerDao) {
        this.CustomerDao = CustomerDao;
    }
 
}
