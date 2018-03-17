package com.mit.daoImpl;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mit.dao.CustomerDao;
import com.mit.model.Customer;
 
 
@Repository
public class CustomerDaoImpl implements CustomerDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addCustomer(Customer Customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(Customer);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<Customer> getAllCustomers() {
 
        return sessionFactory.getCurrentSession().createQuery("from Customer")
                .list();
    }
 
    @Override
    public void deleteCustomer(Integer CustomerId) {
        Customer Customer = (Customer) sessionFactory.getCurrentSession().load(
                Customer.class, CustomerId);
        if (null != Customer) {
            this.sessionFactory.getCurrentSession().delete(Customer);
        }
 
    }
 
    public Customer getCustomer(int empid) {
        return (Customer) sessionFactory.getCurrentSession().get(
                Customer.class, empid);
    }
 
    @Override
    public Customer updateCustomer(Customer Customer) {
        sessionFactory.getCurrentSession().update(Customer);
        return Customer;
    }
 
}